package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;

public class SpRelateCspSectKey extends BaseModel {
    private Long cspId;

    private Long sectId;

    public Long getCspId() {
        return cspId;
    }

    public void setCspId(Long cspId) {
        this.cspId = cspId;
    }

    public Long getSectId() {
        return sectId;
    }

    public void setSectId(Long sectId) {
        this.sectId = sectId;
    }
}