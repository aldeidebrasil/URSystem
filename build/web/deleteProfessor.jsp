<%-- 
    Document   : deleteProfessor
    Created on : Feb 4, 2015, 10:27:02 AM
    Author     : Aldeide Brasil
--%>

<%@page import="model.ProfessorDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<Integer> listProfessorId = new ArrayList<Integer>();
listProfessorId = ProfessorDAO.getAllId();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
    </head>
    <body>
        <form name="frmDeleteProfessor" method='post'>
            <p>ID:</p> 
            <select name='id'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listProfessorId.size(); i++) {%>
                                <option value='<%=listProfessorId.get(i)%>' <%=selected%>><%=listProfessorId.get(i)%></option>
                                <% 
                                }
                                %>
                            </select>

           
            <button type="button" onClick="validateDeleteProfessor()">Delete Professor</button>
            <button type="button" onClick="validateEditProfessor()">Edit Professor</button>
	</form> 
    </body>
</html>
