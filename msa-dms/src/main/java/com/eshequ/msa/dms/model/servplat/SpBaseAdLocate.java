package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;

public class SpBaseAdLocate extends BaseModel {
    private Long mngCellId;

    private String adLocateType;

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }

    public String getAdLocateType() {
        return adLocateType;
    }

    public void setAdLocateType(String adLocateType) {
        this.adLocateType = adLocateType;
    }
}