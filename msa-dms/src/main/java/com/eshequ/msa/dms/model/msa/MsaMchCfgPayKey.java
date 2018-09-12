package com.eshequ.msa.dms.model.msa;

import com.eshequ.msa.common.BaseModel;

public class MsaMchCfgPayKey extends BaseModel {
    private String payMethod;

    private String payScenarios;

    private String infoId;

    private Long mchInfoId;

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayScenarios() {
        return payScenarios;
    }

    public void setPayScenarios(String payScenarios) {
        this.payScenarios = payScenarios;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public Long getMchInfoId() {
        return mchInfoId;
    }

    public void setMchInfoId(Long mchInfoId) {
        this.mchInfoId = mchInfoId;
    }
}