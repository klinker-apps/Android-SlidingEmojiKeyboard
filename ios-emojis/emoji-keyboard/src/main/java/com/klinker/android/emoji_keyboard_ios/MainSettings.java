package com.klinker.android.emoji_keyboard_ios;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.klinker.android.emoji_keyboard_trial_ios.R;

public class MainSettings extends PreferenceActivity {

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
