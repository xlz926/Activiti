<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div class="main_content"  npp-module="module/org/groupInfo">
       <div id="jCrumbs" class="breadCrumb module">
			    <ul>
			        <li>
			            <a href="#"><i class="icon-home">组织架构</i></a>
			        </li>
			        <li>
			            <a href="#">用户管理</a>
			        </li>
			    </ul>
       </div>
       
        <div class='container-fluid'>
        <div class="row-fluid">
        <div class="span9">
           <div class="widget-box">
							<div class="widget-title">
                                <span class="icon"><i class="icon-file"></i></span>
                                <h5>角色列表</h5>
                                <span>排序：</span>
                                  <a class="btn btn-mini btn-primary">用户编码</a>
                                  <a class="btn btn-mini">创建时间</a>
                            </div>
                              <div class="filter">
                           
                                <dl class="type_chouse">
                                    <dt>用户名：</dt>
                                    <dd>
                                        
                                    </dd>
                                </dl>
                            </div>
                            <div class="btn_table">
                                <a id ="openFile" class="btn"><i class="icon-plus"></i>新增用户</a>
                            </div>
                            
                               <div id="templateList" class ="row-fluid" >
	                             </div>
                            <div class="pagination pagination-small btn_all">
                                <ul>
                                    <li><a href="#">«</a></li>
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">»</a></li>
                                </ul>
                            </div>
                       </div>
       
       </div>
       
        <div class="span3">
         <aside class="side-right"  >
         
         <div id="contact" class="tab-pane fade active in">
                                        <div class="side-contact">
                                            <!--contact-control-->
                                            <div class="contact-control">
                                                <h5><i class="icofont-comment color-green"></i> 用户</h5>
                                            </div><!--/contact-control-->
                                            <!--contact-search-->
                                            <div class="contact-search">
                                                <div class="input-icon-prepend">
                                                    <div class="icon">
                                                        <button type="submit">
                                                            <i class="typicn-message color-silver-dark"></i>
                                                        </button>
                                                    </div>
                                                    <input type="text" placeholder="chat with..." name="contact-search" maxlength="11" class="input-block-level grd-white">
                                                </div>
                                            </div><!--/contact-search-->
                                            <!--contact-list, we set this max-height:380px, you can set this if you want-->
                                            <ul class="contact-list">
                                                <li class="contact-alt grd-white">
                                                    <a data-id="iin@mail.com" data-toggle="tab" href="#chat">
                                                        <!--we use contact-item structure like the component media in bootstrap-->
                                                        <div class="contact-item">
                                                            <div class="pull-left">
                                                                <img src="style/img/user-thumb-mini.jpg" style="width: 32px;height: 32px;" class="contact-item-object">
                                                            </div>
                                                            <div class="contact-item-body">
                                                                <div title="busy" class="status"><i class="icofont-certificate color-red"></i></div>
                                                                <p class="contact-item-heading bold">Iin T.</p>
                                                                <p class="help-block"><small class="muted">Team Leader</small></p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="contact-alt grd-white">
                                                    <!--we use data toggle tab for navigate this action-->
                                                    <a data-id="sungep@mail.com" data-toggle="tab" href="#chat">
                                                        <div class="contact-item">
                                                            <div class="pull-left">
                                                                <img src="style/img/user-thumb-mini.jpg" style="width: 32px;height: 32px;" class="contact-item-object">
                                                            </div>
                                                            <div class="contact-item-body">
                                                                <div title="idle" class="status"><i class="icofont-certificate color-orange"></i></div>
                                                                <p class="contact-item-heading bold">Sungep</p>
                                                                <p class="help-block"><small class="muted">UI designer</small></p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="contact-alt grd-white">
                                                    <!--we use data toggle tab for navigate this action-->
                                                    <a data-id="harab@mail.com" data-toggle="tab" href="#chat">
                                                        <div class="contact-item">
                                                            <div class="pull-left">
                                                                <img src="style/img/user-thumb-mini.jpg" style="width: 32px;height: 32px;" class="contact-item-object">
                                                            </div>
                                                            <div class="contact-item-body">
                                                                <div title="ofline" class="status"><i class="icofont-certificate color-silver-dark"></i></div>
                                                                <p class="contact-item-heading bold">Harab</p>
                                                                <p class="help-block"><small class="muted">Team Leader</small></p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="contact-alt grd-white active"> <!-- you can use this for active contact or your self status-->
                                                    <!--we use data toggle tab for navigate this action-->
                                                    <a data-id="janesmith@mail.com" data-toggle="tab" href="#chat">
                                                        <div class="contact-item">
                                                            <div class="pull-left">
                                                                <img src="style/img/user-thumb-mini.jpg" style="width: 32px;height: 32px;" class="contact-item-object">
                                                            </div>
                                                            <div class="contact-item-body">
                                                                <div title="online" class="status"><i class="icofont-certificate color-green"></i></div>
                                                                <p class="contact-item-heading bold">Jane smith</p>
                                                                <p class="help-block"><small class="muted">Data analyst</small></p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="contact-alt grd-white">
                                                    <!--we use data toggle tab for navigate this action-->
                                                    <a data-id="mahardika@mail.com" data-toggle="tab" href="#chat">
                                                        <div class="contact-item">
                                                            <div class="pull-left">
                                                                <img src="style/img/user-thumb-mini.jpg" style="width: 32px;height: 32px;" class="contact-item-object">
                                                            </div>
                                                            <div class="contact-item-body">
                                                                <div title="online" class="status"><i class="icofont-certificate color-green"></i></div>
                                                                <p class="contact-item-heading bold">Mahardika</p>
                                                                <p class="help-block"><small class="muted">PHP Developer</small></p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="contact-alt grd-white">
                                                    <!--we use data toggle tab for navigate this action-->
                                                    <a data-id="opytama@mail.com" data-toggle="tab" href="#chat">
                                                        <div class="contact-item">
                                                            <div class="pull-left">
                                                                <img src="style/img/user-thumb-mini.jpg" style="width: 32px;height: 32px;" class="contact-item-object">
                                                            </div>
                                                            <div class="contact-item-body">
                                                                <div title="ofline" class="status"><i class="icofont-certificate color-silver-dark"></i></div>
                                                                <p class="contact-item-heading bold">Opytama</p>
                                                                <p class="help-block"><small class="muted">PHP Developer</small></p>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                            </ul><!--/contact-list-->
                                        </div>
                                    </div>
         
         </aside>
        </div>
        </div>
	   </div>
	   <script  type="text/x-jsrender"   id ="templateTmpl">
<table class="table">
<thead><tr><th>角色ID</th><th>角色名称</th><th>角色类型</th> </tr></thead>
<tbody> 
{{for data}}
<tr><td>{{:id}}</td><td>{{:name}}</td><td>{{:type}}</td></tr>
{{/for}}
</tbody>
</table>
	</script>
	   
        </div>
       