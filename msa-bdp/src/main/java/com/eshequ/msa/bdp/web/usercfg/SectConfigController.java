package com.eshequ.msa.bdp.web.usercfg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.bdp.model.MsaBaseSect;
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
	@RequestMapping(value="/getSect",method=RequestMethod.GET)
	public List<MsaBaseSect> getSectByEnterpriseId(Long enterpriseId,BaseModel model) {
		return sectConfigService.getSectByEnterpriseId(enterpriseId ,model);
	}
	
	// 根据企业客户信息获得物业参数配置
	@RequestMapping(value="/getSectByEnterprise",method=RequestMethod.POST)
	public BaseResult<?> getSectByEnterprise(Long enterpriseId) {
		//返回很多 物业项目信息
		return null;
	}
	
	//根据物业项目信息id获得项目参数配置
	@RequestMapping(value="/getSectConfigBySectId",method=RequestMethod.POST)
	public BaseResult<?> getSectConfigBySectId(Long sectId) {
		
		return null;
	}
	
	// 根据参数id修改企业参数
	@RequestMapping(value="/updateSectConfigByParaId",method=RequestMethod.POST)
	public BaseResult<?> updateSectConfigByParaId(Long paraId, String paraValue) {

		return null;
	}
	
}
