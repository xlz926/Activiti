define(function(require, exports, module) {
	
	
	//require("./modules/property");
   var  control  =  new (require("./modules/control"))($("#header"));
	
    var controlDialog = $("#control-dialog"),
    property = $("#property-dialog"),
    content = $("#main-content"),
    model = {
    	process:{
    		dataNode:[],
    	sequenceNode:[]},
       attr:{
    	 	key:"",
        	name:"",
        	category:"",
        	version:1,
        	metaInfo:"",
        	deploymentId:"",
       }
    },
    
    instance = jsPlumb.getInstance({	
    	DragOptions : { cursor: "pointer", zIndex:2000 },
    	PaintStyle : { strokeStyle:"gray", lineWidth:2 },
    	EndpointStyle : { radius:8, fillStyle:"none" },
    	HoverPaintStyle : {strokeStyle:"gray" },
    	EndpointHoverStyle : {fillStyle:"gray",strokeStyle:"gray" },
    	Connector :["Flowchart", { stub: [5,10], gap: 1, cornerRadius: 5 }],
    	ConnectionsDetachable:true,
    	ConnectionOverlays: [
    	                     ["Arrow", { location:1, width:10, length:10 }],
    	                     ["Label", {
    	                    	 location: 0.1,
    	                    	 id: "label",
    	                    	 label : " ",
    	                    	 location:0.7,
    	                    	 cssClass: "aLabel"
    	                     }]
    	                     ],
    	                     Container:"main-content"}),
    nodeCount = 0;
    
    $.link(true,"body", model);
    
    
    
    
    
    controlDialog.dialog({
        title: "工具栏",
        resizable: !1,
        width: 110,
        minWidth: 80,
        height: 450,
        position: {
        	my: "left center",
      	  at: "left center",
      	  of: document
        }
    });

    property.dialog({
        resizable: !1,
        width: 220,
        height:500,
        dialogClass: "property-dialog",
        title:"属性设置",
        position:{
             my: "right center",
        	 at: "right bottom",
        	 of: document
        }
    });


    $("li[type]", controlDialog).draggable({
        appendTo: "body",
        opacity: 0.7,
        cursorAt: {
            left: 2,
            top: 2
        },
        helper: "clone",
        revert: "invalid"
    });

    content.droppable({
        greedy: !0,
        tolerance: "pointer",
        accept: ".menu-item",
        drop: function (b, c) {
        	var type=c.draggable.attr("type");
            var flowNode={
                    attr:{
            		id: "node_" + (nodeCount++),
                    name: c.draggable.attr("title"),
                    _left:c.offset.left-25,
                    _top: c.offset.top-40,
                    _type:type
                    }
            };
            flowNode[type]= {documentation:""};
            
            if(type=="userTask"){
            	$.extend(flowNode.attr,{"activiti_assignee":""});
            }else if(type=="startEvent"){
            	$.extend(flowNode.attr,{"activiti_initiator":"applyUserId"});
            }
            
            
            var endpoints=[];
            var endpoint= {isSource:true,isTarget:true,maxConnections:10,deleteEndpointsOnDetach:false};
            $.observable(model.dataNode).insert(0,flowNode);
            instance.draggable(jsPlumb.getSelector("#"+flowNode.attr.id),{stop:function(event,ui){
        	   $.observable(flowNode).setProperty("attr._left", ui.position.left);
        	   $.observable(flowNode).setProperty("attr._top", ui.position.top);
            }});
            endpoints.push($.extend({ anchor: "BottomCenter", uuid: flowNode.attr.id+"BottomCenter"},endpoint));
            endpoints.push($.extend({ anchor: "RightMiddle", uuid: flowNode.attr.id+"RightMiddle"},endpoint));
            endpoints.push($.extend({ anchor: "LeftMiddle", uuid: flowNode.attr.id+"LeftMiddle"},endpoint));
            endpoints.push($.extend({ anchor: "TopCenter", uuid: flowNode.attr.id+"TopCenter"},endpoint));
            instance.addEndpoints(flowNode.attr.id,endpoints);
        }
    });


    property.on("click", '.submenu > a', function (e) {
        e.preventDefault();
        var submenu = $(this).siblings('ul');
        var li = $(this).parents('li');
        if (li.hasClass('open')) {
            submenu.slideDown();
            li.removeClass('open');
        } else {
            li.addClass('open');
           submenu.slideDown();
        }
    });

    instance.bind("connection", function(info,originalEvent ){
    	var sequenceNode ={
    			attr:{sourceRef:info.sourceId,targetRef:info.targetId,id:info.connection.id,name:info.connection.getLabel()},
    			sequenceFlow:""
    	        };
    	info.connection._data=sequenceNode;
    	
    	$(sequenceNode.attr).on("propertyChange", function(event, eventArgs){
    		event.stopPropagation();
    		if(eventArgs.path=="name"){
    			info.connection.setLabel(eventArgs.value);
    		}else if(eventArgs.path == "_value"){
    			sequenceNode.sequenceFlow= '<conditionExpression xsi:type=\"tFormalExpression\"><![CDATA['+eventArgs.value+']]></conditionExpression>';
    		}
    	}); 
    	
    	model.process.push(sequenceNode);
    });
    
    instance.bind("connectionDetached", function(info,originalEvent){
    	$.observable(model.process).remove($.inArray(info.connection._data,model.process));
   });
    
    instance.bind("click", function(conn,originalEvent ){
          $.templates("#sequenceFlow").link("#userview-property", conn._data);
    });
   

    $("#main-content").bind("click",function(){
    	$(this).find(".selected").removeClass("selected");
    	$.templates("#propertyProcess").link("#userview-property",model);
    });
    
    
    $("#main-content").on("click",".flow-node",function(event){
    	event.stopPropagation();
    	$.templates("#propertyNode").link("#userview-property", $.view(this).data);
    	$(this).addClass("selected").siblings(".flow-node").removeClass("selected");
    });
    
    
    $("#pallate").click(function(){
    	property.dialog("open");
    	controlDialog.dialog("open");
    });
    
    $("#save").click(function(){
    	if(!model.attr.id)return ;
    	 $.post("flow/restService/saveResource",{
				method:"repository/models/"+model.attr.id+"/source",
			    params:stell.util.toString(model)
			 },function(){
				 
			 });
    	
    	console.log(stell.util.json2Xml(stell.util.clone(model.dataNode)).replace("activiti_","activiti:"));
    });
    
    $("#new").click(function(){
    	$.post("flow/restService/RestService",{
			method:"repository/models",
		    params:stell.util.toString(model.attr)
		 },function(result){
			 $.extend(model.attr,{id:result.id});
		 });
    });
    
    
    $("#openFlow").click(function(){
    	control.openFlow(function(data){
    		console.log(data);
    	});
    });
    
    
    key('delete', function(event, handler){
    	$("#main-content").find(".selected").each(function(){
    		instance.removeAllEndpoints(this);
    		$.observable(model.dataNode).remove($.inArray($.view(this).data,model.dataNode));
    	});
    });

});