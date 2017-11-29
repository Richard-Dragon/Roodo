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
<link rel="stylesheet" href="css/info-mgt.css" />
<link rel="stylesheet" href="css/WdatePicker.css" />
<title>Roodo乐多文档管理系统</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(".select-title").on("click", function() {
		$(".select-list").hide();
		$(this).siblings($(".select-list")).show();
		return false;
	});
	$(".select-list").on(
			"click",
			"li",
			function() {
				var txt = $(this).text();
				$(this).parent($(".select-list")).siblings($(".select-title"))
						.find("span").text(txt);
			});

	$('.pagination').pagination(100, {
		callback : function(page) {
			alert(page);
		},
		display_msg : true,
		setPageNo : true
	});

	$("tbody").find("tr:odd").css("backgroundColor", "#eff6fa");

	showRemind('input[type=text], textarea', 'placeholder');
</script>

<script type="text/javascript">
	function chooseAll(obj) {
		var is = obj.checked;
		var us = document.getElementsByName("user");
		for (var i = 0; i < us.length; i++) {
			us[i].checked = is;
		}
	}
	function deleteUser() {
		var dus = "";
		var ds = document.getElementsByName("user");
		for (var i = 0; i < ds.length; i++) {
			if (ds[i].checked) {
				dus = dus + ds[i].value + ",";
			}
		}
		if (dus == "") {
			alert("请选择要删除的用户。");
		} else {
			var userId = ${sessionScope.ub.userId};
			if (dus.indexOf(userId) != -1) {
				alert("不能删除自己。");
			} else {
				var is = confirm("确定删除吗？");
				if (is) {
					window.location.href = "UserServlet.do?method=delete&dus="
							+ dus;
				}
			}
		}
	}
	function tiaozhuan() {
		var num = document.getElementById("num").value;
		/*  var totlePages=document.getElementById("tp"); */
		var totlePages = ${pu.totlePages};
		if (parseInt(num) < 1 || parseInt(num) > totlePages) {
			if (totlePages != 1) {
				alert("请输入1到" + totlePages + "的数字。");
			} else {
				alert("只有一页数据。");
			}
		} else {
			location.href = "UserServlet.do?pageNum=" + num;
		}

	}

	function checkTime() {
		var st = document.getElementById("starttime");
		var et = document.getElementById("endtime");
		if (st.value != null && st.value != "" && et.value != null
				&& et.value != "" && st.value > et.value) {
			st.value = "";
			et.value = "";
			alert("请选择正确时间。");
		}
	}
	function test() {
		var sex = document.getElementById("sex").value;
		if (sex != null && sex != "") {
			document.getElementById("sexSelect").value = sex;
		}
		var dept = document.getElementById("dept").value;
		if (dept != null && dept != "") {
			document.getElementById("deptSelect").value = dept;
		}
		var msg = document.getElementById("msg").value;
		if (msg != null && msg != "") {
			alert(msg);
		}
	}
	function chaxun() {
		document.getElementById("myForm").submit();
	}
	function clearAll() {
		location.href = "UserServlet.do?flag=query";
	}
	function autoComplete(obj) {
		var name = obj.value;
		var d = document.getElementById("ac");
		if (name != null && name != "") {
			xmlHttp = null;
			if (window.ActiveXObjec) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} else if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			}
			d.innerHTML="";
			xmlHttp.open("post", "UserServlet.do?method=auto&username=" + name);
			xmlHttp.onreadystatechange = function() {
				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					result = xmlHttp.responseText;
					/* alert(result); */
					eval("rl=" + result);
					if (rl.length > 0) {
						d.style.display = "block";
						for (var i = 0; i < rl.length; i++) {
							var ub = rl[i];
							d.innerHTML += "<div style='cursor:pointer;' onmouseover='changefont(this)' onmouseout='changeout(this)' onmousedown='showfont(this)'>"
									+ ub.userName + "</div>";
						}
					}else{
						d.style.display="none";
					}
				}
			};
			xmlHttp.send(null);
		} else {
			d.innerHTML = "";
			d.style.display = "none";
		}
	}
	function changefont(obj) {
		obj.style.background = "gray";
		obj.style.color = "red";
	}
	function changeout(obj) {
		obj.style.background = "white";
		obj.style.color = "black";
	}
	function showfont(obj) {
		var na = obj.innerHTML;
		document.getElementById("n").value = na;
		var d = document.getElementById("ac");
		d.innerHTML = "";
		d.style.display = "none";
	}
	function clearText(){
		var d=document.getElementById("ac");
		d.innerHTML="";
		d.style.display="none";
	}
</script>

</head>

