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
							<ul class="nav user_menu pull-right">
								<li class="hidden-phone hidden-tablet">
									<div class="nb_boxes clearfix">
										<a data-toggle="modal" data-backdrop="static" href="#myMail" class="label ttip_b" title="New messages">25 <i class="splashy-mail_light"></i></a>
										<a data-toggle="modal" data-backdrop="static" href="#myTasks" class="label ttip_b" title="New tasks">10 <i class="splashy-calendar_week"></i></a>
									</div>
								</li>
								<li class="divider-vertical hidden-phone hidden-tablet"></li>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle nav_condensed" data-toggle="dropdown"><i class="flag-gb"></i> <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="javascript:void(0)"><i class="flag-de"></i> Deutsch</a></li>
										<li><a href="javascript:void(0)"><i class="flag-fr"></i> Français</a></li>
										<li><a href="javascript:void(0)"><i class="flag-es"></i> Español</a></li>
										<li><a href="javascript:void(0)"><i class="flag-ru"></i> Pусский</a></li>
									</ul>
								</li>
								<li class="divider-vertical hidden-phone hidden-tablet"></li>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="style/img/user_avatar.png"  alt="" class="user_avatar" />Johny Smith <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="user_profile.htm" >My Profile</a></li>
										<li><a href="javascrip:void(0)">Another action</a></li>
										<li class="divider"></li>
										<li><a href="index.htm" >Log Out</a></li>
									</ul>
								</li>
							</ul>
							<ul class="nav" id="mobile-nav">
								<li class="dropdown">
									<a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-list-alt icon-white"></i> Forms <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="form_elements.htm" >Form elements</a></li>
										<li><a href="form_extended.htm" >Extended form elements</a></li>
										<li><a href="form_validation.htm" >Form Validation</a></li>
									</ul>
								</li>
								<li class="dropdown">
									<a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-th icon-white"></i> Components <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="alerts_btns.htm" >Alerts & Buttons</a></li>
										<li><a href="icons.htm" >Icons</a></li>
										<li><a href="notifications.htm" >Notifications</a></li>
										<li><a href="tables.htm" >Tables</a></li>
										<li><a href="tables_more.htm" >Tables (more examples)</a></li>
										<li><a href="tabs_accordion.htm" >Tabs & Accordion</a></li>
										<li><a href="tooltips.htm" >Tooltips, Popovers</a></li>
										<li><a href="typography.htm" >Typography</a></li>
										<li><a href="widgets.htm" >Widget boxes</a></li>
										<li class="dropdown">
											<a href="#">Sub menu <b class="caret-right"></b></a>
											<ul class="dropdown-menu">
												<li><a href="#">Sub menu 1.1</a></li>
												<li><a href="#">Sub menu 1.2</a></li>
												<li><a href="#">Sub menu 1.3</a></li>
												<li>
													<a href="#">Sub menu 1.4 <b class="caret-right"></b></a>
													<ul class="dropdown-menu">
														<li><a href="#">Sub menu 1.4.1</a></li>
														<li><a href="#">Sub menu 1.4.2</a></li>
														<li><a href="#">Sub menu 1.4.3</a></li>
													</ul>
												</li>
											</ul>
										</li>
									</ul>
								</li>
								<li class="dropdown">
									<a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-wrench icon-white"></i> Plugins <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="charts.htm" >Charts</a></li>
										<li><a href="calendar.htm" >Calendar</a></li>
										<li><a href="datatable.htm" >Datatable</a></li>
										<li><a href="file_manager.htm" >File Manager</a></li>
										<li><a href="floating_header.htm" >Floating List Header</a></li>
										<li><a href="google_maps.htm" >Google Maps</a></li>
										<li><a href="gallery.htm" >Gallery Grid</a></li>
										<li><a href="wizard.htm" >Wizard</a></li>
									</ul>
								</li>
								<li class="dropdown">
									<a data-toggle="dropdown" class="dropdown-toggle" href="#"><i class="icon-file icon-white"></i> Pages <b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="chat.htm" > Chat</a></li>
										<li><a href="error_404.html" > Error 404</a></li>
										<li><a href="invoice.htm" > Invoice</a></li>
										<li><a href="mailbox.htm" >Mailbox</a></li>
										<li><a href="search_page.htm" >Search page</a></li>
										<li><a href="user_profile.htm" >User profile</a></li>
										<li><a href="user_static.htm" >User profile (static)</a></li>
									</ul>
								</li>
								<li>
								</li>
							</ul>
						</div>
					</div>
				</div>
			
			<div id="contentwrapper">
                <div class="main_content" npp-module="module/index">
                
                  <div id="jCrumbs" class="breadCrumb module">
			    <ul>
			        <li>
			            <a href="#"><i class="icon-home">流程管理</i></a>
			        </li>
			        <li>
			            <a href="#">流程实例</a>
			        </li>
			    </ul>
       </div>
       
           <div class='container-fluid'>
                
                </div>
              </div>
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
										<li><a href="#views/org/userInfo.jsp" class='ajaxMenu'>用户管理</a></li>
										<li><a href="#views/org/groupInfo.jsp" class='ajaxMenu'>角色管理</a></li>
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
										<li><a href="#views/flow/templatesInfo.jsp" class='ajaxMenu'>流程模板</a></li>
										<li><a href="#views/flow/instancesInfo.jsp" class='ajaxMenu'>流程实例</a></li>
										<li><a href="#views/flow/tasksInfo.jsp" class='ajaxMenu'>流程任务</a></li>
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
