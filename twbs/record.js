$(function() {
	
	var hash  = window.location.hash;
	var index = hash.split('#')[1];
	
	if(index == 'login'){
		$('.row .nav [data-index=0]').addClass('active')
		getView('loginPage', 1, 'titles-01');
	}

	if(index == 'register'){
		$('.row .nav [data-index=1]').addClass('active')
		getView('registerPage', 1, 'titles-02');
	}
	
	if(index == 'sms'){
		$('.row .nav [data-index=2]').addClass('active')
		getView('smsPage', 1, 'titles-03');
	}
	
	if(index == 'email'){
		$('.row .nav [data-index=3]').addClass('active')
		getView('emailPage', 1, 'titles-04');
	}
	
})