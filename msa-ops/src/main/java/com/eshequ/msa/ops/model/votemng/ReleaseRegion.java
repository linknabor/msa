package com.eshequ.msa.ops.model.votemng;

import javax.persistence.Id;

import com.eshequ.msa.common.BaseModel;

public class ReleaseRegion extends BaseModel {
	@Id
    private Long regionId;

    private Long provinceId; 

    private String provinceName;

    private Long cityId;

    private String cityName;

    private Long countyId;

    private String countyName;

    private Long releaseId;
    
    private Long sectId;
    
    private String sectName;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

	public Long getSectId() {
		return sectId;
	}

	public void setSectId(Long sectId) {
		this.sectId = sectId;
	}

	public String getSectName() {
		return sectName;
	}

	public void setSectName(String sectName) {
		this.sectName = sectName;
	}
    
    
}