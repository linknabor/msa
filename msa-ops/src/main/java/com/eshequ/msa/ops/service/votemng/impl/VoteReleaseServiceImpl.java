package com.eshequ.msa.ops.service.votemng.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.common.User;
import com.eshequ.msa.ops.mapper.votemng.ReleaseRegionMapper;
import com.eshequ.msa.ops.mapper.votemng.VoteRecordMapper;
import com.eshequ.msa.ops.mapper.votemng.VoteReleaseMapper;
import com.eshequ.msa.ops.model.votemng.ReleaseRegion;
import com.eshequ.msa.ops.model.votemng.VoteOption;
import com.eshequ.msa.ops.model.votemng.VoteRecord;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.service.votemng.IVoteReleaseService;
import com.eshequ.msa.ops.vo.votemng.VoteRelaseOptionVo;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseAndRegionVo;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseParamVo;
import com.eshequ.msa.util.DateUtil;
import com.eshequ.msa.util.ObjectUtil;
import com.eshequ.msa.util.SnowFlake;

@Service
@Transactional
public class VoteReleaseServiceImpl implements IVoteReleaseService {
	private final String SHOW_VOTE_RELEASE = "1";//表示发布有效  0表示发布失效
	@Autowired
	private VoteReleaseMapper voteReleaseMapper;

	@Autowired
	private ReleaseRegionMapper releaseRegionMapper;
	
	@Autowired
	private VoteRecordMapper voteRecordMapper;

	@Autowired
	private SnowFlake snowFlake;

	@Override
	public BaseResult<?> addVoteRelease(VoteReleaseAndRegionVo voteReleaseAndRegionVo) {
		long releaseId = snowFlake.nextId();
		int count = voteReleaseMapper
				.insertSelective(copyVoteReleaseVoToVoteRelease(releaseId, voteReleaseAndRegionVo));
		if (count == 0) {
			return BaseResult.fail("新增失败!");
		}
		if (voteReleaseAndRegionVo.getList() != null && voteReleaseAndRegionVo.getList().size() > 0) {
			for (ReleaseRegion releaseRegion : voteReleaseAndRegionVo.getList()) {
				long regionId = snowFlake.nextId();
				releaseRegion.setRegionId(regionId);
				releaseRegion.setReleaseId(releaseId);
				releaseRegionMapper.insertSelective(releaseRegion);
			}
		}
		return BaseResult.successResult("新增成功!");
	}

	@Override
	public BaseResult<?> updateVoteRelease(VoteReleaseAndRegionVo voteReleaseAndRegionVo) {
		int count = voteReleaseMapper
				.updateByPrimaryKeySelective(copyVoteReleaseVoToVoteRelease(null, voteReleaseAndRegionVo));
		if (count == 0) {
			return BaseResult.fail("保存失败!");
		}
		if (voteReleaseAndRegionVo.getList() != null && voteReleaseAndRegionVo.getList().size() > 0) {
			for (ReleaseRegion releaseRegion : voteReleaseAndRegionVo.getList()) {
				if (releaseRegion.getRegionId() != null) {
					releaseRegionMapper.updateByPrimaryKeySelective(releaseRegion);
				} else {
					long regionId = snowFlake.nextId();
					releaseRegion.setRegionId(regionId);
					releaseRegion.setReleaseId(voteReleaseAndRegionVo.getReleaseId());
					releaseRegionMapper.insertSelective(releaseRegion);
				}

			}
		}
		return BaseResult.successResult("保存成功!");
	}

	@Override
	public List<VoteRelease> getVoteReleaseList(VoteReleaseParamVo voteReleaseParamVo) {

		return voteReleaseMapper.getVoteReleaseList(voteReleaseParamVo);
	}

	@Override
	public BaseResult<?> deleteVoteReleaseById(Long releaseId) {
		if (voteReleaseMapper.deleteByPrimaryKey(releaseId) > 0) {
			releaseRegionMapper.deleteVoteReleaseByReleaseId(releaseId);
			return BaseResult.successResult("删除成功！");
		}

		return BaseResult.fail("删除失败！");
	}

	@Override
	public BaseResult<?> updateVoteReleaseStatus(VoteRelease voteRelease) {
		if (voteReleaseMapper.updateByPrimaryKeySelective(voteRelease) > 0) {
			return BaseResult.successResult("修改成功！");
		}

		return BaseResult.fail("修改失败！");
	}

	@Override
	public VoteReleaseAndRegionVo getVoteReleaseById(VoteRelease voteRelease) {
		return getVoteReleaseAndRegionVo(voteReleaseMapper.selectOne(voteRelease));
	}

	private VoteRelease copyVoteReleaseVoToVoteRelease(Long releaseId, VoteReleaseAndRegionVo voteReleaseAndRegionVo) {
		VoteRelease vr = new VoteRelease();
		BeanUtils.copyProperties(voteReleaseAndRegionVo, vr);
		// 格式化前端传过来的时间
		vr.setCloseDate(DateUtil.format2DB(vr.getCloseDate()));
		vr.setCloseTime(DateUtil.formatTime2DB(vr.getCloseTime()));
		if (releaseId != null) {
			vr.setReleaseId(releaseId);
			vr.setCreateDate(DateUtil.getSysDate());
			vr.setCerateTime(DateUtil.getSysTime());
			vr.setReleaseStatus(SHOW_VOTE_RELEASE);
		}
		String content = voteReleaseAndRegionVo.getReleaseContent();
		if (!ObjectUtil.isEmpty(content)) {
			vr.setReleaseContent(content.replaceAll("#@#@#", "&"));
		}
		return vr;
	}

	private VoteReleaseAndRegionVo getVoteReleaseAndRegionVo(VoteRelease voteRelease) {
		VoteReleaseAndRegionVo vo = new VoteReleaseAndRegionVo();
		BeanUtils.copyProperties(voteRelease, vo);
		return vo;
	}

	@Override
	public List<ReleaseRegion> getReleaseRegionByreleaseId(Long releaseId) {

		return releaseRegionMapper.getReleaseRegionByreleaseId(releaseId);
	}

	@Override
	public VoteRelease getVoteReleaseById(Long releaseId) {
		return voteReleaseMapper.getVoteReleaseById(releaseId);
	}

	@Override
	public BaseResult<?> addVoteRecord(VoteRelaseOptionVo voteRelaseOptionVo, User user) {
		List<VoteOption> list=voteRelaseOptionVo.getList();
		VoteRecord voteRecord=new VoteRecord();
		if(user !=null){
			voteRecord.setUserId(user.getUserId());
			voteRecord.setUserName(user.getUserName());
		}
		voteRecord.setVoteDate(DateUtil.getSysDate());
		voteRecord.setVoteTime(DateUtil.getSysTime());
		for (VoteOption voteOption : list) {
			long recordId = snowFlake.nextId();
			voteRecord.setRecordId(recordId);
			voteRecord.setReleaseId(voteRelaseOptionVo.getReleaseId());
			voteRecord.setVoteId(voteRelaseOptionVo.getVoteId());
			voteRecord.setOptionId(voteOption.getOptionId());
			voteRecordMapper.insertSelective(voteRecord);
		}
		return BaseResult.successResult("投票提交成功！");
	}

	@Override
	public int checkRecord(Long releaseId,User user) {
		int count=0;
		if(user != null){
			count=voteRecordMapper.checkRecord(releaseId, user.getUserId());
		}
		return count;
	}

}
