
$(function () {
    var self = this;
    var control = $("#control-dialog"),
        property = $("#property-dialog"),
    content = $("#main-content"),
   monitor = $("#property-monitor"),
   model = {dataNode:[]},
        nodeCount = 0;
    
    $.link(true,"body", model);

    jsPlumbModule.init();

    control.dialog({
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

    $("#pallate").click(function(){
    	property.dialog("open");
    	control.dialog("open");
    });
    
    $("#save").click(function(){
    	console.log(model);
    });
    
    $("li.menu-item", control).bind({
        mouseenter: function () {
            $(this).addClass("hover");
        },
        mouseleave: function () {
            $(this).removeClass("hover");
        }
    });

    $("li[type]", control).draggable({
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
            var nodeData={
                id: "node_" + (nodeCount++),
                title: c.draggable.attr("title"),
                type:c.draggable.attr("type"),
                left:c.offset.left-25,
                top: c.offset.top-40
            };
            $.observable(model.dataNode).insert(0,nodeData);
           jsPlumb.draggable(jsPlumb.getSelector("#"+nodeData.id),{stop:function(event,ui){
        	   $.observable(nodeData).setProperty("left", ui.position.left);
        	   $.observable(nodeData).setProperty("top", ui.position.top);
            }});
           
           
      
           jsPlumbModule.addEndpoints(nodeData.id, ["BottomCenter", "RightMiddle", "LeftMiddle", "TopCenter"]);
   
            //$.templates("#propertyNode").link("#userview-property", nodeData);
           
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
    
    $("#main-content").on("click",".flow-node",function(){
    	$.templates("#propertyNode").link("#userview-property", $.view(this).data);
    	$(this).addClass("selected").siblings(".flow-node").removeClass("selected");
    });


});