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
    ArrayList<Course> listCoursesTaught =  (ArrayList<Course>) request.getAttribute("listCoursesTaught");
    Map<Course,ArrayList<Student>> mapStudent = (HashMap<Course, ArrayList<Student>>) request.getAttribute("mapStudent");;
    String confirm = (String)request.getAttribute("ok");   
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
     <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
             <%@include file="profileProfessor.jsp"%>
             <div class="actions" style="height: 500px;">
                <form name="frmSeeStudents" method='post'>
                
                
                <% 
                    if(listCoursesTaught!= null){%>
                        <h2>Your Courses:</h2> 
                        <p>Click in the options bellow to see information about the course.</p>
                        <% for (int i=0; i< listCoursesTaught.size(); i++) {%>
                            <input type="checkbox" id="rd" name="rd" onclick="showHideDiv('all<%=i%>')" value="<%=listCoursesTaught.get(i).getID() %>"><%=listCoursesTaught.get(i).getID() %> - <%=listCoursesTaught.get(i).getName()%> - <%=listCoursesTaught.get(i).getStatus().toUpperCase() %><br>
                            <div id="all<%=i%>" style="display: none;">
                                <% if(mapStudent.get(listCoursesTaught.get(i))!=null){
                                if (!mapStudent.get(listCoursesTaught.get(i)).isEmpty()) {  %>
                                <table class="mapStudent"><tr><th>Students</th><th>Major</th></tr>
                                <%  for (int j=0; j<mapStudent.get(listCoursesTaught.get(i)).size(); j++){
                                        
                                            if(j%2==0){
                                %>
                                                <tr class="even">
                                            <% }else{ %>
                                                <tr class="odd">  
                                            <% } %>
                                                <td><%=mapStudent.get(listCoursesTaught.get(i)).get(j).getFname()%> <%=mapStudent.get(listCoursesTaught.get(i)).get(j).getLname()%> </td><td> <%=mapStudent.get(listCoursesTaught.get(i)).get(j).getMajor() %>  </td></tr>   
                                            <% } %>
                                </table>
                                       <% } else{ %>
                                        You do not have any student yet
                                        <% }} else{ %>
                                        You do not have any student yet
                                        <% } %>
                            </div>
                            <% } %>
                            <br>
                    <% }
                     else{%>
                                <h2>You are not registered to teach any course yet.</h2>
                            <%} %>
            </form>
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
