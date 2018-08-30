package com.eshequ.msa.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.mapper.SsoMenuMapper;
import com.eshequ.msa.sso.model.SsoMenu;
import com.eshequ.msa.sso.service.MenuService;
import com.eshequ.msa.util.SnowFlake;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private SsoMenuMapper ssoMenuMapper;
	@Autowired
	private SnowFlake snowFlake;
	
	@Override
	public BaseResult<?> saveMenu(SsoMenu menu, String type) {
		if(type.equals("0")) {
			// 查询当前菜单名是否存在
			int selectCount = ssoMenuMapper.selectCount(menu);
			if (selectCount > 0) {
				return BaseResult.fail(0, "菜单名重复！");
			}
			// 添加菜单
			menu.setMenuId(snowFlake.nextId());
			int insertCount = ssoMenuMapper.insert(menu);
			if (insertCount == 1) {
				return BaseResult.successResult("添加菜单成功！");
			}
		}else {
			// 查询当前菜单名是否存在
			SsoMenu menuMapper = new SsoMenu();
			menuMapper.setMenuName(menu.getMenuName());
			int selectCount = ssoMenuMapper.selectCount(menuMapper);
			if (selectCount > 0) {
				return BaseResult.fail(0, "菜单名重复！");
			}
			// 修改菜单
			int updateCount = ssoMenuMapper.updateSsoMenu(menu);
			if (updateCount == 1) {
				return BaseResult.successResult("修改菜单成功！");
			}
		}
		return BaseResult.fail(99, "操作菜单错误！");
	}

	//获得菜单
	@Override
	public List<SsoMenu> getMenuByLevel(String menuLevel) {
		SsoMenu ssoMenu = new SsoMenu();
		ssoMenu.setMenuLevel(menuLevel);
		List<SsoMenu> result = ssoMenuMapper.select(ssoMenu);
		return result;
	}

	//删除菜单
	@Override
	public BaseResult<?> deleteMenu(Long menuId) {
		SsoMenu menu = new SsoMenu();
		menu.setMenuId(menuId);
		int deleteCount = ssoMenuMapper.delete(menu);
		if(deleteCount > 0) {
			return BaseResult.successResult("删除菜单成功！");
		}
		return BaseResult.fail(0,"当前菜单不存在，删除失败！");
	}

	//获得全部菜单
	@Override
	public List<SsoMenu> getAllMenu() {
		List<SsoMenu> list = ssoMenuMapper.selectAll();
		return list;
	}

	

}
