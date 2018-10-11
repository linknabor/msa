package com.eshequ.msa.ops.web.votemng.front;

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
import com.eshequ.msa.ops.model.votemng.VoteMng;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.service.votemng.IVoteMngService;
import com.eshequ.msa.ops.service.votemng.IVoteReleaseService;
import com.eshequ.msa.ops.service.votemng.ReleaseRegionRemote;
import com.eshequ.msa.ops.vo.votemng.VoteAndOptionVo;
import com.eshequ.msa.ops.vo.votemng.VoteCountAndOptionVo;
import com.eshequ.msa.ops.vo.votemng.VoteOptionVo;
import com.eshequ.msa.ops.vo.votemng.VoteRelaseOptionVo;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseAndRegionVo;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseDetailVo;
import com.eshequ.msa.ops.vo.votemng.VoteReleaseParamVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	private IVoteReleaseService voteReleaseService;

	@Autowired
	private IVoteMngService voteMngService;
	
	@RequestMapping(value = "/getVoteReleaseList", method = RequestMethod.GET)
	public List<VoteRelease> getVoteReleaseList(@RequestBody VoteReleaseParamVo voteReleaseParamVo) {
		List<VoteRelease> lists = voteReleaseService.getVoteReleaseList(voteReleaseParamVo);
		return lists;
	}
	@RequestMapping(value = "/getVoteReleaseById", method = RequestMethod.GET)
	public VoteReleaseDetailVo getVoteReleaseById(Long releaseId,@ModelAttribute(Constants.USER) User user) {
		VoteReleaseDetailVo v=new VoteReleaseDetailVo();
		VoteRelease voteRelease=voteReleaseService.getVoteReleaseById(releaseId);
		VoteMng voteMng=voteMngService.getVoteMngById(voteRelease.getVoteId());
		v.setVoteRelease(voteRelease);
		v.setVoteMng(voteMng);
		v.setVoteCountAndOptionVo(getVoteCountAndOption(voteRelease.getVoteId(),voteRelease.getReleaseId()));
		v.setIsVote(checkRecord(voteRelease.getReleaseId(),user));
		return v;
	}
	@RequestMapping(value = "/addVoteRecord", method = RequestMethod.POST)
	public BaseResult<?> addVoteRecord(VoteRelaseOptionVo voteRelaseOptionVo,
			@ModelAttribute(Constants.USER) User user){
		return voteReleaseService.addVoteRecord(voteRelaseOptionVo,user);
	}
	public VoteCountAndOptionVo getVoteCountAndOption(Long voteId, Long releaseId) {
		List<VoteOptionVo> voteOptionVoList = voteMngService.getOptions(voteId, releaseId);
		int totalVote = voteMngService.getTotalVote(voteId, releaseId);
		VoteCountAndOptionVo v = new VoteCountAndOptionVo();
		v.setTotalVote(totalVote);
		v.setVoteOptionVoList(voteOptionVoList);
		return v;
	}
	
	public int checkRecord(Long releaseId,User user){
		return voteReleaseService.checkRecord(releaseId,user);
	}
}
