<%-- 
    Document   : updateCourse
    Created on : Feb 11, 2015, 12:15:51 AM
    Author     : CMarcelo
--%>


<%@page import="controller.vo.ProfessorxCourse"%>
<%@page import="model.ProfessorxCourseDAO"%>
<%@page import="model.ProfessorDAO"%>
<%@page import="controller.vo.Course"%>
<%@page import="model.CourseDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<% Course course = (Course)request.getAttribute("course");
ProfessorxCourse professorxcourse = ProfessorxCourseDAO.getByIdCourse(course.getID());
 ArrayList<String> listCourseID = CourseDAO.getAllId();
 ArrayList<Integer> listProfessorID = ProfessorDAO.getAllId();
  ArrayList<String> department= CourseDAO.getAllDepartment();
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
            <%@include file="profileAdmin.jsp" %>
            <div class="actions">
         <form name="frmUpdateCourse" method='post'>
               <table style="border: 2px black solid">
                        <tr>
                            <th class="headTable" colspan="2">ID</th>
                        </tr> 
                        <tr class="even">
                            <td><%=course.getID()%></td>
                            <td> <input type="text" name="id" id="id" size="30" value="<%=course.getID()%>" style="line-height: 40px; font-size: 20px;"></td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Name</th>
                        </tr>
                        <tr class="even">
                            <td><%=course.getName()%> </td>
                            <td><input type="text" name="name" id="name" size="30" value="<%=course.getName()%> " style="line-height: 40px; font-size: 20px;"></td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Department</th>
                        </tr>
                        <tr class="even">
                            <td> <%=course.getDepartment()%></td>
                            <td> <select name='department'>
                                    <option value='Biology'>Biology</option>
                 <option value='Computer Science'>Computer Science</option>
                 <option value='Phisical Science'>Physical Science</option>
                 <option value='Sociology'>Sociology</option>
                
              <!-- for (int i=0; i<department.size(); i++){ %>
                 //} -->
                
            </select>
            </td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Prerequisite</th>
                        </tr>
                        <tr class="even">
                            <td><% if(course.getPrerequisite()==null){%>None
                            <%} else {%> <%=course.getPrerequisite()%>
                            <% } %>
                            </td>
                            <td> <select name='prerequisite'>                                
                                <%
                                String courseSelected="";
                                %>
                                <option value=''>None</option>
                                <% for (int i = 0; i < listCourseID.size(); i++) {%>
                                <option value='<%=listCourseID.get(i)%>' <%=courseSelected%>><%=listCourseID.get(i)%></option>
                                <% 
                                }
                                %></select>
                          </td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Value</th>
                        </tr>
                        <tr class="even">
                            <td><%=course.getValue()%></td>
                            <td> <input type="text" name="value" id="value" size="30" value="<%=course.getValue()%>" style="line-height: 40px; font-size: 20px;"></td>
                        </tr>
                         <tr>
                            <th class="headTable" colspan="2">Status</th>
                        </tr>
                        <tr class="even">
                            <td><%=course.getStatus()%></td>
                            <td> <select name="status" id="status">
                <option value='open'>    Open</option>
                <option value='full'>    Full</option>
                <option value='canceled'>Canceled</option>  
            </select></td>
                        </tr>
                         <tr>
                            <th class="headTable" colspan="2">Term</th>
                        </tr>
                        <tr class="even">
                            <td><% if(course.getIdTerm()==1){ %>Spring
                                <%} else if(course.getIdTerm()==2) { %>Fall
                                 <%} else if(course.getIdTerm()==3) { %>Summer
                                 <% } %>
                            </td>
                            <td> <select name="idTerm" id="idTerm">
                <option value='1'>Spring</option>
                <option value='2'>Fall</option>
                <option value='3'>Summer</option> 
                </select></td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Year:</th>
                        </tr>
                        
                        <tr class="even">
                            <td>
                                <% if(course.getYear()==null){%> TBA
                                <% }else {%>
                                <%=course.getYear()%>
                                <% } %>
                            </td><td>
                        <select name='year'>
                           <% for (int i=2014; i<2020; i++) { %> 
                           <option value='<%=i%>'><%=i%></option>
                           <% } %> 
                        </select></td>
                         </tr>          
                        <tr>
                            <th class="headTable" colspan="2">Professor (ID):</th>
                        </tr>
                        <tr class="even">
                           <td><%if(professorxcourse!=null){ %>
                               <%=professorxcourse.getIdProfessor()%>
                               <% } else{ %> None
                               <% } %>
                               
                           </td> 
                        <td><select name='idProfessor'>                                
                <%
                for (int i = 0; i < listProfessorID.size(); i++) {%>
                <option value='<%=listProfessorID.get(i)%>'><%=listProfessorID.get(i)%></option>
                <% 
                }
                %></select>
                        </td>
                        </tr>
            

                    </table>
                        <br><br>

                    <button type="button" onClick="validateUpdateCourse('<%=course.getID()%>')">Update Course</button>   
            
             
                 
	</form> 
        </div></div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div> 
    </body>
</html>
