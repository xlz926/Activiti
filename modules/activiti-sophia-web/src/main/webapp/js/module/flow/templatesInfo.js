define(function(require){
	
	function Template(content){
    	var	that =this ;
		this.url ="flow/restService/RestService" ,
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
			   title:"流程模板上传",
			   buttons:{"保存":function(){
				   that.fileSubmit.ajaxSubmit({success:function(){
					   that.loadData(that.model.templates.start,that.model.templates.size);
					   that.fileSubmit.dialog("close");
				   }});
			   }}
		   });
		this.init();
	}
	
	Template.prototype.init=function(){
		var that =this;
		this.element.find("#pagination").pagination({onSelectPage:function(index,size){
			that.loadData((index-1)*size,size);
		}});
		
	};
	
	Template.prototype.loadData=function(start,size){
		var that =this;
		$.get(this.url,{
			method:"process-definitions?sort=deploymentId&order=desc&start="+start+"&size="+size
			},function(result){
				  $.observable(that.model.templates.data).refresh(result.data);
				  $.observable(that.model).setProperty("start",result.start);
				  $.observable(that.model).setProperty("size",result.size);
				   that.element.find("#pagination").pagination("pageSize",result.total);
		   });
	};
	
	Template.prototype.openFile=function(){
		this.fileSubmit.dialog("open");
		
	};
	
	//启动流程
	Template.prototype.startFlow=function(event,obj){
		 var data =  $.view(obj).data;
		 $.post(this.url,{
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
	};
	
	//激活
	Template.prototype.activate=function(event,obj){
		var data =  $.view(obj).data;
		var that =this ;
		$.post("flow/restService/putRestService",{
			method:"repository/process-definitions/"+data.id,
			params:JSON.stringify({
				 action : "suspend",
				 includeProcessInstances: "false"
			})
		})
	};
	
	//暂停
	Template.prototype.suspend=function(event,obj){
		var data =  $.view(obj).data;
		var that =this ;
		$.post("flow/restService/putRestService",{
			method:"repository/process-definitions/"+data.id,
			params:JSON.stringify({
				 action : "activate",
				 includeProcessInstances: "true"
			})
		})
	};
	
	
	return Template;
	
});