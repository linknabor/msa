package com.eshequ.msa.sso.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.model.SsoUser;
import com.eshequ.msa.sso.service.UserService;
import com.eshequ.msa.util.ObjectUtil;

@RestController
public class UserController {
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

	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public BaseResult<?> resetPassword(String userId) {
		if (!ObjectUtil.isEmpty(userId)) {
			return userService.resetPassWord(userId);
		}
		return BaseResult.fail(500, "参数错误！");

	}

}
