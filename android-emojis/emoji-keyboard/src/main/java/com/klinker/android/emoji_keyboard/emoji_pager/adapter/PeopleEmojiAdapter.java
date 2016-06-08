package com.klinker.android.emoji_keyboard.emoji_pager.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.klinker.android.emoji_keyboard.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard_trial.R;

public class PeopleEmojiAdapter extends BaseEmojiAdapter {

    public PeopleEmojiAdapter(Context context) {
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
            // People
            "\u263A", "\uD83D\uDE0A", "\uD83D\uDE00", "\uD83D\uDE01", "\uD83D\uDE02",
            "\uD83D\uDE03", "\uD83D\uDE04", "\uD83D\uDE05", "\uD83D\uDE06", "\uD83D\uDE07",
            "\uD83D\uDE08", "\uD83D\uDE09", "\uD83D\uDE2F", "\uD83D\uDE10", "\uD83D\uDE11",
            "\uD83D\uDE15", "\uD83D\uDE20", "\uD83D\uDE2C", "\uD83D\uDE21", "\uD83D\uDE22",
            "\uD83D\uDE34", "\uD83D\uDE2E", "\uD83D\uDE23", "\uD83D\uDE24", "\uD83D\uDE25",
            "\uD83D\uDE26", "\uD83D\uDE27", "\uD83D\uDE28", "\uD83D\uDE29", "\uD83D\uDE30",
            "\uD83D\uDE1F", "\uD83D\uDE31", "\uD83D\uDE32", "\uD83D\uDE33", "\uD83D\uDE35",
            "\uD83D\uDE36", "\uD83D\uDE37", "\uD83D\uDE1E", "\uD83D\uDE12", "\uD83D\uDE0D",
            "\uD83D\uDE1b", "\uD83D\uDE1c", "\uD83D\uDE1d", "\uD83D\uDE0b", "\uD83D\uDE17",
            "\uD83D\uDE19", "\uD83D\uDE18", "\uD83D\uDE1a", "\uD83D\uDE0e", "\uD83D\uDE2d",
            "\uD83D\uDE0c", "\uD83D\uDE16", "\uD83D\uDE14", "\uD83D\uDE2a", "\uD83D\uDE0f",
            "\uD83D\uDE13", "\uD83D\uDE2b", "\uD83D\uDE4b", "\uD83D\uDE4c", "\uD83D\uDE4d",
            "\uD83D\uDE45", "\uD83D\uDE46", "\uD83D\uDE47", "\uD83D\uDE4e", "\uD83D\uDE4f",
            "\uD83D\uDE3a", "\uD83D\uDE3c", "\uD83D\uDE38", "\uD83D\uDE39", "\uD83D\uDE3b",
            "\uD83D\uDE3d", "\uD83D\uDE3f", "\uD83D\uDE3e", "\uD83D\uDE40", "\uD83D\uDE48",
            "\uD83D\uDE49", "\uD83D\uDE4a", "\uD83D\uDCA9", "\uD83D\uDC76", "\uD83D\uDC66",
            "\uD83D\uDC66", "\uD83D\uDC68", "\uD83D\uDC69", "\uD83D\uDC74", "\uD83D\uDC75",
            "\uD83D\uDC8f", "\uD83D\uDC91", "\uD83D\uDC6a", "\uD83D\uDC6b", "\uD83D\uDC6c",
            "\uD83D\uDC6d", "\uD83D\uDC64", "\uD83D\uDC65", "\uD83D\uDC6e", "\uD83D\uDC77",
            "\uD83D\uDC81", "\uD83D\uDC82", "\uD83D\uDC6f", "\uD83D\uDC70", "\uD83D\uDC78",
            "\uD83C\uDF85", "\uD83D\uDC7c", "\uD83D\uDC71", "\uD83D\uDC72", "\uD83D\uDC73",
            "\uD83D\uDC83", "\uD83D\uDC86", "\uD83D\uDC87", "\uD83D\uDC85", "\uD83D\uDC7b",
            "\uD83D\uDC79", "\uD83D\uDC7a", "\uD83D\uDC7d", "\uD83D\uDC7e", "\uD83D\uDC7f",
            "\uD83D\uDC80", "\uD83D\uDCaa", "\uD83D\uDC40", "\uD83D\uDC42", "\uD83D\uDC43",
            "\uD83D\uDC63", "\uD83D\uDC44", "\uD83D\uDC45", "\uD83D\uDC8b", "\u2764",
            "\uD83D\uDC99", "\uD83D\uDC9a", "\uD83D\uDC9b", "\uD83D\uDC9c", "\uD83D\uDC93",
            "\uD83D\uDC94", "\uD83D\uDC95", "\uD83D\uDC96", "\uD83D\uDC97", "\uD83D\uDC98",
            "\uD83D\uDC9d", "\uD83D\uDC9e", "\uD83D\uDC9f", "\uD83D\uDC4d", "\uD83D\uDC4e",
            "\uD83D\uDC4c", "\u270a", "\u270c", "\u270b", "\uD83D\uDC4a",
            "\u261d", "\uD83D\uDC46", "\uD83D\uDC47", "\uD83D\uDC48", "\uD83D\uDC49",
            "\uD83D\uDC4b", "\uD83D\uDC4f", "\uD83D\uDC50"
    };

