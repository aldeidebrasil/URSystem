/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 function validateFieldsLogin(){    
    var frm = document.frmLogin;
     var login = frm.login.value;
     var password = frm.password.value;
     if(/^[a-zA-Z0-9-]*$/.test(login) == false){
        alert("Your Login(ID) is incorrect! Please, try again!");
        frm.login.focus;
        return false;
     }
     else if(login == ""){
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

function validateInsertStudent(student){    
    var frm = document.frmInsertUser;
     var id = frm.id.value;
     var fname = frm.fname.value;
     var lname = frm.lname.value;
     var password = frm.password.value;
     var major = frm.major.value;
    if(/^[0-9]*$/.test(id) == false){
        alert("The student's ID must have only numbers!");
        frm.id.focus;
        return false;
     }
    if(id.length<4){
        alert("The ID is too short.");
        frm.id.focus();
        return false;
    }
    else if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else if(/^[a-zA-Z ]*$/.test(fname) == false){
        alert("The student's first name cannot have special characters or numbers");
        frm.fname.focus;
        return false;
     }else if(fname == ""){
        alert("Please, fill out the field First Name!");
        frm.fname.focus();
        return false;
     }else if(/^[a-zA-Z ]*$/.test(lname) == false){
        alert("The student's last name cannot have special characters or numbers");
        frm.lname.focus;
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
        document.forms[2].action = url;  
        window.document.forms[2].submit();
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
        document.forms[2].action = url;  
        window.document.forms[2].submit();
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
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateUpdateStudent(idOld){    
    var frm = document.frmUpdateStudent;
     var id = frm.id.value;
     var fname = frm.fname.value;
     var lname = frm.lname.value;
     var password = frm.password.value;
     var major = frm.major.value;
    if(isNaN(id)){
        alert("Please, the ID must have only numbers!");
        frm.id.focus();
        return false;
    }else if(/^[0-9-]*$/.test(id) == false){
        alert("The student's ID must have only numbers");
        frm.id.focus;
        return false;
     }
    else if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }
     else if(/^[a-zA-Z ]*$/.test(fname) == false){
        alert("The student's first name cannot have special characters or numbers");
        frm.fname.focus;
        return false;
     }
    
    else if(fname == ""){
        alert("Please, fill out the field First Name!");
        frm.fname.focus();
        return false;
     }
     else if(/^[a-zA-Z ]*$/.test(lname) == false){
        alert("The student's last name cannot have special characters");
        frm.lname.focus;
        return false;
     }
    else if(lname == ""){
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
        url = "/URSystem/servletweb?action=UpdateStudent&IdStudent="+idOld;  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateInsertProfessor(){    
    var frm = document.frmInsertProfessor;
     var id = frm.id.value;
     var fname = frm.fname.value;
     var lname = frm.lname.value;
     var password = frm.password.value;
     var title = frm.title.value;
     
    if(isNaN(id)){
        alert("The ID must have only numbers!");
        frm.id.focus();
        return false;
     }else if(/^[0-9-]*$/.test(id) == false){
        alert("The professor's ID must have only numbers");
        frm.id.focus;
        return false;
     }
    
    else if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else if(/^[a-zA-Z ]*$/.test(fname) == false){
        alert("The professor's first name cannot have special characters or numbers");
        frm.fname.focus;
        return false;
     }else if(fname == ""){
        alert("Please, fill out the field First Name!");
        frm.fname.focus();
        return false;
     }else if(/^[a-zA-Z ]*$/.test(lname) == false){
        alert("The professor's last name cannot have special characters or numbers");
        frm.lname.focus;
        return false;
     }else if(lname == ""){
        alert("Please, fill out the field Last Name!");
        frm.lname.focus();
        return false;
     }else if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else if(title == ""){
        alert("Please, fill out the field Title!");
        frm.title.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=InsertProfessor";  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateDeleteProfessor(){    
    var frm = document.frmDeleteProfessor;
     var id = frm.id.value; 
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=DeleteProfessor";  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateEditProfessor(){    
    var frm = document.frmDeleteProfessor;
     var id = frm.id.value;
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=EditProfessor";  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }

 function validateUpdateProfessor(idOld){    
    var frm = document.frmUpdateProfessor;
     var id = frm.id.value;
     var fname = frm.fname.value;
     var lname = frm.lname.value;
     var password = frm.password.value;
     var title = frm.title.value;
     if(isNaN(id)){
        alert("The ID must have only numbers!");
        frm.id.focus();
        return false;
     }else if(/^[0-9-]*$/.test(id) == false){
        alert("The professor's ID must have only numbers");
        frm.id.focus;
        return false;
     }
    
     else if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else if(/^[a-zA-Z ]*$/.test(fname) == false){
        alert("The professor's first name cannot have special characters");
        frm.fname.focus;
        return false;
     }
    else if(fname == ""){
        alert("Please, fill out the field First Name!");
        frm.fname.focus();
        return false;
     }else if(/^[a-zA-Z ]*$/.test(lname) == false){
        alert("The student's last name cannot have special characters");
        frm.lname.focus;
        return false;
     }
    else if(lname == ""){
        alert("Please, fill out the field Last Name!");
        frm.lname.focus();
        return false;
     }else if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else if(title == ""){
        alert("Please, fill out the field Title!");
        frm.title.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=UpdateProfessor&IdProfessor="+idOld;  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateInsertCourse(){ 
   var frm = document.frmInsertCourse;
    var id = frm.id.value;
    var name = frm.name.value;
    var department = frm.department.value;
    var val = frm.val.value;
    var idTerm = frm.idTerm.value;
    var prerequisite = frm.prerequisite.value;

    var status = frm.status.value;
    var idProfessor = frm.idProfessor.value;
     if(isNaN(val)){
      alert("The field Value must be a number");
        frm.val.focus();
       return false;  
    } 
    if(/^[a-zA-Z0-9-]*$/.test(id) == false){
        alert("The course's ID cannot have special characters");
        frm.id.focus;
        return false;
     }
     else if(id.length<5){
         alert("The course's ID must have 5 characters");
        frm.id.focus;
        return false;
     }
     
     else if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }
     else if(/^[a-zA-Z ]*$/.test(name) == false){
        alert("The course's name cannot have special characters or numbers");
        frm.name.focus;
        return false;
     }
    else if(name == ""){
        alert("Please, fill out the field Name!");
        frm.name.focus();
        return false;
     }else if(department == ""){
        alert("Please, fill out the field Department!");
        frm.department.focus();
        return false;
     }
     else if(val == ""){
        alert("Please, fill out the field Value!");
        frm.value.focus();
        return false;
     }else if(idTerm == ""){
        alert("Please, fill out the field Term!");
        frm.idTerm.focus();
        return false;
     }else if(status == ""){
        alert("Please, fill out the field Status!");
        frm.status.focus();
        return false;
     }else if(idProfessor == ""){
        alert("Please, fill out the field  ID Professor!");
        frm.idProfessor.focus();
        return false;
     }
   
     else{
        url = "/URSystem/servletweb?action=InsertCourse";  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }     
 }

 function validateUpdateCourse(idOld){    
    var frm = document.frmUpdateCourse;
     var id = frm.id.value;
     var name = frm.name.value;
     var department = frm.department.value;
     var value = frm.value.value;
     var idTerm = frm.idTerm.value;
     var status = frm.status.value;
     var idProfessor = frm.idProfessor.value;
     if(isNaN(value)){
      alert("The field Value must be a number");
        frm.val.focus();
       return false;  
    } else if(/^[a-zA-Z0-9-]*$/.test(id) == false){
        alert("The course's ID cannot have special characters");
        frm.id.focus;
        return false;
     }
     
     else if(id.length<5){
         alert("The course's ID must have 5 characters");
        frm.id.focus;
        return false;
     }
    
     else if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else if(/^[a-zA-Z ]*$/.test(name) == false){
        alert("The course's name cannot have special characters");
        frm.name.focus;
        return false;
     }
    else if(name == ""){
        alert("Please, fill out the field Name!");
        frm.name.focus();
        return false;
     }else if(department == ""){
        alert("Please, fill out the field Department!");
        frm.department.focus();
        return false;
     }else if(value == ""){
        alert("Please, fill out the field Value!");
        frm.value.focus();
        return false;
     }else if(idTerm == ""){
        alert("Please, fill out the field Term!");
        frm.term.focus();
        return false;
     }else if(status == ""){
        alert("Please, fill out the field Status!");
        frm.status.focus();
        return false;
     }else if(idProfessor == ""){
        alert("Please, fill out the field  ID Professor!");
        frm.idProfessor.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=UpdateCourse&IdCourse="+idOld;  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 
 function validateDeleteCourse(){    
    var frm = document.frmDeleteCourse;
     var id = frm.id.value; 
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=DeleteCourse";  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateEditCourse(){    
    var frm = document.frmDeleteCourse;
     var id = frm.id.value;
     if(id == ""){
        alert("Please, fill out the field ID!");
        frm.id.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=EditCourse";  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateUpdatePasswordStudent(id){    
    var frm = document.frmUpdatePasswordStudent;
     var password = frm.password.value;
     var id = id;
     if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=UpdatePasswordStudent&IdStudent="+id;  
        document.forms[1].action = url;  
        window.document.forms[1].submit();
        return true;
     }      
 }
 
 function validateUpdatePasswordProfessor(id){    
    var frm = document.frmUpdatePasswordProfessor;
     var password = frm.password.value;
     var id = id;
     if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=UpdatePasswordProfessor&IdProfessor="+id;  
        document.forms[1].action = url;  
        window.document.forms[1].submit();
        return true;
     }   
 }
 function validateUpdatePasswordAdmin(id){ 
    var frm = document.frmUpdatePasswordAdmin;
     var password = frm.password.value;
     var id = id;
     if(password == ""){
        alert("Please, fill out the field Password!");
        frm.password.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=UpdatePasswordAdmin&IdAdmin="+id;  
        document.forms[1].action = url;  
        window.document.forms[1].submit();
        return true;
     }      
 }
 
 
 function validateDate(){    
    var frm = document.frmDate;
     var dateStart = frm.termDate.value;
     var dateLimit = frm.dateLimit.value;
     var dateEnd = frm.dateEnd.value;
     
     if(dateStart == ""){
        alert("Please, fill out the field Date Start!");
        frm.termDate.focus();
        return false;
     }else if(dateLimit == ""){
        alert("Please, fill out the field Date Limit!");
        frm.dateLimit.focus();
        return false;
     }else if(dateEnd == ""){
        alert("Please, fill out the field Date End!");
        frm.dateEnd.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=EditDateTerm";  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
 function validateRegisterCourse(id){    
    var frm = document.frmRegisterCourse;
     var course = frm.rd.value;
     if(course == ""){
        alert("Please, choose one course!");
        frm.course.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=AddCourseStudent&IdStudent="+id;  
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
