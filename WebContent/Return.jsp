<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Return Password </title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<br /><br />

<div id="login">
<h2><b><i>Password Retrieval</i></b></h2>

<table align="center" bordercolor="black" cellpadding="8">
<tr><td><b>Your password is: </b></td><td> <c:out value="${sessionScope.password }"></c:out></td></tr>
<br /><br />

<html:form action="OkEnter" method="post">
<tr><td></td><td><html:submit>OK</html:submit></td></tr>
</table>
</html:form>
<br /><br /><br />
</div>
</body>
</html>