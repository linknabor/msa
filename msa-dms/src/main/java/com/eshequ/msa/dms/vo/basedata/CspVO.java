package com.eshequ.msa.dms.vo.basedata;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CspVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1956397627147183609L;

	private Long enterpriseId;

	@JsonProperty("csp_status")
	private String enterpriseState;

	@JsonProperty("csp_name")
	private String enterpriseName;

	@JsonProperty("csp_addr")
	private String enterpriseAddr;

	private String enterpriseType;

	@JsonProperty("org_tel")
	private String enterpriseTel;

	private String remark;

	private Long provinceId = 0L;

	private Long cityId = 0L;

	private Long regionId = 0L;

	@JsonProperty("csp_id")
	private String originId;

	private Long originSys;

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseState() {
		return enterpriseState;
	}

	public void setEnterpriseState(String enterpriseState) {
		this.enterpriseState = enterpriseState;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseAddr() {
		return enterpriseAddr;
	}

	public void setEnterpriseAddr(String enterpriseAddr) {
		this.enterpriseAddr = enterpriseAddr;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getEnterpriseTel() {
		return enterpriseTel;
	}

	public void setEnterpriseTel(String enterpriseTel) {
		this.enterpriseTel = enterpriseTel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public Long getOriginSys() {
		return originSys;
	}

	public void setOriginSys(Long originSys) {
		this.originSys = originSys;
	}
	
	

}
