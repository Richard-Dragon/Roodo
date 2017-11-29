package com.xhhy.service;

import java.util.List;

import com.xhhy.bean.DeptBean;

public interface DeptService {
   public List<DeptBean> getAllDepts();
   public int getSort(String deptId);
}
