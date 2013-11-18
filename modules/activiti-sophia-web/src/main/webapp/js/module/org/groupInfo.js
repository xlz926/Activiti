define(function(require){
	
	
	var $this,that ;
	
	function UserInfo(self){
		that =this;
		$this=self.jquery?self:$(self);
		
		that.loadData();
	}
	
	UserInfo.prototype.loadData=function(){
		console.log($this)
		$.get("flow/restService/getRestService",{method:"identity/groups"},function(result){
			   $.templates("#templateTmpl").link("#templateList",result);
		});
		
	};
	
	return UserInfo;
	
});