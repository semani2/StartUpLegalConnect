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

    /**
     * Sets the int shared preference for the corresponding key
     * @param spName
     * @param key
     * @param value
     * @return
     */
    boolean setInt(String spName, String key, int value);

    /**
     * Gets the int shared preference for the key
     * @param spName
     * @param key
     * @param defValue
     * @return
     */
    int getInt(String spName, String key, int defValue);

    /**
     * Sets the string shared preference value
     * @param spName
     * @param key
     * @param value
     * @return
     */
    boolean setString(String spName, String key, String value);

    /**
     * Gets the string shared preference
     * @param spName
     * @param key
     * @param defValue
     * @return
     */
    String getString(String spName, String key, String defValue);
}
