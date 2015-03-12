/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateSeeStudents(){    
    var frm = document.frmSeeStudents;
    var rd = frm.rd.value;
    if(rd == ""){
        alert("Please, fill out the field ID!");
        frm.rd.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=SeeStudents";  
        document.forms[0].action = url;  
        window.document.forms[0].submit();
        return true;
     }      
 }

