package com.eshequ.msa.dms.vo.basedata;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProvinceVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7661685970410092646L;

	private Long provinceId;

	@JsonProperty("province_status")
	private String provinceStatus;

	@JsonProperty("province_name")
    private String provinceName;

	@JsonProperty("province_short_name")
    private String provinceShortName;

	@JsonProperty("province_id")
    private String remark;

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceStatus() {
		return provinceStatus;
	}

	public void setProvinceStatus(String provinceStatus) {
		this.provinceStatus = provinceStatus;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceShortName() {
		return provinceShortName;
	}

	public void setProvinceShortName(String provinceShortName) {
		this.provinceShortName = provinceShortName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
