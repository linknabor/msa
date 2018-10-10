package com.eshequ.msa.dms.model.msa;

import com.eshequ.msa.common.BaseModel;
import java.math.BigDecimal;

public class MsaBaseCell extends BaseModel {
    private Long mngCellId;

    private String status;

    private String cellNo;

    private String cellName;

    private String cellAddr;

    private BigDecimal cnstArea;

    private String cellFloor;

    private String mngCellType;

    private String mngCellKind;

    private String remark;

    private String liftFlag;

    private String propertyKind;

    private String buildType;

    private String buildUsage;

    private String relatedHouNo;

    private Long sectId;
    
    private String originalId;

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getCellAddr() {
        return cellAddr;
    }

    public void setCellAddr(String cellAddr) {
        this.cellAddr = cellAddr;
    }

    public BigDecimal getCnstArea() {
        return cnstArea;
    }

    public void setCnstArea(BigDecimal cnstArea) {
        this.cnstArea = cnstArea;
    }

    public String getCellFloor() {
        return cellFloor;
    }

    public void setCellFloor(String cellFloor) {
        this.cellFloor = cellFloor;
    }

    public String getMngCellType() {
        return mngCellType;
    }

    public void setMngCellType(String mngCellType) {
        this.mngCellType = mngCellType;
    }

    public String getMngCellKind() {
        return mngCellKind;
    }

    public void setMngCellKind(String mngCellKind) {
        this.mngCellKind = mngCellKind;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLiftFlag() {
        return liftFlag;
    }

    public void setLiftFlag(String liftFlag) {
        this.liftFlag = liftFlag;
    }

    public String getPropertyKind() {
        return propertyKind;
    }

    public void setPropertyKind(String propertyKind) {
        this.propertyKind = propertyKind;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getBuildUsage() {
        return buildUsage;
    }

    public void setBuildUsage(String buildUsage) {
        this.buildUsage = buildUsage;
    }

    public String getRelatedHouNo() {
        return relatedHouNo;
    }

    public void setRelatedHouNo(String relatedHouNo) {
        this.relatedHouNo = relatedHouNo;
    }

    public Long getSectId() {
        return sectId;
    }

    public void setSectId(Long sectId) {
        this.sectId = sectId;
    }

	public String getOriginalId() {
		return originalId;
	}

	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}
    
    
}