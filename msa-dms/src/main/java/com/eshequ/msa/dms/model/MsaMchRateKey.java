package com.eshequ.msa.dms.model;

import com.eshequ.msa.common.BaseModel;

public class MsaMchRateKey extends BaseModel {
    private Long mchInfoId;

    private String payMethod;

    public Long getMchInfoId() {
        return mchInfoId;
    }

    public void setMchInfoId(Long mchInfoId) {
        this.mchInfoId = mchInfoId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
}