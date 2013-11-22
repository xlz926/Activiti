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
			            <a href="#">角色管理</a>
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
                            </div>
                            <div class="btn_table">
                                <a id ="openEidtPage" class="btn"><i class="icon-plus"></i>新增角色</a>
                            </div>
                            
                               <div  class ="row-fluid"  >
                               
                               <table class="table">
								<thead><tr><th>角色ID</th><th>角色名称</th><th>角色类型</th> </tr></thead>
								<tbody data-link="{for groups.data tmpl='#templateTmpl'}"> 
								</tbody>
								</table>
	                             </div>
	                             <div id="pagination"></div>
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
                                            {{for users.data}}
                                                <li class="contact-alt grd-white">
                                                    <a  data-toggle="tab" >
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
                                                {{/for}}
                                            </ul>
                                        </div>
                                    </div>
         
         </aside>
        </div>
        </div>
	   </div>
	   
	    <form class="form-horizontal hide"  id="groupEdit">
					<fieldset>
						<div class="control-group formSep">
							<label class="control-label">角色编码</label>
							   <div class="controls">
								<input type="text" data-link="id"   >
							</div>
						</div>
						<div class="control-group formSep">
							<label class="control-label" for="u_fname">角色名称</label>
							<div class="controls">
								<input type="text" data-link="name"  >
							</div>
						</div>
						
						<div class="control-group formSep">
							<label class="control-label" for="u_fname">角色类型</label>
							<div class="controls">
								<input type="text" data-link="type"  >
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit"  class="btn btn-gebo">保存</button>
							   <a class="btn">取消</a>
							</div>
						</div>
					</fieldset>
				</form>
	   
	   
	   
	   <script  type="text/x-jsrender"   id ="templateTmpl">
           <tr><td>{{:id}}</td><td>{{:name}}</td><td>{{:type}}</td></tr>
	</script>
	   
        </div>
       