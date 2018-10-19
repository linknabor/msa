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
import com.eshequ.msa.ops.model.votemng.VoteMng;
import com.eshequ.msa.ops.model.votemng.VoteRelease;
import com.eshequ.msa.ops.service.votemng.IVoteMngService;
import com.eshequ.msa.ops.vo.votemng.VoteAndOptionVo;
import com.eshequ.msa.ops.vo.votemng.VoteCountAndOptionVo;
import com.eshequ.msa.ops.vo.votemng.VoteMngDetailVo;
import com.eshequ.msa.ops.vo.votemng.VoteOptionVo;
import com.eshequ.msa.ops.web.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/voteMng")
public class VoteMngController extends BaseController {
	@Autowired
	private IVoteMngService voteMngService;
    
	//新建或编辑投票管理
	@RequestMapping(value = "/addOrUpdateVote", method = RequestMethod.POST)
	public BaseResult<?> addOrUpdateVote(@RequestBody VoteAndOptionVo voteAndOptionVo,
			@ModelAttribute(Constants.USER) User user) {
		if (voteAndOptionVo.getVoteMng() != null && voteAndOptionVo.getVoteMng().getVoteId() != null) {
			return voteMngService.updateVote(voteAndOptionVo.getVoteMng(), voteAndOptionVo.getList());
		} else {
			return voteMngService.addVote(voteAndOptionVo.getVoteMng(), voteAndOptionVo.getList(), user);
		}
	}
	
	//获取投票管理列表
	@RequestMapping(value = "/getVoteMngList", method = RequestMethod.GET)
	public PageInfo<VoteMng> getVoteMngList(@RequestParam(defaultValue = "0", required = false) Integer pageNum,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize,VoteMng voteMng) {
		PageHelper.startPage(pageNum, pageSize);
		List<VoteMng> lists = voteMngService.getVoteMngList(voteMng);
		PageInfo<VoteMng> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}
	
	//获取投票管理集合
	@RequestMapping(value = "/selectVoteList", method = RequestMethod.GET)
	public List<VoteMng> selectVoteList(VoteMng voteMng){
		return voteMngService.getVoteMngList(voteMng);
	}
    
	//根据id获取投票管理详情
	@RequestMapping(value = "/getVoteMngDetail", method = RequestMethod.GET)
	public VoteMngDetailVo getVoteMngDetail(Long voteId) {
		VoteMng voteMng = voteMngService.getVoteMngById(voteId);
		List<VoteRelease> voteReleaseList = voteMngService.getVoteReleaseByVoteId(voteId);
		VoteCountAndOptionVo voteCountAndOptionVo = getVoteCountAndOption(voteId, null);
		VoteMngDetailVo voteMngDetailVo = new VoteMngDetailVo();
		voteMngDetailVo.setVoteCountAndOptionVo(voteCountAndOptionVo);
		voteMngDetailVo.setVoteMng(voteMng);
		voteMngDetailVo.setVoteReleaseList(voteReleaseList);
		return voteMngDetailVo;

	}
    
	//获取投票选项和票数
	@RequestMapping(value = "/getVoteCountAndOption", method = RequestMethod.GET)
	public VoteCountAndOptionVo getVoteCountAndOption(Long voteId, Long releaseId) {
		List<VoteOptionVo> voteOptionVoList = voteMngService.getOptions(voteId, releaseId);
		int totalVote = voteMngService.getTotalVote(voteId, releaseId);
		VoteCountAndOptionVo v = new VoteCountAndOptionVo();
		v.setTotalVote(totalVote);
		v.setVoteOptionVoList(voteOptionVoList);
		return v;
	}
    
	//根据id删除投票管理
	@RequestMapping(value = "/deleteVoteMng", method = RequestMethod.GET)
	public BaseResult<?> deleteVoteMngById(Long voteId) {
		if(voteId != null){
			return voteMngService.deleteVoteMngById(voteId);
		}
		return BaseResult.fail(500, "参数错误!");
	}
}
