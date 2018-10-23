package com.eshequ.msa.ops.vo.votemng;

public class VoteOptionVo {
	private Long voteOptionId;
	private String voteOptionName;
	private String status;
	private Integer voteCount;
	public Long getVoteOptionId() {
		return voteOptionId;
	}
	public void setVoteOptionId(Long voteOptionId) {
		this.voteOptionId = voteOptionId;
	}
	public String getVoteOptionName() {
		return voteOptionName;
	}
	public void setVoteOptionName(String voteOptionName) {
		this.voteOptionName = voteOptionName;
	}
	public Integer getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
    
}
