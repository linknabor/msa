package com.eshequ.msa.bdp.web.usercfg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.bdp.model.MasConfigParamVO;
import com.eshequ.msa.bdp.model.MsaBaseEnterprise;
import com.eshequ.msa.bdp.model.MsaCfgEnpPara;
import com.eshequ.msa.bdp.service.usercfg.EnpConfigService;
import com.eshequ.msa.bdp.web.BaseController;
import com.eshequ.msa.common.BaseModel;
import com.eshequ.msa.common.BaseResult;

//企业参数配置
@RestController
@RequestMapping("/enpconfig")
public class EnpConfigController extends BaseController{
	@Autowired
	private EnpConfigService enpConfigService;
	
	//获得企业客户信息
	@RequestMapping(value="/getEnterprise",method=RequestMethod.GET)
	public List<MsaBaseEnterprise> getEnterprise(BaseModel model) {
		return enpConfigService.getEnterprise(model);
	}
	
	// 根据企业客户信息获得物业参数配置
	@RequestMapping(value="/getEnterpriseConfigByEnterpriseId",method=RequestMethod.GET)
	public List<MsaCfgEnpPara> getEnterpriseConfigByEnterpriseId(Long enterpriseId) {
		return enpConfigService.getEnterpriseConfigByEnterpriseId(enterpriseId);
	}
	
	// 根据企业配置id修改企业配置
	@RequestMapping(value="/updateCfgEnpByParaId",method=RequestMethod.GET)
	public BaseResult<?> updateCfgEnpByParaId(Long paraId,String value) {
		return enpConfigService.updateCfgEnpByParaId(paraId, value);
	}

	
}
