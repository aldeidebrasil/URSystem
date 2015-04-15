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
        document.forms[2].action = url;  
        window.document.forms[2].submit();
        return true;
     }      
 }
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
    <body  onload="moveHour()"> <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
            <%@include file="profile.jsp"%>
            <div class="actions2">
       <form name="frmDropCourse" method='post'>
           <% if(listCourses!= null){ %>
      <table style="border: 2px black solid">
            <tr class="headTable"><th>ID</th>
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
                    if(i%2==0){
            %>
            <tr class="even">
                <% } else {%>
                <tr class="odd"> 
                <% } %>
                <td>
                <input type="radio" id="id" name="rd" value="<%=listCourses.get(i).getID()%>"><%=listCourses.get(i).getID()%>
            </td>
            <td>    
                <%=listCourses.get(i).getName()%>
            </td>
            <td>
                <%=listCourses.get(i).getDepartment() %> 
            </td><td>
            <% if(listCourses.get(i).getPrerequisite()!=null) { %>
            
                <%=listCourses.get(i).getPrerequisite() %>
                      
            <% } else {%> None <% } %></td> 
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
            </table><br>
         <button type="button" onClick="validateDropCourse(<%=student.getID()%>)">Drop Course</button>
         <% }else { %>
            There is no course to show.
        <% } %>
        </form></div>
        </div><div class="footer">
            <%@include file="footer.jsp" %>
        </div>
        </body>
</html>
