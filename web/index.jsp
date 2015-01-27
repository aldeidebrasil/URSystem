<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>  
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        </head>
    <body>

    <h1>Login</h1>
    
    <form name="frmLogin" method='post'>
        <label>Login (ID)
            <input type="text" name="login" id="login" maxlength="10" size="12">    
        </label><br>
                <br>
        <label>Password:&nbsp;&nbsp;&nbsp;
            <input type="password" name="password" id="password" maxlength="10" size="12">    
        </label><br>
                <br>
        
        <button type="button" onclick="validateFieldsLogin()">Login</button>        
    </form>  
   
    </body>
</html>
