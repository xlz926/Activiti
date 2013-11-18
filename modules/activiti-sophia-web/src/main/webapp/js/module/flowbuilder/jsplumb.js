; (function () {

    window.jsPlumbModule = {
        init: function () {

            jsPlumb.importDefaults({
                // default drag options
                DragOptions: { cursor: 'pointer', zIndex: 2000 },
                // default to blue at one end and green at the other
                EndpointStyles: [{ fillStyle: '#ffffff' }, { fillStyle: '#fff' }],
                // blue endpoints 7 px; green endpoints 11.
                Endpoints: [["Dot", { radius:1 }], ["Dot", { radius: 1 }]],
                // the overlays to decorate each connection with.  note that the label overlay uses a function to generate the label text; in this
                // case it returns the 'labelText' member that we set on each connection in the 'init' method below.
                ConnectionOverlays: [
					["Arrow", { location: 1, width:10, length:10 }],
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
              //  if (confirm("Delete connection from " + conn.sourceId + " to " + conn.targetId + "?"))
                //jsPlumb.detach(conn);
                console.log(conn.getOverlay());
                console.log(conn)
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
            var connectorPaintStyle = {
                lineWidth: 1,
                strokeStyle: "gray",
                joinstyle: "round",
                outlineColor: "gray",
                outlineWidth: 1
            },
			// .. and this is the hover style. 
			connectorHoverStyle = {
			    lineWidth: 1,
			    strokeStyle: "#5C96BC",
			    outlineWidth: 1,
			    outlineColor: "#5C96BC"
			},
			endpointHoverStyle = { fillStyle: "#5C96BC" },// the definition of source endpoints (the small blue ones)
			endpointPaintStyle = {
			    endpoint: "Dot",
			    paintStyle: {
			        strokeStyle: "#fff",
			        fillStyle: "transparent",
			        radius: 4,
			        lineWidth: 5
			       
			    },
			    isSource: true,
			    isTarget: true,
			    connector: ["Flowchart", { stub: [5,10], gap: 1, cornerRadius: 5, alwaysRespectStubs: false }],
			    connectorStyle: connectorPaintStyle,
			    hoverPaintStyle: endpointHoverStyle,
			    connectorHoverStyle: connectorHoverStyle,


			    maxConnections:99,
			    dragOptions: {}
			};
			

            for (var i = 0; i < sourceAnchors.length; i++) {
                var sourceUUID = toId + sourceAnchors[i];
                jsPlumb.addEndpoint(toId, endpointPaintStyle, { anchor: sourceAnchors[i], uuid: sourceUUID });
            }
        
          
        }
    };
})();