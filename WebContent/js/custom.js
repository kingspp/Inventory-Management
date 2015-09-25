//Variable Declaration
var version = "Beta v0.0.1";

$(".version").html(version); 


$(".user").click( function(){
	//alert("user");
	if ($('#dispAlpha').is(':empty')){
		//$("#dispAlpha").hide();
		var id = 97;
		for(i=id ; i< id+26 ; i++){
			
			setTimeout(function(){ $("#dispAlpha").append("<a href=\"http://www.google.com\">"+String.fromCharCode(i-32)+"</a>&nbsp&nbsp");}, 10);
		}
		
	}

});

$(".inventory").click(function(){
	
	$("#dispAlpha").empty();
	
});
