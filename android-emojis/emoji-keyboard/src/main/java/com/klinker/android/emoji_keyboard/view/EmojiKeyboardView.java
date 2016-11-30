package com.klinker.android.emoji_keyboard.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.klinker.android.emoji_keyboard.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard_trial.R;

public class EmojiKeyboardView extends View {

    private ViewPager viewPager;
    private PagerSlidingTabStrip pagerSlidingTabStrip;
    private static EmojiPagerAdapter emojiPagerAdapter;
    private LinearLayout layout;

    private EmojiKeyboardService emojiKeyboardService;

    public EmojiKeyboardView(Context context) {
        super(context);
        initialize(context);
    }

    public EmojiKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public EmojiKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {

        emojiKeyboardService = (EmojiKeyboardService) context;

        LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        layout = (LinearLayout) inflater.inflate(R.layout.keyboard_main, null);

        viewPager = (ViewPager) layout.findViewById(R.id.emojiKeyboard);

        pagerSlidingTabStrip = (PagerSlidingTabStrip) layout.findViewById(R.id.emojiCategorytab);

        pagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.pager_color));

        emojiPagerAdapter = new EmojiPagerAdapter(emojiKeyboardService, viewPager);

        viewPager.setAdapter(emojiPagerAdapter);

        Button delete = (Button) layout.findViewById(R.id.deleteButton);
        delete = setupDeleteButton(delete);
        pagerSlidingTabStrip.setViewPager(viewPager);

        viewPager.setCurrentItem(1);

    }

    public View getView() {
        return layout;
    }

    public static void notifyDataSetChanged() {
        emojiPagerAdapter.notifyDataSetChanged();
    }

    private Button setupDeleteButton( Button delete) {

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emojiKeyboardService.removeText();
            }
        });

        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //do nothing
                return false;
            }
        });
        return delete;
    }


    int width;
    int height;
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        width = View.MeasureSpec.getSize(widthMeasureSpec);
        height = View.MeasureSpec.getSize(heightMeasureSpec);

        Log.d("emojiKeyboardView", width +" : " + height);
        setMeasuredDimension(width, height);
    }
}
