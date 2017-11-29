package com.xhhy.service;

import java.util.List;

import com.xhhy.bean.RoleBean;
import com.xhhy.dao.RoleDao;
import com.xhhy.dao.RoleDaoImpl;

public class RoleServiceImpl implements RoleService {
    RoleDao rd=new RoleDaoImpl();
	@Override
	public List<RoleBean> getAllRoles() {
		// TODO Auto-generated method stub
		return rd.getAllRoles();
	}

}
