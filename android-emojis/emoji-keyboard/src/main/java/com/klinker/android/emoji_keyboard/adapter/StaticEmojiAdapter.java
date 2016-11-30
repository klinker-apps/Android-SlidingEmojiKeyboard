package com.klinker.android.emoji_keyboard.adapter;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;

public class StaticEmojiAdapter extends BaseEmojiAdapter {

    public StaticEmojiAdapter(Context context, String[] emojiTextsAsStrings, ArrayList<Integer> iconIds) {
        super(context);
        this.emojiTexts =  new ArrayList<String>(Arrays.asList(emojiTextsAsStrings));
        this.iconIds = iconIds;
    }
}