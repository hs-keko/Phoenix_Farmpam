<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/test_likes.jsp</title>
</head>
<body>
	<div>
		<h3>좋아요 추가</h3>
		<form action="${pageContext.request.contextPath}/board/saveLikes.do" method="post">
			<input type="text" name="board_idx" placeholder="좋아요 할 글 번호 입력" />
			<button type="submit">좋아요 추가</button>
		</form>
	</div>
	<div>
		<h3>좋아요 삭제</h3>
		<form action="${pageContext.request.contextPath}/board/removeLikes.do" method="post">
			<input type="text" name="board_idx" placeholder="좋아요 해제할 글 번호 입력" />
			<button type="submit">좋아요 삭제</button>
		</form>
	</div>
</body>
</html>