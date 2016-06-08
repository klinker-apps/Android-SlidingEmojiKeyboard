package com.klinker.android.emoji_keyboard.emoji_pager.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.klinker.android.emoji_keyboard.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard_trial.R;

public class TransEmojiAdapter extends BaseEmojiAdapter {

    public TransEmojiAdapter(Context context) {
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
            // transportation
            "\uD83C\uDFE0", "\uD83C\uDFe1", "\uD83C\uDFE2", "\uD83C\uDFE3", "\uD83C\uDFE4",
            "\uD83C\uDFE5", "\uD83C\uDFe6", "\uD83C\uDFE7", "\uD83C\uDFE8", "\uD83C\uDFE9",
            "\uD83C\uDFEa", "\uD83C\uDFeb", "\u26ea", "\u26f2", "\uD83C\uDFEc",
            "\uD83C\uDFEf", "\uD83C\uDFf0", "\uD83C\uDFEd", "\uD83D\uDDFB", "\uD83D\uDDFc",
            "\uD83D\uDC88", "\uD83D\uDD27", "\uD83D\uDD28", "\uD83D\uDD29", "\uD83D\uDEBF",
            "\uD83D\uDEc1", "\uD83D\uDEc0", "\uD83D\uDEbd", "\uD83D\uDEBe", "\uD83C\uDFbd",
            "\uD83C\uDFa3", "\uD83C\uDFb1", "\uD83C\uDFb3", "\u26be", "\u26f3",
            "\uD83C\uDFbe", "\u26bd", "\uD83C\uDFbf", "\uD83C\uDFc0", "\uD83C\uDFc1",
            "\uD83C\uDFc2", "\uD83C\uDFc3", "\uD83C\uDFc4", "\uD83C\uDFc6", "\uD83C\uDFc7",
            "\uD83D\uDC0E", "\uD83C\uDFc8", "\uD83C\uDFc9", "\uD83C\uDFca", "\uD83D\uDE82",
            "\uD83D\uDE83", "\uD83D\uDE84", "\uD83D\uDE85", "\uD83D\uDE86", "\uD83D\uDE87",
            "\u24c2", "\uD83D\uDE88", "\uD83D\uDE8a", "\uD83D\uDE8b", "\uD83D\uDE8c",
            "\uD83D\uDE8d", "\uD83D\uDE8e", "\uD83D\uDE8f", "\uD83D\uDE90", "\uD83D\uDE91",
            "\uD83D\uDE92", "\uD83D\uDE93", "\uD83D\uDE94", "\uD83D\uDE95", "\uD83D\uDE96",
            "\uD83D\uDE97", "\uD83D\uDE98", "\uD83D\uDE99", "\uD83D\uDE9a", "\uD83D\uDE9b",
            "\uD83D\uDE9c", "\uD83D\uDE9d", "\uD83D\uDE9e", "\uD83D\uDE9f", "\uD83D\uDEa0",
            "\uD83D\uDEa1", "\uD83D\uDEa2", "\uD83D\uDEa3", "\uD83D\uDE81", "\u2708",
            "\uD83D\uDEc2", "\uD83D\uDEc3", "\uD83D\uDEc4", "\uD83D\uDEc5", "\u26f5",
            "\uD83D\uDEb2", "\uD83D\uDEb3", "\uD83D\uDEb4", "\uD83D\uDEb5", "\uD83D\uDEb7",
            "\uD83D\uDEb8", "\uD83D\uDE89", "\uD83D\uDE80", "\uD83D\uDEa4", "\uD83D\uDEb6",
            "\u26fd", "\uD83C\uDD7F", "\uD83D\uDEa5", "\uD83D\uDEa6", "\uD83D\uDEa7",
            "\uD83D\uDEa8", "\u2668", "\uD83D\uDC8C", "\uD83D\uDC8d", "\uD83D\uDC8e",
            "\uD83D\uDC90", "\uD83D\uDC92", "\uD83C\uDDEF\uD83C\uDDF5", "\uD83C\uDDFA\uD83C\uDDF8", "\uD83C\uDDEB\uD83C\uDDF7",
            "\uD83C\uDDE9\uD83C\uDDEA", "\uD83C\uDDEE\uD83C\uDDF9", "\uD83C\uDDEC\uD83C\uDDE7", "\uD83C\uDDEA\uD83C\uDDF8", "\uD83C\uDDF7\uD83C\uDDFA",
            "\uD83C\uDDE8\uD83C\uDDF3", "\uD83C\uDDF0\uD83C\uDDF7"
    };

