<%-- 
    Document   : error
    Created on : Jan 25, 2015, 2:06:25 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%!
String error = "";
%>
<%
error = (String)request.getAttribute("error");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>URSystemn</title>
    </head>
    <body>
        <h2><%=error%></h2>
    </body>
</html>
