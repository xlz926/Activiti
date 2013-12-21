define(function(require){
	
	
	 var controlDialog=$("<div class='userview-property'/>").dialog({
		  autoOpen:false,
	      width: 620,
	      height:350
	});
	 var modelList = $.templates(require("../views/modelList.html"));
	
	function Control(context){
		var that =this;
		this.element  =context && content.jquery?context:$(context||document);
	}
	
	Control.prototype.openFlow=function(callback){
		controlDialog.link(modelList,{models:{data:[]}});
		controlDialog.dialog("open").dialog("option","title","选择流程").dialog("option","buttons",[{
			text:"确定",
			click:function(){
			   var data = $(this).find("#templateList").datagrid("getSelected")[0];
				callback(data);
				$(this).dialog("close");
			}
		},{text:"取消",click:function(){
			$(this).dialog("close");
		}}]);
		controlDialog.find("#templateList").datagrid();
	};
	
	Control.prototype.saveFlow=function(){
		
	};
	return Control;
	
});