    private static final int[] sIconIds = {
            // transportation
            R.drawable.emoji_u1f3e0, R.drawable.emoji_u1f3e1, R.drawable.emoji_u1f3e2, R.drawable.emoji_u1f3e3, R.drawable.emoji_u1f3e4,
            R.drawable.emoji_u1f3e5, R.drawable.emoji_u1f3e6, R.drawable.emoji_u1f3e7, R.drawable.emoji_u1f3e8, R.drawable.emoji_u1f3e9,
            R.drawable.emoji_u1f3ea, R.drawable.emoji_u1f3eb, R.drawable.emoji_u26ea, R.drawable.emoji_u26f2, R.drawable.emoji_u1f3ec,
            R.drawable.emoji_u1f3ef, R.drawable.emoji_u1f3f0, R.drawable.emoji_u1f3ed, R.drawable.emoji_u1f5fb, R.drawable.emoji_u1f5fc,
            R.drawable.emoji_u1f488, R.drawable.emoji_u1f527, R.drawable.emoji_u1f528, R.drawable.emoji_u1f529, R.drawable.emoji_u1f6bf,
            R.drawable.emoji_u1f6c1, R.drawable.emoji_u1f6c0, R.drawable.emoji_u1f6bd, R.drawable.emoji_u1f6be, R.drawable.emoji_u1f3bd,
            R.drawable.emoji_u1f3a3, R.drawable.emoji_u1f3b1, R.drawable.emoji_u1f3b3, R.drawable.emoji_u26be, R.drawable.emoji_u26f3,
            R.drawable.emoji_u1f3be, R.drawable.emoji_u26bd, R.drawable.emoji_u1f3bf, R.drawable.emoji_u1f3c0, R.drawable.emoji_u1f3c1,
            R.drawable.emoji_u1f3c2, R.drawable.emoji_u1f3c3, R.drawable.emoji_u1f3c4, R.drawable.emoji_u1f3c6, R.drawable.emoji_u1f3c7,
            R.drawable.emoji_u1f40e, R.drawable.emoji_u1f3c8, R.drawable.emoji_u1f3c9, R.drawable.emoji_u1f3ca, R.drawable.emoji_u1f682,
            R.drawable.emoji_u1f683, R.drawable.emoji_u1f684, R.drawable.emoji_u1f685, R.drawable.emoji_u1f686, R.drawable.emoji_u1f687,
            R.drawable.emoji_u24c2, R.drawable.emoji_u1f688, R.drawable.emoji_u1f68a, R.drawable.emoji_u1f68b, R.drawable.emoji_u1f68c,
            R.drawable.emoji_u1f68d, R.drawable.emoji_u1f68e, R.drawable.emoji_u1f68f, R.drawable.emoji_u1f690, R.drawable.emoji_u1f691,
            R.drawable.emoji_u1f692, R.drawable.emoji_u1f693, R.drawable.emoji_u1f694, R.drawable.emoji_u1f695, R.drawable.emoji_u1f696,
            R.drawable.emoji_u1f697, R.drawable.emoji_u1f698, R.drawable.emoji_u1f699, R.drawable.emoji_u1f69a, R.drawable.emoji_u1f69b,
            R.drawable.emoji_u1f69c, R.drawable.emoji_u1f69d, R.drawable.emoji_u1f69e, R.drawable.emoji_u1f69f, R.drawable.emoji_u1f6a0,
            R.drawable.emoji_u1f6a1, R.drawable.emoji_u1f6a2, R.drawable.emoji_u1f6a3, R.drawable.emoji_u1f681, R.drawable.emoji_u2708,
            R.drawable.emoji_u1f6c2, R.drawable.emoji_u1f6c3, R.drawable.emoji_u1f6c4, R.drawable.emoji_u1f6c5, R.drawable.emoji_u26f5,
            R.drawable.emoji_u1f6b2, R.drawable.emoji_u1f6b3, R.drawable.emoji_u1f6b4, R.drawable.emoji_u1f6b5, R.drawable.emoji_u1f6b7,
            R.drawable.emoji_u1f6b8, R.drawable.emoji_u1f689, R.drawable.emoji_u1f680, R.drawable.emoji_u1f6a4, R.drawable.emoji_u1f6b6,
            R.drawable.emoji_u26fd, R.drawable.emoji_u1f17f, R.drawable.emoji_u1f6a5, R.drawable.emoji_u1f6a6, R.drawable.emoji_u1f6a7,
            R.drawable.emoji_u1f6a8, R.drawable.emoji_u2668, R.drawable.emoji_u1f48c, R.drawable.emoji_u1f48d, R.drawable.emoji_u1f48e,
            R.drawable.emoji_u1f490, R.drawable.emoji_u1f492, R.drawable.emoji_ufe4e5, R.drawable.emoji_ufe4e6, R.drawable.emoji_ufe4e7,
            R.drawable.emoji_ufe4e8, R.drawable.emoji_ufe4e9, R.drawable.emoji_ufe4ea, R.drawable.emoji_ufe4eb, R.drawable.emoji_ufe4ec,
            R.drawable.emoji_ufe4ed, R.drawable.emoji_ufe4ee
    };
}