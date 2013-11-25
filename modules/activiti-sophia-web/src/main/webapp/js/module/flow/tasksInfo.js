define(function(require){
	
	
	function Instance(content){
		 this.element =content,
		this.model = {tasks:{data:[]}},
		this.running =false,
		this.tmpl =  $.templates(require("pages/flow/tasksInfo.html")),
		this.element.link(this.tmpl,this.model);
	    this.loadData();
	}
	
	Instance.prototype.loadData=function(){
		var that =this;
		$.get("flow/restService/RestService",{method:"sophia/tasks"},function(result){
			  $.observable(that.model.tasks.data).refresh(result.data);
			  that.running=false;
		});
		
	};
	Instance.prototype.agreed =function(event,obj){
		var data =$.view(obj).data,
		    that =this ,
		    request = {action:"complete",
			          assignee:"kermit",
			          variables:[{name:"auditPass",value:true,type:"boolean"}]
		              };
		
		if(!this.running){
			this.running=true;
			$.post("flow/restService/RestService",
					{method:"sophia/task/"+data.id,
				     params:JSON.stringify(request)},function(){
				    	 that.loadData();
				     });
		}
		
		
	}
	
	Instance.prototype.disAgreed =function(event,obj){
		var data =$.view(obj).data,
	    request = {action:"complete",
		          assignee:"kermit",
		          variables:[{name:"auditPass",value:false,scope:"local",type:"boolean"},
		                     {name:"options",value:"错误",type:"String"}]
	              };
	
	   $.post("flow/restService/RestService",
			{method:"sophia/task/"+data.id,
		     params:JSON.stringify(request)},this.loadData);
	}
	
	Instance.prototype.deleted =function(event,obj){
		var data =$.view(obj).data,
	    request = {action:"complete",
		          assignee:"kermit",
		          variables:[{name:"auditPass",value:false,scope:"local",type:"boolean"},
		                     {name:"options",value:"错误",type:"String"}]
	              };
	
	   $.post("flow/restService/RestService",
			{method:"sophia/task/"+data.id,
		     params:JSON.stringify(request)},this.loadData);
	}
	
	
	
	return Instance;
	
});