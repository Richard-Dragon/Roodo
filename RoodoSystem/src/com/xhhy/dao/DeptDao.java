package com.xhhy.dao;

import java.util.List;

import com.xhhy.bean.DeptBean;

public interface DeptDao {
   public List<DeptBean> getAllDepts();
   public int getSort(String deptId);
}
