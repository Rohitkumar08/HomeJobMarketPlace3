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
<table margin-left="50px" width="90%"  style="background-color:salmon" >

<tr><th align="center">JOB TITLE</th><th align="center">START DATE</th><th align="center">END DATE</th><th align="center">PAY PER HOUR</th>
	<c:forEach items="${jobs}" var ="job">
		<html:form action ="updateChoosenJob.do" method="POST">
		<tr>
			<input type="hidden" name="id" value="${job.getId()}"/>
			
			<td ><c:out  value="${job.getJobTitle()}"></c:out></td>
			<td ><c:out  value="${job.getStartDate()}"></c:out></td>
			<td ><c:out  value="${job.getEndDate()}"></c:out></td>
			<td><c:out  value="${job.getPayPerHour()}"></c:out></td>
			<%-- <td><input type="submit" name="inputed" value="update" onclick="this.value += ' <c:out  value="${job.getId()}"/>'"/></td> --%>
			<td><input type="submit"  value="update"></td>
		</tr>
		</html:form>
	</c:forEach>
</table>


<a href="seeker.do"><b>GO BACK.....</b></a>

</center>

</body>
</html>