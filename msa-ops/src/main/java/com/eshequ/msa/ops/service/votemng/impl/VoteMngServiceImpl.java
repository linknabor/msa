package com.eshequ.msa.ops.service.votemng.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.common.User;
import com.eshequ.msa.ops.mapper.votemng.VoteMngMapper;
import com.eshequ.msa.ops.mapper.votemng.VoteOptionMapper;
import com.eshequ.msa.ops.mapper.votemng.VoteRecordMapper;
import com.eshequ.msa.ops.mapper.votemng.VoteReleaseMapper;
import com.eshequ.msa.ops.model.votemng.VoteMng;
import com.eshequ.msa.ops.model.votemng.VoteOption;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.service.votemng.IVoteMngService;
import com.eshequ.msa.ops.vo.votemng.VoteOptionVo;
import com.eshequ.msa.util.DateUtil;
import com.eshequ.msa.util.SnowFlake;

@Service
@Transactional
public class VoteMngServiceImpl implements IVoteMngService {
	private final String SHOW_OPTION = "0";// 显示选项
	// private final String HIDE_OPTION="1";//隐藏选项

	@Autowired
	private VoteMngMapper voteMngMapper;

	@Autowired
	private VoteOptionMapper voteOptionMapper;

	@Autowired
	private VoteRecordMapper voteRecordMapper;

	@Autowired
	private VoteReleaseMapper voteReleaseMapper;

	@Autowired
	private SnowFlake snowFlake;

	@Override
	public BaseResult<?> addVote(VoteMng voteMng, List<VoteOption> list, User user) {
		long voteId = snowFlake.nextId();
		voteMng.setVoteId(voteId);
		if (user != null) {
			voteMng.setUserId(user.getUserId());
			voteMng.setUserName(user.getUserName());
		}
		voteMng.setCreateDate(DateUtil.getSysDate());
		voteMng.setCreateTime(DateUtil.getSysTime());
		// 格式化前端传过来的时间
		voteMng.setVoteCloseDate(DateUtil.format2DB(voteMng.getVoteCloseDate()));
		voteMng.setVoteCloseTime(DateUtil.formatTime2DB(voteMng.getVoteCloseTime()));
		int voteMngCount = voteMngMapper.insertSelective(voteMng);
		if (voteMngCount == 0) {
			return BaseResult.fail("新增失败!");
		}
		for (VoteOption voteOption : list) {
			long optionId = snowFlake.nextId();
			voteOption.setOptionId(optionId);
			voteOption.setVoteId(voteId);
			voteOption.setStatus(SHOW_OPTION);
			voteOptionMapper.insertSelective(voteOption);
		}
		return BaseResult.successResult("新增成功!");
	}

	@Override
	public BaseResult<?> updateVote(VoteMng voteMng, List<VoteOption> list) {
		// 格式化前端传过来的时间
		voteMng.setVoteCloseDate(DateUtil.format2DB(voteMng.getVoteCloseDate()));
		voteMng.setVoteCloseTime(DateUtil.formatTime2DB(voteMng.getVoteCloseTime()));
		int count = voteMngMapper.updateByPrimaryKeySelective(voteMng);
		if (count == 0) {
			return BaseResult.fail("保存失败!");
		}
		for (VoteOption voteOption : list) {
			if (voteOption.getOptionId() != null) {
				voteOptionMapper.updateByPrimaryKeySelective(voteOption);
			} else {
				long optionId = snowFlake.nextId();
				voteOption.setOptionId(optionId);
				voteOption.setVoteId(voteMng.getVoteId());
				voteOptionMapper.insertSelective(voteOption);
			}

		}
		return BaseResult.successResult("保存成功!");
	}

	@Override
	public List<VoteMng> getVoteMngList(VoteMng voteMng) {
		return voteMngMapper.getVoteMngList(voteMng);
	}

	@Override
	public int getTotalVote(Long voteId, Long releaseId) {
		return voteRecordMapper.getTotalVoteByVoteIdAndReleaseId(voteId, releaseId);
	}

	@Override
	public List<VoteOptionVo> getOptions(Long voteId, Long releaseId) {
		List<VoteOptionVo> list = new ArrayList<>();
		List<VoteOption> options = voteOptionMapper.getOptionsByVoteId(voteId);
		for (VoteOption voteOption : options) {
			VoteOptionVo voteOptionVo = new VoteOptionVo();
			voteOptionVo.setVoteOptionId(voteOption.getOptionId());
			voteOptionVo.setVoteOptionName(voteOption.getOptionName());
			voteOptionVo.setVoteCount(voteRecordMapper.getVoteByOptionIdAndVoteIdAndReleaseId(voteOption.getOptionId(),
					voteId, releaseId));
			list.add(voteOptionVo);
		}
		return list;
	}
	@Override
	public List<VoteOptionVo> getShowOptions(Long voteId, Long releaseId) {
		List<VoteOptionVo> list = new ArrayList<>();
		List<VoteOption> options =voteOptionMapper.getShowOptionsByVoteId(voteId);
		for (VoteOption voteOption : options) {
			VoteOptionVo voteOptionVo = new VoteOptionVo();
			voteOptionVo.setVoteOptionId(voteOption.getOptionId());
			voteOptionVo.setVoteOptionName(voteOption.getOptionName());
			voteOptionVo.setVoteCount(voteRecordMapper.getVoteByOptionIdAndVoteIdAndReleaseId(voteOption.getOptionId(),
					voteId, releaseId));
			list.add(voteOptionVo);
		}
		return list;
	}

	@Override
	public VoteMng getVoteMngById(Long voteId) {
		return voteMngMapper.getVoteMngById(voteId);
	}

	@Override
	public List<VoteRelease> getVoteReleaseByVoteId(Long voteId) {
		return voteReleaseMapper.getVoteReleaseByVoteId(voteId);
	}

	@Override
	public BaseResult<?> deleteVoteMngById(Long voteId) {
		if (voteMngMapper.deleteByPrimaryKey(voteId) > 0) {
			voteOptionMapper.deleteByVoteId(voteId);
			return BaseResult.successResult("删除成功！");
		}

		return BaseResult.fail("删除失败！");
	}

}
