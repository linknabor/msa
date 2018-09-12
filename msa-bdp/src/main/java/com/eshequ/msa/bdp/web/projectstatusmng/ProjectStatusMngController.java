package com.eshequ.msa.bdp.web.projectstatusmng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.service.projectstatusmng.ProjectStatusMngService;
import com.eshequ.msa.bdp.vo.SectAndEnterpriseVo;
import com.eshequ.msa.common.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/projectStatusMng")
public class ProjectStatusMngController {
	@Autowired
     private ProjectStatusMngService projectStatusMngService;
	@RequestMapping(value="/getSectAndEnterpriseList",method=RequestMethod.POST)
	public BaseResult<?> getSectAndEnterpriseList(@RequestParam(defaultValue = "0", required = false) int pageNum,
			@RequestParam(defaultValue = "10", required = false) int pageSize,@RequestBody SectAndEnterpriseVo sectAndEnterpriseVo){
		PageHelper.startPage(pageNum, pageSize);
		List<SectAndEnterpriseVo> lists = projectStatusMngService.getSectAndEnterpriseList(sectAndEnterpriseVo);
		PageInfo<SectAndEnterpriseVo> pageInfo = new PageInfo<>(lists);
		return BaseResult.successResult(pageInfo);
		
	}
	@RequestMapping(value="/addOrUpdateMasBaseSect",method=RequestMethod.POST)
	public int addOrUpdateMasBaseSect(@RequestBody MsaBaseSect masBaseSect){
		if(masBaseSect != null){
			if(masBaseSect.getSectId() != null){
				return projectStatusMngService.updateMasBaseSect(masBaseSect);
			}
		}
		return 0;
	}
}
