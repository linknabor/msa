package com.eshequ.msa.ops.model.votemng;

import javax.persistence.Id;

import com.eshequ.msa.common.BaseModel;

public class VoteOption extends BaseModel {
	@Id
    private Long optionId;

    private String optionName;

    private Long voteId;

    private String status;

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}