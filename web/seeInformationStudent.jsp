<%-- 
    Document   : seeInformationStudent
    Created on : Feb 9, 2015, 5:06:14 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Student student = (Student)request.getAttribute("student");
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
            <table style="border: 2px black solid">
                  
            <tr ><th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Major</th>
                <th>Billing</th> 
            </tr>
           
            <tr>
            <td>
                <%=student.getID()%>
            </td>
            <td>
                <%=student.getFname() %> 
            </td>
            <td>
                <%=student.getLname()%>
            </td>
            <td>           
                <%=student.getPassword()%>
            </td><td>    
                <%=student.getMajor()%>
            </td>
            <td>
                <%=student.getBilling()%>
            </td>
            </tr>
            </table> 
        </div>     
    </body>
</html>
