package com.eshequ.msa.bdp.mapper;

import java.util.List;
import java.util.Map;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.model.MsaCfgSectPara;
import com.eshequ.msa.common.CommonMapper;

public interface MsaCfgSectParaMapper extends CommonMapper<MsaCfgSectPara> {
	/**
	 * 根据企业客户信息获得物业项目信息
	 * @param map
	 * @return
	 */
	List<MsaBaseSect> getSectByEnterpriseId(Map<String,Object> map);
}
