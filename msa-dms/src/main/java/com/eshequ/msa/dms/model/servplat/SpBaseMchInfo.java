package com.eshequ.msa.dms.model.servplat;

import com.eshequ.msa.common.BaseModel;

public class SpBaseMchInfo extends BaseModel {
    private Long mchInfoId;

    private String mchId;

    private String mchName;

    private String mchType;

    private String mchStatus;

    private String secret;

    private String appid;

    private String platChannel;

    private String bankAcct;

    private String acctName;

    private String bankName;

    private String createDate;

    private String createTime;

    private String mchSubject;

    private String subjectId;

    private Long parentMchInfoId;

    public Long getMchInfoId() {
        return mchInfoId;
    }

    public void setMchInfoId(Long mchInfoId) {
        this.mchInfoId = mchInfoId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    public String getMchType() {
        return mchType;
    }

    public void setMchType(String mchType) {
        this.mchType = mchType;
    }

    public String getMchStatus() {
        return mchStatus;
    }

    public void setMchStatus(String mchStatus) {
        this.mchStatus = mchStatus;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPlatChannel() {
        return platChannel;
    }

    public void setPlatChannel(String platChannel) {
        this.platChannel = platChannel;
    }

    public String getBankAcct() {
        return bankAcct;
    }

    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMchSubject() {
        return mchSubject;
    }

    public void setMchSubject(String mchSubject) {
        this.mchSubject = mchSubject;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Long getParentMchInfoId() {
        return parentMchInfoId;
    }

    public void setParentMchInfoId(Long parentMchInfoId) {
        this.parentMchInfoId = parentMchInfoId;
    }
}