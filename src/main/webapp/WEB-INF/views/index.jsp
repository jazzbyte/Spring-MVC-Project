<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5/css/all.min.css">
</head>
<body>
<header class="p-3 mb-5 bg-header text-white">
	<jsp:include page="/WEB-INF/views/incl/header.jsp"/>
</header>
<!-- main -->
<main>
<c:choose>
	<c:when test="${userContainer eq null}">
		<div class="title">
			<h3>Welcome to duke bank</h3>
		</div>
	</c:when>
	<c:otherwise>
	<div>
		<div class="title">
			<h3>계좌목록</h3>
		</div>
		<c:forEach var="account" items="${userContainer.accountList }">
			<div class="catalog3-div">
				<span style="font-size: 1rem; font-weight: bold;">${account.accountNum }</span><br>
				<span style="font-size: 0.8rem; font-weight: bold;">
					<c:set var="s" value="SavingsAccount"/>
					<c:set var="c" value="CheckingAccount"/>
					${fn:contains(account.accountType, 'S') ? "SavingsAccount" : "CheckingAccount"}
				</span><br><br>
				<span style="font-size: 2rem;"><fmt:formatNumber value="${account.balance}" pattern="#,###" /></span>
				<span style="font-size: 0.8rem; font-weight: bold">원</span><br><br>
				<span style="font-size: 0.8rem; color: #002060; font-weight: bold">
					<a href="<c:url value='/account/transfer'/>?accountNum=${account.accountNum }">이체하기</a>
				</span>
			</div>
		</c:forEach>
	</div>
	</c:otherwise>
</c:choose>	
</main>
<!-- footer -->
<footer>
	<%@ include file="/WEB-INF/views/incl/footer.jsp" %>
</footer>

</body>
</html>