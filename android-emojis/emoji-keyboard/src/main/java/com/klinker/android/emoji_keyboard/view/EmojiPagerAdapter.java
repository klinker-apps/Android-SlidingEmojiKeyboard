package com.klinker.android.emoji_keyboard.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.klinker.android.emoji_keyboard.EmojiKeyboardInputMethodServiceAdapter;
import com.klinker.android.emoji_keyboard.EmojiKeyboardService;
import com.klinker.android.emoji_keyboard.constants.EmojiIcons;
import com.klinker.android.emoji_keyboard.constants.EmojiTexts;
import com.klinker.android.emoji_keyboard.adapter.RecentEmojiAdapter;
import com.klinker.android.emoji_keyboard.adapter.StaticEmojiAdapter;

import java.util.ArrayList;

public class EmojiPagerAdapter extends PagerAdapter {

    public final String[] TITLES = { "recent",
                                    "people",
                                    "things",
                                    "nature",
                                    "places",
                                    "symbols" };

    private ViewPager pager;
    private ArrayList<View> pages;

    public EmojiPagerAdapter(Context context, ViewPager pager) {
        super();

        this.pager = pager;
        this.pages = new ArrayList<View>();

        pages.add(new KeyboardSinglePageView(context, new RecentEmojiAdapter(context, EmojiKeyboardInputMethodServiceAdapter.getFrequentlyUsedEmojiList())).getView());
        pages.add(new KeyboardSinglePageView(context, new StaticEmojiAdapter(context, EmojiTexts.peopleEmojiTexts, EmojiIcons.peopleIconIds)).getView());
        pages.add(new KeyboardSinglePageView(context, new StaticEmojiAdapter(context, EmojiTexts.thingsEmojiTexts, EmojiIcons.thingsIconIds)).getView());
        pages.add(new KeyboardSinglePageView(context, new StaticEmojiAdapter(context, EmojiTexts.natureEmojiTexts, EmojiIcons.natureIconIds)).getView());
        pages.add(new KeyboardSinglePageView(context, new StaticEmojiAdapter(context, EmojiTexts.transEmojiTexts, EmojiIcons.transIconIds)).getView());
        pages.add(new KeyboardSinglePageView(context, new StaticEmojiAdapter(context, EmojiTexts.otherEmojiTexts, EmojiIcons.otherIconIds)).getView());

    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        pager.addView(pages.get(position), position, EmojiKeyboardService.getKeyboardHeight());
        return pages.get(position);
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {
        pager.removeView(pages.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}