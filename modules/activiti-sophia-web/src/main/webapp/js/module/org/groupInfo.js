define(function(require){
	
	function UserInfo(content){
		this.tmpl = $.templates(require("pages/org/groupInfo.html")),
		this.element  =content.jquery?content:$(content),
		this.model={role:{id:"rrr"},roles:{data:[]},users:{data:[]}},
		this.url ="flow/restService/RestService",
		this.element.link( this.tmpl,this.model);
		this.editFormPage =this.element.find("#groupEdit");
		this.init();
	}
	
	UserInfo.prototype.init=function(){
		var that =this;
		this.editFormPage.dialog({
		    autoOpen:false,
		    width:400,
		    height:200,
		    title:"角色编辑",
		    buttons:[{text:"保存",click:function(){
		    	this.editFormPage.ajax
		    }}]
		   	}).bind("submit",function(e){
			    $.post("flow/restService/RestService",{
				 method:"identity/groups",
				 params:JSON.stringify(that.model.role)
			 }); 
			 return false;
		});
		
		that.element.find("#openEidtPage").click(function(){
			that.editFormPage.dialog("open");
		});
		
		
		 that.element.find("#pagination").pagination({
			   onSelectPage:function(index,size){
				   that.refresh();
			   }
		   });
		
	};
	
	UserInfo.prototype.refresh=function(){
		var that = this;
		$.get(that.url,{method:"identity/groups"},function(result){
			   $.observable(that.model.roles.data).refresh(result.data);
		});
	}
	
	return UserInfo;
	
});