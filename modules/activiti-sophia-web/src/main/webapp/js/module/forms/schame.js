define(function(require){
	function Schame(content){
		this.tmpl = $.templates(require("pages/forms/schame.html"));
		this.element  =content.jquery?content:$(content);
		this.model = {};
		this.element.link( this.tmpl,this.model);
	}
	
	//启动流程
	Schame.prototype.startFlow=function(event,obj){
		 $.post("flow/restService/RestService",{
			 method:"runtime/process-instances",
			 params:JSON.stringify( {
			      processDefinitionKey:"schame",
		          businessKey:Math.random()*1000,
		          variables:this.element.find('form').serializeArray()
		        })
		 }); 
	};
	return Schame;
});