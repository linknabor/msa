package com.eshequ.msa.dms.model.servplat;

import java.math.BigDecimal;

public class SpRelateMchMultiRate extends SpRelateMchMultiRateKey {
    private BigDecimal payRate;

    private String consultThreshold;

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public String getConsultThreshold() {
        return consultThreshold;
    }

    public void setConsultThreshold(String consultThreshold) {
        this.consultThreshold = consultThreshold;
    }
}