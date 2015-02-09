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
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <link href="css/adminStyle.css" type="text/css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body>
    <div class="content">
        <div class="welcome">
        <p>Welcome, Admin!</p>
        </div>
        <div class="adminStudent">
        <h2>Student</h2>
        <a href="insertStudent.jsp">Insert Student</a><br>
        <a href="deleteStudent.jsp">Delete Student</a><br>
        <a href="deleteStudent.jsp">Edit Student</a><br>
        </div>     
        <div class="adminProfessor">
        <h2>Professor</h2>
        <a href="insertProfessor.jsp">Insert Professor</a><br>
        <a href="deleteProfessor.jsp">Delete Professor</a><br>
        <a href="deleteProfessor.jsp">Edit Professor</a><br>
        </div>
        <div class="adminCourse">
        <h2>Course</h2>
        <a href="insertCourse.jsp">Insert Course</a><br>
        <a href="deleteCourse.jsp">Delete Course</a><br>
        <a href="deleteCourse.jsp">Edit Course</a><br>
        </div>
    </div>
    </body>
</html>
