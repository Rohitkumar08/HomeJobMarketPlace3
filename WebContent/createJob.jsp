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
<h2>CREATE A NEW JOB</h2>
<table border="1" width="80%" height="90%" style="background-color: salmon">

<tr><td>Job Title :</td><td> <html:text property="jobTitle" /><html:errors property="jobTitle"/></td></tr>
<tr><td>Start Date(yyyy-mm-dd) : </td><td><html:text property="startDate" /><html:errors property="startDateFormat"/><html:errors property="startDate"/>


</td></tr>
<tr><td>End Date:(yyyy-mm-dd) :</td><td><html:text property="endDate" /><html:errors property="endDate"/><html:errors property="endDateFormat"/></td></tr>
<tr><td>Start Time:(hhmm) : </td><td><html:text property="startTime" />

<html:errors property="startTimeFormat"/>

</td></tr>
<tr><td>End Time:(hhmm) :</td><td><html:text property="endTime"/><html:errors property="endTime"/>
<html:errors property="endTimeFormat"/>

</td></tr>
<tr><td>Pay Per Hour:</td><td><html:text property="payPerHour" /><html:errors property="payPerHour"/></td></tr>

<tr><td colspan="2" align="right" ><input type="submit" value="submit" style="font-size:7pt;"></td></tr>

</table>
</html:form>


</center>
</body>
</html>