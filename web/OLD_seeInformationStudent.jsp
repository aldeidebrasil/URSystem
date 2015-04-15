<%-- 
    Document   : seeInformationStudent
    Created on : Mar 10, 2015, 6:14:59 PM
    Author     : Aldeide Brasil
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="controller.vo.Student"%>
<% Student student = (Student)request.getAttribute("student");
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm");
    Date date = new Date();
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
      <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
            <div class="logout">
                <a href="/URSystem/servletweb?action=Logout">Logout</a>
            </div>
            <p>Today is <%=dateFormat.format(date)%></p>
            <h2>Welcome, <%=student.getFname()%>!</h2>
            <!--Show Information -->
            <div class="profile">
                <img src="images/noPhoto.png" width="150px" height="150px" ><br>
                <p><b><%=student.getFname()%>&nbsp;<%=student.getLname()%></b></p>
                <p><b>Major:</b> <%=student.getMajor()%></p>
                <a href="/URSystem/servletweb?action=EditPasswordStudent&IdStudent=<%=student.getID()%>">Change Password</a><br>
            </div> <div class="actions">
    
         Password changed successfully.
            <br><br>
            <table style="border: 2px black solid">
                  
            <tr ><th>ID</th>
                <th>Title</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Password</th>
            </tr>
           
            <tr>
            <td>
                <%=student.getID()%>
            </td>
            <td>
                <%=student.getMajor()%>
            </td>
            <td>
                <%=student.getLname()%>
            </td>
            <td>           
                <%=student.getFname()%>
            </td>
            <td>    
                <%=student.getPassword()%>
            </td>
            </tr>
            </table> 
        </div><a href="/URSystem/servletweb?action=OpenStudent">Home</a></div>
       
    </body>
</html>
