package com.thestartup.startuplegalconnect.services;

import android.content.Context;

/**
 * Created by sai on 8/27/16.
 */
public class ServiceLocator {
    private static ISharedPreferencesSerivce sharedPreferencesSerivce = null;

    public static ISharedPreferencesSerivce sharedpreferences() {
        return sharedPreferencesSerivce;
    }

    private static void initSharedPreferencesService(Context context) {
        sharedPreferencesSerivce = new SharedPreferencesService(context);
    }

    public static void initAllServices(Context context) {
        //Add Methods here for future service initialization
        initSharedPreferencesService(context);
    }
}
