
$(function () {
    var self = this;
    var control = $("#control-dialog"),
        property = $("#property-dialog"),
    content = $("#main-content"),
   monitor = $("#property-monitor"),
   model = {dataNode:[]},
        nodeCount = 0;
    jsPlumbModule.init();



    //jsPlumb.draggable(jsPlumb.getSelector("#node_0"))

    control.dialog({
        title: "工具栏",
        resizable: !1,
        width: 110,
        minWidth: 80,
        height: 450,
        position: [10, 50]
       
    });

    property.dialog({
        resizable: !1,
        width: 220,
        height:500,
        dialogClass: "property-dialog",
        title:"属性设置",
        position: [$(window).width() - 366, 100]

    });

    $("li.menu-item", control).bind({
        mouseenter: function () {
            $(this).addClass("hover")
        },
        mouseleave: function () {
            $(this).removeClass("hover")
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
        revert: "invalid",
        start: function () {
    
        }

    });

    content.droppable({
        greedy: !0,
        tolerance: "pointer",
        accept: ".menu-item",
        activate: function (b, c) {
           
        },
        deactivate: function (b, c) { 
        },
        over: function (b, c) {
            
        },
        out: function (b, c) {
       
        },
        drop: function (b, c) {

            var nodeData={
                id: "node_" + (nodeCount++),
                title: c.draggable.attr("title"),
                cls: "flow-node"
            }
           
            var node = $("<div class='flow-node' ><a class='img'/>{{if  title!=''}}" +
                "<span data-link='title'></span>{{/if}}</div>")
            node.link($.templates(node.html()), nodeData);
            node.attr("type", c.draggable.attr("type")).appendTo(content).css({ left: c.offset.left, top: c.offset.top });
            jsPlumb.draggable(jsPlumb.getSelector(node));
         
            jsPlumbModule.addEndpoints(node.attr("id"), ["BottomCenter", "RightMiddle", "LeftMiddle", "TopCenter"]);
   
            $.templates("#baseTemplate").link("#node-property", nodeData);
            model.dataNode.push(nodeData);
        }
    });



    property.on("click", '.submenu > a', function (e) {
        e.preventDefault();
        var submenu = $(this).siblings('ul');
        var li = $(this).parents('li');
        var submenus = li.siblings('li.submenu').find("ul");
        var submenus_parents = li.siblings('li.submenu');
        if (li.hasClass('open')) {
            submenu.slideDown();
            li.removeClass('open');
        } else {
          //  submenus_parents.removeClass('open');
            // submenus.slideUp();
            li.addClass('open');
           submenu.slideDown();
         
        }
    });



});