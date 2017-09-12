<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students list</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/service.css">
        
    </head>
    <body>
    <ul>
		<li><a class="active" href="${pageContext.request.contextPath}/service">Students list</a></li>
		<li><a href="${pageContext.request.contextPath}/newStudent">Register new student</a></li>
		<li><a href="${pageContext.request.contextPath}/about">About</a></li>
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
            <h1>Students List</h1>
            <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
                <th>Telephone</th>
                <th>Comment</th>
                <th>Action</th>
            </tr>
                <c:forEach var="student" items="${studentList}" varStatus="status">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.address}</td>
                    <td>${student.email}</td>
                    <td>${student.telephone}</td>
                 	<td>${student.comment}</td>
                    <td><a href="updateStudent/${student.id}">Edit</a>
                        <a href="deleteStudent/${student.id}">Delete</a></td>              
                </tr>
                </c:forEach>             
            </table>
            <a href="truncateDatabase">Delete database - only for user with admin permissions</a>
        </div>
    </body>
</html>