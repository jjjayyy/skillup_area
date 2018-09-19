/**
 * 
 */

$("#fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
	/*
	 * 기본적인 이벤트 처리 제한을 걸어야 드래그 할 때, 새 창으로 파일 관련 화면 안뜸.
	 */
});

$("#fileDrop").on("drop", function(event){
	event.preventDefault();
	
	var files = event.originalEvent.dataTransfer.files;
	
	var file = files[0];
	
	// console.log(file);
	var formData = new FormData();
	
	formData.append("file", file);

	
});

function addFileInfo(){
	var files = document.getElementById("fileUpload").files;
	
	for(var i=0;i<files.length;i++){
		var fileName = files[i].name;
		var fileSize = files[i].size;
		var fileInfo = "<p>" + fileName + "(" + fileSize + "byte)";
		
		fileInfo += "<button type='button' class='btn btn-link' id='delButton'";
		fileInfo += "onclick='deleteFileInfo()'>cancel</button>";
		fileInfo += "</p>";
		$("#fileDrop").append(fileInfo);
	}

}

function deleteFileInfo(){
	if($("#fileDrop p").length==0){
		alert("파일이 없습니다.");
	} else {
		$(document).on('click', '#delButton', function(event) {
			$(this).parent().remove();
		})
		/*$("#fileDrop p").remove();*/
	}

}