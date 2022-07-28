<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	Calendar today = Calendar.getInstance();
	int year = today.get(Calendar.YEAR);
%>
<div>
	<span class="copy">&copy; 2001-<%=year %> I am a Java Developer.</span>
</div>