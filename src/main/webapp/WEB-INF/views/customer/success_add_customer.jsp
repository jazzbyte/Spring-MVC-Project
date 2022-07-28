<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
</head>
<body>
<header class="p-3 mb-5 bg-header text-white">
	<jsp:include page="/WEB-INF/views/incl/header.jsp"/>
</header>

<!-- main -->
<main>
	<div class="title">
		<h3>duke bank에 가입되었습니다.</h3>
	</div>
	<div class="title">
		<h3>로그인</h3>
	</div>
	<div>
		<form method="post" action="<c:url value='/auth/login'/>">
		<div class="form-unit">
			<label class="form-label">이메일 : </label>
			<input type="text" name="email" class="form-control"/><br>
		</div>
		<div class="form-unit">	
			<label class="form-label">비밀번호 : </label>
			<input type="password" name="passwd" class="form-control"/><br>
		</div>
		<button class="submit-btn" type="submit">로그인</button>
		</form>
	</div>
</main>
<!-- footer -->
<footer>
	<%@ include file="/WEB-INF/views/incl/footer.jsp" %>
</footer>
</body>
</html>