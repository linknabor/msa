package com.eshequ.msa.sso.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.service.UserService;
import com.eshequ.msa.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
public class UserController extends BaseController{
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addOrUpdateUser", method = RequestMethod.POST)
	public BaseResult<?> addOrUpdateUser(SsoUser ssoUser) {
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
			@RequestParam(defaultValue = "10", required = false) int pageSize, SsoUser ssoUser, String startDate,
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
	public SsoUser getUserById(String userId){
		
		return userService.getUserById(userId);
		
	}
}
