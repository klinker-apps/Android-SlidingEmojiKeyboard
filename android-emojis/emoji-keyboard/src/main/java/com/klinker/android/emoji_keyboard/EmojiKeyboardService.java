package com.klinker.android.emoji_keyboard;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import com.klinker.android.emoji_keyboard.view.EmojiKeyboardView;
import com.klinker.android.emoji_keyboard.sqlite.EmojiDataSource;
import com.klinker.android.emoji_keyboard.sqlite.Recent;
import com.klinker.android.emoji_keyboard_trial.R;

import java.util.ArrayList;

public class EmojiKeyboardService extends InputMethodService {


    private EmojiKeyboardView emojiKeyboardView;


    public static int keyboardHeight;

    private static InputConnection inputConnection;

    private static EmojiDataSource dataSource;
    private static ArrayList<Recent> frequentlyUsedEmojiList;

    public static ArrayList<Recent> getFrequentlyUsedEmojiList() {
        return frequentlyUsedEmojiList;
    }

    public static int getKeyboardHeight() {
        return keyboardHeight;
    }

    public EmojiKeyboardService() {
        super();

        if (Build.VERSION.SDK_INT >= 17) {
            enableHardwareAcceleration();
        }
    }

    @Override
    public View onCreateInputView() {

        dataSource = new EmojiDataSource(this);
        dataSource.open();
        frequentlyUsedEmojiList = (ArrayList<Recent>) dataSource.getAllRecents();

        Display d = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        keyboardHeight = (int) (d.getHeight()/3.0);

        emojiKeyboardView = (EmojiKeyboardView) getLayoutInflater()
                                                .inflate(R.layout.emoji_keyboard_layout, null);

        return emojiKeyboardView.getView();
    }


    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInputView(attribute, restarting);
        inputConnection = getCurrentInputConnection();
    }

    @Override
    public void onFinishInput() {
        super.onFinishInput();

        try {
            dataSource.close();
        } catch (Exception e) {
            // something wrong with db?
        }
    }

    public static void addText(String emoji, int icon) {
        inputConnection.commitText(emoji, 1);

        for (int i = 0; i < frequentlyUsedEmojiList.size(); i++) {
            if (frequentlyUsedEmojiList.get(i).text.equals(emoji)) {
                dataSource.updateRecent(icon + "");
                frequentlyUsedEmojiList.get(i).count++;
                return;
            }
        }

        Recent recent = dataSource.createRecent(emoji, icon + "");

        if (recent != null) {
            frequentlyUsedEmojiList.add(recent);
        }
    }

    public void removeText() {
        sendDownAndUpKeyEvent(KeyEvent.KEYCODE_DEL, 0);
    }

    public static void removeRecent(int position) {
        dataSource.deleteRecent(frequentlyUsedEmojiList.get(position).id);
        frequentlyUsedEmojiList.remove(position);
        EmojiKeyboardView.notifyDataSetChanged();
    }

    public void sendDownKeyEvent(int keyEventCode, int flags) {
        inputConnection.sendKeyEvent(
                new KeyEvent(
                        SystemClock.uptimeMillis(),
                        SystemClock.uptimeMillis(),
                        KeyEvent.ACTION_DOWN,
                        keyEventCode,
                        0,
                        flags
                )
        );
    }

    public void sendUpKeyEvent(int keyEventCode, int flags) {
        inputConnection.sendKeyEvent(
                new KeyEvent(
                        SystemClock.uptimeMillis(),
                        SystemClock.uptimeMillis(),
                        KeyEvent.ACTION_UP,
                        keyEventCode,
                        0,
                        flags
                )
        );
    }
    public void sendDownAndUpKeyEvent(int keyEventCode, int flags){
        sendDownKeyEvent(keyEventCode, flags);
        sendUpKeyEvent(keyEventCode, flags);
    }


}
