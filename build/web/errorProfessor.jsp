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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileProfessor.jsp"%>
     <div class="actions2">
            <% if(error != null){ %>
             <h2><%=error%></h2>
             <% } else { %>
                OH! Something went wrong!
             <% } %>
        </div>
        </div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
     </body>
</html>
