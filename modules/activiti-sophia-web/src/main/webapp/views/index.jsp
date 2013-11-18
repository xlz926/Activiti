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
                
                
                <div class="row-fluid">
    <div class="span12">
        <h3 class="heading">Horizontal scroll</h3>
        <div role="grid" class="dataTables_wrapper form-inline" id="dt_b_wrapper"><div class="row"><div class="span6"><div id="dt_b_length" class="dataTables_length"><label>Show <select name="dt_b_length" size="1" aria-controls="dt_b"><option value="10" selected="selected">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> entries</label></div></div><div class="span6"><div class="dataTables_filter" id="dt_b_filter"><label>Search: <input type="text" aria-controls="dt_b"></label></div></div></div><div class="dataTables_scroll"><div class="dataTables_scrollHead" style="overflow: hidden; position: relative; border: 0px none; width: 100%;"><div class="dataTables_scrollHeadInner" style="width: 1134px; padding-right: 0px;"><table class="table table-striped table-condensed dataTable" style="margin-left: 0px; width: 1134px;"><thead>
    <tr role="row"><th class="sorting_desc" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 226px;" aria-sort="descending" aria-label="Rendering engine: activate to sort column ascending">Rendering engine</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 231px;" aria-label="Browser: activate to sort column ascending">Browser</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 300px;" aria-label="Platform(s): activate to sort column ascending">Platform(s)</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 188px;" aria-label="Engine version: activate to sort column ascending">Engine version</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 139px;" aria-label="CSS grade: activate to sort column ascending">CSS grade</th></tr>
</thead></table></div></div><div class="dataTables_scrollBody" style="overflow: auto; width: 100%; height: 307px;"><table id="dt_b" class="table table-striped table-condensed dataTable" style="margin-left: 0px; width: 110%;" aria-describedby="dt_b_info"><thead>
    <tr role="row" style="height: 0px;"><th class="sorting_desc" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 226px; padding-top: 0px; padding-bottom: 0px; border-top-width: 0px; border-bottom-width: 0px; height: 0px;" aria-sort="descending" aria-label="Rendering engine: activate to sort column ascending"></th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 231px; padding-top: 0px; padding-bottom: 0px; border-top-width: 0px; border-bottom-width: 0px; height: 0px;" aria-label="Browser: activate to sort column ascending"></th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 300px; padding-top: 0px; padding-bottom: 0px; border-top-width: 0px; border-bottom-width: 0px; height: 0px;" aria-label="Platform(s): activate to sort column ascending"></th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 188px; padding-top: 0px; padding-bottom: 0px; border-top-width: 0px; border-bottom-width: 0px; height: 0px;" aria-label="Engine version: activate to sort column ascending"></th><th class="sorting" role="columnheader" tabindex="0" aria-controls="dt_b" rowspan="1" colspan="1" style="width: 139px; padding-top: 0px; padding-bottom: 0px; border-top-width: 0px; border-bottom-width: 0px; height: 0px;" aria-label="CSS grade: activate to sort column ascending"></th></tr>
</thead>
            
        <tbody role="alert" aria-live="polite" aria-relevant="all"><tr class="odd">
        <td class=" sorting_1">Webkit</td>
        <td class=" ">Safari 1.2</td>
        <td class=" ">OSX.3</td>
        <td class="center ">125.5</td>
        <td class="center ">A</td>
    </tr><tr class="even">
        <td class=" sorting_1">Webkit</td>
        <td class=" ">Safari 1.3</td>
        <td class=" ">OSX.3</td>
        <td class="center ">312.8</td>
        <td class="center ">A</td>
    </tr><tr class="odd">
        <td class=" sorting_1">Webkit</td>
        <td class=" ">Safari 2.0</td>
        <td class=" ">OSX.4+</td>
        <td class="center ">419.3</td>
        <td class="center ">A</td>
    </tr><tr class="even">
        <td class=" sorting_1">Webkit</td>
        <td class=" ">Safari 3.0</td>
        <td class=" ">OSX.4+</td>
        <td class="center ">522.1</td>
        <td class="center ">A</td>
    </tr><tr class="odd">
        <td class=" sorting_1">Webkit</td>
        <td class=" ">OmniWeb 5.5</td>
        <td class=" ">OSX.4+</td>
        <td class="center ">420</td>
        <td class="center ">A</td>
    </tr><tr class="even">
        <td class=" sorting_1">Webkit</td>
        <td class=" ">iPod Touch / iPhone</td>
        <td class=" ">iPod</td>
        <td class="center ">420.1</td>
        <td class="center ">A</td>
    </tr><tr class="odd">
        <td class=" sorting_1">Webkit</td>
        <td class=" ">S60</td>
        <td class=" ">S60</td>
        <td class="center ">413</td>
        <td class="center ">A</td>
    </tr><tr class="even">
        <td class=" sorting_1">Trident</td>
        <td class=" ">Internet
             Explorer 4.0</td>
        <td class=" ">Win 95+</td>
        <td class="center "> 4</td>
        <td class="center ">X</td>
    </tr><tr class="odd">
        <td class=" sorting_1">Trident</td>
        <td class=" ">Internet
             Explorer 5.0</td>
        <td class=" ">Win 95+</td>
        <td class="center ">5</td>
        <td class="center ">C</td>
    </tr><tr class="even">
        <td class=" sorting_1">Trident</td>
        <td class=" ">Internet
             Explorer 5.5</td>
        <td class=" ">Win 95+</td>
        <td class="center ">5.5</td>
        <td class="center ">A</td>
    </tr></tbody></table></div></div><div class="row"><div class="span6"><div class="dataTables_info" id="dt_b_info">Showing 1 to 10 of 57 entries</div></div><div class="span6"><div class="dataTables_paginate paging_bootstrap pagination"><ul><li class="prev disabled"><a href="#">&lt; Previous</a></li><li class="active"><a href="#">1</a></li><li><a href="#">2</a></li><li><a href="#">3</a></li><li><a href="#">4</a></li><li><a href="#">5</a></li><li class="next"><a href="#">Next &gt; </a></li></ul></div></div></div></div>
    </div>
</div>
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
										<li><a href="javascript:void(0)">Blog</a></li>
										<li><a href="javascript:void(0)">FAQ</a></li>
										<li><a href="javascript:void(0)">Formbuilder</a></li>
										<li><a href="javascript:void(0)">Location</a></li>
										<li><a href="javascript:void(0)">Profiles</a></li>
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
