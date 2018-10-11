package com.eshequ.msa.ops.vo.votemng;


import com.eshequ.msa.ops.model.votemng.VoteMng;
import com.eshequ.msa.ops.model.votemng.VoteRelease;

public class VoteReleaseDetailVo {
	private VoteMng voteMng;
	private VoteRelease voteRelease;
	private VoteCountAndOptionVo voteCountAndOptionVo;
	private Integer isVote;//不等于0表示已经投过票
	public VoteMng getVoteMng() {
		return voteMng;
	}
	public void setVoteMng(VoteMng voteMng) {
		this.voteMng = voteMng;
	}
	public VoteRelease getVoteRelease() {
		return voteRelease;
	}
	public void setVoteRelease(VoteRelease voteRelease) {
		this.voteRelease = voteRelease;
	}
	public VoteCountAndOptionVo getVoteCountAndOptionVo() {
		return voteCountAndOptionVo;
	}
	public void setVoteCountAndOptionVo(VoteCountAndOptionVo voteCountAndOptionVo) {
		this.voteCountAndOptionVo = voteCountAndOptionVo;
	}
	public Integer getIsVote() {
		return isVote;
	}
	public void setIsVote(Integer isVote) {
		this.isVote = isVote;
	}
	
}
