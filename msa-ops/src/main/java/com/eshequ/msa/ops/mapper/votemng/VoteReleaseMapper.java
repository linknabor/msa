package com.eshequ.msa.ops.mapper.votemng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseParamVo;

public interface VoteReleaseMapper extends CommonMapper<VoteRelease>{

	List<VoteRelease> getVoteReleaseByVoteId(@Param("voteId")Long voteId);

	List<VoteRelease> getVoteReleaseList(VoteReleaseParamVo voteReleaseParamVo);

	int updateVoteReleaseStatus(VoteRelease voteRelease);
	
	VoteRelease getVoteReleaseById(@Param("releaseId")Long releaseId);

}
