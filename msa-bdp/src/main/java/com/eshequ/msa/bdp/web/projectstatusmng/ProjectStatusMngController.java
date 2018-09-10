package com.eshequ.msa.bdp.web.projectstatusmng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="/getSectAndEnterpriseList")
	public PageInfo<SectAndEnterpriseVo> getSectAndEnterpriseList(@RequestParam(defaultValue = "0", required = false) int pageNum,
			@RequestParam(defaultValue = "10", required = false) int pageSize,SectAndEnterpriseVo sectAndEnterpriseVo){
		PageHelper.startPage(pageNum, pageSize);
		List<SectAndEnterpriseVo> lists = projectStatusMngService.getSectAndEnterpriseList(sectAndEnterpriseVo);
		PageInfo<SectAndEnterpriseVo> pageInfo = new PageInfo<>(lists);
		return pageInfo;
		
	}
	@RequestMapping(value="/addOrUpdateMasBaseSectList")
	public BaseResult<?> addOrUpdateMasBaseSectList(MsaBaseSect masBaseSect){
		if(masBaseSect != null){
			if(masBaseSect.getSectId() != null){
				return projectStatusMngService.updateMasBaseSect(masBaseSect);
			}
		}
		return BaseResult.fail(500, "参数错误！");
	}
}
