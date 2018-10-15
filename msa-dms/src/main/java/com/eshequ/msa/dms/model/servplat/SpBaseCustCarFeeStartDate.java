package com.eshequ.msa.dms.model.servplat;

public class SpBaseCustCarFeeStartDate extends SpBaseCustCarFeeStartDateKey {
    private String feeStartDate;

    private String paymentDate;
    
    private String feeDateType;
    
    private Long carId;

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

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
    
    
}