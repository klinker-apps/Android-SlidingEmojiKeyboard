package com.klinker.android.emoji_keyboard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.klinker.android.emoji_keyboard.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard.sqlite.Recent;

import java.util.ArrayList;

public class RecentEmojiAdapter extends BaseEmojiAdapter {

    public RecentEmojiAdapter(Context context, ArrayList<Recent> recents) {
        super(context);

        setupEmojiDataFromList(recents);
    }

    private void setupEmojiDataFromList(ArrayList<Recent> recents) {
        emojiTexts = new ArrayList<String>();
        iconIds = new ArrayList<Integer>();
        for(Recent i: recents) {
            emojiTexts.add(i.text);
            iconIds.add(Integer.parseInt(i.icon));
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View imageView = super.getView(position, convertView, parent);

        final RecentEmojiAdapter adapter = this;

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                EmojiKeyboardService.removeRecent(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        return imageView;
    }
}