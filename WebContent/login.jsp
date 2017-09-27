<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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



</style>
</head>
<body>
<center>
<h2>Login To MarketPlace Application</h2>
<hr>
<html:form action = "/login" method ="POST">
<table frame="box" border="0" width="00" >
<tr><th colspan="2"></th></tr>
<tr><td>Email:</td> <td><html:text property="email"/></td><html:errors property="emailError"/></tr>
<tr><td>Password:</td> <td><html:password property="password" /></td></tr>
<tr><td align="center" colspan="2"><input type="submit" class="btn btn-success" name="submit"></td></tr>


</table>


</html:form>
<br>

Haven't Registered yet?
<br>
<br><a href="register.jsp">REGISTER HERE</a>

</center>
</body>
</html>