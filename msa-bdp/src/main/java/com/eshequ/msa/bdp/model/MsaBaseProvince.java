package com.eshequ.msa.bdp.model;

import com.eshequ.msa.common.BaseModel;

public class MsaBaseProvince extends BaseModel {
    private Long provinceId;

    private String provinceStatus;

    private String provinceName;

    private String provinceShortName;

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