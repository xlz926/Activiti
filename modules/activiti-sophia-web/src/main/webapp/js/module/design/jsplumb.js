; (function () {

    window.jsPlumbModule = {
        init: function () {
        	var color = "gray";
        	
            jsPlumb.importDefaults({
    			DragOptions : { cursor: "pointer", zIndex:2000 },
    			PaintStyle : { strokeStyle:color, lineWidth:2 },
    			EndpointStyle : { radius:9, fillStyle:color },
    			HoverPaintStyle : {strokeStyle:"#ec9f2e" },
    			EndpointHoverStyle : {fillStyle:"#ec9f2e" },
    			Connector :["Flowchart", { stub: [5,10], gap: 1, cornerRadius: 5, alwaysRespectStubs: false }],
                ConnectionOverlays: [
					["Arrow", { location:1, width:10, length:10 }],
					["Label", {
					    location: 0.1,
					    id: "label",
					    label : "",
					    location:0.7,
					    cssClass: "aLabel"
					}]
                ]
            });

   
      

            //
            // listen for clicks on connections, and offer to delete connections on click.
            //
            jsPlumb.bind("click", function (conn, originalEvent) {
               if (confirm("Delete connection from " + conn.sourceId + " to " + conn.targetId + "?"))
                jsPlumb.detach(conn);
            });

            jsPlumb.bind("connectionDrag", function (connection) {
                console.log("connection " + connection.id + " is being dragged. suspendedElement is ", connection.suspendedElement, " of type ", connection.suspendedElementType);
            });

            jsPlumb.bind("connectionDragStop", function (connection) {
                console.log("connection " + connection.id + " was dragged");
               console.log( jsPlumb.getConnections())
            });
        },
        addEndpoints: function (toId, sourceAnchors, targetAnchors) {
        

            for (var i = 0; i < sourceAnchors.length; i++) {
                var sourceUUID = toId + sourceAnchors[i];
                jsPlumb.addEndpoint(toId,   { anchor: sourceAnchors[i], uuid: sourceUUID });
            }
        
          
        }
    };
})();