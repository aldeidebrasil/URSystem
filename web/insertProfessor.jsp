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
        <title>Insert Professor</title>
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
          <form name="frmInsertProfessor" method='post' >
            <h2>Type the professor's ID:</h2> 
            <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;">
              <h2>Type the professor's first name:</h2> 
            <input type="text" name="fname" id="fname" size="30" style="line-height: 40px; font-size: 20px;">
              <h2>Type the professor's last name:</h2> 
            <input type="text" name="lname" id="lname" size="30" style="line-height: 40px; font-size: 20px;">
              <h2>Type the professor's password:</h2>  
            <input type="password" name="password" id="password" size="30" style="line-height: 40px; font-size: 20px;">
              <h2>Select the professor's title:</h2> 
           <select name="title">
                <option value="Doctor">Doctor</option>
                <option value="Master">Master</option>
                
           </select><br><br>
            <button type="button" onClick="validateInsertProfessor()">Insert Professor</button>
	</form> 
            </div></div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
