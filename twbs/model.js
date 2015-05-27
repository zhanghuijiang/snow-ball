function getJSON(url,page) {

	return $.ajax({
		url : url,
		data : {
			format : 'json',
			page : page
		},
		dataType : 'json',
		type : 'POST'
	}).fail(function() {
		console.log('AJAX error.')
	});

}
