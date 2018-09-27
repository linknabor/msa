package com.eshequ.msa.ops.service.votemng;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.common.User;
import com.eshequ.msa.ops.model.votemng.VoteMng;
import com.eshequ.msa.ops.model.votemng.VoteOption;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.vo.votemng.VoteOptionVo;

public interface IVoteMngService {

	BaseResult<?> addVote(VoteMng voteMng, List<VoteOption> list, User user);

	List<VoteMng> getVoteMngList(VoteMng voteMng);

	int getTotalVote(Long voteId, Long releaseId);

	List<VoteOptionVo> getOptions(Long voteId, Long releaseId);

	VoteMng getVoteMngById(Long voteMngId);

	List<VoteRelease> getVoteReleaseByVoteId(Long voteId);

	BaseResult<?> updateVote(VoteMng voteMng, List<VoteOption> list);

	BaseResult<?> deleteVoteMngById(Long voteId);

}
