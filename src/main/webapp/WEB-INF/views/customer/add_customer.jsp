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
<!-- <script>
$(function() {
   $('#registerBtn').click(function() {
      const $form = $('#customer');
      $('[name=ssn]').val([$('#ssn1').val(), $('#ssn2').val()].join('-'));
      $('[name=email]').val([$('#email1').val(), $('#email2').val()].join('@'));
      $('[name=phone]').val([$('#phone1').val(), $('#phone2').val(), $('#phone2').val()].join('-'));
      $form.submit();
   })
})
</script> -->

</head>
<body>
<header class="p-3 mb-5 bg-header text-white">
	<jsp:include page="/WEB-INF/views/incl/header.jsp"/>
</header>

<!-- main -->
<main>
	<div class="title">
		<h3>회원가입</h3>
	</div>
	<div>
		<form:form method="post"  modelAttribute="customer">
		<div class="form-unit">
			<label class="form-label">이메일 : </label>
			<div class="group-unit"> 
				<form:input path="email1" size="6" class="form-control"/> @
				<form:select path="email2"  class="form-control">
					<option value="unknown">-- 선택 --</option>
					<form:options  items="${emailProviderList}" itemValue="emailHost" itemLabel="emailCode" />
				</form:select>
			</div>
		</div>
		<div class="form-unit">	
			<label class="form-label">비밀번호 : </label>
			<form:password path="passwd"  class="form-control"/><br>
		</div>
		<div class="form-unit">	
			<label class="form-label">이름 : </label>
			<form:input path="name" class="form-control"/><br>
		</div>
		<div class="form-unit">
			<label class="form-label">주민번호 : </label>
			<div class="group-unit"> 
				<form:input path="ssn1" size="6" maxlength="6" class="form-control sevenPx" /> -
				<form:input path="ssn2" size="7" maxlength="7" class="form-control"/>
			</div>
		</div>
		<div class="form-unit">	
			<label class="form-label">연락처 : </label>
			<div class="group-unit"> 
				<form:select path="phone1" class="form-control">
					<option value="unknown">-- 선택 --</option>
					<form:options items="${phoneProviderList}"/>
				</form:select> -
				<form:input path="phone2" size="4" maxlength="4" class="form-control"/> -
				<form:input path="phone3" size="4" maxlength="4" class="form-control"/>
			</div>
		</div>	
		<button id="registerBtn" class="submit-btn" type="submit">회원가입</button>
		</form:form>
	</div>
</main>
<!-- footer -->
<footer>
	<%@ include file="/WEB-INF/views/incl/footer.jsp" %>
</footer>
</body>
<script>
   const form = document.getElementById('customer');
   const submitBtn = document.getElementById('registerBtn');
   submitBtn.addEventListener('click', function() {
      const ssn = form.querySelector('[name=ssn]'), 
      		email = form.querySelector('[name=email]'), 
      		phone = form.querySelector('[name=phone]');
      ssn.value = `${document.getElementById('ssn1').value}-${document.getElementById('ssn2').value}`;
      email.value = `${document.getElementById('email1').value}@${document.getElementById('email2').value}`;
      phone.value = `${document.getElementById('phone1').value}-${document.getElementById('phone2').value}-${document.getElementById('phone3').value}`;
      form.submit();
   });
</script>
</html>