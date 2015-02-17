<%-- 
    Document   : welcomeProfessor
    Created on : Jan 28, 2015, 11:30:34 PM
    Author     : Aldeide Brasil
--%>
<%@page import="controller.vo.Course"%>
<%@page import="controller.vo.ProfessorxCourse"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.vo.Professor"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    Professor professor = (Professor)request.getAttribute("professor");
    ArrayList<ProfessorxCourse> professorxcourse =  (ArrayList<ProfessorxCourse>) request.getAttribute("professorxcourse");
    ArrayList<Course> listCoursesTaught =  (ArrayList<Course>) request.getAttribute("listCoursesTaught");
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
        <h2>Welcome, <%=professor.getTitle()%>&nbsp<%=professor.getLname()%>! </h2>
        <div class="profile">
            <img src="images/noPhoto.png" width="100px" height="100px"><br>
            Name: <%=professor.getFname()%>&nbsp;<%=professor.getLname()%><br>
            Title: <%=professor.getTitle() %><br>
            <a href="/URSystem/servletweb?action=EditPasswordStudent&IdStudent=<%=professor.getID()%>">Change Password</a><br>
        
        </div>
        <div class="actions">
            <form action="/URSystem/servletweb?action=SeeStudents" method='post'>
             <h2>Courses Taught:</h2> 
             <% for (int i=0; i< listCoursesTaught.size(); i++) {
            if(listCoursesTaught.get(i).getStatus().equals("open")){%>
            <input type="radio" name="rd" value="<%=listCoursesTaught.get(i).getID() %>"><%=listCoursesTaught.get(i).getID() %> - <%=listCoursesTaught.get(i).getName()%><br>
            <% }} %><br>
            <button type="button">See your students</button>
       </form>
        </div>      
        <div class="footer">
        </div>
    </body>
</html>
