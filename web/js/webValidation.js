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

function validateInsertStudent(){    
    var frm = document.frmInsertUser;
     var id = frm.id.value;
     var fname = frm.fname.value;
     var lname = frm.lname.value;
     var password = frm.password.value;
     var major = frm.major.value;
     
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else if(fname == ""){
        alert("Please, fill out the field First Name!");
        frm.fname.focus();
        return false;
     }else if(lname == ""){
        alert("Please, fill out the field Last Name!");
        frm.lname.focus();
        return false;
     }else if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else if(major == ""){
        alert("Please, fill out the field Major!");
        frm.major.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=InsertStudent";  
        document.forms[0].action = url;  
        window.document.forms[0].submit();
        return true;
     }      
 }
 function validateDeleteStudent(){    
    var frm = document.frmDeleteStudent;
     var id = frm.id.value;
   
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=DeleteStudent";  
        document.forms[0].action = url;  
        window.document.forms[0].submit();
        return true;
     }      
 }
 function validateEditStudent(){    
    var frm = document.frmDeleteStudent;
     var id = frm.id.value;
   
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=EditStudent";  
        document.forms[0].action = url;  
        window.document.forms[0].submit();
        return true;
     }      
 }
 function validateUpdateStudent(){    
    var frm = document.frmUpdateStudent;
     var id = frm.id.value;
     var fname = frm.fname.value;
     var lname = frm.lname.value;
     var password = frm.password.value;
     var major = frm.major.value;
     
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else if(fname == ""){
        alert("Please, fill out the field First Name!");
        frm.fname.focus();
        return false;
     }else if(lname == ""){
        alert("Please, fill out the field Last Name!");
        frm.lname.focus();
        return false;
     }else if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else if(major == ""){
        alert("Please, fill out the field Major!");
        frm.major.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=UpdateStudent";  
        document.forms[0].action = url;  
        window.document.forms[0].submit();
        return true;
     }      
 }
 
 
