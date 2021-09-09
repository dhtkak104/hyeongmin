$(function() {
	
	$("#loginForm").submit(function(e){	 
		e.preventDefault();		
		var data = $(this).serializeObject();

		$.ajax({
			url: '/login',
			type: 'POST',
			data: JSON.stringify(data),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data, txtStatus, xhr) {
				var code = xhr.status;
				if(200 <= code && code < 300) 
				{
					if(data){
						$(location).attr('href', '/bbs');
					} else {
						alert("로그인 실패");
					}
				}
				else {
					alert("로그인 실패");
				}
			}
		});
		return false;
	});
	
});