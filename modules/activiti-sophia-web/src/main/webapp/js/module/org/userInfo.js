define(function(require){
	
	
	var $this,that,user ={} ;
	
	
	function UserInfo(self){
		that =this;
		$this=self.jquery?self:$(self);
		that.loadData();
		
		this.editFormPage =	$this.find("#userEdit").dialog({
				    autoOpen:false,
				    width:800,
				    height:600,
				    title:"用户编辑"
				   	});
		this.editFormPage.link(true, user);
		this.editFormPage.bind("submit",function(e){
			 $.post("flow/restService/RestService",{
				 method:"identity/users",
				 params:JSON.stringify(user)
			 }); 
			return false;
		});
		
	}
	UserInfo.prototype.loadData=function(){
		$.get("flow/restService/RestService",{method:"identity/users"},function(result){
			   $.templates("#templateTmpl").link("#templateList",result);
		});
	};
	
	UserInfo.prototype.addUser =function(){
		this.editFormPage.dialog("open");
	}
	UserInfo.prototype.saveUser= function(){
		
	
	};
	return UserInfo;
	
});