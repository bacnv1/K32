package com.t3h.buoi13.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUtils {
    private SharedPreferences preferences;
    private static SharedUtils sharedUtils;

    public static String KEY_USER_NAME = "key_user_name";
    public static String KEY_PASSWORD = "key_password";

    public static SharedUtils getInstance(Context context) {
        if (sharedUtils == null) {
            sharedUtils = new SharedUtils(context);
        }
        return sharedUtils;
    }

    private SharedUtils(Context context) {
        preferences = context.getSharedPreferences
                ("SharedUtils", Context.MODE_PRIVATE);
    }

    public void putString(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }

    public String getString(String key) {
        return preferences.getString(key, null);
    }
}
