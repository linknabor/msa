package com.eshequ.msa.ops.service.usercfg;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.model.bdp.MsaCfgSectPara;

@FeignClient(name="msa-bdp",fallback = SectConfigFeignFallBack.class)
public interface SectConfigRemote {
	
	//根据企业客户信息获得物业项目信息
	@RequestMapping(value="bdp/sectconfig/getSectByEnterpriseId",method = RequestMethod.GET)
	List<MsaBaseSect> getSectByEnterpriseId(@RequestParam("sectName")String sectName,
			@RequestParam("sectAddr")String  sectAddr,
			@RequestParam("enterpriseId")Long enterpriseId,
			@RequestParam("pageNum")int pageNum,
			@RequestParam("pageSize")int pageSize);

	@RequestMapping(value="bdp/sectconfig/getSectConfigBySectId",method = RequestMethod.GET)
	List<MsaCfgSectPara> getSectConfigBySectId(@RequestParam("sectId")Long sectId);
	
	@RequestMapping(value="bdp/sectconfig/updateCfgSectByParaId",method = RequestMethod.GET)
	BaseResult<?> updateCfgSectByParaId(@RequestParam("paraId")Long paraId, @RequestParam("paraValue")String paraValue);
}
