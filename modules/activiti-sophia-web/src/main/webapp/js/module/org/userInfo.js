define(function(require){
	
	function UserInfo(content){
		this.tmpl = $.templates(require("pages/org/userInfo.html")),
		this.content=content.jquery?content:$(content),
		this.model ={users:{data:[{id:"dd"}]},
				    user:{id:""},
			        roles:{data:[]}
	            };
		console.log(this.template);
		this.content.link(this.tmpl,this.model);
        this.editFormPage =	this.content.find("#userEdit");
		this.init();
	}
	UserInfo.prototype.init=function(params){
		var  that =this;
		that.editFormPage.dialog({
		    autoOpen:false,
		    width:800,
		    height:600,
		    title:"用户编辑"
		   	}).bind("submit",function(e){
				 $.post("flow/restService/RestService",{
					 method:"identity/users",
					 params:JSON.stringify(that.model.user)
				 }); 
				return false;
			});
		$.get("flow/restService/RestService",{method:"identity/users"},function(result){
			   $.observable(that.model.users.data).refresh(result.data);
			   that.content.find("#pagination").pagination({
				   total:result.total,
				   size:result.size,
				   onSelectPage:function(index,size){
					   
				   }
			   });
		});
	};
	
	
	UserInfo.prototype.addUser =function(){
		this.editFormPage.dialog("open");
	}
	UserInfo.prototype.saveUser= function(){
		
	
	};
	
	
	
	return UserInfo;
	
});