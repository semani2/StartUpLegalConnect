package com.thestartup.startuplegalconnect.viewmodels;

/**
 * Created by sai on 8/27/16.
 */
public interface ICyberLawPolicyViewModel {
    enum POLICY_STATUS {
        compliant,
        noncompliant
    }

    enum CYBER_LAW_POLICIES {
        PRIVACY_POLICY,
        TERMS_OF_USE,
        GRIEVANCE_MECHANISM,
        CYBER_LAW_COMPLIANCE_AGREEMENT,
        LEGAL_DISCLAIMER
    }

    /**
     * Get string for policy
     * @return
     */
    String getPolicyMessage();

    /**
     * Get statis for the policy
     * @return
     */
    POLICY_STATUS getStatusForPolicy();

    /**
     * Sets the policy status
     * @param policyStatus
     */
    void setPolicyStatus(POLICY_STATUS policyStatus);
}
