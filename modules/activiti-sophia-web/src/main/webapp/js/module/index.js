define(function(require){
	
	
	function Index(self){
		var that =this;
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
	}
	
	return Index;
	 
	 
	 
 });













