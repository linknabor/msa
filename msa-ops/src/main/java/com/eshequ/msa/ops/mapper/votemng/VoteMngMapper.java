package com.eshequ.msa.ops.mapper.votemng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.votemng.VoteMng;

public interface VoteMngMapper extends CommonMapper<VoteMng> {

	List<VoteMng> getVoteMngList(VoteMng voteMng);

	VoteMng getVoteMngById(@Param("voteId")Long voteId);

}
