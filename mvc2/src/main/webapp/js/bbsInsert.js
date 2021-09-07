$(function() {
	
	$("#saveForm").submit(function(e){	 
		e.preventDefault();
		var data = $(this).serializeObject();
		
		$.ajax({
			url: '/bbs',
			type: 'POST',
			data: JSON.stringify(data),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data, txtStatus, xhr) {
				var code = xhr.status;
				if(200 <= code && code < 300) {
					if(data){
						$(location).attr('href', '/bbs');
					}
				}	
			}
		});
		return false;
	});
	
	
});