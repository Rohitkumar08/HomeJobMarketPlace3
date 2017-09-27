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

<c:import url="headerSitter.jsp"></c:import>
<center>

<html:form action = "UpdateChoosenParameterSitter.do" method="POST"> 
<table border="0" width="00">

<tr><th colspan="2">USER'S PROFILE DETAILS</th></tr>

		<tr>
		
			<td>FirstName:</td>
			
			<td><html:text  property="firstName" /><html:errors property="firstName" /></td>
			
		
		</tr>
		<tr>
		
			<td>LastName: </td>
			
			<td><html:text  property="lastName"/><html:errors property="lastName" /></td>
			
		
		</tr>
		<tr>
		
			<td>Phone No: </td>
			<%-- <c:out  value="${jobs.getStartDate()}"</c:out> --%>
			<td><html:text property="phone"/><html:errors property="phone" /></td>
			
		</tr>
		<tr>
		
			<td>Email: </td>
				<td><html:text readonly="true" property="email"/></td>
		
		</tr>
	
		<tr>
		
			<td>Years of experience: </td>
			<td><html:text property="yearsOfExperience"/><html:errors property="yearsOfExperience" /></td>
			
		
		</tr>
		
		<tr>
		
			<td>Expected pay: </td>
			
			 	<td><html:text property="expectedPay"/><html:errors property="expectedPay" /></td>
				
		</tr>
		
		<tr>
		<td colspan="2" align="right">
		<input type="submit" name="edit" value="update">
		</td>
		</tr>
	
</table>

</html:form> 

<html:form action="/deleteSitter" method="Post" onsubmit="return confirm('Do you really want to Delete your Sitter profile?');">
    <input type="submit" value="Delete Profile">
</html:form>

</center>
</body>
</html>