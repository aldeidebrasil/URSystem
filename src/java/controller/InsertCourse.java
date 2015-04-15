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
        if(prerequisite==null || prerequisite.isEmpty()){
            prerequisite=null;
        }
        Double value =Double.valueOf(request.getParameter("val"));
        Integer idTerm = Integer.parseInt(request.getParameter("idTerm"));
        String status = request.getParameter("status");
        String year = request.getParameter("year");
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
           course.setYear(year);
           
           Boolean create = CourseDAO.create(course);
           if(create != false){
               professorxcourse.setIdCourse(course.getID());
               professorxcourse.setIdProfessor(idProfessor);
               professorxcourse.setIdTerm(course.getIdTerm());
               professorxcourse.setYear(year);
               int countCourses = ProfessorxCourseDAO.countCourseByProfessor(idProfessor, idTerm, year);
               if(countCourses<=4){
                    if(ProfessorxCourseDAO.create(professorxcourse)){
                       jsp = ListCourses.execute(request, session);
                      }else{
                String erro = "ERROR!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
               }
                else{
                        String erro = "The professor "+ idProfessor+" is going to teach 4 courses ";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                 }

            }else{
                String erro = "ERROR!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    
}
}
