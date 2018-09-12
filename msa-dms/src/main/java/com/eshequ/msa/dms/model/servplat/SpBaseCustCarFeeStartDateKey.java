package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;

public class SpBaseCustCarFeeStartDateKey extends BaseModel {
    private Long carId;

    private String feeDateType;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getFeeDateType() {
        return feeDateType;
    }

    public void setFeeDateType(String feeDateType) {
        this.feeDateType = feeDateType;
    }
}