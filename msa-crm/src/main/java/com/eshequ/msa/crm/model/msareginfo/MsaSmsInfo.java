package com.eshequ.msa.crm.model.msareginfo;

import com.eshequ.msa.common.BaseModel;

public class MsaSmsInfo extends BaseModel {
    private Long smsId;

    private String sendDate;

    private String sendTime;

    private String content;

    private String mappingSmsId;

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMappingSmsId() {
        return mappingSmsId;
    }

    public void setMappingSmsId(String mappingSmsId) {
        this.mappingSmsId = mappingSmsId;
    }
}