package com.klinker.android.emoji_keyboard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.klinker.android.emoji_keyboard.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard.sqlite.EmojiDataSource;
import com.klinker.android.emoji_keyboard.sqlite.RecentEntry;

import java.util.ArrayList;

public class RecentEmojiAdapter extends BaseEmojiAdapter {

    private ArrayList<RecentEntry> frequentlyUsedEmojiList;
    private EmojiDataSource dataSource;

    public RecentEmojiAdapter(Context context) {
        super((EmojiKeyboardService) context);

        dataSource = new EmojiDataSource(context);
        dataSource.openInReadWriteMode();
        frequentlyUsedEmojiList = (ArrayList<RecentEntry>) dataSource.getAllEntriesInDescendingOrderOfCount();
        setupEmojiDataFromList(frequentlyUsedEmojiList);
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

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emojiKeyboardService.sendText(emojiTexts.get(position));

                for (int i = 0; i < frequentlyUsedEmojiList.size(); i++) {
                    if (frequentlyUsedEmojiList.get(i).getText().equals(emojiTexts.get(position))) {
                        dataSource.incrementExistingEntryCountbyOne(iconIds.get(position) + "");
                        frequentlyUsedEmojiList.get(i).setCount(frequentlyUsedEmojiList.get(i).getCount());
                        return;
                    }
                }

                RecentEntry recentEntry = dataSource.insertNewEntry(emojiTexts.get(position), iconIds.get(position) + "");

                if (recentEntry != null)
                    frequentlyUsedEmojiList.add(recentEntry);
            }
        });

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                dataSource.deleteEntryWithId(frequentlyUsedEmojiList.get(position).getId());
                frequentlyUsedEmojiList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        return imageView;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        dataSource.close();
    }
}