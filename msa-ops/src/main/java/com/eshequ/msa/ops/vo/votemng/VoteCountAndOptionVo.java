package com.eshequ.msa.ops.vo.votemng;

import java.util.List;

public class VoteCountAndOptionVo {
	private List<VoteOptionVo> VoteOptionVoList;
	private Integer totalVote;//总投票数
	public List<VoteOptionVo> getVoteOptionVoList() {
		return VoteOptionVoList;
	}
	public void setVoteOptionVoList(List<VoteOptionVo> voteOptionVoList) {
		VoteOptionVoList = voteOptionVoList;
	}
	public Integer getTotalVote() {
		return totalVote;
	}
	public void setTotalVote(Integer totalVote) {
		this.totalVote = totalVote;
	}
    
}
