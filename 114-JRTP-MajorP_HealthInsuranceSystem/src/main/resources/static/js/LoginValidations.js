$(function() {

	$("form[name='LoginForm']").validate({
		rules : {
			userEmail : {
				required : true,
				email : true
			},
			userPassword : "required",
		},
		messages : {
			userEmail : "<br>* Email ID Required.",
			userPassword : "<br>* Password is empty."
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
