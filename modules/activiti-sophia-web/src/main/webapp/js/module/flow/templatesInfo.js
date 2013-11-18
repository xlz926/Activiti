define(function(require){
	
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
		$.get("flow/restService/getRestService",{
			method:"repository/process-definitions"
			},function(data){
			   $.templates("#templateTmpl").link("#templateList",data);
		   });
	};
	Template.prototype.startFlow=function(event,obj){
		 var data =  $.view(obj).data;
		 $.post("flow/restService/postRestService",{
			 method:"runtime/process-instances",
			 params:JSON.stringify( {
			      processDefinitionKey:data.key,
		          businessKey:Math.random()*1000
		        })
		 }); 
		
	}
	
	
	return Template;
	
});