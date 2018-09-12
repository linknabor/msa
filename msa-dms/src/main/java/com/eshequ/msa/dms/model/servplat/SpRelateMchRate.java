package com.eshequ.msa.dms.model.servplat;

import java.math.BigDecimal;

public class SpRelateMchRate extends SpRelateMchRateKey {
    private BigDecimal payRate;

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }
}