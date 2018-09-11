package com.eshequ.msa.dms.model;

import java.math.BigDecimal;

public class MsaMchRate extends MsaMchRateKey {
    private BigDecimal payRate;

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }
}