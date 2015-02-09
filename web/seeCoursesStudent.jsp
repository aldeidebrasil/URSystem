<%-- 
    Document   : seeCoursesStudent
    Created on : Feb 9, 2015, 4:11:03 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.StudentxCourse"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    ArrayList<StudentxCourse> listCourse;
%>
<%
    listCourse = (ArrayList<StudentxCourse>) request.getAttribute("listCourse");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Courses</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="content">
        <table style="border: 2px black solid">
      
            <tr ><th>Course ID</th>
                <th>Student ID</th>
                
            </tr>
            <%
          
                if(listCourse.size()>=4){
                for (int i = 0; i < 4; i++) {
            %>
            <tr>
            <td>
                <%=listCourse.get(i).getIdCourse()%>
            </td>
            <td>    
                <%=listCourse.get(i).getIdStudent() %>
            </td>
            <%
                }}
            %>
        </table>
         </div>
    </body>
</html>
