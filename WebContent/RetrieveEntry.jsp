<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<br /><br />

<div id="login">
<h2><i><b> Retrieve Entry </b></i> </h2>
<html:errors/>
<html:form action="RetrieveEntry" method="post">
<table align="center" bordercolor="black" cellpadding="4">
<tr><td><b>Category:</b></td><td><html:select property="Category">
<html:option value="">Select Category</html:option>
<html:option value="Finance">Finance</html:option>
<html:option value="Entertainment">Entertainment</html:option>
<html:option value="Social">Social</html:option>
<html:option value="Business">Business</html:option>
<html:option value="Educational">Educational</html:option>
</html:select>

</td></tr>
<tr><td></td><td><html:submit>Retrieve</html:submit></td></tr>
<br /><br />
</table>
</html:form>
<br /><br />
</div>
</body>
</html>