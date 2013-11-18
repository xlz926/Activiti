<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div class="main_content"  npp-module="module/org/userInfo">
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
        
           <div class="widget-box">
							<div class="widget-title">
                                <span class="icon"><i class="icon-file"></i></span>
                                <h5>用户列表</h5>
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
	   <script  type="text/x-jsrender"   id ="templateTmpl">
<table class="table table-striped table-hover">
<thead><tr><th>用户ＩＤ</th><th>用户名称</th><th>别名</th><th>邮件地址</th> </tr></thead>
<tbody> 
{{for data}}
<tr><td>{{:id}}</td><td>{{:firstName}}</td><td>{{:lastName}}</td><td>{{: email }}</td></tr>
{{/for}}
</tbody>
</table>
{{pagination total start  size/}}
	</script>
	   
        </div>
       