<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="en" >
   <%@ include file="/common/meta.jsp" %>
   <%@ include file="/common/global.jsp" %>
   <link href="${basePath }/style/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
   
 <link href="${jsPath}/lib/jui/custom-theme/jquery-ui-1.10.3.custom.css" rel="stylesheet" media="screen">
    <link href="${basePath }/js/module/design/style/app.css" rel="stylesheet" media="screen">
 
 
   <script type="text/javascript" src="${jsPath}/lib/jquery/jquery.min.js"> </script>
   <script type="text/javascript" src="${jsPath}/lib/jui/jquery-ui.js"> </script>
    <script type="text/javascript" src="${jsPath}/lib/angular/angular.js"> </script>
    <script type="text/javascript" src="${jsPath}/lib/angular/bootstrap/ui-bootstrap-tpls-0.8.0-SNAPSHOT.js"> </script>
    
     <script type="text/javascript" src="${jsPath}/module/design/app.js"> </script>
   
<head>
<title>流程设计器</title>
</head>
<body  class="grid">
	<div class="navbar navbar-fixed-top" id="header">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">activiti-flowDesign</a>
				<div class="nav-collapse collapse">
					<ul class="nav nav-pills">
						<li class="active"><a href="#">打开</a></li>
						<li><a href="#">保存</a></li>
						<li><a href="#">部署</a></li>
						<li><a href="#">验证</a></li>
						<li><a href="#">导入</a></li>
						<li><a href="#">导出</a></li>
						<li><a href="#">复制</a></li>
						<li><a href="#">剪切</a></li>
						<li><a href="#">粘贴</a></li>
						<li><a href="#">网格</a></li>
						<li><a href="#">帮助</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

		<div id="main-content">
			
		</div>

		<div  id="control-dialog"   >
			<div id="userview-control">
				<ul class="nav nav-list bs-docs-sidenav affix">
					<li class="menu-item start" type="start" title="">开始</li>
					<li class="menu-item end" type="end" title="">结束</li>
					   <li class="divider" title=""></li>
                  	<li class="menu-item ticon7" type="ticon7" title="">分支</li>
                    <li class="menu-item ticon7" type="parallel" title="">并行</li>	
                    <li class="menu-item ticon7" type="parallel44" title="">异或</li>				
			    <li class="divider"></li>
                    <li class="menu-item usertask" type="usertask" title="人工任务">人工任务</li>	
                    <li class="menu-item ticon2" type="ticon2" title="顺序任务">顺序任务</li>	
                    <li class="menu-item web" type="web" title="web服务">web服务</li>	
                    <li class="menu-item sql" type="sql" title="sql活动">sql活动</li>	
                    <li class="menu-item email" type="email" title="邮件任务">邮件任务</li>
                    <li class="menu-item email" type="subTask" title="子流程">子流程</li>
                    
				</ul>
			</div>
		</div>

		<div   id="property-dialog"  >
			<div id="userview-property">
                <ul >
				<li class="active submenu"><a href="#"><i class="icon icon-home"></i> <span>基本属性</span><span class="label">2</span></a>

                    	<ul  class="nav nav-list">
						<li><span>编号</span><input class="input-small" type="text" /></li>
						<li><span>名称</span><input class="input-small" type="text" /></li>
					</ul>
				</li>
				<li class="submenu open">
					<a href="#"><i class="icon icon-th-list"></i> <span>扩展属性</span> <span class="label">3</span></a>
					<ul  class="nav nav-list">
						<li><span>审核人</span><input class="input-small" type="text" /></li>
						<li><span>邮件通知</span><input class="input-small"  type="text" /></li>
						<li><span>过期时间</span><input class="input-small" type="text" /></li>
                        <li><span>提醒频率</span><input class="input-small" type="text" /></li>
					</ul>
				</li>
				
			</ul>

			</div>
		</div>



</body>
</html>