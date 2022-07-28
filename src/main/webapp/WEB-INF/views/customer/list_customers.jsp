<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h3>회원목록</h3>
	</div>
	<div>
		<table>
			<tr>
				<th>번호</th>
				<th>Id</th>
				<th>e-mail</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>주민번호</th>
				<th>연락처</th>
				<th>등록일</th>
			</tr>
			<c:forEach var="customer" items="${customerList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${customer.cid }</td>
					<td>${customer.email }</td>
					<td>${customer.passwd }</td>
					<td>${customer.name }</td>
					<td>${customer.ssn }</td>
					<td>${customer.phone }</td>
					<td><fmt:formatDate value="${customer.regDate }" pattern="yyyy년 MM월 dd일" /></td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</main>
<!-- footer -->
<footer>
	<%@ include file="/WEB-INF/views/incl/footer.jsp" %>
</footer>
</body>
</html>