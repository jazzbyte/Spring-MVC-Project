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
		<h3>신규 계좌가생성되었습니다.</h3>
	</div>
	<div>
		계좌번호 : ${account.accountNum }
		
	</div>
</main>
<!-- footer -->
<footer>
	<%@ include file="/WEB-INF/views/incl/footer.jsp" %>
</footer>
</body>
</html>