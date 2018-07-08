<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<br /><br />
<div id="login">
<h2 align='center'><b><i>Confirmation</i></b></h2>

<br /><br />
<h3><b><i>Your entry has been processed and saved.</i></b></h3>
<br />
<html:form action="ReturnHome" method="post">
<html:submit>Home</html:submit>
</html:form>
<br /><br />
<html:form action="SignOff" method="post">
<html:submit>Logout</html:submit>
</html:form>
<br /><br /><br />
</div>
</body>
</html>