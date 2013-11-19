define(function(require){
	
	var serverUrl ="flow/restService/RestService";
	
	
	function Template(self){
		var that =this;
		  $("#fileSubmit").dialog({
			   autoOpen:false,
			   title:"流程模板上传",
			   open:function(){
				   var $this =$(this);
				   $this.find("form").ajaxForm({success:function(){
					   that.loadData();
					   $this.dialog("close");
				   }});
			   }
		   });
		   
		   $("#openFile").click(function(){
			   $("#fileSubmit").dialog("open");
		   });
		   that.loadData();
		
	}
	Template.prototype.loadData=function(){
		$.get(serverUrl,{
			method:"repository/process-definitions"
			},function(data){
			   $.templates("#templateTmpl").link("#templateList",data);
		   });
	};
	
	//启动流程
	Template.prototype.startFlow=function(event,obj){
		 var data =  $.view(obj).data;
		 $.post(serverUrl,{
			 method:"runtime/process-instances",
			 params:JSON.stringify( {
			      processDefinitionKey:data.key,
		          businessKey:Math.random()*1000
		        })
		 }); 
		
	}
	
	//查看流程模板
	Template.prototype.viewFlow=function(event,obj){
		var data =  $.view(obj).data;
		$.get()
	}
	
	return Template;
	
});