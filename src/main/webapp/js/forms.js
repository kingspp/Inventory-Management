$(function() {


	/*$("form[name='userForm']").submit(function(e) {
		e.preventDefault();
		
		var user = {user_name: $('#userForm input[id="firstName"]').val() + $('#userForm input[id="lastName"]').val(), 
				phone_number:$('#userForm input[id="ph"]').val(), email_id: $('#userForm input[id="email"]').val(),
				blood_group: $('#userForm input[id="bloodGroup"]').val(), doj: $('#userForm input[id="bloodGroup"]').val(),
				project: $('#userForm input[id="project"]').val()};
		console.log(user);
		
		var formData= new FormData();
		var input = document.getElementById("file-input");
		file = input.files[0];
		if(file != undefined){
			
			if(!!file.type.match(/image.*//*)){
				formData.append("imageFile", file);
				console.log("Image appeneded");
			}
		}
		
		 $.ajax({
            url: "/user/insertUser",
            type: "POST",
            data: {imageFile:formData },
            async: false,
            success: function (msg) {
                alert(JSON.stringify(msg));
                console.log(JSON.stringify(msg));
            },
            cache: false,
            contentType: false,
            processData: false
        });


	});
*/
	

	$("form[name='userForm']").submit(function(e) {
		e.preventDefault();
		
	// 	// var user = {user_name: $('#userForm input[id="firstName"]').val() + $('#userForm input[id="lastName"]').val(), 
	// 	// 		phone_number:$('#userForm input[id="ph"]').val(), email_id: $('#userForm input[id="email"]').val(),
	// 	// 		blood_group: $('#userForm input[id="bloodGroup"]').val(), doj: $('#userForm input[id="bloodGroup"]').val(),
	// 	// 		project: $('#userForm input[id="project"]').val()};
		
	// 	console.log("here");
	// 		formData= new FormData(this);
	// 		console.log(formData);
			
	// 			$.ajax({
	// 				url: "/user/insertUser",
	// 				type: "POST",
	// 				data: formData,
	// 				processData: false,
	// 				contentType: false,
	// 				success: function(data){
	// 					alert('success');
	// 				}
	// 			});
			
		
	// });

		var entityJson = form2js("userForm",null,false); // js library to get json from form
		var entityJsonStr = JSON.stringify(entityJson);
		
		

		var formData = new FormData();
		formData.append("data", new Blob([entityJsonStr], {
		                type : "application/json"  // ** specify that this is JSON**
		            })); 



		
       formData.append("image", document.getElementById("file-input").files[0]);
   

		console.log(entityJsonStr);

		$.ajax({
		    url:     "/user/insertUser",
		    type:    'POST',
		    processData: false,
		    contentType: false,
		    cache: false,
		    data:    formData,
		    error: function(xhr,status,err){
		        // failure handling
		    },
		    success: function(response){
		        // success handling
		    }
		});
	
	
});

});



