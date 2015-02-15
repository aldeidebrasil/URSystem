<%-- 
    Document   : seeCoursesProfessor
    Created on : Feb 8, 2015, 10:50:13 PM
    Author     : Leticia
--%>

<%@page import="controller.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    ArrayList<Course> listCourse;
%>
<%
    listCourse = (ArrayList<Course>) request.getAttribute("listCourse");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Courses</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body><table style="border: 2px black solid">
            <tr ><th>Course ID</th>
                <th>Course Name</th>
                <th>Department</th>
                <th>Prerequisite</th>
                <th>Value</th>
                <th>Term</th>
                <th>Status</th>
                <th>Professor ID</th>
                
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
                <%=listCourse.get(i).getDepartment()%>
            </td>
            <td>
                <% if(listCourse.get(i).getPrerequisite()==null){%>
                    None
                <% }else {%>
                      <%=listCourse.get(i).getPrerequisite()%>
                <%}%>
            </td>
            <td>           
                <%=listCourse.get(i).getValue()%>
            </td>
            <td>           
                <%=listCourse.get(i).getStatus()%>
            </td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="welcomeProfessor.jsp">Home</a>
         </div>
    </body>
</html>
