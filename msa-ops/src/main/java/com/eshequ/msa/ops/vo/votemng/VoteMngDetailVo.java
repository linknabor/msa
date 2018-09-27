package com.eshequ.msa.ops.vo.votemng;

import java.util.List;

import com.eshequ.msa.ops.model.votemng.VoteMng;
import com.eshequ.msa.ops.model.votemng.VoteRelease;

public class VoteMngDetailVo {
	private VoteMng voteMng;
	private List<VoteRelease> voteReleaseList;
	private VoteCountAndOptionVo voteCountAndOptionVo;
	
	public VoteMng getVoteMng() {
		return voteMng;
	}
	public void setVoteMng(VoteMng voteMng) {
		this.voteMng = voteMng;
	}
	public List<VoteRelease> getVoteReleaseList() {
		return voteReleaseList;
	}
	public void setVoteReleaseList(List<VoteRelease> voteReleaseList) {
		this.voteReleaseList = voteReleaseList;
	}
	public VoteCountAndOptionVo getVoteCountAndOptionVo() {
		return voteCountAndOptionVo;
	}
	public void setVoteCountAndOptionVo(VoteCountAndOptionVo voteCountAndOptionVo) {
		this.voteCountAndOptionVo = voteCountAndOptionVo;
	}
	
	

}
