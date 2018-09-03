package com.eshequ.msa.ops.model.msareginfo;

import com.eshequ.msa.common.BaseModel;
import java.math.BigDecimal;

public class MsaSmsSum extends BaseModel {
    private Long smsBatch;

    private BigDecimal totalCount;

    private String sendDate;

    private String sendTime;

    private BigDecimal totalFailed;

    public Long getSmsBatch() {
        return smsBatch;
    }

    public void setSmsBatch(Long smsBatch) {
        this.smsBatch = smsBatch;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
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

    public BigDecimal getTotalFailed() {
        return totalFailed;
    }

    public void setTotalFailed(BigDecimal totalFailed) {
        this.totalFailed = totalFailed;
    }
}