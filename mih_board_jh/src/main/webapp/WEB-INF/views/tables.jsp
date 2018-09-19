<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="com.mih.board.board.vo.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
</head>
<body>
	<jsp:include page="/WEB-INF/tiles/layout/header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Board</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Category Name</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Title</th>
										<th>Writer</th>
										<th>Date</th>
										<th>Hits</th>
									</tr>
								</thead>
								<tbody class="boardList">
									<c:forEach items="${boardList}" var="boardList">
										<tr class="gradeA">
											<td><a href=boardDetail?boardNo=${boardList.boardNo}>${boardList.boardTitle}</td>
											<td>${boardList.userNm}</td>
											<td>${boardList.boardDate}</td>
											<td>${boardList.boardViewCount}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div>
								<button type="button" class="btn btn-outline btn-primary"
									onclick="location.href='/writeForm'">Write</button>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>

					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>

		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<jsp:include page="/WEB-INF/tiles/layout/footer.jsp"></jsp:include>
</body>

</html>
