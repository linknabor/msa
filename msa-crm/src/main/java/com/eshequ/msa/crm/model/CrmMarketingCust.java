package com.eshequ.msa.crm.model;

import com.eshequ.msa.common.BaseModel;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class CrmMarketingCust extends BaseModel {
	@Id
    private long custId;

    private int houCount;

    private BigDecimal yearAmt;

    private String qualificationLevel;

    private String saleStatus;

    private String groupCom;

    private String sysOperid;

    private String custName;

    private String custAddr;

    private String remark;

    private String regionId;

    private String cityId;

    private String provinceId;

    private String industryId;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public int getHouCount() {
		return houCount;
	}

	public void setHouCount(int houCount) {
		this.houCount = houCount;
	}

	public BigDecimal getYearAmt() {
		return yearAmt;
	}

	public void setYearAmt(BigDecimal yearAmt) {
		this.yearAmt = yearAmt;
	}

	public String getQualificationLevel() {
		return qualificationLevel;
	}

	public void setQualificationLevel(String qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getGroupCom() {
		return groupCom;
	}

	public void setGroupCom(String groupCom) {
		this.groupCom = groupCom;
	}

	public String getSysOperid() {
		return sysOperid;
	}

	public void setSysOperid(String sysOperid) {
		this.sysOperid = sysOperid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

    
}