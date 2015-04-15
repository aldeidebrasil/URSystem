<%-- 
    Document   : updateStudent
    Created on : Feb 3, 2015, 11:39:18 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Student student = (Student)request.getAttribute("student");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
      <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
            <% if(student!=null){ %>
           <form name="frmUpdateStudent" method='post'>
            <table style="border: 2px black solid">
                <tr>
                    <th class="headTable" colspan="2">ID</th>
                </tr>
                <tr class="even">
                    <td><%=student.getID()%></td>
                    <td> <input type="text" name="id" id="id" size="30" value="<%=student.getID()%>" style="line-height: 40px; font-size: 20px;"></td>
                </tr>
                <tr>
                    <th class="headTable" colspan="2">First Name</th>
                </tr>
                <tr class="even">
                    <td><%=student.getFname()%></td>
                    <td><input type="text" name="fname" id="fname" size="30" value="<%=student.getFname()%>" style="line-height: 40px; font-size: 20px;"></td>
                </tr>
                 <tr>
                    <th class="headTable" colspan="2">Last Name</th>
                </tr>
                <tr class="even">
                    <td><%=student.getLname()%></td>
                    <td><input type="text" name="lname" id="lname" size="30" value="<%=student.getLname()%>" style="line-height: 40px; font-size: 20px;"></td>
                </tr>
                <tr>
                    <th class="headTable" colspan="2">Password</th>
                </tr>
                <tr class="even">
                    <td><%=student.getPassword()%></td>
                    <td> <input type="password" name="password" id="password" size="30" value="<%=student.getPassword()%>" style="line-height: 40px; font-size: 20px;"></td>
                </tr>
                 <tr>
                    <th class="headTable" colspan="2">Major</th>
                </tr>
                <tr class="even">
                    <td><%=student.getMajor()%></td>
                    <td>  <select name="major">
                <option value="Biology">Biology</option>
                <option value="Computer Science">Computer Science</option>
                <option value="Physical Science">Physical Science</option>
                <option value="Sociology">Sociology</option>
           </select></td>
                </tr>
                 <tr>
                    <th class="headTable" colspan="2">Billing</th>
                </tr>
                <tr class="even">
                    <td><%=student.getBilling()%></td>
                    <td> 
                        <input type="text" name="billing" id="billing" size="30" value="<%=student.getBilling()%>" style="line-height: 40px; font-size: 20px;">
                    </td>
                </tr>
            </table>
            <button type="button" onClick="validateUpdateStudent(<%=student.getID()%>)">Update Student</button>
                 
	</form>
            <%} else {%>
            <h2>There is no course to show</h2>
            <% } %>
        </div> 
        </div> 
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>  
    </body>
</html>
