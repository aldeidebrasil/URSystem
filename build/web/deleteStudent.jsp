<%-- 
    Document   : deleteStudent
    Created on : Feb 3, 2015, 11:29:04 PM
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
        <form name="frmDeleteStudent" method='post'>
            <p>ID:</p> 
            <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;">
            <button type="button" onClick="validateDeleteStudent()">Delete Student</button>
            <button type="button" onClick="validateEditStudent()">Edit Student</button>
	</form> 
    </body>
</html>
