<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.dialog.css" />
<link rel="stylesheet" href="css/index.css" />
<title>Roodo乐多文档管理系统</title>
</head>

<body>
	<div id="container">
		<div id="hd">
			<div class="hd-wrap ue-clear">
				<div class="top-light"></div>
				<h1 class="logo">Roodo乐多文档管理系统</h1>

				<div class="login-info ue-clear">
					<div class="welcome ue-clear">
						<span>欢迎您,</span><a href="javascript:;" class="user-name">${sessionScope.ub.userName }</a>
					</div>
					<div class="login-msg ue-clear">
						<a href="javascript:;" id="msg" class="msg-txt">消息</a> <a
							href="javascript:;" class="msg-num">10</a>
					</div>
				</div>

				<div class="toolbar ue-clear">
					<a href="index.jsp" class="home-btn">首页</a> <a href="javascript:;"
						class="quit-btn exit"></a>
				</div>
			</div>
		</div>
		<div id="bd">
			<div class="wrap ue-clear">
				<div class="sidebar">
					<h2 class="sidebar-header">
						<p>菜单导航</p>
					</h2>
					<ul class="nav">
						<li class="office current"><div class="nav-header">
								<a href="javascript:;" date-src="home.html" class="ue-clear"><span>工作中心</span><i
									class="icon"></i></a>
							</div></li>
						<li class="gongwen"><div class="nav-header">
								<a href="javascript:;" date-src="file/add.html" class="ue-clear"><span>文件上传</span><i
									class="icon"></i></a>
							</div></li>
						<li class="konwledge">
							<div class="nav-header">
								<a href="javascript:;" class="ue-clear"><span>文档管理</span><i
									class="icon"></i></a>
							</div>
							<ul class="subnav">
								<li><a href="javascript:;" date-src="file/fileList.html">公司文档</a></li>
								<li><a href="javascript:;" date-src="file/fileList.html">我的文档</a></li>
								<li><a href="javascript:;" date-src="file/shareList.html">共享文档</a></li>
								<li><a href="javascript:;" date-src="file/starList.html">我的关注</a></li>
							</ul>
						</li>
						<li class="gongwen"><div class="nav-header">
								<a href="javascript:;" date-src="bulletin/list.html"
									class="ue-clear"><span>通知公告</span><i class="icon"></i></a>
							</div></li>

						<li class="agency">
							<div class="nav-header">
								<a href="javascript:;" class="ue-clear"><span>通讯录</span><i
									class="icon"></i></a>
							</div>
							<ul class="subnav">
								<li><a href="javascript:;" date-src="book/innerList.html">内部通讯录</a></li>
								<li><a href="javascript:;" date-src="book/myList.html">个人通讯录</a></li>
							</ul>
						</li>


						<li class="email">
							<div class="nav-header">
								<a href="javascript:;" class="ue-clear"><span>邮件管理</span><i
									class="icon"></i></a>
							</div>
							<ul class="subnav">
								<li><a href="javascript:;" date-src="mail/add.html">写信</a></li>
								<li><a href="javascript:;" date-src="mail/revList.html">收件箱</a></li>
								<li><a href="javascript:;" date-src="mail/sendList.html">发件箱</a></li>
								<li><a href="javascript:;" date-src="mail/dropList.html">草稿箱</a></li>
							</ul>
						</li>

						<li class="system">
							<div class="nav-header">
								<a href="javascript:;" class="ue-clear"><span>系统管理</span><i
									class="icon"></i></a>
							</div>
							<ul class="subnav">
								<li><a href="javascript:;"
									date-src="UserServlet.do?flag=query">用户管理</a></li>
								<li><a href="javascript:;"
									date-src="sys/deptment/list.html">部门管理</a></li>
								<li><a href="javascript:;" date-src="sys/role/list.html">角色管理</a></li>
								<li><a href="javascript:;" date-src="sys/power/list.html">权限设置</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="content">
					<iframe src="home.jsp" id="iframe" width="100%" height="100%"
						frameborder="0"></iframe>
				</div>
			</div>
		</div>
		<div id="ft" class="ue-clear">
			<div class="ft-left">
				<span></span> <em>乐多文件管理系统 维护电话：010-66660990</em>
			</div>
			<div class="ft-right">
				<span>Automation</span> <em>V2.0&nbsp;2016</em>
			</div>
		</div>
	</div>
	<div class="exitDialog">
		<div class="dialog-content">
			<div class="ui-dialog-icon"></div>
			<div class="ui-dialog-text">
				<p class="dialog-content">你确定要退出系统？</p>
				<p class="tips">如果是请点击“确定”，否则点“取消”</p>
				<div class="buttons">
					<input type="button" class="button long2 ok" value="确定" /> <input
						type="button" class="button long2 normal" value="取消" />
				</div>
			</div>

		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.dialog.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>

<script>
	$('#msg').click(function(e) {
		layer.open({
			type : 2,
			title : '请选择部门',
			fix : false,
			maxmin : true,
			shadeClose : true,
			area : [ '800px', '600px' ],
			content : 'mail/revList.html',
			end : function() {

			}
		});
	});
</script>

</html>

