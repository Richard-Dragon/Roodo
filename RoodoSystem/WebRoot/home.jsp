<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
<meta charset="utf-8">
<link rel="stylesheet" href="css/base.css"  />
<link rel="stylesheet" href="css/home.css" />
<title>Roodo乐多文档管理系统</title>
</head>

<body>
<div class="article toolbar">
	
	

<div class="article half notice">
	<div class="wrap-l">
        <div class="title ue-clear">
            <h2>通知公告</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<ul class="notice-list">
            	<li class="ue-clear">
                	<a href="file/fileList.html" class="notice-title">中国移动关于设立作风建设监督举报电话的公告</a>
                    <div class="notice-time">05-08</div>
                </li>
                <li class="ue-clear">
                	<a href="file/fileList.html" class="notice-title">关于公示全市中国移动办公生产双主体责任名单的通知</a>
                    <div class="notice-time">05-08</div>
                </li>
                <li class="ue-clear">
                	<a href="file/fileList.html" class="notice-title">南京市中国移动支付系统安全管理责任人名单</a>
                    <div class="notice-time">05-08</div>
                </li>
                <li class="ue-clear">
                	<a href="file/fileList.html" class="notice-title">2014年全市通信行业安全生产工作要点</a>
                    <div class="notice-time">05-08</div>
                </li>
                <li class="ue-clear">
                	<a href="file/fileList.html" class="notice-title">中国移动南京公司关于表彰各位员工的规定</a>
                    <div class="notice-time">05-08</div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="article half matter">
	<div class="wrap-r">
        <div class="title ue-clear">
            <h2 class="title-list">
                <ul class="ue-clear">
                    <li class="current"><a href="javascript:;">快捷菜单</a></li>                    
                </ul>
            </h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<div class="matter-content current ue-clear">

				
				<ul class="toollist ue-clear">
					<li>
						<a href="javascript:;" class="img"><img src="images/icon01.png"  /></a>
						<p><a href="javascript:;">通知公告</a></p>
					</li>
					<li>
						<a href="javascript:;" class="img"><img src="images/icon02.png" /></a>
						<p><a href="javascript:;">文件查询</a></p>
					</li>

					<li>
						<a href="javascript:;" class="img"><img src="images/icon06.png"  /></a>
						<p><a href="javascript:;">通讯录</a></p>
					</li>
					<li>
						<a href="javascript:;" class="img"><img src="images/icon03.png"  /></a>
						<p><a href="javascript:;">密码修改</a></p>
					</li>
					<li>
						<a href="javascript:;" class="img"><img src="images/icon08.png" /></a>
						<p><a href="javascript:;">回收站</a></p>
					</li>    
					
				</ul>
				
                
            </div>            
        </div>
    </div>
</div>
<div class="article half duty">
	<div class="wrap-l">
        <div class="title ue-clear">
            <h2>新传文件</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<table>
            	<thead>
                	<tr>
                    	<th class="remark">名称</th>                      
                        <th class="leader">上传人</th>                        
						<th class="date">上传时间</th>
                      
                    </tr>
                </thead>
                <tbody>
					<tr>
                    	<td class="remark"><a href="file/test.docx" class="notice-title">公司管理规范.doc</a></td>               
                        <td class="leader">张三</td>                        
						<td class="date">2016-10-10 12:12</td>                     
                    </tr>
					<tr>
                    	<td class="remark"><a href="file/test.docx" class="notice-title">财务管理制度.doc</a></td>               
                        <td class="leader">张三</td>                        
						<td class="date">2016-10-10 12:12</td>                     
                    </tr>
                   
				    <tr>
                    	<td class="remark"><a href="file/test.docx" class="notice-title">XXX公司签订合同.doc</a></td>               
                        <td class="leader">张三</td>                        
						<td class="date">2016-10-10 12:12</td>                     
                    </tr>
                   
				   <tr>
                    	<td class="remark"><a href="file/test.docx" class="notice-title">公司管理规范.doc</a></td>               
                        <td class="leader">张三</td>                        
						<td class="date">2016-10-10 12:12</td>                     
                    </tr>
                   
				    <tr>
                    	<td class="remark"><a href="file/test.docx" class="notice-title">公司管理规范.doc</a></td>               
                        <td class="leader">张三</td>                        
						<td class="date">2016-10-10 12:12</td>                     
                    </tr>
                   
                   
                    
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="article half email">
	<div class="wrap-r">
        <div class="title ue-clear">
            <h2>未读邮件</h2>
            <a href="javascript:;" class="more">更多</a>
        </div>
        <div class="content">
        	<table>
            	<thead>
                	<tr>
                    	<th class="icon"></th>
                        <th class="sender">发件人</th>
                        <th class="subject">主题</th>
                        <th class="time last-item">时间</th>
                    </tr>
                </thead>
                <tbody>
                	<tr class="tody">
                    	<td colspan="4"><div class="td-wrap"><em>今天</em><a href="javascript:;">(3封)</a></div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">张三</div></td>
                        <td class="subject"><div class="td-wrap"><a href="mail/view.html">关于移动所有工作人员薪资调整的说明文件</a></div></td>
                        <td class="time"><div class="td-wrap">22分钟前</div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">李四</div></td>
                        <td class="subject"><div class="td-wrap"><a href="mail/view.html">行政廉洁形象建设工程要点会议纪要</a></div></td>
                        <td class="time"><div class="td-wrap">1小时前</div></td>
                    </tr>
                    <tr >
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">王五</div></td>
                        <td class="subject"><div class="td-wrap"><a href="mail/view.html">部门劳动节放假相关通知</a></div></td>
                        <td class="time"><div class="td-wrap">今天14:23</div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">赵六</div></td>
                        <td class="subject"><div class="td-wrap"><a href="mail/view.html">2014年度所有公务员征税政策文件下载</a></div></td>
                        <td class="time"><div class="td-wrap">今天10:23</div></td>
                    </tr>
                    <tr>
                    	<td class="icon"><div class="td-wrap"></div></td>
                        <td class="sender"><div class="td-wrap">陈琦</div></td>
                        <td class="subject"><div class="td-wrap"><a href="mail/view.html">关于移动所有工作人员薪资调整的说明文件</a></div></td>
                        <td class="time"><div class="td-wrap">22分钟前</div></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
</body>
<script type="text/javascript" src="js/jquery.js" ></script>
<script type="text/javascript" src="js/common.js" ></script>
<script type="text/javascript">
$(".title-list ul").on("click","li",function(){
	var aIndex = $(this).index();
	$(this).addClass("current").siblings().removeClass("current");
	$(".matter-content").removeClass("current").eq(aIndex).addClass("current");
});

$(".duty").find("tbody").find("tr:even").css("backgroundColor","#eff6fa");
</script>
</html>
    
   