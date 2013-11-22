

define(function(require, exports, module){
   require("js/module/common/jsviewHelper");
   require("js/module/common/jsviewTag");
   
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
   $("#contentwrapper").on("click","[event-click]",function(event){
 	  event.preventDefault();
    	 $.isFunction(module[$(this).attr("event-click")]) && module[$(this).attr("event-click")](event,$(this)[0]);
	  });
   
   
   $("body").on("click","a.ajaxMenu",function(e){
	   e.preventDefault();
	   seajs.use($(this).attr("href"),function(md){
		   if(md){
			    module =  new md($("#contentwrapper"));
		   }
		
	   });
   });
   
});