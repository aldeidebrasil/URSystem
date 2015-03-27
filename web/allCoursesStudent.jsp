<%-- 
    Document   : allCoursesStudent
    Created on : Mar 10, 2015, 5:53:41 PM
    Author     : Aldeide Brasil
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.StudentDAO"%>
<%@page import="controller.vo.Student"%>
<%@page import="controller.vo.Course"%>
<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Course> listCourse = (ArrayList<Course>) request.getAttribute("listCourse");
    Student student = StudentDAO.getById(Integer.parseInt(session.getAttribute("userid").toString()));
     DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm");
    Date date = new Date();
   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
            <div class="logout">
                <a href="/URSystem/servletweb?action=Logout">Logout</a>
            </div>
            <p>Today is <%=dateFormat.format(date)%></p>
            <h2>Welcome, <%=student.getFname()%>!</h2>
            <!--Show Information -->
            <div class="profile">
                <img src="images/noPhoto.png" width="150px" height="150px" ><br>
                <p><b><%=student.getFname()%>&nbsp;<%=student.getLname()%></b></p>
                <p><b>Major:</b> <%=student.getMajor()%></p>
                <a href="/URSystem/servletweb?action=EditPasswordStudent&IdStudent=<%=student.getID()%>">Change Password</a><br>
            </div>
     <div class="actions">
    
            <table style="border: 2px black solid">
            <tr ><th>ID</th>
                <th>Course</th>
                <th>Department</th>
                <th>Prerequisites</th>
                <th>Value</th>
                <th>Term</th>
                <th>Status</th>
                <th>Year</th>
                
                
            </tr>
            <%
                for (int i = 0; i < listCourse.size(); i++) {
            %>
            <tr>
            <td>
                <%=listCourse.get(i).getID()%>
            </td>
            <td>    
                <%=listCourse.get(i).getName()%>
            </td>
            <td>
                <%=listCourse.get(i).getDepartment() %> 
            </td>
            <td>
                <% if (listCourse.get(i).getPrerequisite()==null){ %>None <% }else{ %>
                    <%=listCourse.get(i).getPrerequisite()%>
                <% }%>
            </td>
            <td>           
                <%=listCourse.get(i).getValue()%>
            </td>
            <td>           
                <%=listCourse.get(i).getIdTerm()%>
            </td>
            <td>           
                <%=listCourse.get(i).getStatus()%>
            </td>
            <td>           
                <%=listCourse.get(i).getYear()%>
            </td>
            </tr>
            <%
                }
            %>
            </table></div><a href="/URSystem/servletweb?action=OpenStudent">Home</a></div>
        </body>
</html>
