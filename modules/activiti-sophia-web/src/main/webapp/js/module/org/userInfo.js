define(function(require){
	
	function UserInfo(content){
		this.tmpl = $.templates(require("pages/org/userInfo.html")),
		this.url ='flow/restService/RestService',
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
		    width:600,
		    height:400,
		    title:"用户编辑",
		    buttons:{"保存":function(){
		    	that.saveUser();
				return false;
		    }}
		    
		   	}).bind("submit",function(e){
				
			});
		$.get(this.url,{method:"identity/users"},function(result){
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
		 $.post(this.url,{
			 method:"identity/users",
			 params:JSON.stringify(that.model.user)
		 },function(){
			 $.observable(that.model).setProperty("user",{});
		 }); 
	};
	
	
	
	return UserInfo;
	
});