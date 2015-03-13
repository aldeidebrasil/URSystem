<%-- 
    Document   : allCoursesStudent
    Created on : Mar 10, 2015, 5:53:41 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Course"%>
<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
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
        <title>All Course</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body><table style="border: 2px black solid">
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
                <%=listCourse.get(i).getPrerequisite()%>
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
        </table>
        </body>
</html>
