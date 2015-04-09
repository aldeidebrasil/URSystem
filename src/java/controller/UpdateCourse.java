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
import model.ProfessorxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdateCourse {
     public static String execute(HttpServletRequest request,HttpSession session) {
        String jsp = "";
        try {
            // 
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String department = request.getParameter("department");
            String prerequisite = request.getParameter("prerequisite");
            if(prerequisite.isEmpty()){
                prerequisite=null;
            }
            Double value = Double.parseDouble(request.getParameter("value"));
            Integer idTerm = Integer.parseInt(request.getParameter("idTerm"));
            String status = request.getParameter("status");
            Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
           
            ProfessorxCourse professorxcourseOld = new ProfessorxCourse();
            professorxcourseOld = ProfessorxCourseDAO.getByIdCourse(id);
            Course course = new Course();
            course.setID(id);
            course.setName(name);
            course.setDepartment(department);
            course.setPrerequisite(prerequisite);
            course.setValue(value);
            course.setIdTerm(idTerm);
            course.setStatus(status);
            
            Boolean update = CourseDAO.update(course);
            if(update!=false){
               ProfessorxCourse professorxcourseNew = new ProfessorxCourse();
                professorxcourseNew.setIdCourse(course.getID());
                professorxcourseNew.setIdProfessor(idProfessor);
                if(ProfessorxCourseDAO.updateByCourse(professorxcourseNew, professorxcourseOld.getIdCourse())){
                jsp = ListCourses.execute(request, session);
                }
                else{
                String erro = "Error Update";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
            }else{
                String erro = "Error Update";
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
