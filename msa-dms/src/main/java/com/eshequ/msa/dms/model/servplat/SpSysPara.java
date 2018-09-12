package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;

public class SpSysPara extends BaseModel {
    private String paraName;

    private String paraType;

    private String paraValue;

    private String remark;

    private String subParaType;

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    public String getParaType() {
        return paraType;
    }

    public void setParaType(String paraType) {
        this.paraType = paraType;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSubParaType() {
        return subParaType;
    }

    public void setSubParaType(String subParaType) {
        this.subParaType = subParaType;
    }
}