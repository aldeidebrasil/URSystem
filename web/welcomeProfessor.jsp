<%-- 
    Document   : welcomeProfessor
    Created on : Jan 28, 2015, 11:30:34 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%!
String lname = null;
%>
<%
lname = (String) request.getAttribute("lname");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <title>URS</title>
    </head>
    <body>
        
        <div class="content">
        <h2>Welcome, <%=lname%> !</h2>
        <a href="seeCoursesProfessor.jsp">See Courses</a><br>
        <a href="seeStudents.jsp">See students</a><br>
        <a href="changePasswordProfessor.jsp">Change Password</a><br>
        </div>      
    </body>
</html>
