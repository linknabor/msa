package com.eshequ.msa.ops.mapper.votemng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.votemng.VoteOption;

public interface VoteOptionMapper extends CommonMapper<VoteOption> {

	List<VoteOption> getOptionsByVoteId(@Param("voteId") Long voteId);

	List<VoteOption> getShowOptionsByVoteId(@Param("voteId") Long voteId);

	void deleteByVoteId(@Param("voteId") Long voteId);

}
