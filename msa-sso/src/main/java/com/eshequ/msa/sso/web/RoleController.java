package com.eshequ.msa.sso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoRole;
import com.eshequ.msa.sso.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Autowired
	private RoleService roleService;

	//添加角色
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public BaseResult<?> addRole(String roleName) {
		return roleService.addRole(roleName);
	}
	
	//保存角色(添加或修改)
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public BaseResult<?> saveRole(SsoRole role,String type) {
		return roleService.saveRole(role,type);
	}
	
	//删除角色
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public BaseResult<?> deleteRole(Long roleId) {
		return roleService.deleteRole(roleId);
	}
	
	//根据角色id查询角色
	@RequestMapping(value = "/getRoleById", method = RequestMethod.POST)
	public SsoRole getRoleById(Long roleId) {
		return roleService.getRoleById(roleId);
	}
	
	//获得角色列表
	@RequestMapping(value = "/getAllRole", method = RequestMethod.POST)
	public List<SsoRole> getAllRole() {
		return roleService.getAllRole();
	}
	
}
