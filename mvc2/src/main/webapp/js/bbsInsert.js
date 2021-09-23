$(function() {
	
	$("#saveForm").submit(function(e){	 
		e.preventDefault();
		var data = $(this).serializeObject();
		
		$.ajax({
			url: '/bbs',					 // api end-point 
			type: 'POST',					 //	HTTP Method
			data: JSON.stringify(data), 	 // Json -> JsonString
			dataType: 'json',				 // server에서 데이터 받는 타입
			contentType: 'application/json', // client에서 데이터 보내는 타입
			success: function (data, txtStatus, xhr) {
				/* 
					data	 : 서버에서 응답한 데이터
					txtStatus: 단순히 success 문자열
					xhr		 : data와 비슷한 값이지만 HTTP Status가 포함된 값
				 */ 
				var code = xhr.status;
				if(200 <= code && code < 300) 
				{
					if(data) {
						$(location).attr('href', '/bbs');
					} else {
						alert("등록실패");
					} 
				}
				else {
					alert("등록실패");
				}
			}
		});
		return false;
	});
	
	
});