//댓글 리스트 불러오기
function replyList() {
	$.ajax({
				url : '/replyList',
				type : 'GET',
				data : {
					'boardNo' : $("#boardNo").val()
				},
				success : function(replyList) {
					
					var comments = '';
					var sessionUserNo = $("#sessionUserNo").val();
					
					$.each(replyList,function(key, value) {
						if(value.depth==0){
							var reContent = '"' + value.reContent + '"';
							comments += "<div class='panel-footer' id='reply_" + value.reNo + "'>";
							comments += "<p class='fa fa-user'>" + value.userNm + "</p>";
							comments += "<p class='fa fa-comment-o'>" + value.reContent + "</p>";
							
							if (sessionUserNo == value.userNo) {
								comments += "<button type='button' class='btn btn-danger btn-circle'";
								comments += "style='float: right' onclick='deleteReply("
										+ value.reNo + ")'>";
								comments += "<i class='fa fa-times'></i></button>";
								comments += "<button type='button' class='btn btn-default btn-circle'";
								comments += "style='float: right' onclick='editReplyForm(" + value.reNo	+ "," + reContent + ")'>";
								comments += "<i class='fa fa-pencil'></i>";
								comments += "</button>";
							}
							comments += "<button type='button' class='btn btn-link' style='float:right' onclick='reReplyForm("
									+ value.reNo + "," + value.depth + ")'>re</button>";
							comments += "</div>";
						} 
						})
						$("#reply").html(comments);
						replyForm(replyList, sessionUserNo);
				}
			})
}

//대댓글 불러오기
function replyForm(replyList, sessionUserNo){
	for(var i=0; i<replyList.length; i++){
		for(var j=0; j<replyList.length; j++){
			if(replyList[i].parentReNo == replyList[j].reNo){
				var reComments = '';
				reComments += "<div class='panel-footer' id='reply_" + replyList[i].reNo + "'>";
				reComments += "<div>";
				reComments += "<p class='fa fa-user'>" + replyList[i].userNm + "</p>";
				reComments += "<p class='fa fa-comment-o'>" + replyList[i].reContent + "</p>";
				if (sessionUserNo == replyList[i].userNo) {
					reComments += "<button type='button' class='btn btn-danger btn-circle'";
					reComments += "style='float: right' onclick='deleteReply("
							+ replyList[i].reNo + ")'>";
					reComments += "<i class='fa fa-times'></i></button>";
					reComments += "<button type='button' class='btn btn-default btn-circle'";
					reComments += "style='float: right' onclick='editReplyForm(" + replyList[i].reNo + "," + replyList[i].reContent + ")'>";
					reComments += "<i class='fa fa-pencil'></i>";
					reComments += "</button>";
				}
				reComments += "</div>";
				reComments += "</div>";
				$("#reply_" + replyList[j].reNo).append(reComments);
		}
		}

}
}

// 댓글 추가
function addReply() {
	var pattern = /\s/g;
	if($("#comment").val()=="" ||  $("#comment").val().match(pattern)){
		alert("댓글을 입력해주세요.");
		return false;
	};
	$.ajax({
		url : '/addReply',
		type : 'POST',
		data : {
			'reContent' : $("#comment").val(),
			'boardNo' : $("#boardNo").val()
		},
		success : function() {
			replyList();
		}
	})
}

// 댓글 삭제
function deleteReply(reNo) {
	$.ajax({
		url : '/deleteReply',
		type : 'GET',
		data : {
			'reNo' : reNo
		},
		success : function() {
			replyList();
		}
	})
}

// 댓글 수정 입력 창
function editReplyForm(reNo, reContent) {
	if ($("#editReplyForm").length > 0) {
		$("#editReplyForm").remove();
	}
	if ($("#reReForm").length >= 0) {
		$("#reReForm").remove();
	}
	var editReplyForm = '';
	editReplyForm += "<div id=editReplyForm>";
	editReplyForm += "<input class='form-control' placeholder='Enter text' id='editReply' value='"
			+ reContent + "'>";
	editReplyForm += "<button type='button' class='btn btn-outline btn-primary' onclick='editReply("
			+ reNo + ")'";
	editReplyForm += ">Edit</button>";
	editReplyForm += "</div>";

	$('#reply_' + reNo).append(editReplyForm);
}

// 댓글 수정
function editReply(reNo) {
	var pattern = /\s/g;
	if($("#editReply").val()=="" ||  $("editReply").val().match(pattern)){
		alert("댓글을 입력해주세요.");
		return false;
	};
	$.ajax({
		url : '/editReply',
		type : 'GET',
		data : {
			'reContent' : $("#editReply").val(),
			'reNo' : reNo
		},
		success : function() {
			replyList();
		}
	})
}

// 대댓글 입력 창
function reReplyForm(reNo, depth) {
	if ($("#reReForm").length > 0) {
		$("#reReForm").remove();
	}
	if ($("#editReplyForm").length >= 0) {
		$("#editReplyForm").remove();
	}
	var reReplyForm = '';
	reReplyForm += "<div id=reReForm>";
	reReplyForm += "<input class='form-control' placeholder='Enter text' id='reReply'>";
	reReplyForm += "<button type='button' class='btn btn-outline btn-primary' onclick='reReply("
			+ reNo + ","+ depth + ")'";
	reReplyForm += ">Save</button>";
	reReplyForm += "</div>";

	$('#reply_' + reNo).append(reReplyForm);
}

// 대댓글 입력
function reReply(reNo, depth) {
	var pattern = /\s/g;
	if($("#reReply").val()==""){
		alert("댓글을 입력해주세요.");
		return false;
	};
	$.ajax({
		url : "/addReply",
		type : "POST",
		data : {
			'reNo':reNo,
			'depth':depth,
			'reContent' : $("#reReply").val(),
			'boardNo' : $("#boardNo").val()
		},
		success:function(){
			replyList();
		},
		error:function(){
			alert("실패");
		}
	})
}



$(function() {
	replyList();
});