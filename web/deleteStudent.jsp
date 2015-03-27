<%-- 
    Document   : deleteStudent
    Created on : Feb 3, 2015, 11:29:04 PM
    Author     : Aldeide Brasil
--%>

<%@page import="model.StudentDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<Integer> listStudentId = new ArrayList<Integer>();
listStudentId = StudentDAO.getAllId();
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
            <div class="logout">
                <a href="/URSystem/servletweb?action=Logout">Logout</a>
            </div>
         <form name="frmDeleteStudent" method='post'>
            <p>ID:</p> 
            
            <select name='id'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listStudentId.size(); i++) {%>
                                <option value='<%=listStudentId.get(i)%>' <%=selected%>><%=listStudentId.get(i)%></option>
                                <% 
                                }
                                %>
                            </select>

            <button type="button" onClick="validateDeleteStudent()">Delete Student</button>
            <button type="button" onClick="validateEditStudent()">Edit Student</button>
	</form> 
        </div>
    </body>
</html>
