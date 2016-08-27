package com.thestartup.startuplegalconnect.viewmodels;

/**
 * Created by sai on 8/27/16.
 */
public interface ICommonMistakeViewModel extends IViewModel {
    /**
     * Gets the message for mistake
     * @return
     */
    String getMessage();

    /**
     * Returns true if user has previously checked out the message
     * @return
     */
    boolean isChecked();

    /**
     * Sets the isChecked property for the mistake
     * @param isChecked
     */
    void setIsChecked(boolean isChecked);
}
