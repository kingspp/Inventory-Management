//Variable Declaration
var version = "Beta v0.0.1";
var urlPath = window.location.href+"welcome/hello/query=";

$(".version").html(version); 



$(".user").click( function(){
	$("#dispAlpha").empty();
	$("#dispAlpha").hide();
	var id = 97;
	while(id < (97 + 26)){			
		$("#dispAlpha").append("<a href=\""+urlPath+String.fromCharCode(id-32)+"\">"+String.fromCharCode(id-32)+"</a>&nbsp&nbsp");		
		id++;
	}
	$("#dispAlpha").slideDown( "slow", function() {});
});

$(".inventory").click(function(){
	$("#dispAlpha").slideUp( "slow", function() {});

});

$(".inventory").click(function(){
	$.ajax({
		url: "json/inventory_category.json",
		//force to handle it as text
		dataType: "text",
		success: function (dataTest) {

			//data downloaded so we call parseJSON function 
			//and pass downloaded data
			var json = $.parseJSON(dataTest);
			//now json variable contains data in json format
			//let's display a few items
			$.each(json.inventory, function (i, jsonObjectList) {
				//alert(jsonObjectList.name);
				var newDiv = document.createElement("div");
				newDiv.setAttribute("Id", jsonObjectList.name);
				$("#inventory_div").append(newDiv);
				$('#'+jsonObjectList.name).append().load('inventory_card.jsp #inventory_card');
			});


		}
	});
});


