package com.eshequ.msa.bdp.service.usercfg;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshequ.msa.bdp.model.MasConfigParamVO;
import com.eshequ.msa.bdp.model.MsaBaseEnterprise;
import com.eshequ.msa.bdp.model.MsaCfgEnpPara;
import com.eshequ.msa.common.BaseModel;
import com.eshequ.msa.common.BaseResult;


public interface EnpConfigService {
	/**
	 * 获得企业客户信息
	 * @return
	 */
	List<MsaBaseEnterprise> getEnterprise(String enterpriseName,int pageNum, int pageSize);

	/**
	 * 根据企业客户信息获得企业参数配置
	 * @param enterpriseId 企业id
	 * @return
	 */
	List<MsaCfgEnpPara> getEnterpriseConfigByEnterpriseId(Long enterpriseId);
	
	/**
	 * 根据企业配置id修改企业配置
	 * @param paraId 参数id
	 * @param value 参数内容
	 * @return
	 */
	BaseResult<?> updateCfgEnpByParaId(Long paraId,String value);
	
}
