define(function(require){
	
	
	function Instance(self){
		var that =this;
		that.loadData();
	}
	
	Instance.prototype.loadData=function(){
		$.get("flow/restService/RestService",{method:"history/historic-process-instances"},function(data){
			$.templates("#templateTmpl").link("#templateList",data);
		   });
		
	};
	
	return Instance;
	
});