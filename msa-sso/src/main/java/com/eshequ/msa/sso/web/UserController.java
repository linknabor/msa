package com.eshequ.msa.sso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.MsaBaseCity;
import com.eshequ.msa.sso.model.SsoOrgInfo;
import com.eshequ.msa.sso.model.SsoRole;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.service.UserService;
import com.eshequ.msa.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addOrUpdateUser", method = RequestMethod.POST)
	public BaseResult<?> addOrUpdateUser(@RequestBody SsoUser ssoUser) {
		if (ssoUser != null) {
			if (ssoUser.getUserId() != null) {
				return userService.updateUser(ssoUser);
			} else {
				return userService.addUser(ssoUser);
			}
		}
		return BaseResult.fail(500, "参数错误！");
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public BaseResult<?> deleteUser(Long userId) {
		if (userId != null) {
			return userService.deleteUser(userId);
		}
		return BaseResult.fail(500, "参数错误！");

	}

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public PageInfo<SsoUser> getUserList(@RequestParam(defaultValue = "0", required = false) int pageNum,
			@RequestParam(defaultValue = "10", required = false) int pageSize,@RequestBody SsoUser ssoUser, String startDate,
			String endDate) {
		PageHelper.startPage(pageNum, pageSize);
		List<SsoUser> lists = userService.getUser(ssoUser, startDate, endDate);
		PageInfo<SsoUser> pageInfo = new PageInfo<SsoUser>(lists);
		return pageInfo;

	}

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public BaseResult<?> resetPassword(String userId) {
		if (!ObjectUtil.isEmpty(userId)) {
			return userService.resetPassWord(userId);
		}
		return BaseResult.fail(500, "参数错误！");
	}

	@RequestMapping(value = "/forbiddenOrOpenUser", method = RequestMethod.POST)
	public BaseResult<?> forbiddenOrOpenUser(String userId, String status) {
		if (!ObjectUtil.isEmpty(userId) && !ObjectUtil.isEmpty(status)) {
			return userService.forbiddenOrOpenUser(userId, status);
		}
		return BaseResult.fail(500, "参数错误！");
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public BaseResult<?> updatePassword(String userId, String oldPassword, String newPassword) {
		if (!ObjectUtil.isEmpty(userId) && !ObjectUtil.isEmpty(oldPassword) && !ObjectUtil.isEmpty(newPassword)) {
			return userService.updatePassword(userId, oldPassword, newPassword);
		}
		return BaseResult.fail(500, "参数错误！");
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public SsoUser getUserById(String userId) {
		return userService.getUserById(userId);
	}

	// 获取所有机构信息
	@RequestMapping(value = "/getOrgInfoList", method = RequestMethod.GET)
	public List<SsoOrgInfo> getOrgInfoList() {
		return userService.getOrgInfoList();
	}

	// 根据机构id获取机构信息
	@RequestMapping(value = "/getOrgInfoById", method = RequestMethod.GET)
	public SsoOrgInfo getOrgInfoById(String orgId) {
		return userService.getOrgInfoById(orgId);
	}

	// 根据机构id获取角色信息
	@RequestMapping(value = "/getRoleByOrgId", method = RequestMethod.GET)
	public List<SsoRole> getRoleByOrgId(String orgId) {
		return userService.getRoleByOrgId(orgId);
	}
	
	//获取所有城市
	@RequestMapping(value = "/getCityList", method = RequestMethod.GET)
	public List<MsaBaseCity> getCityList() {
		return userService.getCityList();
	}
	
}
