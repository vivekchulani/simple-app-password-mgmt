<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LockedUp Login</title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body >
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<br /><br />
<div id="login">
<h2 align='center'><b><i>Login</i></b></h2>
<html:errors/>
<table align="center" bordercolor="black" cellpadding="15" >
<html:form action="LoginSubmit" method="post">
<tr><td><b>Username:</b></td><td><html:text property="username"/></td></tr>
<tr><td><b>Password:</b></td><td><html:password property="password"/></td></tr>
<tr><td><html:submit value="Login" property="method"/></td></tr>
</html:form>

<html:form action="RegisterSubmit" method="post">
<tr><td><html:submit value="Register" property="method"/></td></html:form>

<html:form action="ForgetSubmit" method="post">
<td><html:submit value="Retrieve" property="method"/></td></html:form>

</table>
<br /><br /><br />
</div>
		
</body>
</html>
