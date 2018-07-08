<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<br /><br />

<div id="login">
<h2><b><i>Password Retrieval</i></b></h2>
<html:errors/>
<html:form action="ForgetEnter" method="post">
<table align="center" bordercolor="black" cellpadding="8">
<tr><td><b>Enter last 4 digits of SSN:</b></td><td><html:text property="ssn"/></td></tr>
<br /><br />
<tr><td></td><td><html:submit>Enter</html:submit></td></tr>
</table>
</html:form>
<br /><br /><br />
</div>
</body>
</html>