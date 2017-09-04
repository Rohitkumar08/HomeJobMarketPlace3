<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<html:form action = "/login" method ="POST">
<table border="2" width="50%" style="background-color:salmon">
<tr><th colspan="2">LOG IN</th></tr>
<tr><td>Enter Email:</td> <td><html:text property="email"/></td></tr>
<tr><td>Password:</td> <td><html:password property="password" /></td></tr>
<tr><td align="center" colspan="2"><input type="submit" name="submit"></td></tr>


</table>


</html:form>
OR
<br><a href="register.jsp">REGISTER HERE</a>

</center>
</body>
</html>