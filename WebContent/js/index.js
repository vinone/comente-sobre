$(document).ready(function(){
	var assunto = $("#assunto-js");
	var link = $("#comentar-js");
		 
	link.click(function(){
		if(assunto.val() == ""){
			$(".alert").removeClass("invisible");
			return false;
		}
		else
			link.attr("href",function(i,val){
				return val += assunto.val();
			});
	});	
});