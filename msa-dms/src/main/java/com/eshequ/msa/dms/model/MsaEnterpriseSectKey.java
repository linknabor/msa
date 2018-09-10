package com.eshequ.msa.dms.model;

import com.eshequ.msa.common.BaseModel;

public class MsaEnterpriseSectKey extends BaseModel {
    private String enterpriseId;

    private Long sectId;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getSectId() {
        return sectId;
    }

    public void setSectId(Long sectId) {
        this.sectId = sectId;
    }
}