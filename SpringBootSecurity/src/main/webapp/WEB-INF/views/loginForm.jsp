<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인</h1>
	<h2>
		<c:out value="${error}" />
	</h2>
	<h2>
		<c:out value="${logout}" />
	</h2>
	<form method="post" action="/login"> <!-- 1. 무조건 post 방식 -->
		<div>
			<input type="text" name="username" value=""> <!-- 2. username,password 네임명을 다르게 쓰면 절대안됨 -->
		</div>
		<div>
			<input type="password" name="password" value="">
		</div>
		<div>
			<input type="submit">
		</div>
		<sec:csrfInput /> <!-- 3. 무조건 적어야함 -->
	</form>
</body>
</html>