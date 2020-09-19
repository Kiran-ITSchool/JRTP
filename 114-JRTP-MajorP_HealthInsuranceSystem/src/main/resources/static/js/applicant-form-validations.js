

$(function() {

	$("form[name='applicantForm']").validate({
		// Specify validation rules
		rules : {
			/*
			 * The key name on the left side is the name attribute of an input
			 * field. Validation rules are defined on the right side
			 */

			applicantFirstName : "required",
			
			applicantLastName : "required",

			applicantDob : "required",
			
			applicantGender : "required",
			
			applicantSsn : "required",
			
			applicantPhoneNumber : "required",
			
			applicantEmail : {
				required : true,
				email : true
			} 
		},
		// Specify validation error messages
		messages : {
			applicantFirstName : "<br> * Enter first name",
			applicantLastName : "<br> * Enter last name",
			applicantDob: "<br> * Enter your DOB ",
			applicantGender : "<br> * Select gender",
			applicantSsn : "<br> * SSN required",
			applicantPhoneNumber : "<br> * Phone number required",
			applicantEmail : "<br> * Invalid Email"
		},
		// Make sure the form is submitted to the destination defined
		// in the "action" attribute of the form when valid
		submitHandler : function(form) {
			form.submit();
		}
	});
});

