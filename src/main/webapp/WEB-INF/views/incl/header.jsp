<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="logo">
		<a href="<c:url value='/'/>">
			<i class="bank-icon fas fa-piggy-bank"></i> Duke Bank
		</a>
	</div>
	<div class="menu">
		<ul class="nav">
			<c:choose>
				<c:when test="${userContainer eq null}">
					<li><a href="<c:url value='/customer/add'/>" class="nav-link">회원가입</a></li>
					<li><a href="<c:url value='/auth/login'/>" class="nav-link">로그인</a></li>
					<li><a href="<c:url value='/customer/list'/>" class="nav-link">고객조회</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="<c:url value='/account/open'/>" class="nav-link">계좌신청</a></li>
					<li><a href="<c:url value='/account/mylist'/>" class="nav-link">계좌조회</a></li>
					<li><a href="<c:url value='/auth/logout'/>" class="nav-link">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<c:if test="${userContainer ne null}">
		<div class="cinfo">
			<span>${userContainer.authUser.name }</span>
		</div>
	</c:if>
	
	
	

