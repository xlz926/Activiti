<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="login_page">
<head>
<title>工作流后台管理系统</title>
    <%@ include file="/common/meta.jsp" %>
    <%@ include file="/common/global.jsp" %>
    <%@ include file="/common/include-base-styles.jsp" %>
    <%@ include file="/common/include-plugin-js.jsp" %>
      <%@ include file="/common/include-stell-js.jsp" %>
     <link href="${basePath}/style/css/index.css" rel="stylesheet"  >

<script src="${jsPath }/lib/seajs/sea.js"
        data-config="${jsPath }/lib/seajs/config.js"
        data-main="${jsPath }/module/common/main.js"></script> 
        
</head>
<body>
<div id="maincontainer" class="clearfix">
<header>
	<div class="navbar navbar-fixed-top">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a class="brand" href="dashboard.htm" ><i class="icon-home icon-white"></i> 工作流系统<span class="sml_t">2.0</span></a>
						</div>
					</div>
				</div>
			</header>
			<div id="contentwrapper">
            </div>
              <div class="sidebar">
              <div id="side_accordion" class="accordion">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseOne"  class="accordion-toggle">
									<i class="icon-folder-close"></i> 组织架构
								</a>
							</div>
							<div class="accordion-body" >
								<div class="accordion-inner">
									<ul class="nav nav-list">
										<li><a href="js/module/org/userInfo" class='ajaxMenu'>用户管理</a></li>
										<li><a href="js/module/org/groupInfo" class='ajaxMenu'>角色管理</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseTwo" data-parent="#side_accordion" data-toggle="collapse" class="accordion-toggle">
									<i class="icon-th"></i>流程管理
								</a>
							</div>
							<div class="accordion-body "  >
								<div class="accordion-inner">
									<ul class="nav nav-list">
										<li><a href="js/module/flow/templatesInfo" class='ajaxMenu'>流程模板</a></li>
										<li><a href="js/module/flow/instancesInfo" class='ajaxMenu'>流程实例</a></li>
										<li><a href="design" >流程设计</a></li>
								<!-- 		<li><a href="js/module/flow/tasksInfo" class='ajaxMenu'>待办任务</a></li>
										<li><a href="#views/flow/doneTasks.jsp" class='ajaxMenu'>已办任务</a></li> -->
									</ul>
								</div>
							</div>
						</div>
						<div class="accordion-group">
							<div class="accordion-heading">
								<a href="#collapseThree"  class="accordion-toggle">
									<i class="icon-user"></i> 系统设置
								</a>
							</div>
							<div class="accordion-body collapse"  >
								<div class="accordion-inner">
									<ul class="nav nav-list">
										<li><a href="javascript:void(0)">流程变量管理</a></li>
									</ul>
								</div>
							</div>
						</div>

					</div>
              
              
              </div>  
                 

</div>

</body>
</html>
