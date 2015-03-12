<%-- 
    Document   : seeInformationStudent
    Created on : Mar 10, 2015, 6:14:59 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Student"%>
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
                <%=student.getID()%>
            </td>
            <td>
                <%=student.getMajor()%>
            </td>
            <td>
                <%=student.getLname()%>
            </td>
            <td>           
                <%=student.getFname()%>
            </td>
            <td>    
                <%=student.getPassword()%>
            </td>
            </tr>
            </table> 
        </div>     
    </body>
</html>
