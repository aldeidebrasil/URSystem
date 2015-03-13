<%-- 
    Document   : allCoursesStudent
    Created on : Mar 10, 2015, 5:53:41 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Student"%>
<%@page import="controller.vo.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Course> listCourses = (ArrayList<Course>) request.getAttribute("listCourses");
    Student student =(Student) request.getAttribute("student");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        
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
    <body>  <form name="frmDropCourse" method='post'>
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
        </form>
        </body>
</html>
