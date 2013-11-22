define(function(require){
	
	var serverUrl ="flow/restService/RestService";
	
	
	function Template(content){
	     this.element =content,
		this.model = {templates:{data:[]}},
		this.tmpl =  $.templates(require("pages/flow/templatesInfo.html")),
		this.element.link(this.tmpl,this.model),
		this.viewTemplate =this.element.find("#templateImg").dialog({
												            autoOpen:false,
												            width:600,
												            height:400}),
		this.fileSubmit  =   this.element.find("#fileSubmit").dialog({
			   autoOpen:false,
			   title:"流程模板上传"
		   });
		   this.init();
		   
	}
	Template.prototype.init=function(){
		var that =this;
		this.fileSubmit.find("form").ajaxForm({success:function(){
			   that.loadData();
			   that.fileSubmit.dialog("close");
		   }});
	   this.loadData();
	};
	
	Template.prototype.loadData=function(){
		var that =this;
		$.get(serverUrl,{
			method:"process-definitions"
			},function(result){
				   $.observable(that.model.templates.data).refresh(result.data);
		   });
	}
	
	Template.prototype.openFile=function(){
		this.fileSubmit.dialog("open");
		
	};
	
	//启动流程
	Template.prototype.startFlow=function(event,obj){
		 var data =  $.view(obj).data;
		 $.post(serverUrl,{
			 method:"runtime/process-instances",
			 params:JSON.stringify( {
			      processDefinitionKey:data.key,
		          businessKey:Math.random()*1000,
		          variables:[{name:"isDraft",value:true}]
		        })
		 }); 
		
	}
	
	//查看流程模板
	Template.prototype.viewFlow=function(event,obj){
		var data =  $.view(obj).data;
		var that =this ;
		that.viewTemplate.html($("<img />").attr("src","flow/restService/getResource?deploymentId="+data.deploymentId+"&diagramResourceName="+data.diagramResourceName));
		that.viewTemplate.dialog("open").dialog("option","title",data.name);
	}
	
	return Template;
	
});