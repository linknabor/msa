package com.eshequ.msa.dms.model.msa;

import javax.persistence.Id;

import com.eshequ.msa.common.BaseModel;

public class MsaBaseCarport extends BaseModel {
	@Id
    private Long mngCellId;

    private String carportType;

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }

    public String getCarportType() {
        return carportType;
    }

    public void setCarportType(String carportType) {
        this.carportType = carportType;
    }
}