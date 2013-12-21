define(function(require){

  var tmpl = $(require("../views/property.html"));
  var propertyNodeTmpl = $.templates(tmpl.find("#propertyNode").html());	
  var propertyProcessTmpl = $.templates(tmpl.find("#propertyProcess").html());	
  var sequenceFlowTmpl = $.templates(tmpl.find("#sequenceFlow").html());	
	
  var  propertyDialog=$("<div class='userview-property'/>").dialog({
	  resizable: !1,
	  autoOpen:false,
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
  
  function Property(context){
	
  }
	
  
  
  return  Property;
	
});


