package com.eshequ.msa.sso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.common.Constants;
import com.eshequ.msa.sso.model.SsoMenu;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.service.MenuService;
import com.eshequ.msa.sso.vo.RoleMenuVo;

@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController{
	@Autowired
	private MenuService menuService;
	
	//保存菜单(添加或修改)
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public BaseResult<?> saveMenu(@ModelAttribute(Constants.USER)SsoUser user,@RequestBody SsoMenu menu) {
		return menuService.saveMenu(menu);
	}	
	
	//删除菜单
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	public BaseResult<?> deleteMenu(@ModelAttribute(Constants.USER)SsoUser user,@RequestBody SsoMenu menu) {
		return menuService.deleteMenu(menu.getMenuId());
	}
	
	//根据角色id和菜单等级获得菜单 
	@RequestMapping(value="/getRoleMenuByLevel",method = RequestMethod.GET)
	public List<SsoMenu> getRoleMenuByLevel(@ModelAttribute(Constants.USER)SsoUser user,String menuLevel,Long roleId) {
		return menuService.getRoleMenuByLevel(menuLevel, roleId);
	}
	
	//获得所有菜单
	@RequestMapping(value = "/getAllMenu", method = RequestMethod.GET)
	public List<SsoMenu> getAllMenu(@ModelAttribute(Constants.USER)SsoUser user) {
		return menuService.getAllMenu();
	}
	
	//根据角色获得所有菜单
	@RequestMapping(value = "/getAllMenuByRole", method = RequestMethod.GET)
	public List<SsoMenu> getAllMenuByRole(@ModelAttribute(Constants.USER)SsoUser user,Long roleId) {
		return menuService.getAllMenuByRole(roleId);
	}
	
	//给角色添加菜单权限
	@RequestMapping(value = "/saveRoleMenuByRoleId", method = RequestMethod.POST)
	public void saveRoleMenuByRoleId(@ModelAttribute(Constants.USER)SsoUser user,@RequestBody RoleMenuVo roleMenuVo) {
		menuService.saveRoleMenuByRoleId(roleMenuVo.getMenuIdArray(), roleMenuVo.getRoleId());
	}

}
