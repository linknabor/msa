package com.eshequ.msa.sso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.sso.model.SsoOrgInfo;

public interface SsoOrgInfoMapper extends CommonMapper<SsoOrgInfo>{
	List<SsoOrgInfo> getOrgInFoList();
	
	SsoOrgInfo getOrgInFoById(@Param("orgId")String orgId);
	

}
