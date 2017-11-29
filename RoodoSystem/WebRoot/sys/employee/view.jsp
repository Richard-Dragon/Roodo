<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
  <link rel="stylesheet" href="css/base.css"/>
<link rel="stylesheet" href="css/info-reg.css" />
<title>Roodo乐多文档管理系统</title>
</head>

<body>
<div class="title"><h2>用户管理</h2></div>
<div class="main">
	<p class="short-input ue-clear newstyle">
    	<label>用户姓名：</label>${ub.userName }
    </p>
    
	<p class="short-input ue-clear newstyle">
    	<label>性别：</label>
    	<c:if test="${ub.sex ==0}">男</c:if>
    	<c:if test="${ub.sex ==1}">女</c:if>
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>登录账号：</label>${ub.loginName }
    </p>
    <p class="long-input ue-clear newstyle">
    	<label>身份证号：</label>${ub.idCard }
    </p>
    <p class="long-input ue-clear newstyle">
    	<label>办公电话：</label>${ub.phone }
    </p>
    <p class="long-input ue-clear newstyle">
    	<label>移动电话：</label>${ub.mobilePhone }
    </p>
	<p class="long-input ue-clear newstyle">
    	<label>邮箱：</label>${ub.email }
    </p>

    <p class="short-input ue-clear newstyle">
    	<label>联系地址：</label>${ub.address }
    </p>
    <p class="short-input ue-clear newstyle">
    	<label>部门：</label>${ub.deptName }
    </p>
	
	
	<p class="short-input ue-clear newstyle">
    	<label>角色：</label>${ub.roleName }
    </p>
	
	
	
    <p class="short-input ue-clear newstyle">
    	<label>备注：</label>${ub.remark }
    </p>
</div>
<div class="btn1 ue-clear">
	<a href="UserServlet.do" class="clear">返回</a>
    
</div>
</body>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/common.js" ></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").toggle();
	return false;
});
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find("span").text(txt);
});


showRemind('input[type=text], textarea','placeholder');
</script>
</html>
    
   