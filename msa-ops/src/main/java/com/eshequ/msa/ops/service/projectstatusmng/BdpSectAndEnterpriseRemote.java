package com.eshequ.msa.ops.service.projectstatusmng;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.vo.SectAndEnterpriseVo;

@FeignClient(value = "msa-bdp",fallback=FeignFallBack.class)
public interface BdpSectAndEnterpriseRemote {
	//项目名/controller/接口名
	    //查询项目状态数据集合
		@RequestMapping(value="/bdp/projectStatusMng/getSectAndEnterpriseList",method=RequestMethod.GET,consumes="application/json")
		BaseResult<?> getSectAndEnterpriseList(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize,@RequestBody SectAndEnterpriseVo sectAndEnterpriseVo);
		
		//编辑项目状态
		@RequestMapping(value="/bdp/projectStatusMng/addOrUpdateMasBaseSect",method=RequestMethod.POST,consumes="application/json")
		int updateMasBaseSect(@RequestBody MsaBaseSect msaBaseSect);

}
