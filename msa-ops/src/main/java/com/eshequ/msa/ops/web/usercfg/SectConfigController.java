package com.eshequ.msa.ops.web.usercfg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.model.bdp.MsaCfgSectPara;
import com.eshequ.msa.ops.service.usercfg.SectConfigRemote;
import com.eshequ.msa.ops.web.BaseController;

//项目参数配置
@RestController
@RequestMapping("/sectconfig")
public class SectConfigController extends BaseController{
	@Autowired
	private SectConfigRemote sectConfigRemote;
	
	//根据企业客户信息获得物业项目信息
	@RequestMapping(value="/getSectByEnterpriseId",method=RequestMethod.GET)
	public List<MsaBaseSect> getSectByEnterpriseId(String sectName,String  sectAddr,Long enterpriseId,int pageNum,int pageSize) {
		return sectConfigRemote.getSectByEnterpriseId(sectName,sectAddr,enterpriseId, pageNum, pageSize);
	}
	
	//根据物业项目信息id获得项目参数配置
	@RequestMapping(value="/getSectConfigBySectId",method=RequestMethod.GET)
	public List<MsaCfgSectPara> getSectConfigBySectId(Long sectId) {
		return sectConfigRemote.getSectConfigBySectId(sectId);
	}
	
	// 根据参数id修改企业参数
	@RequestMapping(value="/updateCfgSectByParaId",method=RequestMethod.GET)
	public BaseResult<?> updateCfgSectByParaId(Long paraId, String paraValue) {

		return sectConfigRemote.updateCfgSectByParaId(paraId, paraValue);
	}
	
}
