<%-- 
    Document   : updateStudent
    Created on : Feb 3, 2015, 11:39:18 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Student student = (Student)request.getAttribute("student");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
    </head>
    <body>
        <form name="frmUpdateStudent" method='post'>
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
           <tr><td> <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;"></td>
           <td>
            <input type="text" name="fname" id="fname" size="30" style="line-height: 40px; font-size: 20px;">
            </td><td>
            <input type="text" name="lname" id="lname" size="30" style="line-height: 40px; font-size: 20px;">
           </td><td>
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
           </td><td>
               <input type="text" name="major" id="major" size="30" style="line-height: 40px; font-size: 20px;"></td>
            </tr></table>
            <button type="button" onClick="validateUpdateStudent()">Update Student</button>
                 
	</form> 
     
    </body>
</html>
