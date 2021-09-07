$(function() {
	
	$("#saveForm").submit(function(e){	 
		e.preventDefault();
		
		var data = $(this).serializeObject();
		var bbsNo = $("#bbsNo").val();
		
		$.ajax({
			url: '/bbs/'+bbsNo,
			type: 'PUT',
			data: JSON.stringify(data),
			dataType: 'json',
			contentType: 'application/json',
			success: function (data, txtStatus, xhr) {
				var code = xhr.status;
				if(200 <= code && code < 300) 
				{
					if(code == 204 || data){
						$(location).attr('href', '/bbs');
					} else {
						alert("수정실패");
					}
				}
				else {
					alert("수정실패");
				}
			}
		});
		return false;
	});
	
});