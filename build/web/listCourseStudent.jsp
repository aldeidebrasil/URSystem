<%-- 
    Document   : allCoursesStudent
    Created on : Mar 10, 2015, 5:53:41 PM
    Author     : Aldeide Brasil
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="controller.vo.Student"%>
<%@page import="controller.vo.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Course> listCourses = (ArrayList<Course>) request.getAttribute("listCourses");
    Student student =(Student) request.getAttribute("student");
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm");
    Date date = new Date();
   String confirm = (String)request.getAttribute("ok");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/showContent.js"></script>
       
        
    </head>
    <script>
        function validateDropCourse(idStudent){    
    var frm = document.frmDropCourse;
     var id = frm.id.value; 
     if(id == ""){
        alert("Please, choose a course!");
        frm.id.focus();
        return false;
     }else{
        url = "/URSystem/servletweb?action=DropCourseStudent&IdStudent="+idStudent+"&IdCourse="+id;  
        document.forms[0].action = url;  
        window.document.forms[0].submit();
        return true;
     }      
 }
        
    </script>
    <body> <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
            
            <div class="logout">
                <a href="/URSystem/servletweb?action=OpenStudent"><img src="images/home.png" width="50" height="50" title="Home"></a>
                <a href="/URSystem/servletweb?action=Logout"><img src="images/logout.png" width="45" height="45" title="Logout"></a>
            </div>
            <p>Today is <%=dateFormat.format(date)%></p>
            <h2>Welcome, <%=student.getFname()%>!</h2>
            <!--Show Information -->
            <div class="profile">
                <img src="images/noPhoto.png" width="150px" height="150px" ><br>
                <p><b><%=student.getFname()%>&nbsp;<%=student.getLname()%></b></p>
                <p><b>Major:</b> <%=student.getMajor()%></p>
                <!--/URSystem/servletweb?action=EditPasswordStudent&IdStudent=-->
               <div id="changePassword" style="display:block;"> <a href="#" onclick="showNewPassword('changePassword','newPassword')">Change Password</a></div>
               <div id="newPassword" style="display: none;"> 
                   <form name="frmUpdatePasswordStudent" method='post'>
                       <p><b>Change Password</b><a href="#" onclick="showNewPassword('changePassword','newPassword')"> Do not change</a></p>
            <b> New password:</b> <input type="password" name="password" id="password" size="16" style="line-height: 20px; font-size: 15px;"><br><br>
               <button type="button" onClick="validateUpdatePasswordStudent(<%=student.getID()%>)">Change Password</button>
                 
	</form> 
        </div>
            </div>
            <div class="actions">
       <form name="frmDropCourse" method='post'>
      <table style="border: 2px black solid">
            <tr ><th>ID</th>
                <th>Course</th>
                <th>Department</th>
                <th>Prerequisites</th>
                <th>Value</th>
                <th>Term</th>
                <th>Status</th>
                <th>Year</th>
                
                
            </tr>
            <%
                for (int i = 0; i < listCourses.size(); i++) {
            %>
            <tr>
            <td>
                <input type="radio" id="id" value="<%=listCourses.get(i).getID()%>"><%=listCourses.get(i).getID()%>
            </td>
            <td>    
                <%=listCourses.get(i).getName()%>
            </td>
            <td>
                <%=listCourses.get(i).getDepartment() %> 
            </td>
            <td>
                <%=listCourses.get(i).getPrerequisite()%>
            </td>
            <td>           
                <%=listCourses.get(i).getValue()%>
            </td>
            <td>           
                <%=listCourses.get(i).getIdTerm()%>
            </td>
            <td>           
                <%=listCourses.get(i).getStatus()%>
            </td>
            <td>           
                <%=listCourses.get(i).getYear()%>
            </td>
            </tr>
            <%
                }
            %>
            </table>
         <button type="button" onClick="validateDropCourse(<%=student.getID()%>)">Drop Course</button>
        </form></div>
        </div>
        </body>
</html>
