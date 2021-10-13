var deleteFileNo = null;
var fileList = [];
var fileIdx = 0;

$(function() {
	
	/* 기존 첨부파일 존재여부 확인하여 화면 동적제어 */
	$('.og_file_area').show();
	$('.new_file_area').hide();
	
	var fileNo = $("#fileNo").val();
	if(isEmpty(fileNo)) {
		$('.og_file_area').hide();
		$('.new_file_area').show();
	}
	
	/* 첨부파일 리스너 */ 
	$("#file").on("change", changeFile);
	
	$('#uploadBtn').click(function (e) {
	    e.preventDefault();
	    $('#file').click();
	});

	/* 저장 Submit */ 
	$("#saveForm").submit(function(e){	 
		e.preventDefault();
		
		var formData = new FormData($(this)[0]);
		for (var i=0; i<fileList.length; i++) {
			// 삭제 안한것만 담아 준다. 
			if(!fileList[i].is_delete){
				formData.append("file", fileList[i]);
			}
		}
		if(!isEmpty(deleteFileNo)) {
			formData.append("deleteFileNo", deleteFileNo);
		}
		
		var bbsNo = $("#bbsNo").val();
		$.ajax({
			url: '/bbs/'+bbsNo,
			type: 'POST',
			data: formData,
			async: false,
			cache: false,
			contentType: false,
			enctype: 'multipart/form-data',
			processData: false,
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

function changeFile(e){
	// 초기화
	initFile();
	
	var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);
    
    filesArr.forEach(function (f) {
    	var reader = new FileReader();
    	reader.onload = function (e) {
    		fileList.push(f);
    		$('#newFileChange').append(
				'<div id="file' + fileIdx + '">'
    			+ '<img src="/img/file.png"/>'
         		+ '<a>'+ f.name +'<span class="delete_btn" onclick="deleteNewFile(\'file' + fileIdx + '\')">x</span></a>'
         		+ '</div>'
    		);
    		fileIdx ++;
    	};
    	reader.readAsDataURL(f);
    });
    $("#file").val("");
}

function initFile(){
	for (var i=0; i<fileList.length; i++) {
		$('#file' + i).remove();
	}
	
	fileList = new Array();
	fileIdx = 0;
}

function deleteNewFile(fileId){
	var idx = fileId.replace(/[^0-9]/g, "");
	fileList[idx].is_delete = true;
	$('#' + fileId).remove();
}

function deleteOgFile(fileNo){
	deleteFileNo = fileNo;
	$('.og_file_area').hide();
	$('.new_file_area').show();
}