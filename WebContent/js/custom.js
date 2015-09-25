//Variable Declaration
var version = "Beta v0.0.1";

$(".version").html(version); 


$(".user").click( function(){
	$("#dispAlpha").empty();
	$("#dispAlpha").hide();
	var id = 97;
	while(id < (97 + 26)){			
		$("#dispAlpha").append("<a href=\"http://www.google.com\">"+String.fromCharCode(id-32)+"</a>&nbsp&nbsp");		
		id++;
	}
	$("#dispAlpha").slideDown( "slow", function() {});
});

$(".inventory").click(function(){
	$("#dispAlpha").slideUp( "slow", function() {});

});
