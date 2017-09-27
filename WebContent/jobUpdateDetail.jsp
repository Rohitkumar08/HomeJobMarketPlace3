<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="header.jsp"></c:import>
<center>
<h3>JOB DETAILS</h3>
<html:form action = "/updateChoosenParameter"> 
<table border="2" width="400" style="background-color:salmon">
		<tr>
			<html:hidden property="id"/>
			<td>JOB TITLE</td>
			
			<td><html:text property="jobTitle"/><html:errors property="jobTitle"/></td>
			
			<%-- <td><input type="submit" name="inputed" value="update" onclick=" this.value += ' <c:out  value="jobTitle"/>'"></td> --%>
		</tr>
		<tr>
		
			<td>START DATE(yyyy-mm-dd hh:mm): </td>
		
			<td><html:text readonly="true" property="startDate"/><html:errors property="startDate"/></td>
			
		</tr>
		<tr>
		
			<td>END DATE(yyyy-mm-dd hh:mm): </td>
				<td><html:text property="endDate"/><html:errors property="endDateFormat"/></td>
			<%-- <td><c:out  value="${jobs.getEndDate()}"></c:out></td>
			 onclick="this.value += ' <c:out  value="endDate"/>'"
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updateEndDate.jsp'"></td> --%>
		</tr>
	
		
		<tr>
		
			<td>PAY PER HOUR</td>
			<%-- <c:out  value="${jobs.getPayPerHour()}"</c:out> --%>
			 	<td><html:text property="payPerHour"/><html:errors property="payPerHour"/></td>
	
		<tr>
		<td colspan="2" align="right">
		<input type="submit" name="update" value="update">
		</td>
		</tr>
	
</table>

</html:form> 
<a href="updateJob.do"><b>GO BACK.....</b></a>

</center>
</body>
</html>