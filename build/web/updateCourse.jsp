<%-- 
    Document   : updateCourse
    Created on : Feb 11, 2015, 12:15:51 AM
    Author     : CMarcelo
--%>


<%@page import="controller.vo.Course"%>
<%@page import="model.CourseDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<% Course course = (Course)request.getAttribute("course");
%>
<%! ArrayList<String> listCourseID;
%>
<%    
    listCourseID = CourseDAO.getAllId();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
    </head>
    <body>
       <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
            <div class="logout">
                <a href="/URSystem/servletweb?action=Logout">Logout</a>
            </div>
         <form name="frmUpdateCourse" method='post'>
            <table style="border: 2px black solid">
                  
            <tr ><th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Prerequisite</th>
                <th>Value</th>
                <th>Status</th>
                <th>Term</th>
                <th>Year</th>
            </tr>
           
            <tr>
            <td>
                <%=course.getID()%>
            </td>
            <td>
                <%=course.getName() %> 
            </td>
            <td>
                <%=course.getDepartment()%>
            </td>
            <td>           
                <%=course.getPrerequisite()%>
            </td>
            <td>    
                <%=course.getValue()%>
            </td>
            <td>    
                <%=course.getIdTerm()%>
            </td>
            <td>    
                <%=course.getStatus()%>
            </td>
            <td>    
                <%=course.getYear()%>
            </td>
            </tr>
            <tr><td> <input type="text" name="id" id="id" size="30" value="<%=course.getID()%>" readonly="true" style="line-height: 40px; font-size: 20px;">
            </td><td>
                <input type="text" name="name" id="name" size="30" style="line-height: 40px; font-size: 20px;">
            </td><td>
                <input type="text" name="department" id="department" size="30" style="line-height: 40px; font-size: 20px;">
            </td><td>
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
            </td><td>
                <input type="text" name="value" id="value" size="30" style="line-height: 40px; font-size: 20px;">
            </td><td>
            <select name="status" id="status">
                <option value='open'>    Open</option>
                <option value='full'>    Full</option>
                <option value='canceled'>Canceled</option>  
            </select>
            </td><td>
                <select name="idterm" id="idterm">
                <option value='1'>Spring</option>
                <option value='2'>Fall</option>
                <option value='3'>Summer</option>  
                <option value='4'>Winter</option> 
                </select>
            </td><td>
                <select name='year'>                                
                                <%
                                String professorSelected="";
                                
                                for (int i = 2000; i < 2022; i++) {%>
                                <option value='<%=i%>'><%=i%></option>
                                <% 
                                }
                                %>
                </select>
            </td><td>
            </tr>
            </table>
            <button type="button" onClick="validateUpdateCourse()">Update Course</button>
                 
	</form> 
        </div>
    </body>
</html>
