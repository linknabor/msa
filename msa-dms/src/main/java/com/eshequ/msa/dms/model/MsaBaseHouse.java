package com.eshequ.msa.dms.model;

import com.eshequ.msa.common.BaseModel;

public class MsaBaseHouse extends BaseModel {
    private Long mngCellId;

    private String houseModel;

    private String houseWard;

    private String houseArea;

    private String housePhone;

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }

    public String getHouseModel() {
        return houseModel;
    }

    public void setHouseModel(String houseModel) {
        this.houseModel = houseModel;
    }

    public String getHouseWard() {
        return houseWard;
    }

    public void setHouseWard(String houseWard) {
        this.houseWard = houseWard;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHousePhone() {
        return housePhone;
    }

    public void setHousePhone(String housePhone) {
        this.housePhone = housePhone;
    }
}