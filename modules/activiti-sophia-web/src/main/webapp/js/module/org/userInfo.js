define(function(require){
	
	function UserInfo(content){
		this.tmpl = $.templates(require("pages/org/userInfo.html")),
		this.url ='flow/restService/RestService',
		this.element=content.jquery?content:$(content),
		this.model ={users:{data:[],
			         search:{method:"identity/users"}
		             },
				    user:{id:""},
			        roles:{data:[]}
	            };
		this.element.link(this.tmpl,this.model);
        this.editFormPage =	this.element.find("#userEdit");
        this.userList =this.element.find("#userList");
		this.init();
	}
	UserInfo.prototype.init=function(params){
		var  that =this;
		this.userList.datagrid();
		that.editFormPage.dialog({
		    autoOpen:false,
		    width:600,
		    height:400 });
	};
	UserInfo.prototype.addUser =function(){
		var that =this;
		this.editFormPage.dialog("open").dialog("option","title","添加用户")
		                 .dialog("option","buttons",[{text:"新增",click:function(){
		                	 $.post(that.url,{
		    					 method:"identity/users",
		    					 params:JSON.stringify(that.model.user)
		    				 },function(){
		    					 that.userList.datagrid("refresh");
		    						that.editFormPage.dialog("close");
		    				 }); 
		                 }}]);
	}
	
	UserInfo.prototype.editUser =function(){
		var that =this;
		 var user =   this.userList.datagrid("getSelected")[0];
		   $.observable(that.model.user).setProperty("id",user.id);
		 $.observable(that.model.user).setProperty("firstName",user.firstName);
    	 $.observable(that.model.user).setProperty("lastName",user.lastName);
	  	$.observable(that.model.user).setProperty("email",user.email);
		 $.observable(that.model.user).setProperty("password",user.password);
		 
		this.editFormPage.dialog("open").dialog("option","title","添加用户")
		                 .dialog("option","buttons",[{text:"保存",click:function(){
		                	 $.post("flow/restService/putRestService",{
		    					 method:"identity/users/"+user.id,
		    					 params:JSON.stringify( that.model.user)
		    				 },function(){
		    					 that.userList.datagrid("refresh");
		    						that.editFormPage.dialog("close");
		    				 }); 
		                 }}]);
	}
	
	UserInfo.prototype.deleteUser=function(){
		var that =this;
		 var user =   this.userList.datagrid("getSelected")[0];
		 $.post("flow/restService/deleteRestService",{
			 method:"identity/users/"+user.id
		 },function(){
			 that.userList.datagrid("refresh");
		 }); 
	}
	
	return UserInfo;
	
});