<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<style>
tr,td{
height:35px;

}
h2{
font:verdana
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<center>
	<h2>Register To HomeJobMarketPlace Application</h2>
	<hr>
		
		<html:form action="register.do"  method="POST">

			<table  frame="box" border="0" width="00" style="background-color: white">
				
				<tr>
					<td>First Name:</td>
					<td><html:text property="firstName"/>
							<html:errors property="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><html:text property="lastName"/>
					<html:errors property="lastName" /></td>
				</tr>
				<tr>
					<td>Mobile no:</td>
					<td><html:text property="phone"/>
					<html:errors property="phone" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><html:text property="email"/>
					<html:errors property="emailError" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><html:password property="password"/>
					<html:errors property="pwdError" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><html:text property="address"/></td>
				</tr>

				<tr>
					<td>Member type:</td>
					<td><input type="radio" name="memberType" id="frst"
						value="Seeker" checked/> Seeker
						 <input type="radio" name="memberType" id="sec" value="Sitter"/> Sitter</td>
				</tr>
				<c:set var="inputedType" value="${param.memberType}"></c:set>

				<input type="hidden" name="memberType" value="${inputedType}">


				<tbody id="div1">
					<tr>
						<td>No of Childs:</td>
						<td><html:text property="noOfChilds"
							/>
						<html:errors property="noOfChildError" /></td>
					</tr>
					<tr>
						<td>Spouse name:</td>
						<td><html:text property="spouseName"
							/>
						<html:errors property="spouseName" /></td>
					</tr>
				</tbody>

				<tbody id="div2">
					<tr>
						<td>Expected pay:</td>
						<td><html:text property="expectedPay"
							/>
						<html:errors property="expectedPay" /></td>
					</tr>
					<tr>
						<td>Years Of experience:</td>
						<td><html:text property="yearsOfExperience"
							/>
						<html:errors property="yearsOfExperience" /></td>
					</tr>
				</tbody>

			</table>
			<br>
			<%-- <html:submit value="submit" class="btn btn-success"></html:submit> --%>
			<input type="submit" value="submit" class="btn btn-success"/>
		</html:form>
		<h2>Already a member?
		</h2>
		<a href="login.jsp"><b>Log In</b></a>
	</center>
	<script type="text/javascript" src="file.js"></script>
</body>

</html>