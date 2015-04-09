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
       <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
        <form name="frmInsertUser" method='post'>
            <h2>Type the student's ID:</h2> 
            <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;">
            <h2>Type the student's First Name:</h2> 
            <input type="text" name="fname" id="fname" size="30" style="line-height: 40px; font-size: 20px;">
            <h2>Type the student's Last Name:</h2> 
            <input type="text" name="lname" id="lname" size="30" style="line-height: 40px; font-size: 20px;">
            <h2>Type the student's Password:</h2> 
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
            <h2>Select the student's Major:</h2> 
            <select name="major">
                <option value="Biology">Biology</option>
                <option value="Computer Science">Computer Science</option>
                <option value="Physical Science">Physical Science</option>
                <option value="Sociology">Sociology</option>
           </select><br><br>
            <button type="button" onClick="validateInsertStudent()">Insert Student</button>
	</form> 
        </div></div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
