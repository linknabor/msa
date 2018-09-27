package com.eshequ.msa.ops.service.usercfg;

import java.util.List;

import org.springframework.stereotype.Component;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.ops.model.bdp.MsaBaseSect;
import com.eshequ.msa.ops.model.bdp.MsaCfgSectPara;

@Component
public class SectConfigFeignFallBack implements SectConfigRemote {

	@Override
	public List<MsaBaseSect> getSectByEnterpriseId(String sectName, String sectAddr, Long enterpriseId, int pageNum,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MsaCfgSectPara> getSectConfigBySectId(Long sectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResult<?> updateCfgSectByParaId(Long paraId, String paraValue) {
		// TODO Auto-generated method stub
		return null;
	}



}
