package com.eshequ.msa.bdp.model;

import java.util.List;

import javax.persistence.Transient;

import com.eshequ.msa.common.BaseModel;

public class MsaCfgEnpPara extends BaseModel {
    private Long paraId;

    private String paraName;
    
    private String paraNameCn;

    private String paraValue;

    private String paraType;

    private String paraStatus;

    private Long enterpriseId;
    
    private String paraView;

    private String remark;
    
    @Transient
    private List<MasConfigParamVO> cfgList;//区分input参数和select参数，list>1表示select参数，<1表示input参数
    
    
    
    public List<MasConfigParamVO> getCfgList() {
		return cfgList;
	}

	public void setCfgList(List<MasConfigParamVO> cfgList) {
		this.cfgList = cfgList;
	}

	public String getParaView() {
		return paraView;
	}

	public void setParaView(String paraView) {
		this.paraView = paraView;
	}

	public String getParaNameCn() {
		return paraNameCn;
	}

	public void setParaNameCn(String paraNameCn) {
		this.paraNameCn = paraNameCn;
	}

    public Long getParaId() {
        return paraId;
    }

    public void setParaId(Long paraId) {
        this.paraId = paraId;
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    public String getParaType() {
        return paraType;
    }

    public void setParaType(String paraType) {
        this.paraType = paraType;
    }

    public String getParaStatus() {
        return paraStatus;
    }

    public void setParaStatus(String paraStatus) {
        this.paraStatus = paraStatus;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}