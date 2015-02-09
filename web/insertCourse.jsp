<%-- 
    Document   : insertCourse
    Created on : Feb 9, 2015, 12:23:19 PM
    Author     : Aldeide Brasil
--%>

<%@page import="model.CourseDAO"%>
<%@page import="model.ProfessorDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! ArrayList<Integer> listProfessorID;
    ArrayList<String> listCourseID;
%>
<%    
    listProfessorID = ProfessorDAO.getAllId();
    listCourseID = CourseDAO.getAllId();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    
    </head>
    <body>
        <div class="content">
        <form name="frmInsertCourse" method='post' >
            <p>ID:</p> 
            <input type="text" name="id" id="id" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Name:</p> 
            <input type="text" name="name" id="name" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Department:</p> 
            <input type="text" name="department" id="department" size="30" style="line-height: 40px; font-size: 20px;">
            <p>Prerequisite</p> 
            
           <select name='prerequisite'>                                
                                <%
                                String courseSelected="";
                                %>
                                <option value='' <%=courseSelected%>>None</option>
                                <%
                                for (int i = 0; i < listCourseID.size(); i++) {%>
                                <option value='<%=listCourseID.get(i)%>' <%=courseSelected%>><%=listCourseID.get(i)%></option>
                                <% 
                                }
                                %>
                            
           </select>            
            <p>Value:</p> 
            <input type="text" name="value" id="value" size="30" style="line-height: 40px; font-size: 20px;"><br><br>
            <p>Term</p> 
            <input type="text" name="term" id="term" size="30" style="line-height: 40px; font-size: 20px;"><br><br>
            <p>Status:</p> 
            <select name='status'>
                <option value='open'>Open</option>
                <option value='full'>Full</option>
                <option value='canceled'>Canceled</option>
                
            </select>
            <p>ID Professor</p> 
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
            </div>
    </body>
</html>
