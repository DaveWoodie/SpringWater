<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>First JSP</title>
		<spring:url value="/resources/css/main.css" var="mainCss" />
		<spring:url value="/resources/Bootstrap/js/boostrap.js" var="bsjs" />
		<spring:url value="/resources/Bootstrap/css/boostrap.css" var="bsjs" />
		<spring:url value="/resources/Bootstrap/js/boostrap.js" var="bsjs" />
	</head>
	<body>
	  <%
	    double num = Math.random();
	    if (num > 0.95) {
	  %>
	      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
	  <%
	    } else {
	  %>
	      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
	  <%
	    }
	  %>
	  <a href="/index.html"><h3>Try Again</h3></a>
	</body>
</html>