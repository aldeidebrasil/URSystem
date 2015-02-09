<%-- 
    Document   : modifyStudent
    Created on : Feb 3, 2015, 10:09:08 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Student</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="content">
        <form name="frmInsertUser" method='post'>
            <p>ID:</p> 
            <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;">
            <p>First Name:</p> 
            <input type="text" name="fname" id="fname" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Last Name:</p> 
            <input type="text" name="lname" id="lname" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Password:</p> 
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Major:</p> 
            <input type="text" name="major" id="major" size="30" style="line-height: 40px; font-size: 20px;"><br><br>
            <button type="button" onClick="validateInsertStudent()">Insert Student</button>
	</form> 
        </div>
    </body>
</html>
