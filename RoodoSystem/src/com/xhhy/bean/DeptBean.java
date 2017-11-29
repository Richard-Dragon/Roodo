/**
 * 部门
 */
package com.xhhy.bean;

public class DeptBean {
	private int deptId;//部门编号
	private String deptName;//部门名称
	private String upDept;//上级部门
	private String addTime;//添加时间
	private int sort;//部门排序值
	private String remark;//备注
	private int del;//删除状态
	public DeptBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeptBean(int deptId, String deptName, String upDept, String addTime,
			int sort, String remark, int del) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.upDept = upDept;
		this.addTime = addTime;
		this.sort = sort;
		this.remark = remark;
		this.del = del;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUpDept() {
		return upDept;
	}
	public void setUpDept(String upDept) {
		this.upDept = upDept;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
}
