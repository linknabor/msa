package com.eshequ.msa.dms.model.servplat;

public class SpBaseCustCarFeeStartDate extends SpBaseCustCarFeeStartDateKey {
    private String feeStartDate;

    private String paymentDate;

    public String getFeeStartDate() {
        return feeStartDate;
    }

    public void setFeeStartDate(String feeStartDate) {
        this.feeStartDate = feeStartDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}