<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html>
<base href="<%=basePath%>">
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roodo乐多文档管理系统</title>
<link rel="stylesheet" type="text/css"
	href="css/bootstrap/bootstrap.css" />
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/login.css" />
<script type="text/javascript" src="js/Cookie.js"></script>
<style type="text/css">
@media ( max-width :767px) {
	/*在小于等于767px的屏幕里，这里的样式才生效*/
	body {
		position: relative;
		background-color: #2074bb;
	}
	.container-fluid {
		position: relative;
		background: noner;
	}
	.login {
		margin-top: 30px;
		padding-top: 15px;
		height: auto;
	}
	.login .login-top h1 {
		height: 100px;
		padding-top: 30px;
		color: #FFF;
		font-weight: bold;
		font-family: "微软雅黑";
		font-size: 25px;
	}
	.login .login-top {
		margin: 0 auto;
		height: 100px;
		background: url("images/login_img.png") no-repeat center center;
	}
}
</style>
<script type="text/javascript">
	function checkLogin() {
		var login = document.getElementById("ln");
		if (login.value == null || login.value == "") {
			document.getElementById("ll").innerHTML = "用户名不能为空!";
			login.focus();
			return false;
		} else {
			document.getElementById("ll").innerHTML = "";
			return true;
		}
	}
	function checkPs() {
		var ps = document.getElementById("ps");
		if (ps.value == null || ps.value == "") {
			document.getElementById("lp").innerHTML = "密码不能为空!";
			ps.focus;
			return false;
		} else {
			document.getElementById("lp").innerHTML = "";
			return true;
		}
	}

	function checkValidate() {
		var val = document.getElementById("yzm");
		if (val.value == null || val.value == "") {
			document.getElementById("lv").innerHTML = "验证码不能为空!";
			val.focus();
			return false;
		} else {
				document.getElementById("lv").innerHTML = "";	
				return true;
		}
	}
	
	function checkUser(){
		if(!checkValidate()){
			
		}else if(!checkLogin()){
			
		}else if(!checkPs()){
			
		}else{
			var loginname=document.getElementById("ln");
			var password=document.getElementById("ps");
			var rem=document.getElementById("remember");
			if(rem.checked){
				SetCookie("loginname",loginname.value,14);
				SetCookie("password",password.value,14);
			}else{
				SetCookie("loginname",null,0);
				SetCookie("password",null,0);
			}
			document.getElementById("myForm").submit();
		}
	}
	/* function remember(){
		var loginname=document.getElementById("ln").value;
		var password=document.getElementById("ps").value;
		if(loginname!=null && loginname!="" && password!=null && password!=""){
			document.getElementById("remember").checked=true;
		}
	} */
	function changeImg(){
		var time=new Date();
		document.getElementById("vf").src="number.jpg?time="+time.getTime();
	}
	
	function remember(){
		if(GetCookie("loginname")!=null && GetCookie("password")!=null){
		document.getElementById("remember").checked=true;	
		document.getElementById("ln").value=GetCookie("loginname");
		document.getElementById("ps").value=GetCookie("password");
		} 
	}
	
</script>
</head>

<body onload="remember()">
	<div id="all" class="container-fluid">
		<div id="bd" class="row">
			<div class="col-sm-8 col-sm-offset-2 login img-responsive">
				<div class="row">
					<div class="login-top img-responsive">
						<h1 class="text-center">Roodo乐多文档管理系统</h1>
					</div>
				</div>
				<div class="row" style="margin-top: 10px;">
					<form action="LoginServlet.do" method="post" class="form-horizontal" id="myForm">
						<div class="login-input form-group ">
							<label
								class="col-md-2 col-md-offset-3 control-label col-xs-8 col-xs-offset-2 col-sm-2">用户名</label>
							<div
								class="col-md-3 col-md-offset-0 col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-0">
								<input type="text" class="form-control img-responsive" id="ln"
									onblur="checkLogin()" name="loginname"
									value="" /><%--${cookie.loginname.value} --%>
							</div>
							<div
								class="col-xs-8 col-xs-offset-2 col-sm-offset-4  col-md-offset-0 col-md-3"
								style="height: 14px">
								<label class="control-label" style="color: red; font-size: 10px"
									id="ll">${requestScope.msg }</label>
							</div>
						</div>
						<div class="login-input form-group ">
							<label
								class="col-md-2 col-md-offset-3 control-label col-xs-8 col-xs-offset-2 col-sm-2">密&nbsp;&nbsp;&nbsp;码</label>
							<div
								class="col-md-3 col-md-offset-0 col-xs-8 col-xs-offset-2 col-sm-6 col-sm-offset-0">
								<input type="password" class="form-control img-responsive"
									id="ps" onblur="checkPs()" name="password"
									value="" /> <%--${cookie.password.value} --%>
							</div>
							<div
								class="col-xs-8 col-xs-offset-2 col-sm-offset-4  col-md-offset-0 col-md-3"
								style="height: 14px">
								<label class="control-label" style="color: red; font-size: 10px"
									id="lp"></label>
							</div>
						</div>
						<div class="login-input form-group ">
							<label
								class="col-md-2 col-md-offset-3 control-label col-xs-8 col-xs-offset-2 col-sm-2">验证码</label>
							<div
								class="col-md-2 col-md-offset-0 col-xs-4 col-xs-offset-2 col-sm-3 col-sm-offset-0">
								<input type="text" class="form-control img-responsive"
									name="yzm" value="" id="yzm" onblur="checkValidate()" />
							</div>
							<div
								class="col-md-1 col-md-offset-0 col-xs-4 col-xs-offset-0 col-sm-3 col-sm-offset-0">
								<a href="javascript:changeImg()"><img alt="" src="number.jpg" id="vf"></a>
								</div>
							<div
								class="col-xs-8 col-xs-offset-2 col-sm-offset-4  col-md-offset-1 col-md-3"
								style="height: 14px">
								<label class="control-label" style="color: red; font-size: 10px"
									id="lv">${vfmsg }</label>
							</div>
						</div>
						<div class="form-group text-center">
							<input type="button" name="" id="" value="确认"
								class="btn btn-primary " onclick="checkUser()" /> &nbsp;&nbsp;&nbsp;&nbsp; <label><input
								type="checkbox" class="checkbox-inline" name="remember" value="14"
								id="remember" />记住密码</label>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>

</html>