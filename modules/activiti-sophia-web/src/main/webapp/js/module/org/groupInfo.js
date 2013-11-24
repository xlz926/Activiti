define(function(require){
	
	function GroupInfo(content){
		this.tmpl = $.templates(require("pages/org/groupInfo.html")),
		this.element  =content.jquery?content:$(content),
		this.model={role:{id:"rrr"},roles:{data:[]},users:{data:[]}},
		this.url ="flow/restService/RestService",
		this.element.link( this.tmpl,this.model);
		this.editFormPage =this.element.find("#groupEdit");
		this.element.off();
		this.init();
	}
	
	GroupInfo.prototype.init=function(){
		var that =this;
		this.editFormPage.dialog({
		    autoOpen:false,
		    width:400,
		    height:200,
		    title:"角色编辑",
		    buttons: {"保存":function(){
		    	 $.post("flow/restService/RestService",{
					 method:"identity/groups",
					 params:JSON.stringify(that.model.role)
				 }); 
				 return false;
		    }}
		});
		
		this.element.find("#openEidtPage").click(function(){
			that.editFormPage.dialog("open");
		});
		
		
		 this.element.find("#pagination").pagination({
			   onSelectPage:function(index,size){
				   that.refresh();
			   }
		   });
		 
		 this.element.on("click","#roles tr",function(){
			  var    data = $.view(this).data;
			
		 })
		
	};
	
	GroupInfo.prototype.refresh=function(){
		var that = this;
		$.get(that.url,{method:"identity/groups"},function(result){
			   $.observable(that.model.roles.data).refresh(result.data);
		});
	}
	GroupInfo.prototype.getMembers=function(event,obj){
		var that =this ,
		     data = $.view(this).data;
		  $.get(that.url,{method:"identity/users?memberOfGroup="+data.id},function(result){
			   $.observable(that.model.users.data).refresh(result.data);
		  });
	}
	GroupInfo.prototype.addMenbers=function(event,obj){
		
	}
	
	
	return GroupInfo;
	
});