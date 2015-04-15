<%-- 
    Document   : allCoursesStudent
    Created on : Mar 10, 2015, 5:53:41 PM
    Author     : Aldeide Brasil
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="model.StudentDAO"%>
<%@page import="controller.vo.Student"%>
<%@page import="controller.vo.Course"%>
<%@page import="org.omg.PortableInterceptor.SYSTEM_EXCEPTION"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   ArrayList<Course> listCourse = (ArrayList<Course>) request.getAttribute("listCourse");
   Double bill = (Double)request.getAttribute("billing");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Billing Information</title>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="header">
            <%@include file="header.jsp" %>
        </div>
       <div class="content">
           <%@include file="profile.jsp"%>
            <div class="actions2">
     
       <form name="frmDropCourse" method='post'>
           <% if (!listCourse.isEmpty()){ %>
      <table style="border: 2px black solid">
            <tr class="headTable"><th>ID</th>
                <th>Course</th>
                <th>Department</th>
                <th>Value</th>
                
                
                
            </tr>
            <% int i=0;
                for (i = 0; i < listCourse.size(); i++) {
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
                <%=listCourse.get(i).getValue()%>
            </td>
            </tr>
            <%
                } if(i%2==0){
            %>
            <tr class="even">
                <% } else {%>
                <tr class="odd"> 
                <% } %><th colspan="3">Total</th>
                <td>
                    <% if(bill!=null) { %>
                        <%=bill%>
                    <% }else { %>
                        0
                    <% } %>
                </td>
                </tr>
                
            </table>
                <% } else { %>
                    <h2>You do not have any registration yet.</h2>
                   <% } %>
                <br>
          
            </div>
       </div>
       <div class="footer">
            <%@include file="footer.jsp" %>
        </div>
   </body>
</html>
