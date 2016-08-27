package com.thestartup.startuplegalconnect.services;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sai on 8/27/16.
 */
public class SharedPreferencesService implements ISharedPreferencesSerivce {
    private final Context context;

    public SharedPreferencesService(Context context) {
        this.context = context;
    }

    private SharedPreferences.Editor editor(String prefName) {
        return getPreferences(prefName).edit();
    }

    private SharedPreferences getPreferences(String spName){
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    @Override
    public boolean setBoolean(String spName, String key, boolean value) {
        return editor(spName).putBoolean(key, value).commit();
    }

    @Override
    public boolean getBoolean(String spName, String key, boolean defValue) {
        return getPreferences(spName).getBoolean(key, defValue);
    }

    @Override
    public boolean setInt(String spName, String key, int value) {
        return editor(spName).putInt(key, value).commit();
    }

    @Override
    public int getInt(String spName, String key, int defValue) {
        return getPreferences(spName).getInt(key, defValue);
    }
}
