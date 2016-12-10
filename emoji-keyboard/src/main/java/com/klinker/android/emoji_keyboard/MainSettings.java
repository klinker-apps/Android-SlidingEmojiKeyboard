package com.klinker.android.emoji_keyboard;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.klinker.android.emoji_keyboard_trial.R;

public class MainSettings extends PreferenceActivity {

    public static final String CHANGE_ICON_SET_KEY = EmojiKeyboardService.getStaticApplicationContext()
                                                        .getString(R.string.setting_change_icon_set_key);
    public static final String CHANGE_ICON_SET_VALUE_GOOGLE = EmojiKeyboardService.getStaticApplicationContext()
                                                        .getString(R.string.setting_change_icon_set_value_google);
    public static final String CHANGE_ICON_SET_VALUE_DEFAULT = CHANGE_ICON_SET_VALUE_GOOGLE;
    public static final String CHANGE_ICON_SET_VALUE_APPLE = EmojiKeyboardService.getStaticApplicationContext()
                                                        .getString(R.string.setting_change_icon_set_value_apple);

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
