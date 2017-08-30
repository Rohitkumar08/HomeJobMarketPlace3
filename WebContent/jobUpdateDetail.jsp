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

<html:form action = "/updateChoosenParameter" method="POST"> 
<table border="2" style="background-color:salmon">

<tr><th colspan="2">CHOOSE THE PARAMETER WHICH YOU WANT TO EDIT</th></tr>

		<tr>
			<input type="hidden" name="jobId" value="${jobs.getId()}">
			<td>JOB TITLE <input type="hidden" name="oldJobTitle" value="${jobs.getJobTitle()}" ></td>
			<%-- <c:out  value="${jobs.getJobTitle()}"</c:out> --%>
			<td><html:text property="jobTitle" value="${jobs.getJobTitle()}"/><html:errors property="jobTitle"/></td>
			
			<%-- <td><input type="submit" name="inputed" value="update" onclick=" this.value += ' <c:out  value="jobTitle"/>'"></td> --%>
		</tr>
		<tr>
		
			<td>START DATE</td>
		
			<td><html:text property="startDate" value="${jobs.getStartDate()}"/><html:errors property="startDate"/></td>
			
		</tr>
		<tr>
		
			<td>END DATE</td>
				<td><html:text property="endDate" value="${jobs.getEndDate()}"/><html:errors property="endDate"/></td>
			<%-- <td><c:out  value="${jobs.getEndDate()}"></c:out></td>
			 onclick="this.value += ' <c:out  value="endDate"/>'"
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updateEndDate.jsp'"></td> --%>
		</tr>
	
	
		<tr>
		
			<td>START TIME</td>
			<td><html:text property="startTime" value="${jobs.getStartTime()}"/><html:errors property="startTime" /><html:errors property="startTimeFormat"/></td>
			
			<%-- <td><input type="submit" disabled="disabled" name="inputed" value="update" onclick="this.value += ' <c:out  value="startTime"/>'"></td> --%>
		</tr>
		
		<tr>
		
			<td>END TIME</td>
			<td><html:text property="endTime" value="${jobs.getEndTime()}"/><html:errors property="endTime"/><html:errors property="endTimeFormat"/></td>
			
			<%-- <td><input type="submit"disabled="disabled"  name="inputed" value="update" onclick="this.value += ' <c:out  value="endTime"/>'"></td> --%>
		</tr>
		
		<tr>
		
			<td>PAY PER HOUR</td>
			<%-- <c:out  value="${jobs.getPayPerHour()}"</c:out> --%>
			 	<td><html:text property="payPerHour" value="${jobs.getPayPerHour()}"/><html:errors property="payPerHour"/></td>
	
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