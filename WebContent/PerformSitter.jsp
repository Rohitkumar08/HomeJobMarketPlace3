<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="headerSitter.jsp"></c:import>
<center>
<table border="2" width="50%" style="background-color:salmon">
<tr><th>WELCOME YOU ARE A SITTER</th></tr>
<tr><td><a href="applyNewJob.do">Apply for a Job</a></td></tr>
<tr><td><a href="listOfJobs.do">See all jobs</a></td></tr>
<tr><td><a href="deleteJobApp.do">Delete a job Application</a></td></tr>
</table>
</center>
</body>
</html>