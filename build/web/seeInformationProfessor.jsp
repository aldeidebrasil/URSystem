<%-- 
    Document   : seeInformationProfessor
    Created on : Feb 15, 2015, 3:58:48 PM
    Author     : Leticia
--%>

<%@page import="controller.vo.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Professor professor = (Professor)request.getAttribute("professor");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="content">
            Password changed successfully.
            <br><br>
            <table style="border: 2px black solid">
                  
            <tr ><th>ID</th>
                <th>Title</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Password</th>
            </tr>
           
            <tr>
            <td>
                <%=professor.getID()%>
            </td>
            <td>
                <%=professor.getTitle()%>
            </td>
            <td>
                <%=professor.getLname()%>
            </td>
            <td>           
                <%=professor.getFname()%>
            </td>
            <td>    
                <%=professor.getPassword()%>
            </td>
            </tr>
            </table> 
        </div>     
    </body>
</html>
