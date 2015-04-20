<%-- 
    Document   : updateProfessor
    Created on : Feb 4, 2015, 10:33:22 AM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<% Professor professor = (Professor) request.getAttribute("professor");
     ArrayList<Integer> professors = (ArrayList<Integer>)request.getAttribute("professors"); 

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <script type="text/javascript" src="ajaxrequest.js"></script>
<script type="text/javascript">

  function callAjax(value,professors)
  {
     for(var i=0; i<professors.length; i++){
         if(professors[i]==value){
             alert("This ID already exists");
            
             return false;
         }
     }
     
  }

</script>
    </head>
    <body>
        <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
            <%@include file="profileAdmin.jsp" %>
            <div class="actions">
                <% if(professor!=null){ %>
                <form name="frmUpdateProfessor" method='post'>
                    <table style="border: 2px black solid">
                        <tr>
                            <th class="headTable" colspan="2">ID</th>
                        </tr> 
                        <tr class="even">
                            <td><%=professor.getID()%></td>
                            <td> <input type="text" name="id" id="id" size="30" maxlength="3" value="<%=professor.getID()%>" onchange="if(this.value != '') var boolean = callAjax(this.value, <%=professors%>); if(boolean==false) this.value = null" style="line-height: 40px; font-size: 20px;"></td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">First Name</th>
                        </tr>
                        <tr class="even">
                            <td><%=professor.getFname()%> </td>
                            <td><input type="text" name="fname" id="fname" size="30" maxlength="50" value="<%=professor.getFname()%> " style="line-height: 40px; font-size: 20px;"></td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Last Name</th>
                        </tr>
                        <tr class="even">
                            <td> <%=professor.getLname()%></td>
                            <td><input type="text" name="lname" id="lname" size="30" maxlength="100" value=" <%=professor.getLname()%>" style="line-height: 40px; font-size: 20px;"></td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Password</th>
                        </tr>
                        <tr class="even">
                            <td><%=professor.getPassword()%></td>
                            <td> <input type="password" name="password" id="password" size="30" maxlength="16" value="<%=professor.getPassword()%>" style="line-height: 40px; font-size: 20px;"></td>
                        </tr>
                        <tr>
                            <th class="headTable" colspan="2">Major</th>
                        </tr>
                        <tr class="even">
                            <td><%=professor.getTitle()%></td>
                            <td>  <select name="title">
                                    <option value="Doctor">Doctor</option>
                                    <option value="Master">Master</option>
                                </select>
                            </td>
                        </tr>

                    </table>


                    <button type="button" onClick="validateUpdateProfessor(<%=professor.getID()%>)">Update Professor</button>

                </form>
                    <%} else {%>
                    <h2>There is no professor to show</h2>
                    <%}%>
            </div></div>
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div> 
    </body>
</html>