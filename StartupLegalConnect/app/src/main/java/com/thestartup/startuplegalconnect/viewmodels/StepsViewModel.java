package com.thestartup.startuplegalconnect.viewmodels;

import com.thestartup.startuplegalconnect.services.ServiceLocator;

/**
 * Created by sai on 8/27/16.
 */
public class StepsViewModel implements IStepsViewModel {
    private final String message;
    private final POLICY_STATUS policy_status;
    private final CYBER_LAW_STEPS policy;
    private final String spName = "com.thestartup.startuplegalconnect.cyberlawcompliance";

    public StepsViewModel(String message, CYBER_LAW_STEPS policy) {
        this.message = message;
        this.policy = policy;
        this.policy_status = ServiceLocator.sharedpreferences().getString(spName, policy.name(), POLICY_STATUS.incomplete.name()).equalsIgnoreCase(POLICY_STATUS.complete.name()) ?
                POLICY_STATUS.complete : POLICY_STATUS.incomplete;
    }
    @Override
    public String getStepMessage() {
        return message;
    }

    @Override
    public POLICY_STATUS getStatusForStep() {
        return ServiceLocator.sharedpreferences().getString(spName, policy.name(), POLICY_STATUS.incomplete.name()).equalsIgnoreCase(POLICY_STATUS.complete.name()) ?
                POLICY_STATUS.complete : POLICY_STATUS.incomplete;
    }

    @Override
    public void setPolicyStatus(POLICY_STATUS policyStatus) {
        ServiceLocator.sharedpreferences().setString(spName, policy.name(), policyStatus.name());
    }
}
