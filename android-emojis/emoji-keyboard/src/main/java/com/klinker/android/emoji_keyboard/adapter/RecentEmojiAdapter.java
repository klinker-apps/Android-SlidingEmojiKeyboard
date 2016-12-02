package com.klinker.android.emoji_keyboard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.klinker.android.emoji_keyboard.EmojiKeyboardInputMethodServiceAdapter;
import com.klinker.android.emoji_keyboard.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard.sqlite.RecentEntry;

import java.util.ArrayList;

public class RecentEmojiAdapter extends BaseEmojiAdapter {

    public RecentEmojiAdapter(Context context, ArrayList<RecentEntry> recentEntries) {
        super(context);

        setupEmojiDataFromList(recentEntries);
    }

    private void setupEmojiDataFromList(ArrayList<RecentEntry> recentEntries) {
        emojiTexts = new ArrayList<String>();
        iconIds = new ArrayList<Integer>();
        for(RecentEntry i: recentEntries) {
            emojiTexts.add(i.getText());
            iconIds.add(Integer.parseInt(i.getIcon()));
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View imageView = super.getView(position, convertView, parent);

        final RecentEmojiAdapter adapter = this;

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                EmojiKeyboardInputMethodServiceAdapter.removeRecent(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        return imageView;
    }
}