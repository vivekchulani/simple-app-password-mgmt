<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieval</title>
<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>
<div id="header">
<h1><b>LOCKUP</b></h1>
</div>
<br /><br />
<div id="login">
<h2 align='center'><b><i>Your information:</i></b></h2>


		<table align="center" border="1" cellpadding="5">
			<TR>
				<TH>Title</TH>
				<TH> URL </TH>
				<TH> Username </TH>
				<TH> Password </TH>
			</TR>

<c:forEach items="${List}" var="a">
				<tr>
					<td><c:out value="${a.title }" /></td>
					<td><html:link href="${a.url }" target="_blank" > ${a.url } </html:link></td>		
					<td><c:out value="${a.username }" /></td>
					<td><c:out value="${a.password }" /></td>
					</tr>
					</c:forEach>

</table>
<br /><br />

<html:form action="ReturnHome" method="post">
<html:submit>Home</html:submit>
</html:form>
<br /><br />
<html:form action="SignOff" method="post">
<html:submit>Logout</html:submit>
</html:form>
<br /><br />

</div>
</body>
</html>