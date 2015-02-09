<%-- 
    Document   : updatePasswordStudent
    Created on : Feb 9, 2015, 5:24:06 PM
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
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        
        <div class="content">
        <form name="frmUpdatePasswordStudent" method='post'>
            <table style="border: 2px black solid">
                  
            <tr ><th>Password</th>
                </tr>
           
            <tr>
            <td>           
                <%=student.getPassword()%>
            </td>
            </tr>
            <tr><td>
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
           </td></tr></table>
            <button type="button" onClick="validateUpdatePasswordStudent(<%=student.getID()%>)">Change Password</button>
                 
	</form> 
        </div>     
    </body>
</html>
