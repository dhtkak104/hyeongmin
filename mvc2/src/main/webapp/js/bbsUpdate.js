$(function() {
	
	$("#saveForm").submit(function(e){	 
		e.preventDefault();

		var form = $("#saveForm");
		var formData = form.serialize();
		var bbsNo = $("#bbsNo").val();
		debugger;
		
		$.ajax({
			url: '/bbs/'+bbsNo,
			type: 'POST',
			data: formData,
			dataType: 'json',
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