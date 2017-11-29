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

	function checkName() {
		var name = document.getElementById("loginname");
		/* alert(name.value); */
		if (name.value == "" || name.value == null) {
			document.getElementById("sl").innerHTML = "账号不能为空。";
			return false;
		} else {
			reg =  /^[a-zA-Z]{6,16}$/;
			if (!reg.test(name.value)) {
				document.getElementById("sl").innerHTML = "账号格式不正确。";
				return false;
			} else {
				var is = true;
				var xmlHttp = null;
				if (window.ActiveXObject) {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} else if (window.XMLHttpRequest) {
					xmlHttp = new XMLHttpRequest();
				}
				xmlHttp.open("post", "UserServlet.do?method=onename&loginname="
						+ name.value);
				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
						result = xmlHttp.responseText;
						if (result == 0) {
							document.getElementById("sl").innerHTML = "账号已存在。";
							document.getElementById("sl").style.color = "red";
							is = false;
						} else {
							document.getElementById("sl").innerHTML = "账号可以使用。";
							document.getElementById("sl").style.color = "green";
						}
					}
				};
				xmlHttp.send(null);
				return is;

			}

		}
	}

	function tijiao() {
		var is = confirm("确认添加吗？");
		if (is) {
			if (!checkName()) {

			} else {
				document.getElementById("myForm").submit();
			}
		}
	}
</script>
</head>

<body>
	<form action="UserServlet.do?method=add" method="post" id="myForm">
		<div class="title">
			<h2>用户管理</h2>
		</div>
		<div class="main">
			<p class="short-input ue-clear">
				<label>用户姓名：</label> <input type="text" name="username" /> <span
					id="su"></span>
			</p>
			<p class="short-input ue-clear">
				<label>性别：</label> <select name="sex" id="sex">
					<option value="0">男</option>
					<option value="1">女</option>
				</select> <span id="ss"></span>
			</p>
			<p class="short-input ue-clear">
				<label>登录账号：</label> <input type="text" id="loginname"name="loginname" onblur="checkName()"  /> <span id="sl"></span>
			</p>
			<p class="short-input ue-clear">
				<label>登录密码：</label> <input type="text" name="password" /> <span
					id="sp"></span>
			</p>
			<p class="short-input ue-clear">
				<label>密码确认：</label> <input type="text" placeholder="密码确认" /> <span></span>
			</p>
			<p class="short-input ue-clear">
				<label>身份证号：</label> <input type="text" name="idcard" maxlength=18 />
				<span id="si"></span>
			</p>
			<p class="short-input ue-clear">
				<label>办公电话：</label> <input type="text" name="phone" /> <span
					id="sphone"></span>
			</p>
			<p class="short-input ue-clear">
				<label>手机号：</label> <input type="text" name="mobilephone" /> <span
					id="sm"></span>
			</p>
			<p class="short-input ue-clear">
				<label>邮箱：</label> <input type="text" name="email" /> <span id="se"></span>
			</p>

			<p class="long-input ue-clear">
				<label>联系地址：</label> <input type="text" name="address" />
			</p>


			<div class="short-input select ue-clear">
				<label>部门：</label> <select name="dept" id="deptId">
					<c:forEach items="${dl }" var="dept">
						<option value="${dept.deptId }">${dept.deptName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="short-input select ue-clear">
				<label>角色：</label> <select name="role" id="roleId">
					<c:forEach items="${rl }" var="role">
						<option value="${role.roleId }">${role.roleName }</option>
					</c:forEach>
				</select>
			</div>
			<p class="short-input ue-clear">
				<label>备注：</label>
				<textarea placeholder="请输入1-100文字" name="remark"></textarea>
				<span id="st"></span>

			</p>
		</div>
		<div class="btn ue-clear">
			<input type="button" value="提交" onclick="tijiao()" /> <input
				type="button" value="返回" onclick="javascript:history.back()" /> <input
				type="reset" value="重置" />
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
