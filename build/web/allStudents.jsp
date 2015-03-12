<%-- 
    Document   : ok
    Created on : Feb 3, 2015, 10:26:22 PM
    Author     : Aldeide Brasil
--%>

<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="controller.vo.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    ArrayList<Student> listStudents;
%>
<%
    listStudents = (ArrayList<Student>) request.getAttribute("listStudents");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        
        <div class="content">
        <table style="border: 2px black solid">
            <tr ><th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Major</th>
                <th>Billing</th> 
            </tr>
            <%
                for (int i = 0; i < listStudents.size(); i++) {
            %>
            <tr>
            <td>
                <%=listStudents.get(i).getID()%>
            </td>
            <td>
                <%=listStudents.get(i).getFname() %> 
            </td>
            <td>
                <%=listStudents.get(i).getLname()%>
            </td>
            <td>           
                <%=listStudents.get(i).getPassword()%>
            </td><td>    
                <%=listStudents.get(i).getMajor()%>
            </td>
            <td>
                <%=listStudents.get(i).getBilling()%>
            </td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="welcomeAdmin.jsp">Home</a>
        </div>
        </body>
</html>
