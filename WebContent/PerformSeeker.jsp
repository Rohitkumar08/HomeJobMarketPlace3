<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp"></c:import>

<center>
<table border="2" width="50%" style="background-color:salmon">

<tr><th align="center">WELCOME AS A SEEKER</th></tr>
<tr><td><a href="createJob.do">Create a new Job</a></td></tr>
<tr><td><a href="updateJob.do">Update a Job</a></td></tr>
<tr><td><a href="deleteJob.do">Delete a job</a></td></tr>
<tr><td><a href="applicantsJob.do">View all jobs</a></td></tr>
</table>
<br>
<br>
<table border="1" width="25%" style="background-color:Bisque ">
<th>Recent Activities</th>
	<c:forEach items="${activity}" var ="activity">
		<tr>
			<td><c:out  value="${activity.getMessage()}"></c:out></td>
		</tr>
	</c:forEach>
</table>
</center>
</body>
</html>