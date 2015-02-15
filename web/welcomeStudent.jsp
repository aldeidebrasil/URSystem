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
    ArrayList<Course> courseOpen =  (ArrayList<Course>) request.getAttribute("listCoursesOpen");
    ArrayList<Course> courseTaken = (ArrayList<Course>) request.getAttribute("listCourses");

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
            <form action="/URSystem/servletweb?action=AddCourseStudent" method='post'>
             <h2>Courses for your major:</h2> 
            <% for (int i=0; i< studentxcourse.size(); i++) {
            if(courseOpen.get(i).getStatus().equals("open")){%>
            <input type="radio" name="rd" value="<%=courseOpen.get(i).getID() %>"><%=courseOpen.get(i).getID() %> - <%=courseOpen.get(i).getName()%>><br>
            <% }} %><br>
            <button type="button">Add Course</button>
      
            </form>
            
           <h2>Courses you are registered for this semester</h2>
           
           <a href="addCourse.jsp">Add Course</a><br>
           <a href="deleteCourse.jsp">Drop Course</a><br><br>
        
            
           <!-- <h2>Courses you have taken: </h2>
            for (int i=0; i< studentxcourse.size(); i++) {%>
            studentxcourse.get(i).getIdCourse() %> - courseTaken.get(i).getName()%> - courseTaken.get(i).getTerm() %><br>
            <br>
            -->
        </div>
         </div>      
        <div class="footer"></div>
    </body>
</html>
