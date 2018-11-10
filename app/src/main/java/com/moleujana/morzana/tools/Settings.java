package com.moleujana.morzana.tools;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

import androidx.annotation.Nullable;

public class Settings {
    private static final String PREF_NAME = "morzana";

    private SharedPreferences preference;
    private SharedPreferences.Editor editor;

    private Settings(Context context) {
        preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preference.edit();
        editor.apply();
    }

    public static Settings getInstance(Context context) {
        return new Settings(context);
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defValue) {
        return preference.getString(key, defValue);
    }

    public Set<String> getStringSet(String key) {
        return getStringSet(key, null);
    }

    public Set<String> getStringSet(String key, Set<String> defValues) {
        return preference.getStringSet(key, defValues);
    }

    public int getInt(String key) {
        return getInt(key, -1);
    }

    public int getInt(String key, int defValue) {
        return preference.getInt(key, defValue);
    }

    public long getLong(String key) {
        return getLong(key, -1);
    }

    public long getLong(String key, long defValue) {
        return preference.getLong(key, defValue);
    }

    public float getFloat(String key) {
        return getFloat(key, -1);
    }

    public float getFloat(String key, float defValue) {
        return preference.getFloat(key, defValue);
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean contains(String key) {
        return preference.contains(key);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return preference.getBoolean(key, defValue);
    }

    public Settings putString(String key, @Nullable String value) {
        editor.putString(key, value);
        editor.apply();
        return this;
    }

    public Settings putStringSet(String key, @Nullable Set<String> values) {
        editor.putStringSet(key, values);
        editor.apply();
        return this;
    }

    public Settings putInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
        return this;
    }

    public Settings putLong(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
        return this;
    }

    public Settings putFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
        return this;
    }

    public Settings putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
        return this;
    }

    public Settings remove(String key) {
        editor.remove(key);
        return this;
    }

    public Settings clear() {
        editor.clear();
        return this;
    }
}
