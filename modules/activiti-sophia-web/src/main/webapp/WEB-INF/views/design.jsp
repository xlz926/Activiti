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
    <link href="${jsPath }/src/themes/bootstrap/datagrid.css" rel="stylesheet" media="screen">
   
   <script type="text/javascript" src="${jsPath}/lib/jquery/jquery.min.js"> </script>
   <script type="text/javascript" src="${jsPath}/lib/jui/jquery-ui.js"> </script>
     <script src="${jsPath}/lib/jsview/jsviews.js"></script>
  <script src="${jsPath}/lib/extend/keymaster.js"></script>
   
    <script src="${jsPath}/lib/jsplumb/jquery.jsPlumb-1.5.2.js"></script>
      <script type="text/javascript"  src="${jsPath}/module/design/jsplumb.js"></script>
     <script type="text/javascript" src="${jsPath}/src/ui/framework.util.js"> </script>
      <script type="text/javascript" src="${jsPath}/src/ui/framework.pagination.js"> </script>
      <script type="text/javascript" src="${jsPath}/src/ui/framework.datagrid.js"> </script>
   
   <script src="${jsPath }/lib/seajs/sea.js"
        data-config="${jsPath }/lib/seajs/config.js"
        data-main="${jsPath }/module/design/flow.js"></script> 
   
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
						<li class="active"><a href="#" id="openFlow">打开</a></li>
							<li><a href="#" action="newFlow">新建</a></li>
						<li><a href="#" id="save">保存</a></li>
						<li><a href="#">部署</a></li>
						<li><a href="#">验证</a></li>
						<li><a href="#">导入</a></li>
						<li><a href="#">导出</a></li>
						<li><a href="#">复制</a></li>
						<li><a href="#">剪切</a></li>
						<li><a href="#">粘贴</a></li>
						<li><a href="#">帮助</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

		<div id="main-content" data-link="{for process tmpl='#flowNode'}">
		</div>

		<div  id="control-dialog"   >
			<div id="userview-control">
				<ul class="nav nav-list bs-docs-sidenav affix">
					<li class="menu-item start" type="startEvent" title="开始">开始</li>
					<li class="menu-item end" type="endEvent" title="结束">结束</li>
					   <li class="divider" title=""></li>
                  	<li class="menu-item ticon7" type="ticon7" title="">分支</li>
                    <li class="menu-item ticon7" type="parallel" title="">并行</li>	
                    <li class="menu-item ticon7" type="parallel44" title="">异或</li>				
			    <li class="divider"></li>
                    <li class="menu-item usertask" type="userTask" title="人工任务">人工任务</li>	
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
           
			</div>
		</div>

      <script  type="text/x-jsrender" id="flowNode">
      <div class='flow-node' id="{{:attr.id}}" type="{{:attr._type}}" style="left:{{:attr._left}}px;top:{{:attr._top}}px" ><a class='img'></a>
               {{if attr._type!='startEvent' &&  attr._type!='endEvent'  }}
                     <span data-link="attr.name"> </span>
               {{/if}}
       </div>
      </script>
      
        <script  type="text/x-jsrender" id="propertyNode">
          <ul>
				<li class="active open"><a href="#"><i class="icon icon-home"></i> <span>基本属性</span><span class="label">2</span></a>
                    	<ul  class="nav nav-list">
						<li><span>编号</span><input class="input-small" type="text" data-link="attr.id" /></li>
						<li><span>名称</span><input class="input-small" type="text" data-link="attr.name" /></li>
                         {{if userTask}}
	                      <li><span>审核人</span><input class="input-small" type="text" data-link="attr.activiti_assignee"  /></li>
                         {{/if}}
					</ul>
				</li>
			</ul>
       </script>
       
        <script  type="text/x-jsrender" id="propertyProcess">
          <ul>
				<li class="submenu open"><a href="#"><i class="icon icon-home"></i> <span>基本属性</span><span class="label">2</span></a>
                    	<ul  class="nav nav-list">
						<li><span>流程编号</span><input class="input-small" type="text" data-link="attr.key" /></li>
						<li><span>流程名称</span><input class="input-small" type="text" data-link="attr.name" /></li>
					</ul>
				</li>
               <li class="submenu"><a href="#"><i class="icon icon-home"></i> <span>基本属性</span><span class="label">2</span></a>
                    	<ul  class="nav nav-list">
						<li><span>流程类别</span><input class="input-small" type="text" data-link="attr.category" /></li>
						<li><span>版本号</span><input class="input-small" type="text" data-link="attr.version" /></li>
						<li><span>描述</span><input class="input-small" type="text" data-link="attr.metaInfo" /></li>
					</ul>
				</li>
			</ul>
       </script>
       
      <script  type="text/x-jsrender" id="sequenceFlow">
          <ul>
				<li class="active open"><a href="#"><i class="icon icon-home"></i> <span>基本属性</span><span class="label">2</span></a>
                    	<ul  class="nav nav-list">
						<li><span>编号</span><input class="input-small" type="text" data-link="attr.id" /></li>
						<li><span>名称</span><input class="input-small" type="text" data-link="attr.name" /></li>
                        <li><span>条件</span><input class="input-small" type="text" data-link="attr._value" /></li>
					</ul>
				</li>
			</ul>
       </script>
       

</body>
</html>