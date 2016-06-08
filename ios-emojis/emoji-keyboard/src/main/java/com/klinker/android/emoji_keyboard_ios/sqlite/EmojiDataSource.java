package com.klinker.android.emoji_keyboard_ios.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EmojiDataSource {
    // Database fields
    private SQLiteDatabase database;
    private EmojiSQLiteHelper dbHelper;
    private String[] allColumns = { EmojiSQLiteHelper.COLUMN_ID,
            EmojiSQLiteHelper.COLUMN_TEXT, EmojiSQLiteHelper.COLUMN_ICON, EmojiSQLiteHelper.COLUMN_COUNT };

    public EmojiDataSource(Context context) {
        dbHelper = new EmojiSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Recent createRecent(String text, String icon) {
        try {
            ContentValues values = new ContentValues();
            values.put(EmojiSQLiteHelper.COLUMN_TEXT, text);
            values.put(EmojiSQLiteHelper.COLUMN_ICON, icon);
            values.put(EmojiSQLiteHelper.COLUMN_COUNT, 0);
            long insertId = database.insert(EmojiSQLiteHelper.TABLE_RECENTS, null,
                    values);
            Cursor cursor = database.query(EmojiSQLiteHelper.TABLE_RECENTS,
                    allColumns, EmojiSQLiteHelper.COLUMN_ID + " = " + insertId, null,
                    null, null, null);
            cursor.moveToFirst();
            Recent newRecent = cursorToRecent(cursor);
            cursor.close();
            return newRecent;
        } catch (Exception e) {
            return null;
        }
    }

    public void updateRecent(String icon) {
        try {
            Cursor cursor = database.query(EmojiSQLiteHelper.TABLE_RECENTS,
                    allColumns, EmojiSQLiteHelper.COLUMN_ICON + " = " + icon, null,
                    null, null, null);
            cursor.moveToFirst();
            Recent newRecent = cursorToRecent(cursor);
            cursor.close();
            ContentValues values = new ContentValues();
            values.put(EmojiSQLiteHelper.COLUMN_TEXT, newRecent.text);
            values.put(EmojiSQLiteHelper.COLUMN_ICON, newRecent.icon);
            values.put(EmojiSQLiteHelper.COLUMN_COUNT, newRecent.count + 1);
            database.update(EmojiSQLiteHelper.TABLE_RECENTS, values, "_id=" + newRecent.id, null);
        } catch (Exception e) {

        }
    }

    public void deleteRecent(long id) {
        try {
            database.delete(EmojiSQLiteHelper.TABLE_RECENTS, EmojiSQLiteHelper.COLUMN_ID
                    + " = " + id, null);
        } catch (Exception e) {

        }
    }

    private static final int NUM_RECENTS_TO_SAVE = 60;

    public List<Recent> getAllRecents() {
        List<Recent> recents = new ArrayList<Recent>();

        Cursor cursor = database.query(EmojiSQLiteHelper.TABLE_RECENTS,
                allColumns, null, null, null, null, EmojiSQLiteHelper.COLUMN_COUNT + " * 1 DESC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getPosition() >= NUM_RECENTS_TO_SAVE) {
                deleteRecent(cursor.getLong(0));
            } else {
                Recent recent = cursorToRecent(cursor);
                recents.add(recent);
            }

            cursor.moveToNext();
        }

        cursor.close();
        return recents;
    }

    private Recent cursorToRecent(Cursor cursor) {
        Recent recent = new Recent();
        recent.id = cursor.getLong(0);
        recent.text = cursor.getString(1);
        recent.icon = cursor.getString(2);
        recent.count = cursor.getLong(3);
        return recent;
    }
}