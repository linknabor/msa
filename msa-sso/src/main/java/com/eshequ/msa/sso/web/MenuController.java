package com.eshequ.msa.sso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoMenu;
import com.eshequ.msa.sso.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController{
	@Autowired
	private MenuService menuService;
	
	//保存菜单(添加或修改)
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public BaseResult<?> saveMenu(SsoMenu menu, String type) {
		return menuService.saveMenu(menu, type);
	}	
	
	//删除菜单
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public BaseResult<?> deleteMenu(@RequestParam(required=true)Long menuId) {
		return menuService.deleteMenu(menuId);
	}
	
	//根据角色id和菜单等级获得菜单 
	@RequestMapping(value="/getRoleMenuByLevel",method = RequestMethod.POST)
	public List<SsoMenu> getRoleMenuByLevel(String menuLevel,Long roleId) {
		return menuService.getRoleMenuByLevel(menuLevel, roleId);
	}
	
	//获得所有菜单
	@RequestMapping(value = "/getAllMenu", method = RequestMethod.POST)
	public List<SsoMenu> getAllMenu() {
		return menuService.getAllMenu();
	}
	
	//根据角色获得所有菜单
	@RequestMapping(value = "/getAllMenuByRole", method = RequestMethod.POST)
	public List<SsoMenu> getAllMenuByRole(Long roleId) {
		return menuService.getAllMenuByRole(roleId);
	}
	
	//给角色添加菜单权限
	@RequestMapping(value = "/saveRoleMenuByRoleId", method = RequestMethod.POST)
	public void saveRoleMenuByRoleId(Long[] menuIdArray,Long roleId) {
		menuService.saveRoleMenuByRoleId(menuIdArray, roleId);
	}

}
