<%-- 
    Document   : welcomeAdmin
    Created on : Jan 28, 2015, 11:34:58 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <% 
    String confirm = (String)request.getAttribute("ok");
 %>   
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <link href="css/adminStyle.css" type="text/css" rel="stylesheet"/>
        <title>Home - Admin</title>
    </head>
    <body>
   <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
        <h2>Student</h2>
        <a href="/URSystem/servletweb?action=OpenPage&page=insertStudent">Insert Student</a><br>
        <a href="/URSystem/servletweb?action=OpenPage&page=deleteStudent">Edit or Delete Student</a><br>
        
        <h2>Professor</h2>
        <a href="/URSystem/servletweb?action=OpenPage&page=insertProfessor">Insert Professor</a><br>
        <a href="/URSystem/servletweb?action=OpenPage&page=deleteProfessor">Edit or Delete Professor</a><br>
      
        <h2>Course</h2>
        <a href="/URSystem/servletweb?action=OpenPage&page=insertCourse">Insert Course</a><br>
        <a href="/URSystem/servletweb?action=OpenPage&page=deleteCourse">Edit or Delete Course</a><br>
        </div>
 </div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
        <% if(confirm != null) { confirm = null;%>
            <script>alert("Password changed successfully");</script>
        <%} %>
    </body>
</html>
