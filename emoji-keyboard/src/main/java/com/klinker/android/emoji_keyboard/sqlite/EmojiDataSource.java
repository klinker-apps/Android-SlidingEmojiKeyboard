package com.klinker.android.emoji_keyboard.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EmojiDataSource {
    private static final int NUM_RECENTS_TO_SAVE = 60;
    // Database fields
    private SQLiteDatabase database;
    private EmojiSQLiteHelper databaseHelper;
    private String[] allColumns = { EmojiSQLiteHelper.COLUMN_ID,
            EmojiSQLiteHelper.COLUMN_TEXT, EmojiSQLiteHelper.COLUMN_ICON, EmojiSQLiteHelper.COLUMN_COUNT };

    public EmojiDataSource(Context context) {
        databaseHelper = new EmojiSQLiteHelper(context);
    }

    public void openInReadWriteMode() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    public void openInReadMode() throws SQLException {
        database = databaseHelper.getReadableDatabase();
    }

    public void close() {
        databaseHelper.close();
    }

    private ContentValues getFilledContentValuesObject(String text, String icon, long count) {

        ContentValues values = new ContentValues();
        values.put(EmojiSQLiteHelper.COLUMN_TEXT, text);
        values.put(EmojiSQLiteHelper.COLUMN_ICON, icon);
        values.put(EmojiSQLiteHelper.COLUMN_COUNT, count);

        return values;
    }

    private ContentValues getFilledContentValuesObject(RecentEntry recentEntry) {
        return getFilledContentValuesObject(recentEntry.getText(), recentEntry.getIcon(), recentEntry.getCount());
    }

    public RecentEntry insertNewEntry(String text, String icon) {

        int initialCount = 0;
        ContentValues values = getFilledContentValuesObject(text, icon, initialCount);
        long insertId = database.insert(EmojiSQLiteHelper.TABLE_RECENTS, null, values);

        if (insertId == -1) {
            return null;
        } else {
            return new RecentEntry(text, icon, initialCount, insertId);
        }
    }

    public void incrementExistingEntryCountbyOne(String icon) {
        Cursor cursor = database.query(EmojiSQLiteHelper.TABLE_RECENTS,
                allColumns, EmojiSQLiteHelper.COLUMN_ICON + " = " + icon, null,
                null, null, null);
        cursor.moveToFirst();
        RecentEntry newRecentEntry = cursorToRecent(cursor);
        cursor.close();
        newRecentEntry.incrementUsageCountByOne();
        ContentValues values = getFilledContentValuesObject(newRecentEntry);
        database.update(EmojiSQLiteHelper.TABLE_RECENTS, values, EmojiSQLiteHelper.COLUMN_ID +"="+ newRecentEntry.getId(), null);
    }

    public boolean deleteEntryWithId(long id) {

        int rowsDeleted = database.delete(EmojiSQLiteHelper.TABLE_RECENTS, EmojiSQLiteHelper.COLUMN_ID + " = " + id, null);

        if(rowsDeleted == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<RecentEntry> getAllEntriesInDescendingOrderOfCount() {
        List<RecentEntry> recentEntries = new ArrayList<RecentEntry>();

        Cursor cursor = database.query(EmojiSQLiteHelper.TABLE_RECENTS,
                allColumns, null, null, null, null, EmojiSQLiteHelper.COLUMN_COUNT + " * 1 DESC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getPosition() >= NUM_RECENTS_TO_SAVE) {
                deleteEntryWithId(cursor.getLong(0));
            } else {
                RecentEntry recentEntry = cursorToRecent(cursor);
                recentEntries.add(recentEntry);
            }

            cursor.moveToNext();
        }

        cursor.close();
        return recentEntries;
    }

    private RecentEntry cursorToRecent(Cursor cursor) {
        return new RecentEntry(cursor.getString(1),
                                cursor.getString(2),
                                cursor.getLong(3),
                                cursor.getLong(0));
    }
}