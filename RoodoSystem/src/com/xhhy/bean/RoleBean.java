/**
 * 角色
 */
package com.xhhy.bean;

public class RoleBean {
	private int roleId;//
	private String roleName;//角色名称
	private String addTime;//添加时间
	private int sort;//角色排序值
	private String remark;//备注
	private int del;//删除状态
	
	public RoleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleBean(int roleId, String roleName, String addTime, int sort,
			String remark, int del) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.addTime = addTime;
		this.sort = sort;
		this.remark = remark;
		this.del = del;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
