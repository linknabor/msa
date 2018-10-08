package com.eshequ.msa.sso.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.sso.model.SsoRole;

public interface SsoRoleMapper extends CommonMapper<SsoRole> {
	
	/**
	 * 修改角色
	 * @param role 角色实体
	 * @return
	 */
	int updateSsoRole(SsoRole role);
	
	List<SsoRole> getRoleByOrgId(@Param("orgId")String orgId);
	
	/**
	 * 搜索角色
	 * @param roleId 角色id
	 * @param roleName 角色名称
	 * @return
	 */
	List<SsoRole> searchRole(Map<String,Object> map);
    
}