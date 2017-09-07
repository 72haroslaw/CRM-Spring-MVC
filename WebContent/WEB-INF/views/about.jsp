<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM System information</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/app.css">
</head>
<body>
	<ul>
			<li><a href="${pageContext.request.contextPath}/service">Students list</a></li>
			<li><a href="${pageContext.request.contextPath}/newStudent">Register new student</a></li>
			<li><a class="active" href="${pageContext.request.contextPath}/about">About</a></li>
			<c:url value="/logout" var="logoutUrl" />
			<li style="float:right"><form id="logout" action="${logoutUrl}" method="post" >
			  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
				<a href="javascript:document.getElementById('logout').submit()">Logout</a>
				</c:if>
			</li>
		</ul>
	<div align="center">
		<h3>Author: Rafal Zdzieborski</h3>
	</div>	
</body>
</html>