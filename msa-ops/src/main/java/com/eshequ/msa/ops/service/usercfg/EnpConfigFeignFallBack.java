package com.eshequ.msa.ops.service.usercfg;

import java.util.List;

import org.springframework.stereotype.Component;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseEnterprise;
import com.eshequ.msa.ops.model.bdp.MsaCfgEnpPara;

@Component
public class EnpConfigFeignFallBack implements EnpConfigRemote{

	@Override
	public List<MsaBaseEnterprise> getEnterprise(String enterpriseName,int pageNum, int pageSize) {
		System.out.println("FallBack:报错了，你晓得不？？？？？？？");
		return null;
	}

	@Override
	public List<MsaCfgEnpPara> getEnterpriseConfigByEnterpriseId(Long enterpriseId) {
		System.out.println("FallBack:报错了，你晓得不？？？？？？？");
		return null;
	}

	@Override
	public BaseResult<?> updateCfgEnpByParaId(Long paraId, String value) {
		System.out.println("FallBack:报错了，你晓得不？？？？？？？");
		return null;
	}






}