    private static final int[] sIconIds = {
            // people
            R.drawable.emoji_u263a, R.drawable.emoji_u1f60a,  R.drawable.emoji_u1f600, R.drawable.emoji_u1f601, R.drawable.emoji_u1f602,
            R.drawable.emoji_u1f603, R.drawable.emoji_u1f604, R.drawable.emoji_u1f605, R.drawable.emoji_u1f606, R.drawable.emoji_u1f607,
            R.drawable.emoji_u1f608, R.drawable.emoji_u1f609, R.drawable.emoji_u1f62f, R.drawable.emoji_u1f610, R.drawable.emoji_u1f611,
            R.drawable.emoji_u1f615, R.drawable.emoji_u1f620, R.drawable.emoji_u1f62c, R.drawable.emoji_u1f621, R.drawable.emoji_u1f622,
            R.drawable.emoji_u1f634, R.drawable.emoji_u1f62e, R.drawable.emoji_u1f623, R.drawable.emoji_u1f624, R.drawable.emoji_u1f625,
            R.drawable.emoji_u1f626, R.drawable.emoji_u1f627, R.drawable.emoji_u1f628, R.drawable.emoji_u1f629, R.drawable.emoji_u1f630,
            R.drawable.emoji_u1f61f, R.drawable.emoji_u1f631, R.drawable.emoji_u1f632, R.drawable.emoji_u1f633, R.drawable.emoji_u1f635,
            R.drawable.emoji_u1f636, R.drawable.emoji_u1f637, R.drawable.emoji_u1f61e, R.drawable.emoji_u1f612, R.drawable.emoji_u1f60d,
            R.drawable.emoji_u1f61b, R.drawable.emoji_u1f61c, R.drawable.emoji_u1f61d, R.drawable.emoji_u1f60b, R.drawable.emoji_u1f617,
            R.drawable.emoji_u1f619, R.drawable.emoji_u1f618, R.drawable.emoji_u1f61a, R.drawable.emoji_u1f60e, R.drawable.emoji_u1f62d,
            R.drawable.emoji_u1f60c, R.drawable.emoji_u1f616, R.drawable.emoji_u1f614, R.drawable.emoji_u1f62a, R.drawable.emoji_u1f60f,
            R.drawable.emoji_u1f613, R.drawable.emoji_u1f62b, R.drawable.emoji_u1f64b, R.drawable.emoji_u1f64c, R.drawable.emoji_u1f64d,
            R.drawable.emoji_u1f645, R.drawable.emoji_u1f646, R.drawable.emoji_u1f647, R.drawable.emoji_u1f64e, R.drawable.emoji_u1f64f,
            R.drawable.emoji_u1f63a, R.drawable.emoji_u1f63c, R.drawable.emoji_u1f638, R.drawable.emoji_u1f639, R.drawable.emoji_u1f63b,
            R.drawable.emoji_u1f63d, R.drawable.emoji_u1f63f, R.drawable.emoji_u1f63e, R.drawable.emoji_u1f640, R.drawable.emoji_u1f648,
            R.drawable.emoji_u1f649, R.drawable.emoji_u1f64a, R.drawable.emoji_u1f4a9, R.drawable.emoji_u1f476, R.drawable.emoji_u1f466,
            R.drawable.emoji_u1f467, R.drawable.emoji_u1f468, R.drawable.emoji_u1f469, R.drawable.emoji_u1f474, R.drawable.emoji_u1f475,
            R.drawable.emoji_u1f48f, R.drawable.emoji_u1f491, R.drawable.emoji_u1f46a, R.drawable.emoji_u1f46b, R.drawable.emoji_u1f46c,
            R.drawable.emoji_u1f46d, R.drawable.emoji_u1f464, R.drawable.emoji_u1f465, R.drawable.emoji_u1f46e, R.drawable.emoji_u1f477,
            R.drawable.emoji_u1f481, R.drawable.emoji_u1f482, R.drawable.emoji_u1f46f, R.drawable.emoji_u1f470, R.drawable.emoji_u1f478,
            R.drawable.emoji_u1f385, R.drawable.emoji_u1f47c, R.drawable.emoji_u1f471, R.drawable.emoji_u1f472, R.drawable.emoji_u1f473,
            R.drawable.emoji_u1f483, R.drawable.emoji_u1f486, R.drawable.emoji_u1f487, R.drawable.emoji_u1f485, R.drawable.emoji_u1f47b,
            R.drawable.emoji_u1f479, R.drawable.emoji_u1f47a, R.drawable.emoji_u1f47d, R.drawable.emoji_u1f47e, R.drawable.emoji_u1f47f,
            R.drawable.emoji_u1f480, R.drawable.emoji_u1f4aa, R.drawable.emoji_u1f440, R.drawable.emoji_u1f442, R.drawable.emoji_u1f443,
            R.drawable.emoji_u1f463, R.drawable.emoji_u1f444, R.drawable.emoji_u1f445, R.drawable.emoji_u1f48b, R.drawable.emoji_u2764,
            R.drawable.emoji_u1f499, R.drawable.emoji_u1f49a, R.drawable.emoji_u1f49b, R.drawable.emoji_u1f49c, R.drawable.emoji_u1f493,
            R.drawable.emoji_u1f494, R.drawable.emoji_u1f495, R.drawable.emoji_u1f496, R.drawable.emoji_u1f497, R.drawable.emoji_u1f498,
            R.drawable.emoji_u1f49d, R.drawable.emoji_u1f49e, R.drawable.emoji_u1f49f, R.drawable.emoji_u1f44d, R.drawable.emoji_u1f44e,
            R.drawable.emoji_u1f44c, R.drawable.emoji_u270a, R.drawable.emoji_u270c, R.drawable.emoji_u270b, R.drawable.emoji_u1f44a,
            R.drawable.emoji_u261d, R.drawable.emoji_u1f446, R.drawable.emoji_u1f447, R.drawable.emoji_u1f448, R.drawable.emoji_u1f449,
            R.drawable.emoji_u1f44b, R.drawable.emoji_u1f44f, R.drawable.emoji_u1f450
    };
}