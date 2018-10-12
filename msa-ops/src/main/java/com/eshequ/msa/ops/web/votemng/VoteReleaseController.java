package com.eshequ.msa.ops.web.votemng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.common.User;
import com.eshequ.msa.constants.Constants;
import com.eshequ.msa.ops.model.votemng.ReleaseRegion;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.service.votemng.IVoteReleaseService;
import com.eshequ.msa.ops.service.votemng.ReleaseRegionRemote;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseAndRegionVo;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseParamVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/voteRelease")
public class VoteReleaseController {

	@Autowired
	private IVoteReleaseService voteReleaseService;

	@Autowired
	private ReleaseRegionRemote releaseRegionRemote;

	@RequestMapping(value = "/addOrUpdateVoteRelease", method = RequestMethod.POST)
	public BaseResult<?> addOrUpdateVoteRelease(@RequestBody VoteReleaseAndRegionVo VoteReleaseAndRegionVo,
			@ModelAttribute(Constants.USER) User user) {
		if (VoteReleaseAndRegionVo != null) {
			if (VoteReleaseAndRegionVo.getReleaseId() != null) {
				return voteReleaseService.updateVoteRelease(VoteReleaseAndRegionVo);
			} else {
				return voteReleaseService.addVoteRelease(VoteReleaseAndRegionVo,user);
			}
		}
		return BaseResult.fail("参数错误！");
	}

	@RequestMapping(value = "/getVoteReleaseList", method = RequestMethod.GET)
	public PageInfo<VoteRelease> getVoteReleaseList(@RequestParam(defaultValue = "0", required = false) Integer pageNum,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize,
			@RequestBody VoteReleaseParamVo voteReleaseParamVo) {
		PageHelper.startPage(pageNum, pageSize);
		List<VoteRelease> lists = voteReleaseService.getVoteReleaseList(voteReleaseParamVo);
		PageInfo<VoteRelease> pageInfo = new PageInfo<>(lists);
		return pageInfo;

	}

	@RequestMapping(value = "/getVoteReleaseById", method = RequestMethod.GET)
	public VoteReleaseAndRegionVo getVoteReleaseById(@RequestBody VoteRelease voteRelease) {
		VoteReleaseAndRegionVo v = voteReleaseService.getVoteReleaseById(voteRelease);
		List<ReleaseRegion> list = voteReleaseService.getReleaseRegionByreleaseId(voteRelease.getReleaseId());
		v.setList(list);
		return v;

	}

	@RequestMapping(value = "/deleteVoteReleaseById", method = RequestMethod.GET)
	public BaseResult<?> deleteVoteReleaseById(Long releaseId) {
		if (releaseId != null) {
			return voteReleaseService.deleteVoteReleaseById(releaseId);
		}
		return BaseResult.fail(500, "参数错误!");
	}

	@RequestMapping(value = "/updateVoteReleaseStatus", method = RequestMethod.POST)
	public BaseResult<?> updateVoteReleaseStatus(@RequestBody VoteRelease voteRelease) {
		return voteReleaseService.updateVoteReleaseStatus(voteRelease);
	}

	@RequestMapping(value = "/getAllRegion", method = RequestMethod.GET)
	public BaseResult<?> getAllRegion() {
		return releaseRegionRemote.getAllRegion();
	}
}
