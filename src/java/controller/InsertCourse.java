/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.ProfessorxCourse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.ProfessorDAO;
import model.ProfessorxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class InsertCourse {
    static String execute(HttpServletRequest request, HttpSession session) {        
        
        String error="";        
        String jsp=""; 
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String prerequisite = request.getParameter("prerequisite");
        if(prerequisite.isEmpty()){
            prerequisite=null;
        }
        Double value =Double.valueOf(request.getParameter("val"));
        Integer idTerm = Integer.parseInt(request.getParameter("idTerm"));
        String status = request.getParameter("status");
        Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
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
           
           Boolean create = CourseDAO.create(course);
           if(create != false){
               professorxcourse.setIdCourse(course.getID());
               professorxcourse.setIdProfessor(idProfessor);
              if(ProfessorxCourseDAO.create(professorxcourse)){
                 jsp = ListCourses.execute(request, session);
                }else{
                String erro = "ERROR!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
            }else{
                String erro = "ERROR!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    
}
}
