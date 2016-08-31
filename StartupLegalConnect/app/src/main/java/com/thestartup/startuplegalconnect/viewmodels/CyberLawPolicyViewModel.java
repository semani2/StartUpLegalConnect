package com.thestartup.startuplegalconnect.viewmodels;

import com.thestartup.startuplegalconnect.services.ServiceLocator;

/**
 * Created by sai on 8/27/16.
 */
public class CyberLawPolicyViewModel implements ICyberLawPolicyViewModel {
    private final String message;
    private final POLICY_STATUS policy_status;
    private final CYBER_LAW_POLICIES policy;
    private final String spName = "com.thestartup.startuplegalconnect.cyberlawcompliance";

    public CyberLawPolicyViewModel(String message, CYBER_LAW_POLICIES policy) {
        this.message = message;
        this.policy = policy;
        this.policy_status = ServiceLocator.sharedpreferences().getString(spName, policy.name(), POLICY_STATUS.noncompliant.name()).equalsIgnoreCase(POLICY_STATUS.compliant.name()) ?
                POLICY_STATUS.compliant : POLICY_STATUS.noncompliant;
    }
    @Override
    public String getPolicyMessage() {
        return message;
    }

    @Override
    public POLICY_STATUS getStatusForPolicy() {
        return ServiceLocator.sharedpreferences().getString(spName, policy.name(), POLICY_STATUS.noncompliant.name()).equalsIgnoreCase(POLICY_STATUS.compliant.name()) ?
                POLICY_STATUS.compliant : POLICY_STATUS.noncompliant;
    }

    @Override
    public void setPolicyStatus(POLICY_STATUS policyStatus) {
        ServiceLocator.sharedpreferences().setString(spName, policy.name(), policyStatus.name());
    }
}
