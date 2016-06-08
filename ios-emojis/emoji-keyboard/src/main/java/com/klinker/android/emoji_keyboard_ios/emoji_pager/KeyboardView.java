package com.klinker.android.emoji_keyboard_ios.emoji_pager;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.widget.GridView;
import com.klinker.android.emoji_keyboard_ios.emoji_pager.adapter.*;
import com.klinker.android.emoji_keyboard_ios.sqlite.Recent;
import com.klinker.android.emoji_keyboard_trial_ios.R;

import java.util.ArrayList;

public class KeyboardView {

    private int position;
    private Context context;
    private ArrayList<Recent> recents;

    public KeyboardView(Context context, int position) {
        this.context = context;
        this.position = position;
    }

    public KeyboardView(Context context, int position, ArrayList<Recent> recents) {
        this(context, position);
        this.recents = recents;
    }

    public View getView() {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        final GridView emojiGrid = new GridView(context);

        emojiGrid.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics()));
        emojiGrid.setNumColumns(GridView.AUTO_FIT);

        if(sharedPrefs.getString("emoji_keyboard_color", "1").equals("2")) {
            emojiGrid.setBackgroundColor(context.getResources().getColor(android.R.color.black));
        } else if(sharedPrefs.getString("emoji_keyboard_color", "1").equals("3")){
            emojiGrid.setBackgroundColor(context.getResources().getColor(R.color.black));
        }


        if (position == 0)
            emojiGrid.setAdapter(new RecentEmojiAdapter(context, recents));
        else if (position == 1)
            emojiGrid.setAdapter(new PeopleEmojiAdapter(context));
        else if (position == 2)
            emojiGrid.setAdapter(new ThingsEmojiAdapter(context));
        else if (position == 3)
            emojiGrid.setAdapter(new NatureEmojiAdapter(context));
        else if (position == 4)
            emojiGrid.setAdapter(new TransEmojiAdapter(context));
        else
            emojiGrid.setAdapter(new OtherEmojiAdapter(context));

        return emojiGrid;
    }
}