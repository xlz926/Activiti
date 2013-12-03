

define(function(require, exports, module){
   require("js/module/common/jsviewHelper");
   require("js/module/common/jsviewTag");
   
   
   stell.callbacks.add(function(context){
	   context = context.jquery?context:$(context);
	   context.find("[pagination]").each(function(){
		   $(this).pagination(stell.util.eval($(this).attr("pagination")));
	   });
	   context.find("[datagrid]").each(function(){
		   $(this).datagrid(stell.util.eval($(this).attr("datagrid")));
	   });
   });
/*   $("[npp-module]").livequery(function(){
	   var $this =$(this);
	  seajs.use($this.attr('npp-module'),function(module){
		      var module =   new module($this);
		      $this.on("click","[event-click]",function(event){
		    	  event.preventDefault();
		    	$.isFunction(module[$(this).attr("event-click")]) && module[$(this).attr("event-click")](event,$(this)[0]);
		      });
	   });
	
   });*/
   
   var module;
   $("#contentwrapper").off().on("click","[event-click]",function(event){
 	  event.preventDefault();
    	 $.isFunction(module[$(this).attr("event-click")]) && module[$(this).attr("event-click")](event,$(this)[0]);
	  });
   
   
   $("body").on("click","a.ajaxMenu",function(e){
	   e.preventDefault();
	   seajs.use($(this).attr("href"),function(md){
		   if(md){
			    module =  new md($("#contentwrapper"));
			   // stell.callbacks.fire($("#contentwrapper"));
		   }
		
	   });
   });
   
	$('#side_accordion .accordion-toggle').click(function(e){
		   e.preventDefault();
		   var   thisAccordion = $(this).closest(".accordion-group");
		   if(thisAccordion.hasClass("open")){
			   thisAccordion.find(".accordion-body").slideUp();  
			   thisAccordion.removeClass("open");
		   }else{
			   thisAccordion.find(".accordion-body").slideDown();  
			   thisAccordion.addClass("open");
		   }
		});
   
});