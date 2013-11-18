;(function($,window,undefined){
	
	$.views.tags({
		pagination:function(total,start,size){
			var page =[];
		  page.push("<div class='pagination'><ul>");
		  	for(var i=0;i<total;i++){
				if(i==0){
					page.push('<li><a href="#" ><<</a></li>');
					continue;
				}else if((i+1)==total){
					page.push('<li><a href="#" >>></a></li>');
					continue;
				}else{
					page.push('<li><a href="#">'+i+'</a></li>');
				}
			}
		  	page.push("</ul></div>")
			return page.join('');
			
		}
		
		
	})
	
	
})(jQuery,window,undefined);