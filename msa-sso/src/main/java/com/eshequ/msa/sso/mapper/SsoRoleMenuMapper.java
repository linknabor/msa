package com.eshequ.msa.sso.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.sso.model.SsoRoleMenu;

public interface SsoRoleMenuMapper extends CommonMapper<SsoRoleMenu>{
	
	/**
	 * 通过角色id删除菜单
	 * @param roleId
	 * @return
	 */
	int deleteSsoRoleMenuByRoleId(@Param("roleId")Long roleId);
	
	/**
	 * 添加角色和菜单
	 * @param map
	 * @return
	 */
	int insertSsoRoleMenu(Map<String,Object> map);

}