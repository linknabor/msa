package com.eshequ.msa.sso.service;

import java.util.List;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoMenu;

public interface MenuService {
	/**
	 * 保存菜单(添加或修改)
	 * @param menu 菜单实体
	 * @param type 操作类型
	 * @return
	 */
	BaseResult<?> saveMenu(SsoMenu menu, String type);
	
	/**
	 * 删除菜单
	 * @param menuId 菜单id
	 * @return
	 */
	BaseResult<?> deleteMenu(Long menuId);
	
	/**
	 * 根据菜单等级获得菜单
	 * @param menuLevel 菜单等级
	 * @return
	 */
	List<SsoMenu> getMenuByLevel(String menuLevel);
	
	/**
	 * 获得全部菜单
	 * @return
	 */
	List<SsoMenu> getAllMenu();
}
