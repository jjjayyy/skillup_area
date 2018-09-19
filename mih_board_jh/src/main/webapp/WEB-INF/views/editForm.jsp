<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/tiles/layout/header.jsp"></jsp:include>
	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Edit an Article</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="form-group">
				<form action="/edit" method="post">
					<div class="col-lg-12">
						<div class="panel panel-info">
							<c:forEach items="${boardDetail}" var="boardDetail">
								<input type="text" class="form-control" name="boardTitle"
									value="${boardDetail.boardTitle}">
								<textarea class="form-control" rows="10" name="boardContent">${boardDetail.boardContent}
								</textarea>
								<input type="hidden" name="boardNo" value="${boardDetail.boardNo}">
							</c:forEach>
						</div>
					</div>
					<button type="submit" class="btn btn-outline btn-primary">Save</button>
				</form>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<jsp:include page="/WEB-INF/tiles/layout/footer.jsp"></jsp:include>
</body>
</html>