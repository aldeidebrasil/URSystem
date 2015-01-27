/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 function validateFieldsLogin(){    
    var frm = document.frmLogin;
     var login = frm.login.value;
     var password = frm.password.value;
     
     if(login == ""){
        alert("Please, fill out the field Login!");
        frm.login.focus();
        return false;
     }else if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=Login";  
        document.forms[0].action = url;  
        window.document.forms[0].submit();
        return true;
     }      
 }

