package com.eshequ.msa.ops.model.msasmsmng;

import com.eshequ.msa.common.BaseModel;
import java.math.BigDecimal;

public class OpsArrearageInfo extends BaseModel {
    private Long arrearageInfo;

    private String mobile;

    private String custName;

    private String custAddr;

    private BigDecimal arrearageAmt;

    private String importDate;

    private String importTime;

    private Long importBatch;

    public Long getArrearageInfo() {
        return arrearageInfo;
    }

    public void setArrearageInfo(Long arrearageInfo) {
        this.arrearageInfo = arrearageInfo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public BigDecimal getArrearageAmt() {
        return arrearageAmt;
    }

    public void setArrearageAmt(BigDecimal arrearageAmt) {
        this.arrearageAmt = arrearageAmt;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getImportTime() {
        return importTime;
    }

    public void setImportTime(String importTime) {
        this.importTime = importTime;
    }

    public Long getImportBatch() {
        return importBatch;
    }

    public void setImportBatch(Long importBatch) {
        this.importBatch = importBatch;
    }
}