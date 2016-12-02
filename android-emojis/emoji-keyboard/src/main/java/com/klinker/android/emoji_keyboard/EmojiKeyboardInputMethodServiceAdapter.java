package com.klinker.android.emoji_keyboard;

import android.content.Context;
import android.view.KeyEvent;

import com.klinker.android.emoji_keyboard.sqlite.EmojiDataSource;
import com.klinker.android.emoji_keyboard.sqlite.RecentEntry;
import com.klinker.android.emoji_keyboard.view.EmojiKeyboardView;

import java.util.ArrayList;

public class EmojiKeyboardInputMethodServiceAdapter {

    private EmojiKeyboardService emojiKeyboardService;
    private static EmojiKeyboardView emojiKeyboardView;
    private static EmojiDataSource dataSource;
    private static ArrayList<RecentEntry> frequentlyUsedEmojiList;

    public static ArrayList<RecentEntry> getFrequentlyUsedEmojiList() {
        return frequentlyUsedEmojiList;
    }


    public EmojiKeyboardInputMethodServiceAdapter(EmojiKeyboardService emojiKeyboardService, EmojiKeyboardView emojiKeyboardView){

        this.emojiKeyboardService = emojiKeyboardService;
        this.emojiKeyboardView = emojiKeyboardView;
        dataSource = new EmojiDataSource(emojiKeyboardService);
        dataSource.open();
        frequentlyUsedEmojiList = (ArrayList<RecentEntry>) dataSource.getAllEntriesInDescendingOrderOfCount();
    }

    public void sendDeleteKeyPressEvent() {
        emojiKeyboardService.sendDownAndUpKeyEvent(KeyEvent.KEYCODE_DEL, 0);
    }

    public void onFinishInput() {
        dataSource.close();
    }

    public static void sendEmojiForInput(String emoji, int icon) {

        EmojiKeyboardService.sendText(emoji);

        for (int i = 0; i < frequentlyUsedEmojiList.size(); i++) {
            if (frequentlyUsedEmojiList.get(i).getText().equals(emoji)) {
                dataSource.updateExistingEntry(icon + "");
                frequentlyUsedEmojiList.get(i).setCount(frequentlyUsedEmojiList.get(i).getCount());
                return;
            }
        }

        RecentEntry recentEntry = dataSource.insertNewEntry(emoji, icon + "");

        if (recentEntry != null)
            frequentlyUsedEmojiList.add(recentEntry);
    }


    public static void removeRecent(int position) {
        dataSource.deleteEntryWithId(frequentlyUsedEmojiList.get(position).getId());
        frequentlyUsedEmojiList.remove(position);
        emojiKeyboardView.notifyDataSetChanged();
    }

}
