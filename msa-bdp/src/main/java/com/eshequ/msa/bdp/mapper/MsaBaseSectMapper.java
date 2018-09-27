package com.eshequ.msa.bdp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.bdp.model.MsaBaseSect;
import com.eshequ.msa.bdp.vo.SectAndEnterpriseVo;
import com.eshequ.msa.common.CommonMapper;

public interface MsaBaseSectMapper extends CommonMapper<MsaBaseSect>{
	List<SectAndEnterpriseVo> getSectAndEnterpriseList(SectAndEnterpriseVo sectAndEnterpriseVo);
	
	/**
	 * 根据企业客户信息获得物业项目信息
	 * @param map
	 * @return
	 */
	List<MsaBaseSect> getSectByEnterpriseId(
			@Param("sectName")String sectName,
			@Param("sectAddr")String  sectAddr,
			@Param("enterpriseId") Long enterpriseId);

    List<MsaBaseSect> getAllSect();
}
