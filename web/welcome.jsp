<%-- 
    Document   : error
    Created on : Jan 25, 2015, 2:06:25 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%!
String fname = null;
Integer idStudent;
%>
<%
fname = (String) request.getAttribute("fname");
idStudent = (Integer) request.getAttribute("idStudent");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <title>URS</title>
    </head>
    <body>
        
        <div class="content">
        <h2>Welcome <%=fname%> </h2>
        <a href="/URSystem/servletweb?action=SeeCoursesStudent&IdStudent=<%=idStudent%>">See Courses</a><br>
        <a href="seeBilling.jsp">See Billing </a><br>
        <a href="/URSystem/servletweb?action=SeeInformationStudent&IdStudent=<%=idStudent%>">See Information</a><br>
        <a href="/URSystem/servletweb?action=EditPasswordStudent&IdStudent=<%=idStudent%>">Change Password</a><br>
        <a href="addCourse.jsp">Add Course</a><br>
        <a href="deleteCourse.jsp">Delete Course</a><br>
        </div>      
    </body>
</html>
