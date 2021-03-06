<%-- 
    Document   : allStudents
    Created on : Feb 3, 2015, 10:26:22 PM
    Author     : Aldeide Brasil
--%>

<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="controller.vo.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Student> listStudents = (ArrayList<Student>) request.getAttribute("listStudents");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
      <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
            <% if(listStudents!= null || !listStudents.isEmpty()){ %>
         <table style="border: 2px black solid">
            <tr class="headTable"><th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Major</th> 
            </tr>
            <%
                for (int i = 0; i < listStudents.size(); i++) {
            if(i%2==0){
                    %>
            <tr class="even">
                <% } else {%>
                <tr class="odd"> 
                <% } %>
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
                <% for (int s=0; s<listStudents.get(i).getPassword().length();s++){ %>
                *
                <% } %>
            </td><td>    
                <%=listStudents.get(i).getMajor()%>
            </td>
            </tr>
            <%
                }
            %>
        </table>
        <% } else { %>
        There is no students to show
        <% } %>
        </div>
        </div> 
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
        </body>
</html>
