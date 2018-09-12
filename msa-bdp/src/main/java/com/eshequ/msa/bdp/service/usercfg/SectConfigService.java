package com.eshequ.msa.bdp.service.usercfg;

import java.util.List;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.common.BaseModel;

public interface SectConfigService {
	/**
	 * 根据企业客户信息获得物业项目信息
	 * @param enterpriseId 企业id
	 * @param model 分页参数
	 * @return
	 */
	List<MsaBaseSect> getSectByEnterpriseId(Long enterpriseId,BaseModel model);

}
