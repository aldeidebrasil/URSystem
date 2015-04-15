<%-- 
    Document   : seeStudents
    Created on : Feb 22, 2015, 10:50:02 PM
    Author     : Aldeide Brasil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="controller.vo.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    ArrayList<Student> student = new ArrayList<Student>();
    student =  (ArrayList<Student>)request.getAttribute("listStudents");
   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
         <table style="border: 2px black solid">
            <tr ><th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Major</th>
                
            </tr>
            <%
                for (int i = 0; i<student.size(); i++) {
            %>
            <tr>
            <td>
                <%=student.get(i).getID()%>
            </td>
            <td>
                <%=student.get(i).getFname() %> 
            </td>
            <td>
                <%=student.get(i).getLname()%>
            </td>
            <td>    
                <%=student.get(i).getMajor()%>
            </td>
            </tr>
            <% } %>
        </table>
        </div>
    </body>
</html>
