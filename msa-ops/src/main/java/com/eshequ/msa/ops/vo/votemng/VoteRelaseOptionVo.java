package com.eshequ.msa.ops.vo.votemng;

import java.util.List;

import com.eshequ.msa.ops.model.votemng.VoteOption;

public class VoteRelaseOptionVo {
	private Long releaseId;
	private Long voteId;
	private List<VoteOption> list;
	public Long getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}
	public Long getVoteId() {
		return voteId;
	}
	public void setVoteId(Long voteId) {
		this.voteId = voteId;
	}
	public List<VoteOption> getList() {
		return list;
	}
	public void setList(List<VoteOption> list) {
		this.list = list;
	}
	
	

}
