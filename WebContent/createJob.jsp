<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<title>Insert title here</title>
<style>
tr,td{
height:35px;

}
h2{
font:verdana
}

</style>
</head>
<body>

<c:import url="header.jsp"></c:import>
<center>
<html:form action="/CreateJob" method="POST">
<h2>CREATE A NEW JOB</h2>
<table border="0" width="00" height="100%" style="background-color: white">

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



</table>
<br>
<input type="submit" class="btn btn-success" value="submit" style="">
</html:form>


</center>
</body>
</html>