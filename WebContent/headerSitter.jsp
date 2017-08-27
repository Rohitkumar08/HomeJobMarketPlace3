<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>

</head>
<body>
<center>

<span style="float:left">
<a href="sitter.do"><img src="images/images.jpeg" /></a>

<html:form action="/SearchEmail">
<input type = "text" placeholder="Enter Seeker's email" name="searchEmail">
<input type="submit" value="search" name="searchButton"><html:errors property="error"/>
</html:form>
</span> 

<span style="float:right">
<a href="ViewProfileSitter.do" data-toggle="tooltip" title="Edit your profile"><button type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-user"></span> <c:out value="${sessionScope.uname}"/> 
        </button></a>
<a href="logout.do">Logout</a></b>

</span>
</center>
</body>
</html>