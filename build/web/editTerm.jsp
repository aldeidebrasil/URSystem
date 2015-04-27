<%-- 
    Document   : editTerm
    Created on : Apr 5, 2015, 9:59:27 PM
    Author     : Aldeide Brasil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Term - Edit Date</title>
         <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <script type="text/javascript" language="JavaScript" src="js/webValidation.js"></script>
    </head>
    <body>
      <div class="header">
            <%@include file="header.jsp" %>
        </div>
        <div class="content">
           <%@include file="profileAdmin.jsp" %>
        <div class="actions">
           <form name="frmDate" method='post'>
               <h2>Select the term and the start date: </h2>
               <select name='term'>                                
                               <option value='1'>Spring</option>
                               <option value='3'>Summer</option>
                               <option value='2'>Fall</option>
            </select> <br>     
               <h2>Date Start Term: <input type="date" name="termDate" id="termDate"></h2>
               <h2>Date Limit to Register: <input type="date" name="dateLimit" id="dateLimit"></h2>
               <h2>Date Finish Term: <input type="date" name="dateEnd" id="dateEnd"></h2>
               <button type="button" onclick="validateDate()">Update Term</button>
            </form> 
        </div> 
        </div> 
        <div class="footer">
            <%@include file="footer.jsp" %>
        </div>  
    </body>
</html>

