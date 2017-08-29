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

<c:import url="header.jsp"></c:import>
<center>
<html:form action="/CreateJob" method="POST">
<table border="2" width="50%" style="background-color:salmon">
<tr><th colspan="2">CREATE A NEW JOB</th></tr>

<tr><td>Job Title:</td><td> <input type = "text" name="jobTitle" placeholder="Enter Job-Title" required><html:errors property="jobTitle"/></td></tr>
<tr><td>Start Date: </td><td><input type = "date" name="startDate" required><html:errors property="startDate"/></td></tr>
<tr><td>End Date:</td><td><input type = "date" name="endDate" required><html:errors property="endDate"/></td></tr>
<tr><td>Start Time: </td><td><input type = "text" name="startTime" placeholder="hh:mm[24hour]" required></td></tr>
<tr><td>End Time:</td><td><input type = "text" name="endTime" placeholder="hh:mm[24hour]" required><html:errors property="endTime"/></td></tr>
<tr><td>Pay Per Hour:</td><td><input type = "number" name="payPerHour" placeholder="Enter pay per hour" required><html:errors property="payPerHour"/></td></tr>

<tr><td colspan="2" align="right" ><input type="submit" value="submit" style="font-size:7pt;"></td></tr>

</table>
</html:form>


</center>
</body>
</html>