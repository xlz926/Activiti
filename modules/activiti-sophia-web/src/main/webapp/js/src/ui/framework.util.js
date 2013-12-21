
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
			  serialize:function(obj){
				  var result =[];
				  $.map(obj,function(v,k){
					  result.push(k+"="+v);
				  });
				  return  result.join("&");
			  },
	         toString:function(obj){
	        	 //对象转换成字符串
	        	 return JSON.stringify(obj);
	         },
			 equal:function(source,target){
				 //判断对象的值是否相等
				 return JSON.stringify(source)==JSON.stringify(target);
			 },
			 clone:function(json){
               return JSON.parse(JSON.stringify(json));			 
			 }, 
			 json2Xml:function(json, opts) {
					opts =opts||{attr:"attr"};
					var result = opts.header?'<?xml version="1.0" encoding="UTF-8"?>':'';
					opts.header = false;
					type = json.constructor.name;
					
					if(type==='Array'){
						json.forEach(function(node){
							result += stell.util.json2Xml(node, opts);
						});
					} else if(type ==='Object' && typeof json === "object") {
						Object.keys(json).forEach(function(key){
							if(key!==opts.attr&&!(/^_/).test(key)){
								var node = json[key],
								attributes = '';
								if(opts.attr && json[opts.attr]){
									Object.keys(json[opts.attr]).forEach(function(k){
											if(!(/^_/).test(k)&&json[opts.attr][k]&&json[opts.attr][k]!="")attributes +=" "+k+"=\""+json[opts.attr][k]+"\"";
									});
								}
								var inner = stell.util.json2Xml(node,opts);
								if(inner){
									result += "<"+key+ attributes +">" + stell.util.json2Xml(node,opts)+"</"+key+">";
								} else {
									result += "<" +key + attributes+"/>";
								}
							}
						});
					} else {
						if(opts.char){
							return json.toString().replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');	
						}else{
							return json.toString();	
						}
						
					}

					return result;
				}
    };
	stell.callbacks=$.Callbacks();
	
  return stell;
})(jQuery, window, undefined);