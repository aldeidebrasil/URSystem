<%-- 
    Document   : ok
    Created on : Feb 3, 2015, 10:26:22 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Course"%>
<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Course> listCourse = (ArrayList<Course>) request.getAttribute("listCourse");   
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Course</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head><div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
            <%if(listCourse!=null){ %>
            <table style="border: 2px black solid">
           <tr class="headTable"><th>ID</th>
                <th>Course</th>
                <th>Department</th>
                <th>Prerequisites</th>
                <th>Value</th>
                <th>Term</th>
                <th>Status</th>
                
            </tr>
            <%
                for (int i = 0; i < listCourse.size(); i++) {
            if(i%2==0){
                    %>
            <tr class="even">
                <% } else {%>
                <tr class="odd"> 
                <% } %>
            <td>
                <%=listCourse.get(i).getID()%>
            </td>
            <td>    
                <%=listCourse.get(i).getName()%>
            </td>
            <td>
                <%=listCourse.get(i).getDepartment() %> 
            </td>
            <td>
                <% if(listCourse.get(i).getPrerequisite()==null){ %>None
                <%} else{ %> 
                <%=listCourse.get(i).getPrerequisite()%>
                <% }%>
            </td>
            <td>           
                <%=listCourse.get(i).getValue()%>
            </td>
            <td> 
                <% if(listCourse.get(i).getIdTerm()==1){ %>Spring
                <%} else if(listCourse.get(i).getIdTerm()==2){ %>Fall 
                <%} else{ %> Summer
                <% }%>
                
            </td>
            <td>           
                <%=listCourse.get(i).getStatus()%>
            </td>
           
            </tr>
            <%
                }
            %>
        </table>
        <% } else { %>
           <h2> There is no courses to show.</h2>
        <% }%>
        </div>
        </div>
         <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
</body>
</html>
