<%-- 
    Document   : allTerm
    Created on : Apr 7, 2015, 4:25:58 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Term"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Term> listTerm= (ArrayList<Term>) request.getAttribute("listTerm");
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Term</title>
    </head>
    <body>
        <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
            <% if(listTerm != null || !listTerm.isEmpty()) { %>
            <table style="border: 2px black solid">
            <tr class="headTable">
               
                <th>Name</th>
                <th>Start Date</th> 
                <th>End Date</th>
            </tr>
            <%
                for (int i = 0; i < 3; i++) {
            if(i%2==0){
                    %>
            <tr class="even">
                <% } else {%>
                <tr class="odd"> 
                <% } %>
            
            <td>
                <%=listTerm.get(i).getName() %> 
            </td>
            <td>
                <%=listTerm.get(i).getDateStart()%>
            </td>
           <td>
                <%=listTerm.get(i).getDateEnd()%>
            </td>
            </tr>
            <%
                }
            %>
        </table>
        <% }else{ %>
            There is no terms to show
        <% } %>
            </div></div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
