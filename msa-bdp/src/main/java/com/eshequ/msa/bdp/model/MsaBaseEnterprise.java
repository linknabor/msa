package com.eshequ.msa.bdp.model;

import com.eshequ.msa.common.BaseModel;

public class MsaBaseEnterprise extends BaseModel {
    private Long enterpriseId;

    private String enterpriseState;

    private String enterpriseName;

    private String enterpriseAddr;

    private String enterpriseType;

    private String enterpriseTel;

    private String remark;

    private Long provinceId;

    private Long cityId;

    private Long regionId;

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

    public void setCustName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddr() {
        return enterpriseAddr;
    }

    public void setCustAddr(String enterpriseAddr) {
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