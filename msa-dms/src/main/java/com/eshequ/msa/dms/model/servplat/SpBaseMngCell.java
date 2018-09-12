package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;
import java.math.BigDecimal;

public class SpBaseMngCell extends BaseModel {
    private Long mngCellId;

    private String cellStatus;

    private String lendFlag;

    private String lendServiceFlag;

    private String cellNo;

    private String cellName;

    private String cellAddr;

    private BigDecimal cnstArea;

    private String cellFloor;

    private String mngCellType;

    private String mngCellKind;

    private String remark;

    private Long sectId;

    private Long buildId;

    private Long unitId;

    private String liftFlag;

    private String propertyKind;

    private String buildType;

    private String buildUsage;

    private String relatedHouNo;

    public Long getMngCellId() {
        return mngCellId;
    }

    public void setMngCellId(Long mngCellId) {
        this.mngCellId = mngCellId;
    }

    public String getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(String cellStatus) {
        this.cellStatus = cellStatus;
    }

    public String getLendFlag() {
        return lendFlag;
    }

    public void setLendFlag(String lendFlag) {
        this.lendFlag = lendFlag;
    }

    public String getLendServiceFlag() {
        return lendServiceFlag;
    }

    public void setLendServiceFlag(String lendServiceFlag) {
        this.lendServiceFlag = lendServiceFlag;
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

    public Long getSectId() {
        return sectId;
    }

    public void setSectId(Long sectId) {
        this.sectId = sectId;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
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
}