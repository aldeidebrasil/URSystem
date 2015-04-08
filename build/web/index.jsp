<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<% 
    String confirm = (String)request.getAttribute("ok");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>  
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        </head>
   <body>
      <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
            <div class="checkList"><h2>Need help?</h2>
                <ul><li><img src="images/check.png" width="45" >Your Username is your Student ID number.</li>
                    <li><img src="images/check.png" width="45" >Your Password was registered by the Department of Registrar</li>
                    <li><img src="images/check.png" width="45" >If you do not remember your password, you can either send us an <a href="mailto:registrar@ursystem.edu" target="_blank">email</a> or go to the Department of Registrar</li></ul></div>
   <div class="form">
        <div class="blackboard">
            <form name="frmLogin" method='post' class="frm">
                <table> <tr><th>Login (ID)</th></tr><tr><td><input type="text" name="login" id="login" maxlength="10" size="30"></td></tr>
           <tr><th>Password:</th></tr><tr><td> <input type="password" name="password" id="password" maxlength="16" size="30"> </td></tr>
           <tr><td colspan="2"><button type="button" onclick="validateFieldsLogin()">Login</button></td> </tr></table>       
    </form>  
        </div>
   
   </div>
    </div>
        
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
        <% 
             System.out.println(confirm);
        if(confirm != null) {confirm = null; %>
            <script>alert("User not found");</script>
            
        <%} %>
    </body>
</html>
