package com.klinker.android.emoji_keyboard_ios.emoji_pager.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.klinker.android.emoji_keyboard_ios.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard_trial_ios.R;

public class NatureEmojiAdapter extends BaseEmojiAdapter {

    public NatureEmojiAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return mEmojiTexts.length;
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

        imageView.setImageResource(sIconIds[position]);
        imageView.setBackgroundResource(R.drawable.btn_background);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmojiKeyboardService.addText(mEmojiTexts[position], sIconIds[position]);
            }
        });

        return imageView;
    }

    public static final String[] mEmojiTexts = {
            // nature
            "\uD83D\uDC15", "\uD83D\uDC36", "\uD83D\uDC29", "\uD83D\uDC08", "\uD83D\uDC31",
            "\uD83D\uDC00", "\uD83D\uDC01", "\uD83D\uDC2d", "\uD83D\uDC39", "\uD83D\uDC22",
            "\uD83D\uDC07", "\uD83D\uDC30", "\uD83D\uDC13", "\uD83D\uDC14", "\uD83D\uDC23",
            "\uD83D\uDC25", "\uD83D\uDC26", "\uD83D\uDC0f", "\uD83D\uDC11",
            "\uD83D\uDC10", "\uD83D\uDC3a", "\uD83D\uDC03", "\uD83D\uDC02", "\uD83D\uDC04",
            "\uD83D\uDC2e", "\uD83D\uDC34", "\uD83D\uDC17", "\uD83D\uDC16", "\uD83D\uDC37",
            "\uD83D\uDC3d", "\uD83D\uDC38", "\uD83D\uDC0d", "\uD83D\uDC3c", "\uD83D\uDC27",
            "\uD83D\uDC18", "\uD83D\uDC28", "\uD83D\uDC12", "\uD83D\uDC35", "\uD83D\uDC06",
            "\uD83D\uDC2f", "\uD83D\uDC3b", "\uD83D\uDC2a", "\uD83D\uDC2b", "\uD83D\uDC0a",
            "\uD83D\uDC33", "\uD83D\uDC0b", "\uD83D\uDC1f", "\uD83D\uDC20", "\uD83D\uDC21",
            "\uD83D\uDC19", "\uD83D\uDC1a", "\uD83D\uDC2c", "\uD83D\uDC0c", "\uD83D\uDC1b",
            "\uD83D\uDC1c", "\uD83D\uDC1d", "\uD83D\uDC1e", "\uD83D\uDC32", "\uD83D\uDC09",
            "\uD83D\uDC3e", "\uD83C\uDF78", "\uD83C\uDF7A", "\uD83C\uDF7b", "\uD83C\uDF77",
            "\uD83C\uDF79", "\uD83C\uDF76", "\u2615", "\uD83C\uDF75", "\uD83C\uDF7c",
            "\uD83C\uDF74", "\uD83C\uDF68", "\uD83C\uDF67", "\uD83C\uDF66", "\uD83C\uDF65",
            "\uD83C\uDF70", "\uD83C\uDF6a", "\uD83C\uDF6b", "\uD83C\uDF6c", "\uD83C\uDF6d",
            "\uD83C\uDF6e", "\uD83C\uDF6f", "\uD83C\uDF73", "\uD83C\uDF54", "\uD83C\uDF5f",
            "\uD83C\uDF5d", "\uD83C\uDF55", "\uD83C\uDF56", "\uD83C\uDF57", "\uD83C\uDF64",
            "\uD83C\uDF63", "\uD83C\uDF71", "\uD83C\uDF5e", "\uD83C\uDF5c", "\uD83C\uDF59",
            "\uD83C\uDF5a", "\uD83C\uDF5b", "\uD83C\uDF72", "\uD83C\uDF65", "\uD83C\uDF62",
            "\uD83C\uDF61", "\uD83C\uDF58", "\uD83C\uDF60", "\uD83C\uDF4c", "\uD83C\uDF4e",
            "\uD83C\uDF4f", "\uD83C\uDF4a", "\uD83C\uDF4b", "\uD83C\uDF44", "\uD83C\uDF45",
            "\uD83C\uDF46", "\uD83C\uDF47", "\uD83C\uDF48", "\uD83C\uDF49", "\uD83C\uDF50",
            "\uD83C\uDF51", "\uD83C\uDF52", "\uD83C\uDF53", "\uD83C\uDF4d", "\uD83C\uDF30",
            "\uD83C\uDF31", "\uD83C\uDF32", "\uD83C\uDF33", "\uD83C\uDF34", "\uD83C\uDF35",
            "\uD83C\uDF37", "\uD83C\uDF38", "\uD83C\uDF39", "\uD83C\uDF40", "\uD83C\uDF41",
            "\uD83C\uDF42", "\uD83C\uDF43", "\uD83C\uDF3a", "\uD83C\uDF3b", "\uD83C\uDF3c",
            "\uD83C\uDF3d", "\uD83C\uDF3e", "\uD83C\uDF3f", "\u2600", "\uD83C\uDF08",
            "\u26c5", "\u2601", "\uD83C\uDF01", "\uD83C\uDF02", "\u2614",
            "\uD83D\uDCA7", "\u26a1", "\uD83C\uDF00", "\u2744", "\u26c4",
            "\uD83C\uDF19", "\uD83C\uDF1e", "\uD83C\uDF1d", "\uD83C\uDF1a", "\uD83C\uDF1b",
            "\uD83C\uDF1c", "\uD83C\uDF11", "\uD83C\uDF12", "\uD83C\uDF13", "\uD83C\uDF14",
            "\uD83C\uDF15", "\uD83C\uDF16", "\uD83C\uDF17", "\uD83C\uDF18", "\uD83C\uDF91",
            "\uD83C\uDF04", "\uD83C\uDF05", "\uD83C\uDF07", "\uD83C\uDF06", "\uD83C\uDF03",
            "\uD83C\uDF0c", "\uD83C\uDF09", "\uD83C\uDF0a", "\uD83C\uDF0b", "\uD83C\uDF0e",
            "\uD83C\uDF0f", "\uD83C\uDF0d", "\uD83C\uDF10"
    };



    private static final int[] sIconIds = {
            // nature
            R.drawable.emoji_u1f415, R.drawable.emoji_u1f436, R.drawable.emoji_u1f429, R.drawable.emoji_u1f408, R.drawable.emoji_u1f431,
            R.drawable.emoji_u1f400, R.drawable.emoji_u1f401, R.drawable.emoji_u1f42d, R.drawable.emoji_u1f439, R.drawable.emoji_u1f422,
            R.drawable.emoji_u1f407, R.drawable.emoji_u1f430, R.drawable.emoji_u1f413, R.drawable.emoji_u1f414, R.drawable.emoji_u1f423,
            R.drawable.emoji_u1f425, R.drawable.emoji_u1f426, R.drawable.emoji_u1f40f, R.drawable.emoji_u1f411,
            R.drawable.emoji_u1f410, R.drawable.emoji_u1f43a, R.drawable.emoji_u1f403, R.drawable.emoji_u1f402, R.drawable.emoji_u1f404,
            R.drawable.emoji_u1f42e, R.drawable.emoji_u1f434, R.drawable.emoji_u1f417, R.drawable.emoji_u1f416, R.drawable.emoji_u1f437,
            R.drawable.emoji_u1f43d, R.drawable.emoji_u1f438, R.drawable.emoji_u1f40d, R.drawable.emoji_u1f43c, R.drawable.emoji_u1f427,
            R.drawable.emoji_u1f418, R.drawable.emoji_u1f428, R.drawable.emoji_u1f412, R.drawable.emoji_u1f435, R.drawable.emoji_u1f406,
            R.drawable.emoji_u1f42f, R.drawable.emoji_u1f43b, R.drawable.emoji_u1f42a, R.drawable.emoji_u1f42b, R.drawable.emoji_u1f40a,
            R.drawable.emoji_u1f433, R.drawable.emoji_u1f40b, R.drawable.emoji_u1f41f, R.drawable.emoji_u1f420, R.drawable.emoji_u1f421,
            R.drawable.emoji_u1f419, R.drawable.emoji_u1f41a, R.drawable.emoji_u1f42c, R.drawable.emoji_u1f40c, R.drawable.emoji_u1f41b,
            R.drawable.emoji_u1f41c, R.drawable.emoji_u1f41d, R.drawable.emoji_u1f41e, R.drawable.emoji_u1f432, R.drawable.emoji_u1f409,
            R.drawable.emoji_u1f43e, R.drawable.emoji_u1f378, R.drawable.emoji_u1f37a, R.drawable.emoji_u1f37b, R.drawable.emoji_u1f377,
            R.drawable.emoji_u1f379, R.drawable.emoji_u1f376, R.drawable.emoji_u2615, R.drawable.emoji_u1f375, R.drawable.emoji_u1f37c,
            R.drawable.emoji_u1f374, R.drawable.emoji_u1f368, R.drawable.emoji_u1f367, R.drawable.emoji_u1f366, R.drawable.emoji_u1f369,
            R.drawable.emoji_u1f370, R.drawable.emoji_u1f36a, R.drawable.emoji_u1f36b, R.drawable.emoji_u1f36c, R.drawable.emoji_u1f36d,
            R.drawable.emoji_u1f36e, R.drawable.emoji_u1f36f, R.drawable.emoji_u1f373, R.drawable.emoji_u1f354, R.drawable.emoji_u1f35f,
            R.drawable.emoji_u1f35d, R.drawable.emoji_u1f355, R.drawable.emoji_u1f356, R.drawable.emoji_u1f357, R.drawable.emoji_u1f364,
            R.drawable.emoji_u1f363, R.drawable.emoji_u1f371, R.drawable.emoji_u1f35e, R.drawable.emoji_u1f35c, R.drawable.emoji_u1f359,
            R.drawable.emoji_u1f35a, R.drawable.emoji_u1f35b, R.drawable.emoji_u1f372, R.drawable.emoji_u1f365, R.drawable.emoji_u1f362,
            R.drawable.emoji_u1f361, R.drawable.emoji_u1f358, R.drawable.emoji_u1f360, R.drawable.emoji_u1f34c, R.drawable.emoji_u1f34e,
            R.drawable.emoji_u1f34f, R.drawable.emoji_u1f34a, R.drawable.emoji_u1f34b, R.drawable.emoji_u1f344, R.drawable.emoji_u1f345,
            R.drawable.emoji_u1f346, R.drawable.emoji_u1f347, R.drawable.emoji_u1f348, R.drawable.emoji_u1f349, R.drawable.emoji_u1f350,
            R.drawable.emoji_u1f351, R.drawable.emoji_u1f352, R.drawable.emoji_u1f353, R.drawable.emoji_u1f34d, R.drawable.emoji_u1f330,
            R.drawable.emoji_u1f331, R.drawable.emoji_u1f332, R.drawable.emoji_u1f333, R.drawable.emoji_u1f334, R.drawable.emoji_u1f335,
            R.drawable.emoji_u1f337, R.drawable.emoji_u1f338, R.drawable.emoji_u1f339, R.drawable.emoji_u1f340, R.drawable.emoji_u1f341,
            R.drawable.emoji_u1f342, R.drawable.emoji_u1f343, R.drawable.emoji_u1f33a, R.drawable.emoji_u1f33b, R.drawable.emoji_u1f33c,
            R.drawable.emoji_u1f33d, R.drawable.emoji_u1f33e, R.drawable.emoji_u1f33f, R.drawable.emoji_u2600, R.drawable.emoji_u1f308,
            R.drawable.emoji_u26c5, R.drawable.emoji_u2601, R.drawable.emoji_u1f301, R.drawable.emoji_u1f302, R.drawable.emoji_u2614,
            R.drawable.emoji_u1f4a7, R.drawable.emoji_u26a1, R.drawable.emoji_u1f300, R.drawable.emoji_u2744, R.drawable.emoji_u26c4,
            R.drawable.emoji_u1f319, R.drawable.emoji_u1f31e, R.drawable.emoji_u1f31d, R.drawable.emoji_u1f31a, R.drawable.emoji_u1f31b,
            R.drawable.emoji_u1f31c, R.drawable.emoji_u1f311, R.drawable.emoji_u1f312, R.drawable.emoji_u1f313, R.drawable.emoji_u1f314,
            R.drawable.emoji_u1f315, R.drawable.emoji_u1f316, R.drawable.emoji_u1f317, R.drawable.emoji_u1f318, R.drawable.emoji_u1f391,
            R.drawable.emoji_u1f304, R.drawable.emoji_u1f305, R.drawable.emoji_u1f307, R.drawable.emoji_u1f306, R.drawable.emoji_u1f303,
            R.drawable.emoji_u1f30c, R.drawable.emoji_u1f309, R.drawable.emoji_u1f30a, R.drawable.emoji_u1f30b, R.drawable.emoji_u1f30e,
            R.drawable.emoji_u1f30f, R.drawable.emoji_u1f30d, R.drawable.emoji_u1f310
    };
}