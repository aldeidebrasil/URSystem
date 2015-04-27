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
ArrayList<Integer> listProfessorId = ProfessorDAO.getAllId();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Professor - Update/Delete</title>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body><div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
           <% if(listProfessorId!= null){ %>
            <h2>Update or Delete Professor</h2>
            <p>To update an information or delete a professor, you have to choose the professor's ID and click the correspondent button.</p>
            
            <form name="frmDeleteProfessor" method='post'>
            <b>Professor's ID:</b> 
            <select name='id'>                                
                                <%
                                String selected="";
                                
                                for (int i = 0; i < listProfessorId.size(); i++) {%>
                                <option value='<%=listProfessorId.get(i)%>'><%=listProfessorId.get(i)%></option>
                                <% 
                                }
                                %>
                            </select>

           
            <button type="button" onClick="validateEditProfessor()">Edit Professor</button>
            <button type="button" onClick="validateDeleteProfessor()">Delete Professor</button>
            <% } else {%>
                <h2>There is no professors yet.</h2>
            <% } %>
	</form> 
        </div></div>
               <div class="footer">
            <%@include file="footer.jsp" %>
        </div>              
    </body>
</html>
