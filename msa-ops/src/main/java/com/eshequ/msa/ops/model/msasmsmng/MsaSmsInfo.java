package com.eshequ.msa.ops.model.msasmsmng;
import com.eshequ.msa.common.BaseModel;

public class MsaSmsInfo extends BaseModel {
    private Long smsId;

    private String mobile;

    private String sendDate;

    private String sendTime;

    private String content;

    private Long smsBatch;

    private String smsStatus;

    private String mappingSmsId;

    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Long getSmsBatch() {
        return smsBatch;
    }

    public void setSmsBatch(Long smsBatch) {
        this.smsBatch = smsBatch;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public String getMappingSmsId() {
        return mappingSmsId;
    }

    public void setMappingSmsId(String mappingSmsId) {
        this.mappingSmsId = mappingSmsId;
    }
}