package com.eshequ.msa.sso.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshequ.msa.common.BaseResult;
import com.eshequ.msa.sso.mapper.SsoMenuMapper;
import com.eshequ.msa.sso.mapper.SsoRoleMenuMapper;
import com.eshequ.msa.sso.model.SsoMenu;
import com.eshequ.msa.sso.service.MenuService;
import com.eshequ.msa.util.SnowFlake;

@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private SsoMenuMapper ssoMenuMapper;
	@Autowired
	private SsoRoleMenuMapper ssoRoleMenuMapper;
	@Autowired
	private SnowFlake snowFlake;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public BaseResult<?> saveMenu(SsoMenu menu) {
		if(menu.getMenuId() == null) {
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

	//根据角色id和菜单等级获得菜单
	@Override
	public List<SsoMenu> getRoleMenuByLevel(String menuLevel,Long roleId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("menuLevel", menuLevel);
		map.put("roleId", roleId);
		List<SsoMenu> result = ssoMenuMapper.selectRoleMenuByLevel(map);
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
	
	//根据角色获得所有菜单
	@Override
	public List<SsoMenu> getAllMenuByRole(Long roleId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);//指定角色
		//查找父级菜单
		map.put("menuLevel", 1);
		List<SsoMenu> list_parent = ssoMenuMapper.selectRoleMenuByLevel(map);
		for (SsoMenu ssoMenu : list_parent) {
			//查找角色下指定父级id的菜单（二级）
			map.put("parentId", ssoMenu.getMenuId());
			List<SsoMenu> list_two = ssoMenuMapper.selectRoleMenuByParentId(map);
			ssoMenu.setSsoMenuList(list_two);
			
			//查找角色下指定父级id的菜单（三级）
			for (SsoMenu ssoMenu2 : list_two) {
				map.put("parentId", ssoMenu2.getMenuId());
				List<SsoMenu> list_three = ssoMenuMapper.selectRoleMenuByParentId(map);
				map.put("parentId", ssoMenu2.getMenuId());
				ssoMenu2.setSsoMenuList(list_three);
			}
		}
		return list_parent;
	}

	//给角色添加菜单权限
	@Override
	@Transactional
	public void saveRoleMenuByRoleId(Long[] menuIdArray,Long roleId) {
		//先清空当前角色所有的菜单，再依次添加新的菜单
		int i = ssoRoleMenuMapper.deleteSsoRoleMenuByRoleId(roleId);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("menuIdArray", menuIdArray);
		map.put("roleId", roleId);
		ssoRoleMenuMapper.insertSsoRoleMenu(map);
	}

	// 通过角色，获得所有菜单及权限
	@Override
	public List<SsoMenu> getAllRoleMenuByRoleId(Long roleId) {
		List<SsoMenu> allMenuList = ssoMenuMapper.selectAll();//全部菜单
		List<SsoMenu> allRoleMenuList = getAllMenuByRole(roleId);//当前角色权限的菜单
		for (SsoMenu menu : allMenuList) {
			for (SsoMenu roleMenu : allRoleMenuList) {
				if(menu.getMenuId() == roleMenu.getMenuId()) {
					menu.setChecked(true);//设置是否有此权限
					menu.setSsoMenuList(roleMenu.getSsoMenuList());//设置子级权限
				}
			}
		}
		return allMenuList;
	}


	

}
