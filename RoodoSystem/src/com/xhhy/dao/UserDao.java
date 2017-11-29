package com.xhhy.dao;


import java.util.List;

import com.xhhy.bean.UserBean;
import com.xhhy.bean.UserParam;
import com.xhhy.util.PageUtil;

public interface UserDao {
   public UserBean Index(String loginName,String password);
   public List<UserBean> show(PageUtil pu,UserParam up);
   public UserBean look(String userId);
   public boolean deleteUser(String dus);
   public boolean edit(UserBean ub);
   public boolean addUser(UserBean ub);
   public int getCount(UserParam up);
   public UserBean oneName(String loginName);
   public List<UserBean> autoComplete(String userName);
}
