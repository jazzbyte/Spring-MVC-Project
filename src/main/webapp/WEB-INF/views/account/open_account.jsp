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
		<h3>계좌신청</h3>
	</div>
	<div>
		<form:form method="post"  modelAttribute="account">
		<div class="form-unit">
			<label class="form-label">계좌종류</label>
			<div class="group-unit"> 
				<form:radiobuttons  
						items="${accountTypeList}" 
						itemLabel="accountName" 
						itemValue="accountType" 
						path="accountType"
						cssClass="form-label"/>
			</div>
		</div>
		<div class="form-unit">	
			<label class="form-label">초기 입금액</label>
			<form:input path="balance" class="form-control"/><br>
		</div>
		<div class="form-unit">	
			<label class="form-label">계좌 비밀번호</label>
			<form:password path="passwd" class="form-control"/><br>
		</div>
		<form:hidden path="customer.id" value="${userContainer.authUser.uid }"/>
		<button class="submit-btn" type="submit">계좌생성</button>
		</form:form>
	</div>
</main>
<!-- footer -->
<footer>
	<%@ include file="/WEB-INF/views/incl/footer.jsp" %>
</footer>
</body>
</html>