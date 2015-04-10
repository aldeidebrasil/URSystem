<%-- 
    Document   : errorAdmin
    Created on : Apr 9, 2015, 6:04:39 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
String error = "";
%>
<%
error = (String)request.getAttribute("error");
%>
<html> <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp"%>
     <div class="actions2">
             <h2><%=error%></h2>
        </div>
        </div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
     </body>
</html>
