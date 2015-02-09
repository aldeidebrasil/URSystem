<%-- 
    Document   : updateProfessor
    Created on : Feb 4, 2015, 10:33:22 AM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<% Professor professor = (Professor)request.getAttribute("professor");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
    </head>
    <body>
        
        <div class="content">
        <form name="frmUpdateProfessor" method='post'>
            <table style="border: 2px black solid">
                  
            <tr ><th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Password</th>
                <th>Title</th>
            </tr>
           
            <tr>
            <td>
                <%=professor.getID()%>
            </td>
            <td>
                <%=professor.getFname() %> 
            </td>
            <td>
                <%=professor.getLname()%>
            </td>
            <td>           
                <%=professor.getPassword()%>
            </td><td>    
                <%=professor.getTitle()%>
            </td>
            </tr>
            <tr><td> <input type="text" name="id" id="id" size="30" value="<%=professor.getID()%>" readonly="true" style="line-height: 40px; font-size: 20px;"></td>
           <td>
            <input type="text" name="fname" id="fname" size="30" style="line-height: 40px; font-size: 20px;">
            </td><td>
            <input type="text" name="lname" id="lname" size="30" style="line-height: 40px; font-size: 20px;">
           </td><td>
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
           </td><td>
               <input type="text" name="title" id="major" size="30" style="line-height: 40px; font-size: 20px;"></td>
            </tr></table>
            <button type="button" onClick="validateUpdateProfessor()">Update Professor</button>
                 
	</form> 
        </div>
    </body>
</html>