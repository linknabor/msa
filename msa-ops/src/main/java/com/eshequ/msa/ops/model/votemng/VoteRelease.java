package com.eshequ.msa.ops.model.votemng;


import javax.persistence.Id;

import com.eshequ.msa.common.BaseModel;

public class VoteRelease extends BaseModel {
	@Id
    private Long releaseId;

    private String visibleState;

    private String closeDate;

    private String closeTime;

    private Long voteId;

    private String voteName;

    private String releaseTitle;

    private String releaseContent;

    private String releaseStatus;

    private String createDate;

    private String cerateTime;
    //主图
    private String mainImage;
    //用户id
    private Long userId;
    //机构名称
    private String orgName;
    
    
    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    public String getVisibleState() {
        return visibleState;
    }

    public void setVisibleState(String visibleState) {
        this.visibleState = visibleState;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public String getReleaseTitle() {
        return releaseTitle;
    }

    public void setReleaseTitle(String releaseTitle) {
        this.releaseTitle = releaseTitle;
    }

    public String getReleaseContent() {
        return releaseContent;
    }

    public void setReleaseContent(String releaseContent) {
        this.releaseContent = releaseContent;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCerateTime() {
        return cerateTime;
    }

    public void setCerateTime(String cerateTime) {
        this.cerateTime = cerateTime;
    }

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
 
}