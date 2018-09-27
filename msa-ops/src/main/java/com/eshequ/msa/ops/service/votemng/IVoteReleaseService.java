package com.eshequ.msa.ops.service.votemng;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.votemng.ReleaseRegion;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseAndRegionVo;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseParamVo;

public interface IVoteReleaseService {

	List<VoteRelease> getVoteReleaseList(VoteReleaseParamVo voteReleaseParamVo);

	BaseResult<?> deleteVoteReleaseById(Long releaseId);

	BaseResult<?> updateVoteReleaseStatus(VoteRelease voteRelease);

	VoteReleaseAndRegionVo getVoteReleaseById(VoteRelease voteRelease);

	BaseResult<?> addVoteRelease(VoteReleaseAndRegionVo voteReleaseAndRegionVo);

	BaseResult<?> updateVoteRelease(VoteReleaseAndRegionVo voteReleaseAndRegionVo);

	List<ReleaseRegion> getReleaseRegionByreleaseId(Long releaseId);

}
