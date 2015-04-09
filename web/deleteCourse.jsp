<%-- 
    Document   : deleteCourse
    Created on : Feb 10, 2015, 9:27:02 PM
    Author     : CMarcelo
--%>

<%@page import="model.CourseDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<String> listCourseId = new ArrayList<String>();
listCourseId = CourseDAO.getAllId();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body><div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
            <h2>Update or Delete Course</h2>
            <p>To update an information or delete a course, you have to choose the Course's ID and click the correspondent button.</p>
            
            <form name="frmDeleteCourse" method='post'>
            <p>Course's ID:</p> 
            <select name='id'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listCourseId.size(); i++) {%>
                                <option value='<%=listCourseId.get(i)%>' <%=selected%>><%=listCourseId.get(i)%></option>
                                <% 
                                }
                                %>
                            </select>

           
            <button type="button" onClick="validateEditCourse()">Edit Course</button>
            <button type="button" onClick="validateDeleteCourse()">Delete Course</button>
	</form> 
        </div></div>
                             <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>