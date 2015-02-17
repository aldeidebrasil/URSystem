<%-- 
    Document   : updatePasswordProfessor
    Created on : Feb 15, 2015, 3:15:06 PM
    Author     : Leticia
--%>

<%@page import="controller.vo.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Professor professor = (Professor)request.getAttribute("professor");
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
        <form name="frmUpdatePasswordProfessor" method='post'>
            <table style="border: 2px black solid">
                  
            <tr ><th>Password</th>
                </tr>
           
            <tr>
            <td>           
                <%=professor.getPassword()%>
            </td>
            </tr>
            <tr><td>
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
           </td></tr></table>
            <button type="button" onClick="validateUpdatePasswordProfessor(<%=professor.getID()%>)">Change Password</button>
                 
	</form> 
        </div>     
    </body>
</html>

