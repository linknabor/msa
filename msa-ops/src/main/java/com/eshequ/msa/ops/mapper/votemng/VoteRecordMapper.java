package com.eshequ.msa.ops.mapper.votemng;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.ops.model.votemng.VoteRecord;

public interface VoteRecordMapper extends CommonMapper<VoteRecord> {
	int getTotalVoteByVoteIdAndReleaseId(@Param("voteId") Long voteId, @Param("releaseId") Long releaseId);
	int getVoteByOptionIdAndVoteIdAndReleaseId(@Param("optionId")Long optionId,@Param("voteId") Long voteId, @Param("releaseId") Long releaseId);
	//检测是否重复投票
	int checkVoteUser(@Param("voteId") Long voteId,@Param("userId") Long userId);
	
	//检测是否重复投票
	int checkRecord(@Param("releaseId") Long releaseId,@Param("userId") Long userId);
	//统计参与投票人数
	List<VoteRecord> getVoteMngPeopleCount(@Param("voteId") Long voteId);
}
