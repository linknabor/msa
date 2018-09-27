package com.eshequ.msa.bdp.web.usercfg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.model.MsaCfgEnpPara;
import com.eshequ.msa.bdp.model.MsaCfgSectPara;
import com.eshequ.msa.bdp.service.usercfg.EnpConfigService;
import com.eshequ.msa.bdp.service.usercfg.SectConfigService;
import com.eshequ.msa.bdp.web.BaseController;
import com.eshequ.msa.common.BaseModel;
import com.eshequ.msa.common.BaseResult;

//项目参数配置
@RestController
@RequestMapping("/sectconfig")
public class SectConfigController extends BaseController{
	@Autowired
	private SectConfigService sectConfigService;
	
	
	//根据企业客户信息获得物业项目信息
	@RequestMapping(value="/getSectByEnterpriseId",method=RequestMethod.GET)
	public List<MsaBaseSect> getSectByEnterpriseId(String sectName,String  sectAddr,Long enterpriseId,int pageNum, int pageSize) {
		return sectConfigService.getSectByEnterpriseId(sectName,sectAddr,enterpriseId, pageNum, pageSize);
	}
	
	// 根据物业项目信息获得项目参数配置
	@RequestMapping(value = "/getSectConfigBySectId", method = RequestMethod.GET)
	public List<MsaCfgSectPara> getSectConfigBySectId(Long sectId) {
		return sectConfigService.getSectConfigBySectId(sectId);
	}
	
	// 根据参数id修改企业参数
	@RequestMapping(value="/updateCfgSectByParaId",method=RequestMethod.GET)
	public BaseResult<?> updateCfgSectByParaId(Long paraId, String paraValue) {
		return sectConfigService.updateCfgSectByParaId(paraId, paraValue);
	}
	
}
