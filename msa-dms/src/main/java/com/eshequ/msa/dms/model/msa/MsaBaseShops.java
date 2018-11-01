package com.eshequ.msa.dms.model.msa;

import javax.persistence.Id;

import com.eshequ.msa.common.BaseModel;

public class MsaBaseShops extends BaseModel {
	@Id
    private Long mngCellId;

    private String shopsType;

    private String shopsArea;

    private String shopsPhone;

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }

    public String getShopsType() {
        return shopsType;
    }

    public void setShopsType(String shopsType) {
        this.shopsType = shopsType;
    }

    public String getShopsArea() {
        return shopsArea;
    }

    public void setShopsArea(String shopsArea) {
        this.shopsArea = shopsArea;
    }

    public String getShopsPhone() {
        return shopsPhone;
    }

    public void setShopsPhone(String shopsPhone) {
        this.shopsPhone = shopsPhone;
    }
}