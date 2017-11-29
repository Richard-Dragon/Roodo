package com.xhhy.service;

import java.util.List;

import com.xhhy.bean.UserBean;
import com.xhhy.bean.UserParam;
import com.xhhy.dao.UserDao;
import com.xhhy.dao.UserDaoImpl;
import com.xhhy.util.PageUtil;

public class UserServiceImpl implements UserService {
    UserDao ud=new UserDaoImpl();
	@Override
	public UserBean Index(String loginName, String password) {
		// TODO Auto-generated method stub
		return ud.Index(loginName, password);
	}
	@Override
	public List<UserBean> show(PageUtil pu,UserParam up) {
		// TODO Auto-generated method stub
		return ud.show(pu,up);
	}
	@Override
	public UserBean look(String userId) {
		// TODO Auto-generated method stub
		return ud.look(userId);
	}
	@Override
	public boolean deleteUser(String dus) {
		// TODO Auto-generated method stub
		return ud.deleteUser(dus);
	}
	@Override
	public boolean edit(UserBean ub) {
		// TODO Auto-generated method stub
		return ud.edit(ub);
	}
	@Override
	public boolean addUser(UserBean ub) {
		// TODO Auto-generated method stub
		return ud.addUser(ub);
	}
	@Override
	public int getCount(UserParam up) {
		// TODO Auto-generated method stub
		return ud.getCount(up);
	}
	@Override
	public UserBean oneName(String loginName) {
		// TODO Auto-generated method stub
		return ud.oneName(loginName);
	}
	@Override
	public List<UserBean> autoComplete(String userName) {
		// TODO Auto-generated method stub
		return ud.autoComplete(userName);
	}
   
}
