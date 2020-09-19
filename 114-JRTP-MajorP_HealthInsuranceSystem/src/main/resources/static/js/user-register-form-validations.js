$(function() {

	$("form[name='userForm']").validate({
		// Specify validation rules
		rules : {
			/*
			 * The key name on the left side is the name attribute of an input
			 * field. Validation rules are defined on the right side
			 */

			firstName : "required",

			lastName : "required",

			userGender : "required",
			
			userRole : "required"
		
		},
		messages : {
			firstName : "<br>* Required.",
			lastName : "<br>* Required field.",
			userGender : "<br>* Please select gender.",
			userRole : "<br>* Please select a role"
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
