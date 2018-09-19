<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="com.mih.board.board.vo.CategoryVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
</head>
<body>

	<jsp:include page="/WEB-INF/tiles/layout/header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Write Form</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="form-group">
				<form action="/write" method="post" enctype="multipart/form-data">
					<label>Category</label> <select class="form-control"
						id="selectCategory" onchange="selectFunction()" name="ctNoMinor">
						<option selected disabled>---Select---</option>
						<c:forEach items="${ctMinorList}" var="ctMinorList">
							<option value="${ctMinorList.ctNoMinor}">${ctMinorList.ctNmMinor}</option>
						</c:forEach>
					</select> <br /> <label>Title</label> <input class="form-control"
						name="boardTitle"> <br /> <label>Contents</label>
					<textarea class="form-control" rows="10" name="boardContent"></textarea>
					<div class="form-group">
						<label>File</label> <input multiple="multiple" type="file"
							name="files" id="fileUpload" onchange="addFileInfo()">
						<div id="fileDrop"></div>

					</div>

					<button type="submit" class="btn btn-outline btn-primary">Write
						Post</button>
				</form>

			</div>

		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<jsp:include page="/WEB-INF/tiles/layout/footer.jsp"></jsp:include>
	<script src="/resources/js/file.js"></script>

</body>

</html>
