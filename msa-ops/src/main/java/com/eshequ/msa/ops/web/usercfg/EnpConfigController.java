package com.eshequ.msa.ops.web.usercfg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseEnterprise;
import com.eshequ.msa.ops.model.bdp.MsaCfgEnpPara;
import com.eshequ.msa.ops.service.usercfg.EnpConfigRemote;
import com.eshequ.msa.ops.web.BaseController;

//企业参数配置
@RestController
@RequestMapping("/enpconfig")
public class EnpConfigController extends BaseController{
	@Autowired
	private EnpConfigRemote userConfigRemote;
	
	//获得企业客户信息
	@RequestMapping(value="/getEnterprise",method=RequestMethod.GET)
	public List<MsaBaseEnterprise> getEnterprise(String enterpriseName,int pageNum, int pageSize) {
		List<MsaBaseEnterprise> list = userConfigRemote.getEnterprise(enterpriseName,pageNum, pageSize);
		return list;
	}
	
	// 根据企业客户信息获得物业参数配置
	@RequestMapping(value="/getEnterpriseConfigByEnterpriseId",method=RequestMethod.GET)
	public List<MsaCfgEnpPara> getEnterpriseConfigByEnterpriseId(Long enterpriseId) {
		return userConfigRemote.getEnterpriseConfigByEnterpriseId(enterpriseId);
	}

	// 根据企业配置id修改企业配置
	@RequestMapping(value = "/updateCfgEnpByParaId", method = RequestMethod.GET)
	public BaseResult<?> updateCfgEnpByParaId(Long paraId, String value) {
		return userConfigRemote.updateCfgEnpByParaId(paraId, value);
	}
}
