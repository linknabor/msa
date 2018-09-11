package com.eshequ.msa.bdp.model;

import com.eshequ.msa.common.BaseModel;

public class MsaEnterpriseSect extends BaseModel {
    private Long enterpriseId;

    private Long sectId;

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getSectId() {
        return sectId;
    }

    public void setSectId(Long sectId) {
        this.sectId = sectId;
    }
}