<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<div id="login">
<h2><b><i>New User Registration</i></b></h2>
<html:errors/>

<html:form action="Register">

<table align="center" bordercolor="black" cellpadding="3">

<tr><td><b>First Name:</b></td><td><html:text property="fname" /></td></tr>
<tr><td><b>Last Name:</b></td><td><html:text property="lname" /></td></tr>
<tr><td><b>Username:</b></td><td><html:text property="username" /></td></tr>
<tr><td><b>Password:</b></td><td><html:password property="password" /></td></tr>
<tr><td><b>Email:</b></td><td><html:text property="mail" /></td></tr>
<tr><td><b>Last 4 digits of SSN:</b></td><td><html:text property="ssn" /></td></tr>
<tr><td></td><td><html:submit>Register</html:submit></td></tr>

</table>

</html:form>
<br /><br /><br />
</div>

</body>
</html>