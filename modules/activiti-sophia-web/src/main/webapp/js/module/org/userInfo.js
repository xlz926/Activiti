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
		    height:400,
		    title:"用户编辑",
		    buttons:{"保存":function(){
		    	that.saveUser();
				return false;
		    }}
		   	})
	};
	UserInfo.prototype.addUser =function(){
		this.editFormPage.dialog("open");
	}
	UserInfo.prototype.saveUser= function(){
		var that =this;
		 $.post(this.url,{
			 method:"identity/users",
			 params:JSON.stringify(that.model.user)
		 },function(){
			 that.userList.datagrid("refresh");
		 }); 
	};
	return UserInfo;
	
});