package com.xhhy.bean;

public class UserParam {
   private String userName;
   private String sex;
   private String deptId;
   private String startTime;
   private String endTime;
   
public UserParam() {
	super();
	// TODO Auto-generated constructor stub
}

public UserParam(String userName, String sex, String deptId, String startTime,
		String endTime) {
	super();
	this.userName = userName;
	this.sex = sex;
	this.deptId = deptId;
	this.startTime = startTime;
	this.endTime = endTime;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getDeptId() {
	return deptId;
}
public void setDeptId(String deptId) {
	this.deptId = deptId;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
   
   
}
