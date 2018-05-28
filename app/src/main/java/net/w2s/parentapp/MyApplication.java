package net.w2s.parentapp;

import android.app.Application;
import android.content.res.Configuration;

import java.util.Locale;

import net.w2s.parentapp.Local.LocaleUtils;
import net.w2s.parentapp.Utilities.ConstantKeys;
import net.w2s.parentapp.Utilities.Utility;

/**
 * Created by RWS 6 on 11/29/2016.
 */
public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();

        if (Utility.getSharedPreferences(MyApplication.this, ConstantKeys.Setting_Language).equals("1")) {
            LocaleUtils.setLocale(new Locale("ar"));
            LocaleUtils.updateConfig(this, getBaseContext().getResources().getConfiguration());
        } else {
            LocaleUtils.setLocale(new Locale("en"));
            LocaleUtils.updateConfig(this, getBaseContext().getResources().getConfiguration());
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleUtils.updateConfig(this, newConfig);
    }
}
