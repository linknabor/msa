package com.eshequ.msa.ops.service.usercfg;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseEnterprise;
import com.eshequ.msa.ops.model.bdp.MsaCfgEnpPara;

@FeignClient(name="msa-bdp",fallback = EnpConfigFeignFallBack.class)
public interface EnpConfigRemote {
	//项目名/controller/接口名
	@RequestMapping(value = "/bdp/enpconfig/getEnterprise", method = RequestMethod.GET)
	List<MsaBaseEnterprise> getEnterprise(@RequestParam("enterpriseName")String enterpriseName,@RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize);
	
	@RequestMapping(value = "/bdp/enpconfig/getEnterpriseConfigByEnterpriseId", method = RequestMethod.GET)
	List<MsaCfgEnpPara> getEnterpriseConfigByEnterpriseId(@RequestParam("enterpriseId")Long enterpriseId);
	
	@RequestMapping(value = "/bdp/enpconfig/updateCfgEnpByParaId", method = RequestMethod.GET)
	BaseResult<?> updateCfgEnpByParaId(@RequestParam("paraId")Long paraId, @RequestParam("value")String value);
}