<body onload="test()">
	<input type="hidden" id="msg" value="${requestScope.msg }" />
	<input type="hidden" value="${up.sex }" id="sex" />
	<input type="hidden" value="${up.deptId }" id="dept" />
	<div class="title">
		<h2>用户管理</h2>
	</div>
	<div class="query">
		<form action="UserServlet.do" method="post" id="myForm">
			<input type="hidden" name="flag" value="query">
			<div class="query-conditions ue-clear">
				<div class="conditions staff ue-clear">
					<label>姓名：</label> <input type="text" name="username" id="n"
						autocomplete="off" value="${up.userName }"
						onkeyup="autoComplete(this)" onblur="clearText()" />
				</div>
				<div id="ac"
					style="width:173px;height:30px;border:1px solid #c5d6e0;background-color: white;
			        position:absolute;left:98px;top:81px;display:none;padding:0 10px">

				</div>
				<div class="conditions staff ue-clear">
					<label>性别：</label> <select name="sex" id="sexSelect"
						style="width:195px;height:30px;align:center;border:1px solid #c5d6e0">
						<option value="999">请选择</option>
						<option value="0">男</option>
						<option value="1">女</option>
					</select> <span id="ss"></span>
				</div>
				<div class="conditions staff ue-clear">
					<label> 部门：</label> <select name="dept" id="deptSelect"
						style="width:195px;height:30px;align:center;border:1px solid #c5d6e0">
						<option value="999">请选择</option>
						<c:forEach items="${dl }" var="dept">
							<option value="${dept.deptId }">${dept.deptName }</option>
						</c:forEach>
					</select>
					<!-- <a
					href="javascript:;" class="staff-select">选择</a> -->
				</div>
				<div class="conditions time ue-clear">
					<label>添加时间：</label>
					<div class="time-select">
						<!-- {dateFmt:'yyy-MM-dd HH:mm:ss'} -->
						<input type="text" placeholder="开始时间" name="starttime"
							id="starttime" onclick="WdatePicker()" onchange="checkTime()"
							value="${up.startTime }" /> <i class="icon"></i>
					</div>
					<span class="line">-</span>
					<div class="time-select">
						<input type="text" placeholder="结束时间" name="endtime" id="endtime"
							onclick="WdatePicker()" onchange="checkTime()"
							value="${up.endTime }" /> <i class="icon"></i>
					</div>
				</div>

			</div>
			<div class="query-btn ue-clear">
				<!-- <a href="javascript:;" class="confirm">查询</a> <a href="javascript:;"
				class="clear">清空条件</a> -->
				<input type="button" value="查询" class="" onclick="chaxun()">&nbsp;&nbsp;&nbsp;
				<input type="button" value="清空条件" class="" onclick="clearAll()">
			</div>
		</form>
	</div>
	<div class="table-operate ue-clear">
		<a href="UserServlet.do?method=padd" class="add">添加</a> <a
			href="javascript:deleteUser();" class="del">删除</a> <a
			href="javascript:;" class="check">xls</a>
	</div>
	<div class="table-box">
		<table>
			<thead>
				<tr>
					<th class="num"><input type="checkbox"
						onclick="chooseAll(this)" /></th>
					<th class="name">姓名</th>
					<th class="node">登录账号</th>
					<th class="name">性别</th>
					<th class="node">手机号</th>
					<th class="name">所在部门</th>
					<th class="process">角色</th>
					<th class="process">添加时间</th>
					<th class="num">排序</th>
					<th class="operate">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list }">
					<tr>
						<td colspan="9"
							style="font-size: 26px;color: red;text-align:center">没有找到合适的数据</td>
					</tr>
				</c:if>
				<c:if test="${!empty list }">
					<c:forEach items="${list }" var="u">
						<tr>
							<td class="num"><input type="checkbox" name="user"
								value="${u.userId }" /></td>
							<td class="name">${u.userName }</td>
							<td class="name">${u.loginName }</td>
							<c:if test="${u.sex == 0 }">
								<td class="num">男</td>
							</c:if>
							<c:if test="${u.sex == 1 }">
								<td class="num">女</td>
							</c:if>
							<td class="node">${u.mobilePhone }</td>
							<td class="time">${u.deptName }</td>
							<td class="name">${u.roleName }</td>
							<td class="name">${u.addTime }</td>
							<td class="num">${u.sort }</td>
							<td class="operate"><a
								href="UserServlet.do?method=look&userid=${u.userId}">查看</a>&nbsp;&nbsp;
								<a href="UserServlet.do?method=pedit&userid=${u.userId }"
								class="edit">修改</a></td>
						</tr>
					</c:forEach>
				</c:if>

			</tbody>
		</table>
	</div>
	<!-- <div class="pagination ue-clear"></div> -->
	<span>显示第 ${(pu.pageNum-1)*pu.pageRows+1} 条到 <c:choose>
			<c:when
				test="${((pu.pageNum-1)*pu.pageRows+pu.pageRows)<=pu.totleRows }">${(pu.pageNum-1)*pu.pageRows+pu.pageRows}</c:when>
			<c:otherwise>${pu.totleRows }</c:otherwise>
		</c:choose>条记录，总共 ${pu.totleRows} 条
	</span>
	<span style="float:right"> <a href="UserServlet.do?pageNum=1">首页</a>
		<c:if test="${pu.pageNum==1 }">上一页</c:if> <c:if
			test="${pu.pageNum>1 }">
			<a href="UserServlet.do?pageNum=${pu.pageNum-1 }">上一页</a>
		</c:if> <c:forEach begin="1" end="${pu.totlePages }" step="1" var="pn">
			<c:if test="${pn==pu.pageNum }"> ${pn }</c:if>
			<c:if test="${pn!=pu.pageNum }">
				<a href="UserServlet.do?pageNum=${pn }"> ${pn } </a>
			</c:if>
		</c:forEach> <c:if test="${pu.pageNum<pu.totlePages }">
			<a href="UserServlet.do?pageNum=${pu.pageNum+1 }">下一页</a>
		</c:if> <c:if test="${pu.pageNum==pu.totlePages }">下一页</c:if> <a
		href="UserServlet.do?pageNum=${pu.totlePages }">尾页</a> 转到 <input
		type="number" name="pageNum"
		style="width:40px;height:20px;text-align:center" id="num" /> 页
		<button type="button" onclick="tiaozhuan()">GO</button>
	</span>
</body>

</html>

