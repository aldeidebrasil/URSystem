<%-- 
    Document   : welcomeAdmin
    Created on : Jan 28, 2015, 11:34:58 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome, Admin!</h1>
        <a href="insertStudent.jsp">Insert Student</a><br>
        <a href="deleteStudent.jsp">Delete Student</a><br>
        <a href="deleteStudent.jsp">Edit Student</a><br>
        <a href="http://localhost:8080/URSystem/servletweb?action=InsertProfessor">Insert Professor</a><br>
        <a href="http://localhost:8080/URSystem/servletweb?action=EditProfessor">Edit Professor</a><br>
        <a href="http://localhost:8080/URSystem/servletweb?action=EditCourse">Edit Course</a><br>
        <a href="http://localhost:8080/URSystem/servletweb?action=InsertCourse">Insert Course</a><br>
    </body>
</html>
