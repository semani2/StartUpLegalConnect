package com.thestartup.startuplegalconnect.services;

/**
 * Created by sai on 8/27/16.
 */
public interface ISharedPreferencesSerivce extends IService {
    /**
     * Sets the boolean shared preference for the corresponding key
     * @param spName
     * @param key
     * @param value
     * @return
     */
    boolean setBoolean(String spName, String key, boolean value);

    /**
     * Gets the boolean name for the shared preference for the corresponding key
     * @param spName
     * @param key
     * @param defValue
     * @return
     */
    boolean getBoolean(String spName, String key, boolean defValue);
}
