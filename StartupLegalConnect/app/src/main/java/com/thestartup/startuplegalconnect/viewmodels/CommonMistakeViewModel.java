package com.thestartup.startuplegalconnect.viewmodels;

import com.thestartup.startuplegalconnect.services.ServiceLocator;

/**
 * Created by sai on 8/27/16.
 */
public class CommonMistakeViewModel implements ICommonMistakeViewModel {
    private final String message;
    private final boolean isChecked;
    private final MistakeType mistakeType;
    private static final String spName = "com.thestartup.startuplegalconnect.common_mistakes";

    public enum MistakeType{
        LOGO_PROTECTION,
        POOR_BRANDING,
        IP_ISSUES,
        COPYRIGHT_ISSUES,
        HYPERLINKING,
        NO_LEGAL_DOC,
        CUT_AND_PASTE,
        DIY_LEGAL
    }

    public CommonMistakeViewModel(String message, MistakeType mistakeType) {
        this.message = message;
        this.mistakeType = mistakeType;
        this.isChecked = ServiceLocator.sharedpreferences().getBoolean(spName, mistakeType.name(), false);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void setIsChecked(boolean isChecked) {
        ServiceLocator.sharedpreferences().setBoolean(spName, mistakeType.name(), isChecked);
    }
}
