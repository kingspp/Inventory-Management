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
		var input = document.getElementById("file-id");
		file = input.files[0];
		var user = {user_name: $('#userForm input[id="firstName"]').val() + $('#userForm input[id="lastName"]').val(), 
				phone_number:$('#userForm input[id="ph"]').val(), email_id: $('#userForm input[id="email"]').val(),
				blood_group: $('#userForm input[id="bloodGroup"]').val(), doj: $('#userForm input[id="bloodGroup"]').val(),
				project: $('#userForm input[id="project"]').val()};
		if(file != undefined){
			formData= new FormData();
			if(!!file.type.match(/image.*/)){
				formData.append("image", file);
				$.ajax({
					url: "/user/insertUser",
					type: "POST",
					data: {userDetails: user, imageFile: formData},
					processData: false,
					contentType: false,
					success: function(data){
						alert('success');
					}
				});
			}else{
				alert('Not a valid image!');
			}
		}else{
			alert('Input something!');
		}
	});
	
	
});



