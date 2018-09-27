package com.eshequ.msa.bdp.service.usercfg;

import java.util.List;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.model.MsaCfgSectPara;
import com.eshequ.msa.common.BaseModel;
import com.eshequ.msa.common.BaseResult;

public interface SectConfigService {
	/**
	 * 根据企业客户信息获得物业项目信息
	 * @param enterpriseId 企业id
	 * @param curr_page 当前页
	 * @param page_size 页面大小
	 * @return
	 */
	List<MsaBaseSect> getSectByEnterpriseId(String sectName,String  sectAddr,Long enterpriseId,int pageNum, int pageSize);
	
	/**
	 * 根据物业项目信息获得项目参数配置
	 * @param sectId 项目id
	 * @return
	 */
	List<MsaCfgSectPara> getSectConfigBySectId(Long sectId);
	
	/**
	 * 根据项目参数配置id修改项目参数配置
	 * @param paraId 参数id
	 * @param value 参数内容
	 * @return
	 */
	BaseResult<?> updateCfgSectByParaId(Long paraId,String value);

}
