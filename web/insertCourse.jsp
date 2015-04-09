<%-- 
    Document   : insertCourse
    Created on : Feb 9, 2015, 12:23:19 PM
    Author     : Aldeide Brasil
--%>

<%@page import="model.CourseDAO"%>
<%@page import="model.ProfessorDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.vo.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ArrayList<Integer> listProfessorID = ProfessorDAO.getAllId();
    ArrayList<String> listCourseID = CourseDAO.getAllId();
%>

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
           <%@include file="profileAdmin.jsp" %>
        <div class="actions"> 
             <form name="frmInsertCourse" method='post' >
             <h2>Type the course's ID:</h2>
            <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;">
           
             <h2>Type the course's Name:</h2>
            <input type="text" name="name" id="name" size="30" style="line-height: 40px; font-size: 20px;">
             <h2>Type the course's Department:</h2>
            <input type="text" name="department" id="department" size="30" style="line-height: 40px; font-size: 20px;">
             <h2>Select the course's prerequisite:</h2>
            
           <select name='prerequisite'>                                
                                <%
                                String courseSelected="";
                                %>
                                <option value=''>None</option>
                                <%
                                for (int i = 0; i < listCourseID.size(); i++) {%>
                                <option value='<%=listCourseID.get(i)%>' <%=courseSelected%>><%=listCourseID.get(i)%></option>
                                <% 
                                }
                                %>
                            
           </select>            
             <h2>Type the course's value(U$):</h2>
            <input type="text" name="val" id="val" size="30" style="line-height: 40px; font-size: 20px;"><br><br>
             <h2>Select the course's term:</h2>
              <select name='idTerm'>
                <option value='1'>Spring</option>
                <option value='2'>Fall</option>
                <option value='3'>Summer</option>
                
            </select>
           <br><br>
             <h2>Select the course's status:</h2>
            <select name='status'>
                <option value='open'>Open</option>
                <option value='full'>Full</option>
                <option value='canceled'>Canceled</option>
                
            </select>
             <h2>Select the course's professor (ID): </h2>
           <select name='idProfessor'>                                
                <%
                String professorSelected="";

                for (int i = 0; i < listProfessorID.size(); i++) {%>
                <option value='<%=listProfessorID.get(i)%>' <%=professorSelected%>><%=listProfessorID.get(i)%></option>
                <% 
                }
                %>
            </select>
            <button type="button" onClick="validateInsertCourse()">Insert Course</button>
	</form> 
            </div></div>
               <div class="footer">
            <%@include file="footer.jsp" %>
        </div> 
    </body>
</html>
