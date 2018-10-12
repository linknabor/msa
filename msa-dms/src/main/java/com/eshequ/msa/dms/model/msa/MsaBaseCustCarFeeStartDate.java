package com.eshequ.msa.dms.model.msa;

import com.eshequ.msa.common.BaseModel;

public class MsaBaseCustCarFeeStartDate extends BaseModel {
    private Long carId;

    private String feeStartDate;

    private String paymentDate;
    
    private String feeDateType;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getFeeStartDate() {
        return feeStartDate;
    }

    public void setFeeStartDate(String feeStartDate) {
        this.feeStartDate = feeStartDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

	public String getFeeDateType() {
		return feeDateType;
	}

	public void setFeeDateType(String feeDateType) {
		this.feeDateType = feeDateType;
	}
    
    
}