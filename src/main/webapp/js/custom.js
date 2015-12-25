//Variable Declaration


var version = "Beta v0.1.4";
var urlPath = window.location.href+"welcome/hello/";
$('.timer').countTo();

$(".version").html(version);


$(document).ready(function(){
	// the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered	
	$('.modal-trigger').leanModal();
	$('select').material_select();	
});

function tab(){
	$(".collection").slideDown(750);
}


$('.datepicker').pickadate({
	container: 'body',
	selectMonths: true, // Creates a dropdown to control month
	selectYears: 15 // Creates a dropdown of 15 years to control year
});

$(".user").click( function(){
	$("#inventory_div").slideUp( "slow", function() {});
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
	$("#inventory_div").slideDown( "slow", function() {});
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









document.getElementById("file-input").onchange = function () {
	var reader = new FileReader();
	//console.log(document.getElementById("file-input").files[0]);

	reader.onload = function (e) {
		// get loaded data and render thumbnail.
		document.getElementById("userImage").src = e.target.result;

	};

	// read the image file as a data URL.
	reader.readAsDataURL(this.files[0]);
};









