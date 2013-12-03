define(function(require){
	
	function GroupInfo(content){
		var that =this;
		this.tmpl = $.templates(require("pages/org/groupInfo.html")),
		this.element  =content.jquery?content:$(content),
		this.model={role:{},
				roles:{data:[]},
				users:{data:[]},
				userList:{data:[]}},
		this.element.link( this.tmpl,this.model);
		this.editFormPage =this.element.find("#groupEdit");
		this.rolesList = this.element.find("#rolesList").datagrid({
			onClickRow:function(event,data){
			 	$.get("flow/restService/RestService",{
					method:"identity/users?memberOfGroup="+data.id
				},function(result){
					$.observable(that.model.users.data).refresh(result.data);
				}); 
			}
		});
		this.userList = this.element.find("#userList").datagrid();
		this.init();
	}
	
	GroupInfo.prototype.init=function(){
		var that =this;
		this.editFormPage.dialog({
		    autoOpen:false,
		    width:500,
		    height:300,
		    title:"角色编辑"
		});
		
		this.userList.dialog({
			autoOpen:false,
		    width:400,
		    height:300,
		    title:"选择用户",
		    buttons: {"保存":function(){
		    	var user = that.userList.datagrid("getSelected")[0],
		    	     role =that.rolesList.datagrid("getSelected")[0]
		    	if(user&&role){
		    			 $.post("flow/restService/RestService",{
							 method:"identity/groups/"+role.id+"/members",
							 params:JSON.stringify({userId:user.id})
						 },function(){
							 $.observable(that.model.users.data).insert(0,user);
						 }); 
		    		}
		         $(this).dialog("close");
		    }}}); 
		
	};
	GroupInfo.prototype.editRole=function(){
		var role =this.rolesList.datagrid("getSelected")[0];
		var that =this;
		if(role){
			 $.observable(that.model.role).setProperty("id",role.id);
			 $.observable(that.model.role).setProperty("name",role.name);
			 $.observable(that.model.role).setProperty("type",role.type);
			that.editFormPage.dialog("open");
			 this.editFormPage.dialog("option","buttons",[{text:"保存",click:function(){
				 $.post("flow/restService/putRestService",{
					method:"identity/groups/"+role.id,
				    params:stell.util.toString(that.model.role)
				 },function(){
					 that.rolesList.datagrid("refresh");
					 that.editFormPage.dialog("close");
				 });
			 }}]);
		}else{
			alert("你还未选择任何 记录");
		}
		
	}
	
	GroupInfo.prototype.addRole=function(){
		var that =this;
		 that.editFormPage.dialog("open");
		 this.editFormPage.dialog("option","buttons",[{text:"新增",click:function(){
			 $.post("flow/restService/RestService",{
				method:"identity/groups",
			    params:stell.util.toString(that.model.role)
			 },function(){
				 that.rolesList.datagrid("refresh");
				 that.editFormPage.dialog("close");
			 });
		 }}]);
	}
	
	GroupInfo.prototype.addMenbers=function(event,obj){
		this.userList.dialog("open");
		
	}
	GroupInfo.prototype.deleteRole=function(event,obj){
		var that =this,
		    role = this.rolesList.datagrid("getSelected")[0];
		if(role){
			  $.post("flow/restService/deleteRestService",{
					method:"identity/groups/"+role.id
				 },function(){
					 that.rolesList.datagrid("refresh");
					 that.editFormPage.dialog("close");
				 });
		}
	
		
	}
	
	return GroupInfo;
	
});