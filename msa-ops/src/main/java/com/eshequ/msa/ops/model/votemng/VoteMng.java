package com.eshequ.msa.ops.model.votemng;

import javax.persistence.Id;

import com.eshequ.msa.common.BaseModel;

public class VoteMng extends BaseModel {
	@Id
    private Long voteId;

    private String createTime;

    private String createDate;

    private Long userId;

    private String userName;

    private Integer votePeople;

    private String voteTitle;

    private String voteMode;

    private String voteCloseTime;

    private String voteCloseDate;

    private String voteName;

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getVotePeople() {
        return votePeople;
    }

    public void setVotePeople(Integer votePeople) {
        this.votePeople = votePeople;
    }

    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }

    public String getVoteMode() {
        return voteMode;
    }

    public void setVoteMode(String voteMode) {
        this.voteMode = voteMode;
    }

    public String getVoteCloseTime() {
        return voteCloseTime;
    }

    public void setVoteCloseTime(String voteCloseTime) {
        this.voteCloseTime = voteCloseTime;
    }

    public String getVoteCloseDate() {
        return voteCloseDate;
    }

    public void setVoteCloseDate(String voteCloseDate) {
        this.voteCloseDate = voteCloseDate;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }
}