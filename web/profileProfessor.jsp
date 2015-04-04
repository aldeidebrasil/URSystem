<%-- 
    Document   : profile
    Created on : Mar 29, 2015, 3:07:26 PM
    Author     : Aldeide Brasil
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="controller.vo.Course"%>
<%@page import="controller.vo.StudentxCourse"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.vo.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Professor professor = (Professor)request.getAttribute("professor");
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
    Date date = new Date();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <link href="css/studentStyle.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" language="JavaScript" src="js/showContent.js"></script>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
    </head>
    <script language="JavaScript"> 
function moveHour(){ 
   	now = new Date() 
   	hour = now.getHours() 
   	minute = now.getMinutes() 
   	second = now.getSeconds() 

   	printHour = hour + ":" + minute + ":" + second 

   	document.form_hour.timeNow.value = printHour 

   	setTimeout("moveHour()",1000) 
} 

</script> 
<body onload="moveHour()">
       <div class="logout">
               <a href="/URSystem/servletweb?action=OpenProfessor"><img src="images/home.png" width="50" height="50" title="Home"></a>
                <a href="/URSystem/servletweb?action=Logout"><img src="images/logout.png" width="45" height="45" title="Logout"></a>
            </div>
            <form name="form_hour"> 
              <p class="time">Today is <%=dateFormat.format(date)%>  
                  <input type="text" name="timeNow" style="border: none;">
              </p>
            </form> 

            
            <h2>Welcome, <%=professor.getTitle()%>&nbsp<%=professor.getLname()%>! </h2>
            <!--Show Information -->
            <div class="profile">
                <img src="images/noPhoto.png" width="100px" height="100px" ><br>
                <p><b>Name: </b><%=professor.getFname()%>&nbsp;<%=professor.getLname()%></p>
                <p><b>Title: </b><%=professor.getTitle() %></p>
                
                <!--/URSystem/servletweb?action=EditPasswordStudent&IdStudent=-->
               <div id="changePassword" style="display:block;"> <a href="#" onclick="showNewPassword('changePassword','newPassword')">Change Password</a></div>
               <div id="newPassword" style="display: none;"> 
                   <form name="frmUpdatePasswordProfessor" method='post'>
                       <p><b>Change Password</b><a href="#" onclick="showNewPassword('changePassword','newPassword')"> Do not change</a></p>
                       <b> New password:</b> <input type="password" name="password" id="password" size="16" style="line-height: 20px; font-size: 15px;"><br><br>
                        <button type="button" onClick="validateUpdatePasswordProfessor(<%=professor.getID()%>)">Change Password</button>
                </form> 
                </div>
            </div>
    </body>
</html>
