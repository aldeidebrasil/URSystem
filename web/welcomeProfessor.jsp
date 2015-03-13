<%-- 
    Document   : welcomeProfessor
    Created on : Jan 28, 2015, 11:30:34 PM
    Author     : Aldeide Brasil
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="controller.vo.Student"%>
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
    ArrayList<Student> student = new ArrayList<Student>();
    Map<Course,ArrayList<Student>> mapStudent = (HashMap<Course, ArrayList<Student>>) request.getAttribute("mapStudent");;
       
%>    

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/professorStyle.css" type="text/css" rel="stylesheet"/>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" language="JavaScript" src="js/professorJS.js"></script>
        <title>Home - Professor</title>
 </head>
    <body>
        <div class="header"></div>
        <div class="content">
            <h2>Welcome, <%=professor.getTitle()%>&nbsp<%=professor.getLname()%>! </h2>
            <div class="profile">
                <img src="images/noPhoto.png" width="100px" height="100px" ><br>
                Name: <%=professor.getFname()%>&nbsp;<%=professor.getLname()%><br>
                Title: <%=professor.getTitle() %><br>
                <a href="/URSystem/servletweb?action=EditPasswordProfessor&IdProfessor=<%=professor.getID()%>">Change Password</a><br>
            </div>
            <div class="actions">
                <form name="frmSeeStudents" method='post'>
                <h2>Your Courses:</h2> 
                <p>Click in the options bellow to see information about the course.</p>
                <% for (int i=0; i< listCoursesTaught.size(); i++) {
                    if(listCoursesTaught.get(i).getStatus().equals("open")){%>  
                    <input type="checkbox" id="rd" name="rd" onclick="showHideDiv('all<%=i%>')" value="<%=listCoursesTaught.get(i).getID() %>"><%=listCoursesTaught.get(i).getID() %> - <%=listCoursesTaught.get(i).getName()%><br>
                    <div id="all<%=i%>" style="display: none;">
                        <table class="mapStudent"><tr><th>Students</th><th>Major</th></tr>
                        <% for (int j=0; j<mapStudent.size(); j++){ %>
                        <tr><td><%=mapStudent.get(listCoursesTaught.get(i)).get(j).getFname()%> <%=mapStudent.get(listCoursesTaught.get(i)).get(j).getLname()%> </td><td> <%=mapStudent.get(listCoursesTaught.get(i)).get(j).getMajor() %>  </td></tr>   
                        <%} %>
                        </table>
                    </div>
                <% }} %><br>
                </form>
            </div>
        </div>      
        <div class="footer">
        </div>
    </body>
</html>
