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
<%-- <% 

	if(session.getAttribute("uname")==null)
		response.sendRedirect("error.jsp");



%> --%>

<c:import url="header.jsp"></c:import>
<center>

<html:form action = "/updateChoosenParameterSeeker" method="POST" onsubmit="return confirm('Do you really want to Delete your Seeker profile?');"> 
<table border="2" style="background-color:salmon">

<tr><th colspan="2">CHOOSE THE PARAMETER WHICH YOU WANT TO EDIT</th></tr>

		<tr>
		
			<td>FirstName <input type="hidden" name="oldFirstName" value="${Seeker.getFirstName()}" ></td>
			<%-- <c:out  value="${jobs.getJobTitle()}"</c:out> --%>
			<td><input type="text" name="firstName" value="${seeker.getFirstName()}"></td>
			
			<%-- <td><input type="submit" name="inputed" value="update" onclick=" this.value += ' <c:out  value="jobTitle"/>'"></td> --%>
		</tr>
		<tr>
		
			<td>Phone No</td>
			<%-- <c:out  value="${jobs.getStartDate()}"</c:out> --%>
			<td><input type="text" name="phone" value="${seeker.getPhone()}"></td>
			<%-- this.value += ' <c:out  value="startDate"/>' --%>
			<!-- <td><input type="submit" name="inputed" value="update" onclick="window.location='updateStartDate.jsp'"></td> -->
		</tr>
		<tr>
		
			<td>Email</td>
				<td><input type="text" read-only="true" name="email" value="${seeker.getEmail()}"></td>
			<%-- <td><c:out  value="${jobs.getEndDate()}"></c:out></td>
			 onclick="this.value += ' <c:out  value="endDate"/>'"
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updateEndDate.jsp'"></td> --%>
		</tr>
	
	
		<%-- <tr>
		
			<td>Password</td>
			<td><input type="text" ReadOnly="true" name="password" value="${seeker.getPassword()}"></td>
			
			<td><input type="submit" disabled="disabled" name="inputed" value="update" onclick="this.value += ' <c:out  value="startTime"/>'"></td>
		</tr> --%>
		<%-- 	<tr>
		
			<td>Address</td>
			<td><input type="text" ReadOnly="true" name="password" value="${seeker.getAdd()}"></td>
			
			<td><input type="submit" disabled="disabled" name="inputed" value="update" onclick="this.value += ' <c:out  value="startTime"/>'"></td>
		</tr> --%>
		
		
		<tr>
		
			<td>No Of Child</td>
			<td><input type="text" name="noOfChilds" value="${seeker.getNoOfChilds()}"></td>
			
			<%-- <td><input type="submit"disabled="disabled"  name="inputed" value="update" onclick="this.value += ' <c:out  value="endTime"/>'"></td> --%>
		</tr>
		
		<tr>
		
			<td>Spouse name</td>
			<%-- <c:out  value="${jobs.getPayPerHour()}"</c:out> --%>
			 	<td><input type="text" name="spouseName" value="${seeker.getSpouseName()}"/></td>
		<%--	<td><c:out  value="${jobs.getPayPerHour()}"></c:out></td>
			this.value += ' <c:out  value="payPerHour"/>'
			<td><input type="submit" name="inputed" value="update" onclick="window.location='updatePayPerHour.jsp'"></td> --%>
		</tr>
		
		<tr>
		<td colspan="2" align="right">
		<input type="submit" name="edit" value="update">
		</td>
		</tr>
	
</table>

</html:form> 

<html:form action="/deleteSeeker" method="Post">
    <input type="submit" value="Delete Profile">
</html:form>
</center>
</body>
</html>