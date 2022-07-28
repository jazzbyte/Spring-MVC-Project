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
<script type="text/javascript">
$(function() {
   // [받는 계좌번호를 변경하면 계좌주 확인]--------------------------------------------
   $('select[name=toAccountNum]').change(function() {
      const select = this;
      $.getJSON('/jvx331/account/receiver/check/' + select.value)
      .always(function(xhr) {
         if(xhr.status == 200) {
            const receiver = xhr.responseText;
            // 소유주 확인되면 '받는 사람'에 입력
            $('[name=receiver]').val(receiver);
         }else if(xhr.status >= 400) {
            // 소유주 확인 실패시 계좌번호 선택 초기화
            alert('계좌 소유주를 확인할 수 없습니다.');
            select.firstElementChild.selected = true;
         }
      })
   })
})
</script>
</head>
<body>
<header class="p-3 mb-5 bg-header text-white">
	<jsp:include page="/WEB-INF/views/incl/header.jsp"/>
</header>

<!-- main -->
<main>
	<div class="title">
		<h3>계좌이체</h3>
	</div>
	<div>
		<form method="post">
		<div class="form-unit">	
			<label class="form-label">출금계좌</label>
			<input type="text" name="fromAccountNum" value="${from.accountNum }" readonly="readonly" class="form-control"/><br>
		</div>
		<div class="form-unit">	
			<label class="form-label">출금액</label>
			<input type="text" name="amount" class="form-control"/><br>
		</div>
		<div class="form-unit">	
			<label class="form-label">받는 계좌번호</label>
			<select name="toAccountNum" class="form-control">
				<option selected disabled>---선택---</option>
				<c:forEach var="account" items="${toList}">
					<option value="${account.accountNum }">${account.accountNum }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-unit">	
			<label class="form-label">받는사람</label>
			<input type="text" name="receiver" class="form-control"/><br>
		</div>
		<div class="form-unit">	
			<label class="form-label">계좌 비밀번호</label>
			<input type="password" name="passwd" class="form-control"/><br>
		</div>
		<button class="submit-btn" type="submit">이체하기</button>
		</form>
	</div>
</main>
<!-- footer -->
<footer>
	<%@ include file="/WEB-INF/views/incl/footer.jsp" %>
</footer>
</body>
</html>