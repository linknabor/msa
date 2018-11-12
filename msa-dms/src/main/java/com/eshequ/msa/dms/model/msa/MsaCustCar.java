package com.eshequ.msa.dms.model.msa;

import javax.persistence.Id;

import com.eshequ.msa.common.BaseModel;

public class MsaCustCar extends BaseModel {
	@Id
    private Long custId;

    private Long mngCellId;

    private Long carId;

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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}