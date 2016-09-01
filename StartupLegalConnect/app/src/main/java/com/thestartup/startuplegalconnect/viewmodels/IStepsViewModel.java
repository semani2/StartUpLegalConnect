package com.thestartup.startuplegalconnect.viewmodels;

/**
 * Created by sai on 8/27/16.
 */
public interface IStepsViewModel {
    enum POLICY_STATUS {
        complete,
        incomplete
    }

    enum CYBER_LAW_STEPS {
        PROTECT_IDEA,
        PROTECT_LOGO,
        FOUNDERS_AGREEMENT,
        OUTSOURCING_AGREEMENT,
        PRODUCT_DOCUMENTS,
        CYBER_LAW_COMPLIANCE,
        LEGAL_AGREEMENTS,
        DIGITAL_MARKETING,
        EMPLOYEE_AGREEMENTS,
        ADVISOR_AGREEMENTS,
        NON_DISCLOSURE_AGREEMENTS,
        PROTECT_DATA,
        IP_AGREEMENTS,
        TERM_SHEETS,
        INVESTOR_AGREEMENTS,
        SHAREHOLDER_AGREEMENTS
    }

    /**
     * Get string for policy
     * @return
     */
    String getStepMessage();

    /**
     * Get statis for the policy
     * @return
     */
    POLICY_STATUS getStatusForStep();

    /**
     * Sets the policy status
     * @param policyStatus
     */
    void setPolicyStatus(POLICY_STATUS policyStatus);
}
