package com.eshequ.msa.bdp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.bdp.model.MasConfigParamVO;
import com.eshequ.msa.bdp.model.MsaCfgEnpPara;
import com.eshequ.msa.common.CommonMapper;

public interface MsaCfgEnpParaMapper  extends CommonMapper<MsaCfgEnpPara>{
	/**
	 * 去重（分组）查询企业对应的参数列表
	 * @param enterpriseId 企业id
	 * @return
	 */
	List<MsaCfgEnpPara> getMsaCfgEnpParaGroup(@Param("enterpriseId") Long enterpriseId);
	
	/**
	 * 获得企业参数的参数
	 * @param map
	 * @return
	 */
	List<MasConfigParamVO> getMsaCfgEnpParaByParam(Map<String,Object> map);
	
	/**
	 * 根据企业配置id修改企业配置
	 * @param msaCfgEnpPara
	 * @return
	 */
	int updateCfgEnpByParaId(MsaCfgEnpPara msaCfgEnpPara);
}
