package com.klinker.android.emoji_keyboard_ios.emoji_pager.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.klinker.android.emoji_keyboard_ios.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard_trial_ios.R;

public class OtherEmojiAdapter extends BaseEmojiAdapter {

    public OtherEmojiAdapter(Context context) {
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
            // other
            "\uD83D\uDD1d", "\uD83D\uDD19", "\uD83D\uDD1b", "\uD83D\uDD1c", "\uD83D\uDD1a",
            "\u23f3", "\u231b", "\u23f0", "\u2648", "\u2649",
            "\u264a", "\u264b", "\u264c", "\u264d", "\u264e",
            "\u264f", "\u2650", "\u2651", "\u2652", "\u2653",
            "\uD83D\uDD31", "\uD83D\uDD2f", "\uD83D\uDEbb", "\uD83D\uDEae",
            "\uD83D\uDEaf", "\uD83D\uDEb0", "\uD83D\uDEb1", "\uD83C\uDD70", "\uD83C\uDD71",
            "\uD83C\uDD8e", "\uD83C\uDD7e", "\uD83D\uDCae", "\uD83D\uDCaf", "\uD83D\uDD20",
            "\uD83D\uDD21", "\uD83D\uDD22", "\uD83D\uDD23", "\uD83D\uDD24", "\u27bf",
            "\uD83D\uDCf6", "\uD83D\uDCf3", "\uD83D\uDCf4", "\uD83D\uDCf5", "\uD83D\uDEb9",
            "\uD83D\uDEba", "\uD83D\uDEbc", "\u267f", "\u267b", "\uD83D\uDEad",
            "\uD83D\uDEa9", "\u26a0", "\uD83C\uDE01", "\uD83D\uDD1e", "\u26d4",
            "\uD83C\uDD92", "\uD83C\uDD97", "\uD83C\uDD95", "\uD83C\uDD98", "\uD83C\uDD99",
            "\uD83C\uDD93", "\uD83C\uDD96", "\uD83C\uDD9a", "\uD83C\uDE32", "\uD83C\uDE33",
            "\uD83C\uDE34", "\uD83C\uDE35", "\uD83C\uDE36", "\uD83C\uDE37", "\uD83C\uDE38",
            "\uD83C\uDE39", "\uD83C\uDE02", "\uD83C\uDE3a", "\uD83C\uDE50", "\uD83C\uDE51",
            "\u3299", "\u00ae", "\u00a9", "\u2122", "\uD83C\uDE1a",
            "\uD83C\uDE2f", "\u3297", "\u2b55", "\u274c", "\u274e",
            "\u2139", "\uD83D\uDEab", "\u2705", "\u2714", "\uD83D\uDD17",
            "\u2734", "\u2795", "\u2796", "\u2716",
            "\u2797", "\uD83D\uDCa0", "\uD83D\uDCa1", "\uD83D\uDCa4", "\uD83D\uDCa2",
            "\uD83D\uDD25", "\uD83D\uDCa5", "\uD83D\uDCa6", "\uD83D\uDCa8", "\uD83D\uDCab",
            "\uD83D\uDD5b", "\uD83D\uDD67", "\uD83D\uDD50", "\uD83D\uDD5c", "\uD83D\uDD51",
            "\uD83D\uDD5d", "\uD83D\uDD52", "\uD83D\uDD5e", "\uD83D\uDD53", "\uD83D\uDD5f",
            "\uD83D\uDD54", "\uD83D\uDD60", "\uD83D\uDD54", "\uD83D\uDD61", "\uD83D\uDD56",
            "\uD83D\uDD62", "\uD83D\uDD57", "\uD83D\uDD63", "\uD83D\uDD58", "\uD83D\uDD64",
            "\uD83D\uDD59", "\uD83D\uDD65", "\uD83D\uDD5a", "\uD83D\uDD66", "\u2195",
            "\u2b06", "\u2197", "\u27a1", "\u2198", "\u2b07",
            "\u2199", "\u2b05", "\u2196", "\u2194", "\u2934",
            "\u2935", "\u23ea", "\u23e9", "\u23eb", "\u23ec",
            "\u25c0", "\u25b6", "\uD83D\uDD3d", "\uD83D\uDD3c", "\u2747",
            "\u2728", "\uD83D\uDD34", "\uD83D\uDD35", "\u26aa", "\u26ab",
            "\uD83D\uDD33", "\uD83D\uDD32", "\u2b50", "\uD83C\uDF1f", "\uD83C\uDF20",
            "\u25ab", "\u25aa", "\u25fd", "\u25fe", "\u25fc",
            "\u25fb", "\u2b1b", "\u2b1c", "\uD83D\uDD39", "\uD83D\uDD38",
            "\uD83D\uDD37", "\uD83D\uDD36", "\uD83D\uDD3a", "\uD83D\uDD3b", "\uD83D\uDD1f",
            "\u2754", "\u2753", "\u2755", "\u2757",
            "\u203c", "\u2049", "\u3030", "\u27b0", "\u2660",
            "\u2665", "\u2663", "\u2666", "\uD83C\uDD94", "\uD83D\uDD11",
            "\u21a9", "\uD83C\uDD91", "\uD83D\uDD0d", "\uD83D\uDD12", "\uD83D\uDD13",
            "\u21aa", "\uD83D\uDD10", "\u2611", "\uD83D\uDD18", "\uD83D\uDD0e",
            "\uD83D\uDD16", "\uD83D\uDD0f", "\uD83D\uDD03", "\uD83D\uDD00", "\uD83D\uDD01",
            "\uD83D\uDD02", "\uD83D\uDD04", "\uD83D\uDCe7", "\uD83D\uDD05", "\uD83D\uDD06",
            "\uD83D\uDD07", "\uD83D\uDD08", "\uD83D\uDD09"
    };

