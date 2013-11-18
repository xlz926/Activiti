define(function(require){
  var Oaleave = function Oaleave(self){
	 this.self =self||$(document);
	 self.find("form").ajaxForm();
 };
 
 return Oaleave;
});