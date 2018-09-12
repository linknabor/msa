package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;

public class SpRelateCustKey extends BaseModel {
    private Long custId;

    private Long mngCellId;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }
}