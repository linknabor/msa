package com.eshequ.msa.sso.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.common.Constants;
import com.eshequ.msa.common.User;
import com.eshequ.msa.sso.model.SsoRole;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.service.RoleService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	private RoleService roleService;

	//添加角色
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public BaseResult<?> addRole(@ModelAttribute(Constants.USER) User user, String roleName) {
		return roleService.addRole(roleName);
	}
	
	//保存角色(添加或修改)
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public BaseResult<?> saveRole(@ModelAttribute(Constants.USER)SsoUser user,SsoRole role,String type) {
		return roleService.saveRole(role,type);
	}
	
	//删除角色
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public BaseResult<?> deleteRole(@ModelAttribute(Constants.USER)SsoUser user,@RequestParam(required=true) Long roleId) {
		logger.info("删除角色接口的roleId="+roleId);
		return roleService.deleteRole(roleId);
	}
	
	//根据角色id查询角色
	@RequestMapping(value = "/getRoleById", method = RequestMethod.POST)
	public SsoRole getRoleById(@ModelAttribute(Constants.USER)SsoUser user,Long roleId) {
		return roleService.getRoleById(roleId);
	}
	
	//获得角色列表
	@RequestMapping(value = "/getAllRole", method = RequestMethod.POST)
	public List<SsoRole> getAllRole(@ModelAttribute(Constants.USER)SsoUser user) throws JsonParseException, JsonMappingException, IOException {
		return roleService.getAllRole();
	}
	
	//搜索角色
	@RequestMapping(value = "/searchRole", method = RequestMethod.POST)
	public List<SsoRole> searchRole(@ModelAttribute(Constants.USER)SsoUser user,Long roleId,String roleName) {
		logger.info("进入搜索角色接口");
		logger.info("roleId="+roleId);
		logger.info("roleName="+roleName);
		return roleService.searchRole(roleId, roleName);
	}
	
}
