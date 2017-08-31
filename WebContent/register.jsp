<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<center>

		<html:form action="register.do" method="POST">

			<table border="0" width="500" style="background-color: white">
				<tr>
					<th colspan="2">Registration form:</th>
				</tr>
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
					<td>password:</td>
					<td><html:text property="password"/>
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
						<td>Years OF experience:</td>
						<td><html:text property="yearsOfExperience"
							/>
						<html:errors property="yearsOfExperience" /></td>
					</tr>
				</tbody>

				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="submit" style="font-size: 7pt;"></td>
				</tr>
			</table>
		</html:form>
		<h2>OR</h2>
		<a href="login.jsp"><b>Log In</b></a>
	</center>
	<script type="text/javascript" src="file.js"></script>
</body>

</html>