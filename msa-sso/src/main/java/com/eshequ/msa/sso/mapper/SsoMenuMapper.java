package com.eshequ.msa.sso.mapper;

import java.util.List;
import java.util.Map;

import com.eshequ.msa.common.CommonMapper;
import com.eshequ.msa.sso.model.SsoMenu;

public interface SsoMenuMapper extends CommonMapper<SsoMenu>{
	/**
	 * 修改菜单
	 * @param menu 菜单实体
	 * @return
	 */
	int updateSsoMenu(SsoMenu menu);
	
	/**
	 * 根据角色id和菜单等级查询菜单
	 * @param map
	 * @return
	 */
	List<SsoMenu> selectRoleMenuByLevel(Map<String,Object> map);
	
	/**
	 * 根据父级id和角色id查询菜单
	 * @param map
	 * @return
	 */
	List<SsoMenu> selectRoleMenuByParentId(Map<String,Object> map);
	
	/**
	 * 根据权限查询菜单
	 * @param roleId 角色id
	 * @return
	 */
	List<SsoMenu> selectRoleMenuByRoleId(Map<String,Object> map);
    
}