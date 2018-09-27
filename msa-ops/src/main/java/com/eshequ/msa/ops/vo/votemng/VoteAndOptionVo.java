package com.eshequ.msa.ops.vo.votemng;

import java.util.List;

import com.eshequ.msa.ops.model.votemng.VoteMng;
import com.eshequ.msa.ops.model.votemng.VoteOption;

public class VoteAndOptionVo {
	private VoteMng voteMng;
	private List<VoteOption> list;
	public VoteMng getVoteMng() {
		return voteMng;
	}
	public void setVoteMng(VoteMng voteMng) {
		this.voteMng = voteMng;
	}
	public List<VoteOption> getList() {
		return list;
	}
	public void setList(List<VoteOption> list) {
		this.list = list;
	}
	
	

}
