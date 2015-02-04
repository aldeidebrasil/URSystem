<%-- 
    Document   : insertProfessor
    Created on : Feb 4, 2015, 9:32:20 AM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
    
    </head>
    <body>
       
        <form name="frmInsertProfessor" method='post'>
            <p>ID:</p> 
            <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;">
            <p>First Name:</p> 
            <input type="text" name="fname" id="fname" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Last Name:</p> 
            <input type="text" name="lname" id="lname" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Password:</p> 
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Title:</p> 
            <input type="text" name="title" id="title" size="30" style="line-height: 40px; font-size: 20px;"><br><br>
            <button type="button" onClick="validateInsertProfessor()">Insert Professor</button>
	</form> 
    </body>
</html>
