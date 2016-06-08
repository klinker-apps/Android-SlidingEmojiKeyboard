package com.klinker.android.emoji_keyboard;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.klinker.android.emoji_keyboard_trial.R;

/**
 * Created by luke on 10/16/13.
 */
public class MainSettings extends PreferenceActivity {

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
