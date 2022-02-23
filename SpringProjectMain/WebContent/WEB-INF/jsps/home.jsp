<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HOME </h1>

<!--  Read the attribute -->

<%
String msgVal = (String) request.getAttribute("msg_model");
out.println(msgVal);
%>
<HR>

<%
String msgVal1 = (String) request.getAttribute("msg_request");
out.println(msgVal1);
%>
<HR>

<%
String msgVal2 = (String) request.getAttribute("msg_mav");
out.println(msgVal2);
%>

</body>
</html>