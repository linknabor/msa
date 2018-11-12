package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SpBaseHouse extends BaseModel {
	@JsonProperty("mng_cell_id")
    private Long mngCellId;

	@JsonProperty("house_model")
    private String houseModel;

	@JsonProperty("house_ward")
    private String houseWard;

	@JsonProperty("house_area")
    private String houseArea;

	@JsonProperty("house_phone")
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