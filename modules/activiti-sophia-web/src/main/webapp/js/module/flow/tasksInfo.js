define(function(require){
	
	
	function Instance(self){
		var that =this;
		that.loadData();
	}
	
	Instance.prototype.loadData=function(){
		$.get("flow/restService/RestService",{method:"sophia/tasks?assignee=kermit"},function(data){
			$.templates("#templateTmpl").link("#templateList",data);
		   });
		
	};
	Instance.prototype.agreed =function(event,obj){
		var data =$.view(obj).data,
		    request = {action:"complete",
			          assignee:"kermit",
			          variables:[{name:"auditPass",value:true,type:"boolean"}]
		              };
		
		$.post("flow/restService/RestService",
				{method:"sophia/task/"+data.id,
			     params:JSON.stringify(request)});
	}
	
	Instance.prototype.disAgreed =function(event,obj){
		var data =$.view(obj).data,
	    request = {action:"complete",
		          assignee:"kermit",
		          variables:[{name:"auditPass",value:false,type:"boolean"}]
	              };
	
	   $.post("flow/restService/RestService",
			{method:"sophia/task/"+data.id,
		     params:JSON.stringify(request)});
	}
	
	return Instance;
	
});