<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
    border: 1px solid black;
    cellpadding:15;
}
</style>
</head>
<body>

<c:import url="header.jsp"></c:import>

<center>

<h2>LIST OF ALL JOBS POSTED BY YOU</h2>
<table border="2" style="background-color:salmon" width="85%">

<tr><th>JOB TITLE</th><th>START DATE</th><th>END DATE</th><th>PAY PER HOUR</th></tr>
	<c:forEach items="${jobs}" var ="job">
		<html:form action ="deleteChoosenJob.do" method="POST" >
		<tr>
			<input type="hidden" name="id"  value="${job.getId()}"/>
			<td ><c:out  value="${job.getJobTitle()}"></c:out></td>
			<td ><c:out  value="${job.getStartDate()}"></c:out></td>
			<td ><c:out  value="${job.getEndDate()}"></c:out></td>
		
			<td ><c:out  value="${job.getPayPerHour()}"></c:out></td>
			<%-- <td><input type="submit" name="inputed" value="delete"  onclick="this.value += ' <c:out  value="${job.getId()}" />'"/></td> --%>
			<td><input type="submit" value="delete"></td>
		</tr>
		</html:form>
	</c:forEach>
</table>


<a href="seeker.do"><b>GO BACK.....</b></a>

</center>

</body>
</html>