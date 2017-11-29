/**
 * 用户
 */
package com.xhhy.bean;

public class UserBean {
	private int userId;
	private String loginName;//账号
	private String password;//密码
	private String userName;//姓名
	private int sex;//性别
	private String idCard;//身份证号码
	private String phone;//座机
	private String mobilePhone;//手机
	private String email;//邮箱
	private String address;//联系地址
	private int deptId;//部门编号
	private int roleId;//角色编号
	private String remark;//备注
	private int sort;//排序值
	private String addTime;//添加时间
	private int del;//删除状态
	private String deptName;
	private String roleName;
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBean(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
	}
	
	public UserBean(int userId, String loginName, String password,
			String userName, int sex, String idCard, String phone,
			String mobilePhone, String email, String address, int deptId,
			int roleId, String remark, int sort, String addTime, int del) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.password = password;
		this.userName = userName;
		this.sex = sex;
		this.idCard = idCard;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.address = address;
		this.deptId = deptId;
		this.roleId = roleId;
		this.remark = remark;
		this.sort = sort;
		this.addTime = addTime;
		this.del = del;
	}
	
	
	public UserBean(int userId, String loginName, String password,
			String userName, int sex, String idCard, String phone,
			String mobilePhone, String email, String address, int deptId,
			int roleId, String remark, int sort, String addTime, int del,
			String deptName, String roleName) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.password = password;
		this.userName = userName;
		this.sex = sex;
		this.idCard = idCard;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.email = email;
		this.address = address;
		this.deptId = deptId;
		this.roleId = roleId;
		this.remark = remark;
		this.sort = sort;
		this.addTime = addTime;
		this.del = del;
		this.deptName = deptName;
		this.roleName = roleName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoldId(int roleId) {
		this.roleId = roleId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
}
