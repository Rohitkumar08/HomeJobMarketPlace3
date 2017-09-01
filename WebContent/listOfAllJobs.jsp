<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<c:import url="headerSitter.jsp"></c:import>
<center>
<h3>LIST OF ALL JOBS</h3>
<table border="2" style="background-color:salmon" cellpadding="10" cellspacing="5px">

<tr><th>JOB TITLE</th><th>START DATE</th><th>END DATE</th><th>START TIME</th><th>END TIME</th><th>PAY PER HOUR</th></tr>

	<c:forEach items="${jobs}" var ="job">

		<tr>
		
			<td > <c:out value="${job.getJobTitle()}"></c:out></td>
			<td><c:out value="${job.getStartDate()}"></c:out></td>
			<td><c:out value="${job.getEndDate()}"></c:out></td>
			<td><c:out value="${job.getStartTime()}"></c:out></td>
			<td><c:out value="${job.getEndTime()}"></c:out></td>
			<td><c:out value="${job.getPayPerHour()}"></c:out></td>
			
		</tr>
	
	</c:forEach>
</table>




</center>
</body>
</html>