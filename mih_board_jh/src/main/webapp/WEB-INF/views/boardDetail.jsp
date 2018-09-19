<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mih.board.board.vo.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/tiles/layout/header.jsp"></jsp:include>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="col-lg-12">
				<h1 class="page-header">Read an Article</h1>
			</div>
			<!-- /.col-lg-12 -->

			<div class="form-group">
				<div class="col-lg-12">
					<div class="panel panel-info">
						<c:forEach items="${boardDetail}" var="boardDetail">
							<div class="panel-heading">${boardDetail.boardTitle}
								<p class="fa fa-calendar" style="float: right">
									&nbsp;${boardDetail.boardDate}</p>
								<p class="fa fa-user" style="float: right">&nbsp;${boardDetail.userNm}&emsp;</p>
							</div>
							<div class="panel-body">
								<p>${boardDetail.boardContent}</p>
							</div>
							<div class="panel-footer">
								<c:forEach items="${fileList}" var="fileList">
									<div>
									<input type="hidden" id="fileNo" value="${fileList.fileNo}">
									<a href="/downloadFile?fileNo=${fileList.fileNo}" name="file">${fileList.originalFileNm}</a>(${fileList.fileSize}kb)
									</div>
								</c:forEach>
							</div>
						</c:forEach>
					</div>

					<input type="hidden" id=sessionUserNo value="${userNo}">
					<!-- 댓글 -->
					<div id="reply"></div>
					<div class="form-group">
						<label>Comment</label> <input class="form-control"
							placeholder="Enter text" id="comment"> <input
							type="hidden" id="boardNo" value="${param.boardNo}">
						<button type="button" class="btn btn-default" onclick="addReply()">Comment</button>
					</div>

					<c:forEach items="${boardDetail}" var="boardDetail">
						<c:if test="${sessionScope.userNo==boardDetail.userNo}">
							<button type="submit" class="btn btn-outline btn-primary"com
								onclick="location.href='/editForm?boardNo=${param.boardNo}'">Edit</button>
							<button type="button" class="btn btn-outline btn-primary"
								onclick="location.href='/deleteArticle?boardNo=${param.boardNo}'">Delete</button>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
		<jsp:include page="/WEB-INF/tiles/layout/footer.jsp"></jsp:include>
		<script src="/resources/js/reply.js"></script>
		
<!-- 		<script>
			$(document).ready(function(){
				$("a[name='file']").on("click", function(e){
					e.preventDefault();
					downloadFile($(this));
				})
			})
		
			function downloadFile(obj){
				var fileNo = obj.parent().find("#fileNo").val();
				$.ajax({
					url:"/downloadFile",
					type:"POST",
					data:{"fileNo":fileNo},
					success:function(data){
						data;
					}
				})
			}
		</script> -->
</body>
</html>