package com.klinker.android.emoji_keyboard_ios.emoji_pager.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.klinker.android.emoji_keyboard_ios.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard_trial_ios.R;

public class ThingsEmojiAdapter extends BaseEmojiAdapter {

    public ThingsEmojiAdapter(Context context) {
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
            //things
            "\uD83D\uDD30", "\uD83D\uDC84", "\uD83D\uDC5e", "\uD83D\uDC5f", "\uD83D\uDC51",
            "\uD83D\uDC52", "\uD83C\uDFa9", "\uD83C\uDF93", "\uD83D\uDC53", "\u231a",
            "\uD83D\uDC54", "\uD83D\uDC55", "\uD83D\uDC56", "\uD83D\uDC57", "\uD83D\uDC58",
            "\uD83D\uDC59", "\uD83D\uDC60", "\uD83D\uDC61", "\uD83D\uDC62", "\uD83D\uDC5a",
            "\uD83D\uDC5c", "\uD83D\uDCbc", "\uD83C\uDF92", "\uD83D\uDC5d", "\uD83D\uDC5b",
            "\uD83D\uDCb0", "\uD83D\uDCb3", "\uD83D\uDCb2", "\uD83D\uDCb5", "\uD83D\uDCb4",
            "\uD83D\uDCb6", "\uD83D\uDCb7", "\uD83D\uDCb1", "\uD83D\uDCb8", "\uD83D\uDCb9",
            "\uD83D\uDD2b", "\uD83D\uDD2a", "\uD83D\uDCa3", "\uD83D\uDC89", "\uD83D\uDC8a",
            "\uD83D\uDEac", "\uD83D\uDD14", "\uD83D\uDD15", "\uD83D\uDEaa", "\uD83D\uDD2c",
            "\uD83D\uDD2d", "\uD83D\uDD2e", "\uD83D\uDD26", "\uD83D\uDD0b", "\uD83D\uDD0c",
            "\uD83D\uDCdc", "\uD83D\uDCd7", "\uD83D\uDCd8", "\uD83D\uDCd9", "\uD83D\uDCda",
            "\uD83D\uDCd4", "\uD83D\uDCd2", "\uD83D\uDCd1", "\uD83D\uDCd3", "\uD83D\uDCd5",
            "\uD83D\uDCd6", "\uD83D\uDCf0", "\uD83D\uDCdb", "\uD83C\uDF83", "\uD83C\uDF84",
            "\uD83C\uDF80", "\uD83C\uDF81", "\uD83C\uDF82", "\uD83C\uDF88", "\uD83C\uDF86",
            "\uD83C\uDF87", "\uD83C\uDF89", "\uD83C\uDF8a", "\uD83C\uDF8d", "\uD83C\uDF8f",
            "\uD83C\uDF8c", "\uD83C\uDF90", "\uD83C\uDF8b", "\uD83C\uDF8e", "\uD83D\uDCf1",
            "\uD83D\uDCf2", "\uD83D\uDCdf", "\u260e", "\uD83D\uDCde", "\uD83D\uDCe0",
            "\uD83D\uDCe6", "\u2709", "\uD83D\uDCe8", "\uD83D\uDCe9", "\uD83D\uDCea",
            "\uD83D\uDCeb", "\uD83D\uDCed", "\uD83D\uDCec", "\uD83D\uDCee", "\uD83D\uDCe4",
            "\uD83D\uDCe5", "\uD83D\uDCef", "\uD83D\uDCe3", "\uD83D\uDCe2", "\uD83D\uDCe1",
            "\uD83D\uDCac", "\uD83D\uDCad", "\u2712", "\u270f", "\uD83D\uDCdd",
            "\uD83D\uDCcf", "\uD83D\uDCd0", "\uD83D\uDCcd", "\uD83D\uDCcc", "\uD83D\uDCce",
            "\u2702", "\uD83D\uDCba", "\uD83D\uDCbb", "\uD83D\uDCbd", "\uD83D\uDCbe",
            "\uD83D\uDCbf", "\uD83D\uDCc6", "\uD83D\uDCc5", "\uD83D\uDCc7", "\uD83D\uDCcb",
            "\uD83D\uDCc1", "\uD83D\uDCc2", "\uD83D\uDCc3", "\uD83D\uDCc4", "\uD83D\uDCca",
            "\uD83D\uDCc8", "\uD83D\uDCc9", "\u26fa", "\uD83C\uDFa1", "\uD83C\uDFa1",
            "\uD83C\uDFa0", "\uD83C\uDFaa", "\uD83C\uDFa8", "\uD83C\uDFac", "\uD83C\uDFa5",
            "\uD83D\uDCf7", "\uD83D\uDCf9", "\uD83C\uDFad", "\uD83C\uDFab",
            "\uD83C\uDFae", "\uD83C\uDFb2", "\uD83C\uDFb0", "\uD83C\uDCCF", "\uD83C\uDFb4",
            "\uD83C\uDC04", "\uD83C\uDFaf", "\uD83D\uDCfa", "\uD83D\uDCfb", "\uD83D\uDCc0",
            "\uD83D\uDCfc", "\uD83C\uDFa7", "\uD83C\uDFa4", "\uD83C\uDFb5", "\uD83C\uDFb6",
            "\uD83C\uDFbc", "\uD83C\uDFbb", "\uD83C\uDFb9", "\uD83C\uDFb7", "\uD83C\uDFba",
            "\uD83C\uDFb8", "\u303d"
    };

