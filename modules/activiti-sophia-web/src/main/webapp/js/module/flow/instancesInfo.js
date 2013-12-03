define(function(require){
	
	
	function Instance(content){
		var	that =this ;
	    this.element =content,
		this.model = {instances:{data:[]},
	    		      historyTask:{data:[]}},
		this.tmpl =  $.templates(require("pages/flow/instancesInfo.html")),
		this.element.link(this.tmpl,this.model);
		this.templateList =this.element.find("#instanceList").datagrid();
	   this.historyDialog =	this.element.find("#history").dialog({ autoOpen:false});
	   this.diagram =	this.element.find("#diagram").dialog({ autoOpen:false});
	}
	
	
	Instance.prototype.showTask=function(){
		var data = this.templateList.datagrid("getSelected")[0],
		    that =this;
		
		var history ={}
		$.get("flow/restService/RestService",{method:"history/historic-detail?processInstanceId="+data.id},function(result){
			
			$.each(result.data||[],function(i,v){
				history[v.executionId]=history[v.executionId]||[];
				history[v.executionId].push(v.variable);
			})
			console.log(history);
		});
		
	
		
		$.get("flow/restService/RestService",{method:"sophia/historic/tasks?processInstanceId="+data.id},function(result){
			$.observable(that.model.historyTask.data).refresh(result.data);
		});
		 this.historyDialog.dialog("open");
		 
	}

	Instance.prototype.showDiagram=function(){
		var data = this.templateList.datagrid("getSelected")[0],
	    that =this;
		this.diagram.html("<img src='flow/restService/getinstancesImg?processInstanceId="+data.id+"'>");
		this.diagram.dialog("open");
	}
	
	return Instance;
	
});