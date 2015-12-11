$(function() {
	/* $('#userForm').submit(function() {
    	console.log("in submit");
      var user = {firstName: $("form[name='userForm'] input[name='first_name']").val()};
      console.log(JSON.stringify(user));
        return false;
    });*/

	// attach a submit handler to the form 
	/*$("#userForm").submit(function(event) {
		var $form = $( this ),
		url = $form.attr( 'action' );

		/*stop form from submitting normally 
		event.preventDefault();

		 get some values from elements on the page: 
		

		var user = {user_name: $('#userForm input[id="firstName"]').val() + $('#userForm input[id="lastName"]').val(), 
				phone_number:$('#userForm input[id="ph"]').val(), email_id: $('#userForm input[id="email"]').val(),
				blood_group: $('#userForm input[id="bloodGroup"]').val(), doj: $('#userForm input[id="bloodGroup"]').val(),
				project: $('#userForm input[id="project"]').val(), filePath:"/home/files"
				filePath:	file-input};
		console.log(user);

		//Send the data using post 
		var posting = $.post( url, user );

		//Alerts the results 
		posting.done(function( data ) {
			alert('success');
		});
		 */

		/*$.ajax({
			type: "POST",
			url: url,
			data: new FormData($('#userForm')),
			processData: false,
			contentType: false,
			success: function (data) {
				console.log(data);
			}
		});*/
	/*	$("#userForm").ajaxSubmit(options); 
		return false;
	});
	*/
	
	$('#userForm').ajaxForm(function() { 
        alert("Thank you for your comment!"); 
    }); 
});
