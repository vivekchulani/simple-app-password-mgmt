<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<br /><br />

<div id="login">
<h2><b><i>Choose Option</i></b></h2><br />
<table align="center" bordercolor="black" cellpadding="12">
<html:form action="Add" method="post">
<html:submit value="Add" property="method"></html:submit>
</html:form><br /><br /><br />
<html:form action="Retrieve" method="post">
<html:submit value="Retrieve" property="method"></html:submit>
</html:form>
</table>

<br /><br /><br />

</div>

</body>
</html>