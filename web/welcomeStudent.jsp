<%-- 
    Document   : error
    Created on : Jan 25, 2015, 2:06:25 PM
    Author     : Aldeide Brasil
--%>

<%@page import="controller.vo.Course"%>
<%@page import="controller.vo.StudentxCourse"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.vo.Student"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    Student student = (Student)request.getAttribute("student");
    ArrayList<StudentxCourse> studentxcourse =  (ArrayList<StudentxCourse>) request.getAttribute("studentxcourse");
    ArrayList<Course> listAllCourses =  (ArrayList<Course>) request.getAttribute("listAllCourses");
    ArrayList<Course> listCoursesDepartment = (ArrayList<Course>) request.getAttribute("listCoursesDepartment");
    ArrayList<Course> listAllTaken = (ArrayList<Course>) request.getAttribute("listAllTaken");
    ArrayList<Course> listNew = (ArrayList<Course>) request.getAttribute("listNew");
    ArrayList<Course> listTerm = (ArrayList<Course>) request.getAttribute("listTerm");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <title>URS</title>
        <script>
            function showHideDiv(id,id2,id3,id4){
  var obj = document.getElementById(id);
  var obj2 = document.getElementById(id2);
  var obj3 = document.getElementById(id3);
  
  var obj4 = document.getElementById(id4);
    if (obj.style.display=="none"){
      obj.style.display='block';
      obj2.style.display='none';
      obj3.style.display='none';
      
      obj4.style.display='block';
    } else if(obj.style.display=="block"){
      obj.style.display='none';
      obj2.style.display='block';
      obj3.style.display='block';
      
      obj4.style.display='none';
        }
}
            
        </script>
     </head>
    <body>
        <div class="header"></div>
        <div class="content">
        <h2>Welcome <%=student.getFname()%> </h2>
        <div class="profile">
            <img src="images/noPhoto.png" width="100px" height="100px"><br>
            Name: <%=student.getFname()%>&nbsp;<%=student.getLname()%><br>
            Major: <%=student.getMajor()%><br>
            Billing Information: <%=student.getBilling()%><br>
             <a href="/URSystem/servletweb?action=EditPasswordStudent&IdStudent=<%=student.getID()%>">Change Password</a><br>
      
            </div>
        <div class="actions">
            <form action="/URSystem/servletweb?action=AddCourseStudent&IdStudent=<%=student.getID()%>" method='post'>
             <h2>Courses Open:</h2> 
             <div id="linkMore" style="display: block">
                <a href="#" onclick="showHideDiv('allCourses','courseMajor','linkMore','linkLess')">See all courses</a>
             </div>
             <div id="linkLess" style="display: none">
                 <a href="#" onclick="showHideDiv('allCourses','courseMajor','linkMore','linkLess')">See courses from your major only</a>
             </div><br> 
             <div id="courseMajor" style="display: block"><% for (int i=0; i< listNew.size(); i++) {
                if(listNew.get(i).getDepartment().equals(student.getMajor())){%> 
                    <input type="radio" name="rd" value="<%=listNew.get(i).getID() %>"><%=listNew.get(i).getID() %> - <%=listNew.get(i).getName()%><br>
                <% }} %><br></div>
            <div id="allCourses" style="display: none">
                <% for (int i=0; i< listNew.size(); i++) {
                %> 
                    <input type="radio" name="rd" value="<%=listNew.get(i).getID() %>"><%=listNew.get(i).getID() %> - <%=listNew.get(i).getName()%><br>
                <% } %><br>
            </div>
            <button type="submit">Add Course</button>
            <br>
            
            </form>
            
           <h2>Courses you are registered for this semester</h2>
           
 
           <% if(listTerm.size()>0){ %>
                              <h3>Regular courses:</h3>
 
           <%    for (int i=0; i< listTerm.size(); i++) { 
           
                    if(i<4){
           %>
            <%=listTerm.get(i).getID()%> - <%=listTerm.get(i).getName()%><br>
             <%} else{ if(i==4){%>
             <h3>Extra courses:</h3><%}%>
            <%=listTerm.get(i).getID()%> - <%=listTerm.get(i).getName()%><br>
            
             <%}}} else{%>
             No courses to show.
             <% }%>
           <a href="addCourse.jsp">Add Course</a><br>
           <a href="deleteCourse.jsp">Drop Course</a><br><br>
        
            
           <!-- <h2>Courses you have taken: </h2>
            for (int i=0; i< studentxcourse.size(); i++) {%>
            studentxcourse.get(i).getIdCourse() %> - courseTaken.get(i).getName()%> - courseTaken.get(i).getTerm() %><br>
            <br>
            -->
        </div>
         </div>      
        <div class="footer"><a href="/URSystem/servletweb?action=Logout">Logout</a></div>
    </body>
</html>
