<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="headerSitter.jsp"></c:import>
<center>
<html:form action="/deleteThisApp" method="POST">
<table border="2" style="background-color:salmon">
<h2>LIST OF ALL APPLIED JOBS</h2>
<tr><th>JOB TITLE</th><th>START DATE</th><th>END DATE</th><th>START TIME</th><th>END TIME</th><th>PAY PER HOUR</th></tr>

	<c:forEach items="${apps}" var ="job">

		<tr>
		
			<td><c:out value="${job.getJobs().getJobTitle()}"></c:out></td>
			<td><c:out value="${job.getJobs().getStartDate()}"></c:out></td>
			<td><c:out value="${job.getJobs().getEndDate()}"></c:out></td>
			<td><c:out value="${job.getJobs().getStartTime()}"></c:out></td>
			<td><c:out value="${job.getJobs().getEndTime()}"></c:out></td>
			<td><c:out value="${job.getJobs().getPayPerHour()}"></c:out></td>
			<td><input type="submit" name="inputed" value="delete" onclick="this.value += ' <c:out  value="${job.getJobs().getId()}"/>'"></td>
		</tr>
	
	</c:forEach>
</table>
</html:form>




</center>
</body>
</html>