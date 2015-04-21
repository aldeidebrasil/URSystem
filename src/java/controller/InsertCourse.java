/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Course;
import controller.vo.ProfessorxCourse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.CourseDAO;
import model.ProfessorDAO;
import model.ProfessorxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class InsertCourse {
    static String execute(HttpServletRequest request, HttpSession session) {        
          Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
      
        String error="";        
        String jsp=""; 
        String id = request.getParameter("id");
        
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String prerequisite = request.getParameter("prerequisite");
        if(prerequisite==null || prerequisite.isEmpty()){
            prerequisite=null;
        }
        Double value =Double.valueOf(request.getParameter("val"));
        Integer idTerm = Integer.parseInt(request.getParameter("idTerm"));
        String status = request.getParameter("status");
        String year = request.getParameter("year");
        Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
        Course verifyCourse = CourseDAO.getById(id);
        if(verifyCourse==null){
        Course course = new Course();  
        ProfessorxCourse professorxcourse = new ProfessorxCourse();
        try {
            
           course.setID(id);
           course.setName(name);
           course.setDepartment(department);
           course.setPrerequisite(prerequisite);
           course.setValue(value);
           course.setIdTerm(idTerm);
           course.setStatus(status);
           course.setYear(year);
           
           Boolean create = CourseDAO.create(course);
           if(create != false){
               professorxcourse.setIdCourse(course.getID());
               professorxcourse.setIdProfessor(idProfessor);
               professorxcourse.setIdTerm(course.getIdTerm());
               professorxcourse.setYear(year);
               int countCourses = ProfessorxCourseDAO.countCourseByProfessor(idProfessor, idTerm, year);
               if(countCourses<=3){
                    if(ProfessorxCourseDAO.create(professorxcourse)){
                       jsp = ListCourses.execute(request, session);
                      }else{
                         request.setAttribute("admin", admin);
      
                String erro = "An error occurred during the operation Insert Course!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
               }
                else{
                     request.setAttribute("admin", admin);
                    String erro = "The professor "+ idProfessor+" is going to teach 3 courses ";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                 }

            }else{
                request.setAttribute("admin", admin);
      
                String erro = "An error occurred during the operation Insert Course!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
        
        } catch (Exception e) {
            e.printStackTrace();
             request.setAttribute("admin", admin);
      
                 String erro = "This course already exists!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
        }
        }else{
                request.setAttribute("admin", admin);
      
                 String erro = "This course already exists!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
         }
        return jsp;
    
}
}
