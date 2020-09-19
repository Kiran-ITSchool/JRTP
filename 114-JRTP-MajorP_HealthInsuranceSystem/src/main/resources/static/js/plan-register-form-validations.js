

$(function() {

	$("form[name='planForm']").validate({
		// Specify validation rules
		rules : {
			/*
			 * The key name on the left side is the name attribute of an input
			 * field. Validation rules are defined on the right side
			 */

			planName : "required",
			
			planDesc : "required",

			startDate : {
				required : true,
			},
			
			endDate : {
				required : true,
			} 
		},
		// Specify validation error messages
		messages : {
			planName : "<br> * Please enter plan name",
			planDesc : "<br> * Please enter plan description",
			startDate: "<br> * Pick a start date",
			endDate : "<br> * Pick an end date"
		},
		// Make sure the form is submitted to the destination defined
		// in the "action" attribute of the form when valid
		submitHandler : function(form) {
			form.submit();
		}
	});
});

