package com.klinker.android.emoji_keyboard_ios;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.inputmethodservice.InputMethodService;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import com.astuetz.PagerSlidingTabStrip;
import com.klinker.android.emoji_keyboard_ios.emoji_pager.KeyboardView;
import com.klinker.android.emoji_keyboard_ios.sqlite.EmojiDataSource;
import com.klinker.android.emoji_keyboard_ios.sqlite.Recent;
import com.klinker.android.emoji_keyboard_trial_ios.R;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class EmojiKeyboardService extends InputMethodService {

    private ViewPager vp;
    private static MyPagerAdapter adapter;
    private PagerSlidingTabStrip tabs;

    private View view1;
    private View view2;

    private boolean unlocked;
    public static int keyboardHeight;

    private static InputConnection ic;

    private static EmojiDataSource dataSource;
    private static ArrayList<Recent> recents;

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
        recents = (ArrayList<Recent>) dataSource.getAllRecents();

        for (int i = 0; i < recents.size(); i++) {
            Log.v("recent_emojis", recents.get(i).id + " " + recents.get(i).count);
        }

        try {
            PackageManager pm = getPackageManager();
            pm.getPackageInfo("com.klinker.android.emoji_keyboard", PackageManager.GET_ACTIVITIES);
            unlocked = true;
        } catch (Exception e) {
            unlocked = checkUnlocked();
        }

        Display d = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        keyboardHeight = (int) (d.getHeight()/3.0);

        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.keyboard_main, null);

        vp = (ViewPager) layout.findViewById(R.id.emojiKeyboard);

        vp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, keyboardHeight));
        tabs = (PagerSlidingTabStrip) layout.findViewById(R.id.tabs);
        tabs.setIndicatorColor(getResources().getColor(R.color.pager_color));

        adapter = new MyPagerAdapter(this, vp);
        vp.setAdapter(adapter);

        tabs.setViewPager(vp);

        vp.setCurrentItem(1);

        ImageButton delete = (ImageButton) layout.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeText();
            }
        });

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        if(sharedPrefs.getString("emoji_keyboard_color", "1").equals("2") || sharedPrefs.getString("emoji_keyboard_color", "1").equals("3")) {


            view1 = layout.findViewById(R.id.view1);
            view1.setVisibility(View.GONE);
            view2 = layout.findViewById(R.id.view2);
            view2.setVisibility(View.GONE);

            if(sharedPrefs.getString("emoji_keyboard_color", "1").equals("2")) {
                tabs.setBackgroundColor(getResources().getColor(android.R.color.black));
                delete.setBackgroundColor(getResources().getColor(android.R.color.black));
            } else {
                tabs.setBackgroundColor(getResources().getColor(R.color.black));
                delete.setBackgroundColor(getResources().getColor(R.color.black));
            }
        }

        final InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        final IBinder token = this.getWindow().getWindow().getAttributes().token;

        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // switches to previous ime

                Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vib.vibrate(25);

                try {
                    //imm.setInputMethod(token, LATIN);
                    imm.switchToLastInputMethod(token);
                } catch (Throwable t) { // java.lang.NoSuchMethodError if API_level<11
                    Context context = getApplicationContext();
                    CharSequence text = "Unfortunately input method switching isn't supported in your version of Android! You will have to do it manually :(";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                return false;
            }
        });

        if (unlocked) {
            return layout;
        } else {
            RelativeLayout unlockLayout = new RelativeLayout(this);
            unlockLayout.addView(layout);

            LinearLayout unlocker = (LinearLayout) getLayoutInflater().inflate(R.layout.trial_expired, null);
            unlocker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            Button btn = (Button) unlocker.findViewById(R.id.upgrade);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.klinker.android.emoji_keyboard&hl=en"));
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                }
            });

            unlockLayout.addView(unlocker, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, keyboardHeight + (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics())));
            return unlockLayout;

        }
    }

    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInputView(attribute, restarting);
        ic = getCurrentInputConnection();
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
        ic.commitText(emoji, 1);

        for (int i = 0; i < recents.size(); i++) {
            if (recents.get(i).text.equals(emoji)) {
                dataSource.updateRecent(icon + "");
                recents.get(i).count++;
                return;
            }
        }

        Recent recent = dataSource.createRecent(emoji, icon + "");

        if (recent != null) {
            recents.add(recent);
        }
    }

    public static void removeText() {
        ic.deleteSurroundingText(1, 0);
    }

    public static void removeRecent(int position) {
        dataSource.deleteRecent(recents.get(position).id);
        recents.remove(position);
        adapter.notifyDataSetChanged();
    }

    public class MyPagerAdapter extends PagerAdapter {

        private final String[] TITLES = { getString(R.string.recent), getString(R.string.people), getString(R.string.things), getString(R.string.nature), getString(R.string.places), getString(R.string.symbols) };
        private ViewPager pager;
        private ArrayList<View> pages;

        public MyPagerAdapter(Context context, ViewPager pager) {
            super();

            this.pager = pager;
            this.pages = new ArrayList<View>();

            pages.add(new KeyboardView(context, 0, recents).getView());
            pages.add(new KeyboardView(context, 1).getView());
            pages.add(new KeyboardView(context, 2).getView());
            pages.add(new KeyboardView(context, 3).getView());
            pages.add(new KeyboardView(context, 4).getView());
            pages.add(new KeyboardView(context, 5).getView());
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            pager.addView(pages.get(position), position, keyboardHeight);
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

    public static final int TRIAL_LENGTH = 5;

    public boolean checkUnlocked() {
        boolean unlocked = true;

        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File (sdCard.getAbsolutePath() + "/Android/data/com.klinker.android/");
        dir.mkdirs();
        File file = new File(dir, "keyboard_expires.txt");

        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String s = reader.readLine();
                long date = Long.parseLong(s);

                if (Calendar.getInstance().getTimeInMillis() > date) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {

            }
        } else {
            try {
                FileOutputStream f = new FileOutputStream(file);
                PrintWriter pw = new PrintWriter(f);

                pw.println(Calendar.getInstance().getTimeInMillis() + (TRIAL_LENGTH * 24 * 60 * 60 * 1000));

                pw.flush();
                pw.close();
                f.close();

                return true;
            } catch (Exception e) {

            }
        }

        return unlocked;
    }
}
