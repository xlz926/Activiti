<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div class="main_content"  npp-module="module/flow/instancesInfo">
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
        <div class="widget-box">
							<div class="widget-title">
                                <span class="icon"><i class="icon-file"></i></span>
                                <h5>待办任务</h5>
                                <div>
                                    <span>排序：</span>
                                    <a class="btn btn-mini btn-primary">单据编号</a>
                                    <a class="btn btn-mini">创建时间</a>
                                </div>

                            </div>
                              <div class="filter">
                                <dl class="store">
                                    <dt>单据类型：</dt>
                                    <dd class="wrap-selects">
                                        <select>
                                            <option value="">--请选择--</option>
                                            <option value="1">差旅费</option>
                                            <option selected="selected" value="2">资产申购</option>
                                        </select>
                                    </dd>
                                    <dd class="instock">
                                        <a href="#">仅显示本人</a>
                                    </dd>
                                </dl>
                                <dl class="type_chouse">
                                    <dt>类型：</dt>
                                    <dd>
                                        <a class="on" href="#">全部</a>
                                    </dd>
                                    <dd>
                                        <a href="#">第一部分</a>
                                    </dd>
                                    <dd>
                                        <a href="#">第二部分</a>
                                    </dd>
                                </dl>
                            </div>
                            <div class="btn_table">
                                <a id ="openFile" class="btn"><i class="icon-plus"></i>文件上传</a>
                            </div>
                            
                               <div id="templateList" class ="row-fluid tab-pane active" >
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
</div>

<script  type="text/x-jsrender"   id ="templateTmpl">
<table class="table">
<thead><tr><th>流程实例ID</th><th>模板名称</th><th>类型</th><th>部署时间</th> </tr></thead>
<tbody> 
{{for data}}
<tr><td>{{:id}}</td><td>{{:businessKey}}</td><td>{{:processDefinitionId}}</td><td>{{: deploymentTime }}</td></tr>
{{/for}}
</tbody>

</table>
</script>


