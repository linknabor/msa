package com.eshequ.msa.dms.model.msa;

import com.eshequ.msa.common.BaseModel;

public class MsaBaseCust extends BaseModel {
    private Long custId;

    private String custStatus;

    private String custName;

    private String custType;

    private String codeType;

    private String custCode;

    private String telNo;

    private String acctBank;

    private String acctName;

    private String acctNo;

    private String remark;

    private Long custAcctNo;

    private String isCertifi;

    private String relatedCustNo;
    
    private String originalId;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAcctBank() {
        return acctBank;
    }

    public void setAcctBank(String acctBank) {
        this.acctBank = acctBank;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCustAcctNo() {
        return custAcctNo;
    }

    public void setCustAcctNo(Long custAcctNo) {
        this.custAcctNo = custAcctNo;
    }

    public String getIsCertifi() {
        return isCertifi;
    }

    public void setIsCertifi(String isCertifi) {
        this.isCertifi = isCertifi;
    }

    public String getRelatedCustNo() {
        return relatedCustNo;
    }

    public void setRelatedCustNo(String relatedCustNo) {
        this.relatedCustNo = relatedCustNo;
    }

	public String getOriginalId() {
		return originalId;
	}

	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}
    
    
}