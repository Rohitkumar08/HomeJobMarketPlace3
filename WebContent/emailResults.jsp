<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="headerSitter.jsp"></c:import>

<center>
<h2>LIST OF ALL EMAILS</h2>
<table border="2" style="background-color:salmon">

<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone no</th></tr>


	<c:forEach items="${member}" var ="member">

		<tr>
			<td><c:out  value="${member.getFirstName()}"></c:out></td>
			<td><c:out  value="${member.getLastName()}"></c:out></td>
			<td><c:out  value="${member.getEmail()}"></c:out></td>
			<td><c:out  value="${member.getPhone()}"></c:out></td>
		</tr>
	
	</c:forEach>
</table>
<br>
<a href="sitter.do">GO BACK..</a>
</center>
</body>
</html>