define(function(require){
	
	function TodoTasks(content){
		this.tmpl = $.templates(require("pages/flow/todoTasks.html"));
		this.element  =content.jquery?content:$(content);
		this.model = {tasks:{data:[],search:{assignee:$("#username").val()}}};
		this.element.link( this.tmpl,this.model);
		this.templateList =this.element.find("#todoList").datagrid();
		this.formDialog=this.element.find("#formTask").dialog({
			  autoOpen:false,
			  width:500,
			  height:300
		});
		this.diagram =	this.element.find("#diagram").dialog({ autoOpen:false});
		this.init();
	}

	
	TodoTasks.prototype.complate=function(){
		var that =this;
		var  data  = this.templateList.datagrid("getSelected")[0];
		var tmpl = $.templates(require("pages/forms/schameAudit.html"));
		var url ="flow/restService/RestService";
		var detailModel={};
		var formModel={};
		if(data){
			$.when($.get(url,{
				method:"history/historic-detail",
				params:"size=1000&processInstanceId="+data.processInstanceId
			}),$.get(url,{
				method:"history/historic-activity-instances",
				params:"size=1000&processInstanceId="+data.processInstanceId
			}),
			$.get(url,{
				method:"runtime/tasks/"+data.id+"/variables"
			})).done(function(details,instances,variables){
				var instancesTmpl={};
				$.each(instances[0].data||[],function(i,v){
					instancesTmpl[v.id]=v;
				});
				
				$.each(details[0].data||[],function(i,v){
					if(v.variable&&v.activityInstanceId){
						detailModel[v.variable.name]= detailModel[v.variable.name]||[];
						detailModel[v.variable.name].push({
							value:v.variable.value,
							taskId:v.taskId,
							activityName:instancesTmpl[v.activityInstanceId].activityName,
							assignee:instancesTmpl[v.activityInstanceId].assignee,
						});
					}
				});
				
				$.each(variables[0]||[],function(i,v){
					formModel[v.name]=$.extend({detail:detailModel[v.name]},{current:v.value});
				});
			
				that.formDialog.html(tmpl.render(formModel));
				that.formDialog.dialog("open").dialog("option","buttons",[{text:"同意",click:function(){
					var taskVar = [];
					$.each(that.formDialog.find("form").serializeArray(),function(i,v){
						if(v.value!=""&&formModel[v.name]!=v.value){
							taskVar.push(v);
						}
					});
					$.post("flow/restService/RestService",{
						 method:"runtime/tasks/"+data.id,
						 params:JSON.stringify({
							   "action" : "complete",
					          "variables":taskVar
					        })
					},function(){
						that.formDialog.dialog("close");
						that.templateList.datagrid("refresh");
					});
				}}]);
				
				that.formDialog.find(".tip").toggle(function(){
					$(this).siblings(".popover").show().css("left",$(this).position().left-236)
					                                   .css("left",$(this).position().left-236);
				},function(){
					$(this).siblings(".popover").hide();
				});
			});
		}
	
	};
	
	
	TodoTasks.prototype.init=function(){
		this.formDialog.on("dblclick",".showLabel",function(){
			var $this = $(this).hide();
			var $li  =$this.closest("li");
			$li.find($this.attr("for")).val($this.text()).show().mouseleave(function(){
				$this.show().html($(this).hide().val());
			});
		});
		
		
	};
	
	TodoTasks.prototype.showDiagram=function(){
		var data = this.templateList.datagrid("getSelected")[0],
	    that =this;
		this.diagram.html("<img src='flow/restService/getinstancesImg?processInstanceId="+data.processInstanceId+"'>");
		this.diagram.dialog("open");
	}
	
	return TodoTasks;
});