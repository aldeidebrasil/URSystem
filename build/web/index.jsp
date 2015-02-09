<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>  
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        </head>
    <body>
        
<div class="content">
    <div class="form">
    <form name="frmLogin" method='post' class="frm">
       <table> <tr><th>Login (ID)</th>
               <td><input type="text" name="login" id="login" maxlength="10" size="30">    </td>
           <tr><th>Password:</th><br><br>
               <td> <input type="password" name="password" id="password" maxlength="16" size="30"> </td>    
           </tr>
           <tr><td colspan="2"><button type="button" onclick="validateFieldsLogin()">Login</button></td> </tr></table>       
    </form>  
        </div>
   </div>
    </body>
</html>
