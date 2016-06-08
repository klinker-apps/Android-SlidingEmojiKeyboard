package com.klinker.android.emoji_keyboard_ios.emoji_pager.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.klinker.android.emoji_keyboard_ios.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard_ios.sqlite.Recent;
import com.klinker.android.emoji_keyboard_trial_ios.R;

import java.util.ArrayList;

public class RecentEmojiAdapter extends BaseEmojiAdapter {

    private ArrayList<Recent> recents;

    public RecentEmojiAdapter(Context context, ArrayList<Recent> recents) {
        super(context);
        this.recents = recents;
    }

    @Override
    public int getCount() {
        try {
            return recents.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            int scale = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, context.getResources().getDisplayMetrics());
            imageView.setPadding(scale, (int)(scale*1.2), scale, (int)(scale * 1.2));
            imageView.setAdjustViewBounds(true);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(Integer.parseInt(recents.get(position).icon));
        imageView.setBackgroundResource(R.drawable.btn_background);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmojiKeyboardService.addText(recents.get(position).text, Integer.parseInt(recents.get(position).icon));
            }
        });

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