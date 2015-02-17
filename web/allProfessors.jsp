<%-- 
    Document   : ok
    Created on : Feb 3, 2015, 10:26:22 PM
    Author     : Aldeide Brasil
--%>

<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="controller.vo.Professor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    ArrayList<Professor> listProfessor;
%>
<%
    listProfessor = (ArrayList<Professor>) request.getAttribute("listProfessor");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body><table style="border: 2px black solid">
            <tr ><th>ID</th>
                <th>Title</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                
            </tr>
            <%
                for (int i = 0; i < listProfessor.size(); i++) {
            %>
            <tr>
            <td>
                <%=listProfessor.get(i).getID()%>
            </td>
            <td>    
                <%=listProfessor.get(i).getTitle()%>
            </td>
            <td>
                <%=listProfessor.get(i).getFname() %> 
            </td>
            <td>
                <%=listProfessor.get(i).getLname()%>
            </td>
            <td>           
                <%=listProfessor.get(i).getPassword()%>
            </td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="welcomeAdmin.jsp">Home</a>
        </body>
</html>
