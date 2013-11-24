
var  stell={} ;

(function ($, window, undefined){
	stell.util={
			  eval:function(){
				  //字符串转换成json对象
				  try{
					if ($.type(data) == 'string')
						return eval('(' + data + ')');
						else return data;
					} catch (e){
						return {};
					}
			  },
	         toString:function(obj){
	        	 //对象转换成字符串
	        	 return JSON.stringify(obj);
	         },
			 equal:function(source,target){
				 //判断对象的值是否相等
				 return JSON.stringify(source)==JSON.stringify(target);
			 }
    }
	stell.callbacks=$.Callbacks();
	
  return stell;
})(jQuery, window, undefined);