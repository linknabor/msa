package com.eshequ.msa.sso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//删除角色
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public BaseResult<?> deleteMenu(Long menuId) {
		return menuService.deleteMenu(menuId);
	}
	
	//根据菜单等级获得菜单
	@RequestMapping(value="/getMenuByLevel",method = RequestMethod.POST)
	public List<SsoMenu> getMenuByLevel(String menuLevel) {
		
		return menuService.getMenuByLevel(menuLevel);
	}
	
	//根据菜单等级获得菜单
	@RequestMapping(value = "/getAllMenu", method = RequestMethod.POST)
	public List<SsoMenu> getAllMenu() {
		return menuService.getAllMenu();
	}

}
