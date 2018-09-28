package com.eshequ.msa.sso.service;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoMenu;

public interface MenuService {
	/**
	 * 保存菜单(添加或修改)
	 * @param menu 菜单实体
	 * @return
	 */
	BaseResult<?> saveMenu(SsoMenu menu);
	
	/**
	 * 删除菜单
	 * @param menuId 菜单id
	 * @return
	 */
	BaseResult<?> deleteMenu(Long menuId);
	
	/**
	 * 根据角色id和菜单等级获得菜单
	 * @param menuLevel 菜单等级
	 * @param roleId 角色id
	 * @return
	 */
	List<SsoMenu> getRoleMenuByLevel(String menuLevel,Long roleId);
	
	/**
	 * 获得全部菜单
	 * @return
	 */
	List<SsoMenu> getAllMenu();
	
	/**
	 * 根据角色获得所有菜单
	 * @param roleId 角色id
	 */
	List<SsoMenu> getAllMenuByRole(Long roleId);
	
	/**
	 * 给角色添加菜单权限
	 * @param roleId 角色id
	 * @param menuIdArray 菜单id数组
	 */
	void saveRoleMenuByRoleId(Long[] menuIdArray,Long roleId);
	
}
