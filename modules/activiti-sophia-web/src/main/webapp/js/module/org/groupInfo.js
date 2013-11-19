define(function(require){
	
	
	var $this,that ;
	
	function UserInfo(self){
		that =this;
		$this=self.jquery?self:$(self);
		
		that.loadData();
	}
	
	UserInfo.prototype.loadData=function(){
		$.get("flow/restService/RestService",{method:"identity/groups"},function(result){
			   $.templates("#templateTmpl").link("#templateList",result);
		});
		
	};
	
	return UserInfo;
	
});