    private static final int[] sIconIds = {
            //things
            R.drawable.emoji_u1f530, R.drawable.emoji_u1f484, R.drawable.emoji_u1f45e, R.drawable.emoji_u1f45f, R.drawable.emoji_u1f451,
            R.drawable.emoji_u1f452, R.drawable.emoji_u1f3a9, R.drawable.emoji_u1f393, R.drawable.emoji_u1f453, R.drawable.emoji_u231a,
            R.drawable.emoji_u1f454, R.drawable.emoji_u1f455, R.drawable.emoji_u1f456, R.drawable.emoji_u1f457, R.drawable.emoji_u1f458,
            R.drawable.emoji_u1f459, R.drawable.emoji_u1f460, R.drawable.emoji_u1f461, R.drawable.emoji_u1f462, R.drawable.emoji_u1f45a,
            R.drawable.emoji_u1f45c, R.drawable.emoji_u1f4bc, R.drawable.emoji_u1f392, R.drawable.emoji_u1f45d, R.drawable.emoji_u1f45b,
            R.drawable.emoji_u1f4b0, R.drawable.emoji_u1f4b3, R.drawable.emoji_u1f4b2, R.drawable.emoji_u1f4b5, R.drawable.emoji_u1f4b4,
            R.drawable.emoji_u1f4b6, R.drawable.emoji_u1f4b7, R.drawable.emoji_u1f4b1, R.drawable.emoji_u1f4b8, R.drawable.emoji_u1f4b9,
            R.drawable.emoji_u1f52b, R.drawable.emoji_u1f52a, R.drawable.emoji_u1f4a3, R.drawable.emoji_u1f489, R.drawable.emoji_u1f48a,
            R.drawable.emoji_u1f6ac, R.drawable.emoji_u1f514, R.drawable.emoji_u1f515, R.drawable.emoji_u1f6aa, R.drawable.emoji_u1f52c,
            R.drawable.emoji_u1f52d, R.drawable.emoji_u1f52e, R.drawable.emoji_u1f526, R.drawable.emoji_u1f50b, R.drawable.emoji_u1f50c,
            R.drawable.emoji_u1f4dc, R.drawable.emoji_u1f4d7, R.drawable.emoji_u1f4d8, R.drawable.emoji_u1f4d9, R.drawable.emoji_u1f4da,
            R.drawable.emoji_u1f4d4, R.drawable.emoji_u1f4d2, R.drawable.emoji_u1f4d1, R.drawable.emoji_u1f4d3, R.drawable.emoji_u1f4d5,
            R.drawable.emoji_u1f4d6, R.drawable.emoji_u1f4f0, R.drawable.emoji_u1f4db, R.drawable.emoji_u1f383, R.drawable.emoji_u1f384,
            R.drawable.emoji_u1f380, R.drawable.emoji_u1f381, R.drawable.emoji_u1f382, R.drawable.emoji_u1f388, R.drawable.emoji_u1f386,
            R.drawable.emoji_u1f387, R.drawable.emoji_u1f389, R.drawable.emoji_u1f38a, R.drawable.emoji_u1f38d, R.drawable.emoji_u1f38f,
            R.drawable.emoji_u1f38c, R.drawable.emoji_u1f390, R.drawable.emoji_u1f38b, R.drawable.emoji_u1f38e, R.drawable.emoji_u1f4f1,
            R.drawable.emoji_u1f4f2, R.drawable.emoji_u1f4df, R.drawable.emoji_u260e, R.drawable.emoji_u1f4de, R.drawable.emoji_u1f4e0,
            R.drawable.emoji_u1f4e6, R.drawable.emoji_u2709, R.drawable.emoji_u1f4e8, R.drawable.emoji_u1f4e9, R.drawable.emoji_u1f4ea,
            R.drawable.emoji_u1f4eb, R.drawable.emoji_u1f4ed, R.drawable.emoji_u1f4ec, R.drawable.emoji_u1f4ee, R.drawable.emoji_u1f4e4,
            R.drawable.emoji_u1f4e5, R.drawable.emoji_u1f4ef, R.drawable.emoji_u1f4e3, R.drawable.emoji_u1f4e2, R.drawable.emoji_u1f4e1,
            R.drawable.emoji_u1f4ac, R.drawable.emoji_u1f4ad, R.drawable.emoji_u2712, R.drawable.emoji_u270f, R.drawable.emoji_u1f4dd,
            R.drawable.emoji_u1f4cf, R.drawable.emoji_u1f4d0, R.drawable.emoji_u1f4cd, R.drawable.emoji_u1f4cc, R.drawable.emoji_u1f4ce,
            R.drawable.emoji_u2702, R.drawable.emoji_u1f4ba, R.drawable.emoji_u1f4bb, R.drawable.emoji_u1f4bd, R.drawable.emoji_u1f4be,
            R.drawable.emoji_u1f4bf, R.drawable.emoji_u1f4c6, R.drawable.emoji_u1f4c5, R.drawable.emoji_u1f4c7, R.drawable.emoji_u1f4cb,
            R.drawable.emoji_u1f4c1, R.drawable.emoji_u1f4c2, R.drawable.emoji_u1f4c3, R.drawable.emoji_u1f4c4, R.drawable.emoji_u1f4ca,
            R.drawable.emoji_u1f4c8, R.drawable.emoji_u1f4c9, R.drawable.emoji_u26fa, R.drawable.emoji_u1f3a1, R.drawable.emoji_u1f3a2,
            R.drawable.emoji_u1f3a0, R.drawable.emoji_u1f3aa, R.drawable.emoji_u1f3a8, R.drawable.emoji_u1f3ac, R.drawable.emoji_u1f3a5,
            R.drawable.emoji_u1f4f7, R.drawable.emoji_u1f4f9, R.drawable.emoji_u1f3ad, R.drawable.emoji_u1f3ab,
            R.drawable.emoji_u1f3ae, R.drawable.emoji_u1f3b2, R.drawable.emoji_u1f3b0, R.drawable.emoji_u1f0cf, R.drawable.emoji_u1f3b4,
            R.drawable.emoji_u1f004, R.drawable.emoji_u1f3af, R.drawable.emoji_u1f4fa, R.drawable.emoji_u1f4fb, R.drawable.emoji_u1f4c0,
            R.drawable.emoji_u1f4fc, R.drawable.emoji_u1f3a7, R.drawable.emoji_u1f3a4, R.drawable.emoji_u1f3b5, R.drawable.emoji_u1f3b6,
            R.drawable.emoji_u1f3bc, R.drawable.emoji_u1f3bb, R.drawable.emoji_u1f3b9, R.drawable.emoji_u1f3b7, R.drawable.emoji_u1f3ba,
            R.drawable.emoji_u1f3b8, R.drawable.emoji_u303d
    };
}