    private static final int[] sIconIds = {
            // other
            R.drawable.emoji_u1f51d, R.drawable.emoji_u1f519, R.drawable.emoji_u1f51b, R.drawable.emoji_u1f51c, R.drawable.emoji_u1f51a,
            R.drawable.emoji_u23f3, R.drawable.emoji_u231b, R.drawable.emoji_u23f0, R.drawable.emoji_u2648, R.drawable.emoji_u2649,
            R.drawable.emoji_u264a, R.drawable.emoji_u264b, R.drawable.emoji_u264c, R.drawable.emoji_u264d, R.drawable.emoji_u264e,
            R.drawable.emoji_u264f, R.drawable.emoji_u2650, R.drawable.emoji_u2651, R.drawable.emoji_u2652, R.drawable.emoji_u2653,
            R.drawable.emoji_u1f531, R.drawable.emoji_u1f52f, R.drawable.emoji_u1f6bb, R.drawable.emoji_u1f6ae,
            R.drawable.emoji_u1f6af, R.drawable.emoji_u1f6b0, R.drawable.emoji_u1f6b1, R.drawable.emoji_u1f170, R.drawable.emoji_u1f171,
            R.drawable.emoji_u1f18e, R.drawable.emoji_u1f17e, R.drawable.emoji_u1f4ae, R.drawable.emoji_u1f4af, R.drawable.emoji_u1f520,
            R.drawable.emoji_u1f521, R.drawable.emoji_u1f522, R.drawable.emoji_u1f523, R.drawable.emoji_u1f524, R.drawable.emoji_u27bf,
            R.drawable.emoji_u1f4f6, R.drawable.emoji_u1f4f3, R.drawable.emoji_u1f4f4, R.drawable.emoji_u1f4f5, R.drawable.emoji_u1f6b9,
            R.drawable.emoji_u1f6ba, R.drawable.emoji_u1f6bc, R.drawable.emoji_u267f, R.drawable.emoji_u267b, R.drawable.emoji_u1f6ad,
            R.drawable.emoji_u1f6a9, R.drawable.emoji_u26a0, R.drawable.emoji_u1f201, R.drawable.emoji_u1f51e, R.drawable.emoji_u26d4,
            R.drawable.emoji_u1f192, R.drawable.emoji_u1f197, R.drawable.emoji_u1f195, R.drawable.emoji_u1f198, R.drawable.emoji_u1f199,
            R.drawable.emoji_u1f193, R.drawable.emoji_u1f196, R.drawable.emoji_u1f19a, R.drawable.emoji_u1f232, R.drawable.emoji_u1f233,
            R.drawable.emoji_u1f234, R.drawable.emoji_u1f235, R.drawable.emoji_u1f236, R.drawable.emoji_u1f237, R.drawable.emoji_u1f238,
            R.drawable.emoji_u1f239, R.drawable.emoji_u1f202, R.drawable.emoji_u1f23a, R.drawable.emoji_u1f250, R.drawable.emoji_u1f251,
            R.drawable.emoji_u3299, R.drawable.emoji_u00ae, R.drawable.emoji_u00a9, R.drawable.emoji_u2122, R.drawable.emoji_u1f21a,
            R.drawable.emoji_u1f22f, R.drawable.emoji_u3297, R.drawable.emoji_u2b55, R.drawable.emoji_u274c, R.drawable.emoji_u274e,
            R.drawable.emoji_u2139, R.drawable.emoji_u1f6ab, R.drawable.emoji_u2705, R.drawable.emoji_u2714, R.drawable.emoji_u1f517,
            R.drawable.emoji_u2734, R.drawable.emoji_u2795, R.drawable.emoji_u2796, R.drawable.emoji_u2716,
            R.drawable.emoji_u2797, R.drawable.emoji_u1f4a0, R.drawable.emoji_u1f4a1, R.drawable.emoji_u1f4a4, R.drawable.emoji_u1f4a2,
            R.drawable.emoji_u1f525, R.drawable.emoji_u1f4a5, R.drawable.emoji_u1f4a6, R.drawable.emoji_u1f4a8, R.drawable.emoji_u1f4ab,
            R.drawable.emoji_u1f55b, R.drawable.emoji_u1f567, R.drawable.emoji_u1f550, R.drawable.emoji_u1f55c, R.drawable.emoji_u1f551,
            R.drawable.emoji_u1f55d, R.drawable.emoji_u1f552, R.drawable.emoji_u1f55e, R.drawable.emoji_u1f553, R.drawable.emoji_u1f55f,
            R.drawable.emoji_u1f554, R.drawable.emoji_u1f560, R.drawable.emoji_u1f555, R.drawable.emoji_u1f561, R.drawable.emoji_u1f556,
            R.drawable.emoji_u1f562, R.drawable.emoji_u1f557, R.drawable.emoji_u1f563, R.drawable.emoji_u1f558, R.drawable.emoji_u1f564,
            R.drawable.emoji_u1f559, R.drawable.emoji_u1f565, R.drawable.emoji_u1f55a, R.drawable.emoji_u1f566, R.drawable.emoji_u2195,
            R.drawable.emoji_u2b06, R.drawable.emoji_u2197, R.drawable.emoji_u27a1, R.drawable.emoji_u2198, R.drawable.emoji_u2b07,
            R.drawable.emoji_u2199, R.drawable.emoji_u2b05, R.drawable.emoji_u2196, R.drawable.emoji_u2194, R.drawable.emoji_u2934,
            R.drawable.emoji_u2935, R.drawable.emoji_u23ea, R.drawable.emoji_u23e9, R.drawable.emoji_u23eb, R.drawable.emoji_u23ec,
            R.drawable.emoji_u25c0, R.drawable.emoji_u25b6, R.drawable.emoji_u1f53d, R.drawable.emoji_u1f53c, R.drawable.emoji_u2747,
            R.drawable.emoji_u2728, R.drawable.emoji_u1f534, R.drawable.emoji_u1f535, R.drawable.emoji_u26aa, R.drawable.emoji_u26ab,
            R.drawable.emoji_u1f533, R.drawable.emoji_u1f532, R.drawable.emoji_u2b50, R.drawable.emoji_u1f31f, R.drawable.emoji_u1f320,
            R.drawable.emoji_u25ab, R.drawable.emoji_u25aa, R.drawable.emoji_u25fd, R.drawable.emoji_u25fe, R.drawable.emoji_u25fc,
            R.drawable.emoji_u25fb, R.drawable.emoji_u2b1b, R.drawable.emoji_u2b1c, R.drawable.emoji_u1f539, R.drawable.emoji_u1f538,
            R.drawable.emoji_u1f537, R.drawable.emoji_u1f536, R.drawable.emoji_u1f53a, R.drawable.emoji_u1f53b, R.drawable.emoji_u1f51f,
            R.drawable.emoji_u2754, R.drawable.emoji_u2753, R.drawable.emoji_u2755, R.drawable.emoji_u2757,
            R.drawable.emoji_u203c, R.drawable.emoji_u2049, R.drawable.emoji_u3030, R.drawable.emoji_u27b0, R.drawable.emoji_u2660,
            R.drawable.emoji_u2665, R.drawable.emoji_u2663, R.drawable.emoji_u2666, R.drawable.emoji_u1f194, R.drawable.emoji_u1f511,
            R.drawable.emoji_u21a9, R.drawable.emoji_u1f191, R.drawable.emoji_u1f50d, R.drawable.emoji_u1f512, R.drawable.emoji_u1f513,
            R.drawable.emoji_u21aa, R.drawable.emoji_u1f510, R.drawable.emoji_u2611, R.drawable.emoji_u1f518, R.drawable.emoji_u1f50e,
            R.drawable.emoji_u1f516, R.drawable.emoji_u1f50f, R.drawable.emoji_u1f503, R.drawable.emoji_u1f500, R.drawable.emoji_u1f501,
            R.drawable.emoji_u1f502, R.drawable.emoji_u1f504, R.drawable.emoji_u1f4e7, R.drawable.emoji_u1f505, R.drawable.emoji_u1f506,
            R.drawable.emoji_u1f507, R.drawable.emoji_u1f508, R.drawable.emoji_u1f509
    };
}