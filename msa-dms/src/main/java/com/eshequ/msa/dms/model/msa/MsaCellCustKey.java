package com.eshequ.msa.dms.model.msa;

import com.eshequ.msa.common.BaseModel;

public class MsaCellCustKey extends BaseModel {
    private Long mngCellId;

    private Long custId;

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }
}