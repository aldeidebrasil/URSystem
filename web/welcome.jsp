<%-- 
    Document   : error
    Created on : Jan 25, 2015, 2:06:25 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.Course"%>
<%@page import="controller.StudentxCourse"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Student"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    Student student = (Student)request.getAttribute("student");
    ArrayList<StudentxCourse> studentxcourse =  (ArrayList<StudentxCourse>) request.getAttribute("studentxcourse");
    ArrayList<Course> course =  (ArrayList<Course>) request.getAttribute("listCourses");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <title>URS</title>
    </head>
    <body>
        <div class="header"></div>
        <div class="content">
        <h2>Welcome <%=student.getFname()%> </h2>
        <div class="profile">
            <img src="images/noPhoto.png" width="100px" height="100px"><br>
            Name: <%=student.getFname()%>&nbsp;<%=student.getLname()%><br>
            Major: <%=student.getMajor()%><br>
            Billing Information: <%=student.getBilling()%><br>
             <a href="/URSystem/servletweb?action=EditPasswordStudent&IdStudent=<%=student.getID()%>">Change Password</a><br>
      
            </div>
        <div class="actions">
            <% for (int i=0; i< studentxcourse.size(); i++) {%>
            <%=studentxcourse.get(i).getIdCourse() %> - <%=course.get(i).getName()%> - <%=course.get(i).getTerm() %><br>
            <% } %><br>
           <a href="addCourse.jsp">Add Course</a><br>
           <a href="deleteCourse.jsp">Drop Course</a><br><br>
        </div>
         </div>      
        <div class="footer"></div>
    </body>
</html>
