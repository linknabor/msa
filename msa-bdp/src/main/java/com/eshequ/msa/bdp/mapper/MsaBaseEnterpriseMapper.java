package com.eshequ.msa.bdp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.bdp.model.MsaBaseEnterprise;
import com.eshequ.msa.common.CommonMapper;

public interface MsaBaseEnterpriseMapper extends CommonMapper<MsaBaseEnterprise>{
	/**
	 * 获得全部企业信息
	 * @return
	 */
	List<MsaBaseEnterprise> getEnterprise(@Param("enterpriseName")String enterpriseName);
}
