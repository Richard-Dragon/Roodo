<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-reg.css" />
<title>Roodo乐多文档管理系统</title>
<script type="text/javascript">
 function test(){
	 var ss=document.getElementById("sex");
	 var sex=${ub.sex};
	 ss.value=sex;
	 var deptName=${ub.deptId};
	 var dn=document.getElementById("deptId");
	 dn.value=deptName;
	 var roleName=${ub.roleId};
	 var rn=document.getElementById("roleId");
	 rn.value=roleName;
 }
 function queren(){
	 var is=confirm("确认修改吗？");
	 if(is){
	 document.getElementById("myForm").submit();
	 }
 }
 function fanhui(){
	 location.href="UserServlet.do";
 }
</script>
</head>
<body onload="test()" >
	<form action="UserServlet.do" method="post" id="myForm" >
	<input type="hidden" name="method" value="edit" />
	<input type="hidden" name="userid" value="${ub.userId }" />
		<div class="title">
			<h2>用户管理</h2>
		</div>
		<div class="main">
			<p class="short-input ue-clear">
				<label>用户姓名：</label> <input type="text" value="${ub.userName }" />
			</p>
			<p  class=" ue-clear select ue-clear">
				<label>性别：</label>
			<%-- 	<c:if test="${ub.sex==0 }">
					<select name="sex"  >
						<option value="0" selected="selected">男</option>
						<option value="1">女</option>
					</select>
				</c:if>
				<c:if test="${ub.sex==1 }">
					<select name="sex" >
						<option value="0" >男</option>
						<option value="1" selected="selected">女</option>
					</select>
				</c:if> --%>
				
				<select name="sex" id="sex" >
						<option value="0" >男</option>
						<option value="1" >女</option>
					</select>
                   <span id="ss"></span>
			</p>
			<p class="short-input ue-clear">
				<label>登录账号：</label> <input type="text" value="${ub.loginName }"
					readonly="readonly" />
			</p>
			<p class="short-input ue-clear">
				<label>身份证号：</label> <input type="text" value="${ub.idCard }" />
			</p>
			<p class="short-input ue-clear">
				<label>办公电话：</label> <input type="text" value="${ub.phone }" />
			</p>
			<p class="short-input ue-clear">
				<label>手机号：</label> <input type="text" value="${ub.mobilePhone }" />
			</p>
			<p class="short-input ue-clear">
				<label>邮箱：</label> <input type="text" value="${ub.email }" />
			
			<p class="long-input ue-clear">
				<label>联系地址：</label> <input type="text" value="${ub.address }" />
			</p>
			<p class="ue-clear  select ue-clear">
				<label>部门：</label> 
				<select name="dept" id="deptId"  >
					<c:forEach items="${dl }" var="dept">
						<option value="${dept.deptId }">${dept.deptName }</option>
					</c:forEach>
				</select>
			</p>
             <p class="ue-clear  select ue-clear">
				<label>角色：</label> 
				<select name="role" id="roleId"  >
					<c:forEach items="${rl }" var="role">
						<option value="${role.roleId }">${role.roleName }</option>
					</c:forEach>
				</select>
			</p>
			<p class="short-input ue-clear">
				<label>备注：</label>
				<textarea id="tet" >${ub.remark }</textarea>
			</p>
		</div>
		<div class="btn ue-clear">
		<input type="button" value="确定" onclick="queren()" />
		<input type="button"  value="返回" onclick="javascript:fanhui()" />
		<!-- <input type="reset" value="重置" /> -->
		</div>
	</form>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<script type="text/javascript">
	$(".select-title").on("click", function() {
		$(".select-list").toggle();
		return false;
	});
	$(".select-list").on("click", "li", function() {
		var txt = $(this).text();
		$(".select-title").find("span").text(txt);
	});

	showRemind('input[type=text], textarea', 'placeholder');
</script>
</html>
