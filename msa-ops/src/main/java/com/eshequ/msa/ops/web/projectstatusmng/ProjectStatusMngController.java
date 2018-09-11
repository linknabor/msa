package com.eshequ.msa.ops.web.projectstatusmng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.model.msasmsmng.MsaSmsSum;
import com.eshequ.msa.ops.service.projectstatusmng.ProjectStatusMngService;
import com.eshequ.msa.ops.vo.SectAndEnterpriseVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/projectStatusMng")
public class ProjectStatusMngController {
	@Autowired
     private ProjectStatusMngService projectStatusMngService;
	@RequestMapping(value="/getMsaBaseSectList")
	public PageInfo<MsaBaseSect> getMsaBaseSectList(@RequestParam(defaultValue = "0", required = false) int pageNum,
			@RequestParam(defaultValue = "10", required = false) int pageSize,SectAndEnterpriseVo sectAndEnterpriseVo){
		  projectStatusMngService.getSectAndEnterpriseList(pageNum,pageSize,sectAndEnterpriseVo);
		
		return null;
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
