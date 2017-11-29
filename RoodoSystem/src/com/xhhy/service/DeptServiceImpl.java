package com.xhhy.service;

import java.util.List;

import com.xhhy.bean.DeptBean;
import com.xhhy.dao.DeptDao;
import com.xhhy.dao.DeptDaoImpl;

public class DeptServiceImpl implements DeptService {
   DeptDao dd=new DeptDaoImpl();
	@Override
	public List<DeptBean> getAllDepts() {
		// TODO Auto-generated method stub
		return dd.getAllDepts();
	}
	@Override
	public int getSort(String deptId) {
		// TODO Auto-generated method stub
		return dd.getSort(deptId);
	}

}
