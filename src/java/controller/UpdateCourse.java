/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Course;
import controller.vo.ProfessorxCourse;
import controller.vo.StudentxCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.CourseDAO;
import model.ProfessorxCourseDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdateCourse {
     public static String execute(HttpServletRequest request,HttpSession session) throws SQLException {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        
        try {
            // 
            String id = request.getParameter("id");
            String idOld = request.getParameter("IdCourse");
            String name = request.getParameter("name");
            String department = request.getParameter("department");
            String prerequisite = request.getParameter("prerequisite");
            if(prerequisite.isEmpty()){
                prerequisite=null;
            }
            Double value = Double.parseDouble(request.getParameter("value"));
            Integer idTerm = Integer.parseInt(request.getParameter("idTerm"));
            String status = request.getParameter("status");
            String year = request.getParameter("year");
            Integer idProfessor = Integer.parseInt(request.getParameter("idProfessor"));
           
            if(id!=idOld){
                Course course = CourseDAO.getById(idOld);
                ProfessorxCourse professorxcourseOld = ProfessorxCourseDAO.getByIdCourse(idOld);
                ArrayList<StudentxCourse> studentxcourseOld = StudentxCourseDAO.getByIdCourse(idOld);
                if(professorxcourseOld!=null){
                    ProfessorxCourseDAO.delete(professorxcourseOld);
                }
                if(studentxcourseOld!=null){
                    for(int i=0; i<studentxcourseOld.size();i++){
                        StudentxCourseDAO.delete(studentxcourseOld.get(i));
                    }
                }
                ArrayList<Course> listPrerequisite = CourseDAO.getAllPrerequisite(idOld);
                if(listPrerequisite!=null){
                for(int i=0; i<listPrerequisite.size();i++){
                    listPrerequisite.get(i).setPrerequisite(null);
                    CourseDAO.update(listPrerequisite.get(i));
                }}
                    if(CourseDAO.delete(course)){
                        Course courseNew = new Course();
                        courseNew.setID(id);
                        courseNew.setName(name);
                        courseNew.setDepartment(department);
                        courseNew.setPrerequisite(prerequisite);
                        courseNew.setValue(value);
                        courseNew.setIdTerm(idTerm);
                        courseNew.setStatus(status);
                        courseNew.setYear(year);
                        if(CourseDAO.create(courseNew)){
                            if(listPrerequisite!=null){
                            for(int i=0; i<listPrerequisite.size(); i++){
                                listPrerequisite.get(i).setPrerequisite(prerequisite);
                                CourseDAO.update(courseNew);
                            }
                            }
                            boolean createStudentCourse=false;
                            ProfessorxCourse professorxcourseNew = new ProfessorxCourse();
                            professorxcourseNew.setIdCourse(id);
                            professorxcourseNew.setIdProfessor(idProfessor);
                           if(studentxcourseOld!=null){
                               
                            for(int i=0; i<studentxcourseOld.size();i++){
                            StudentxCourse studentxcourseNew = new StudentxCourse();
                            studentxcourseNew.setIdCourse(id);
                            studentxcourseNew.setIdStudent(studentxcourseOld.get(i).getIdStudent());
                            studentxcourseNew.setIdTerm(studentxcourseOld.get(i).getIdTerm());
                            studentxcourseNew.setYear(studentxcourseOld.get(i).getYear());
                            studentxcourseNew.setIdCourse(id);
                            createStudentCourse = StudentxCourseDAO.create(studentxcourseNew);
                            }
                           }
                               
                             jsp = ListCourses.execute(request, session);
                  
                           } else{
                            String erro = "Error Update";
                            request.setAttribute("admin", admin);
                           
                            request.setAttribute("error", erro);
                            jsp = "/errorAdmin.jsp";
                        }
                        }
                        
                    }
                    
                
            
            
            
            
            ProfessorxCourse professorxcourseOld = new ProfessorxCourse();
            professorxcourseOld = ProfessorxCourseDAO.getByIdCourse(idOld);
            Course course = new Course();
            course.setID(id);
            course.setName(name);
            course.setDepartment(department);
            course.setPrerequisite(prerequisite);
            course.setValue(value);
            course.setIdTerm(idTerm);
            course.setStatus(status);
            course.setYear(year);
            
            Boolean update = CourseDAO.update(course);
            if(update!=false){
               ProfessorxCourse professorxcourseNew = new ProfessorxCourse();
                professorxcourseNew.setIdCourse(course.getID());
                professorxcourseNew.setIdProfessor(idProfessor);
                professorxcourseNew.setIdTerm(course.getIdTerm());
                professorxcourseNew.setYear(year);
                if(professorxcourseOld!=null){
                    if(ProfessorxCourseDAO.updateByCourse(professorxcourseNew, professorxcourseOld.getIdCourse())){
                     jsp =  ListCourses.execute(request, session);
                    }
                    
                else{
                    request.setAttribute("admin", admin);
                     String erro = "Error Update 134";
                    request.setAttribute("error", erro);
                    jsp = "/errorAdmin.jsp";
                }
                }
                else{
                    if(ProfessorxCourseDAO.create(professorxcourseNew)){
                        jsp =  ListCourses.execute(request, session);
                    }else{
                        request.setAttribute("admin", admin);
                        String erro = "Error Update 148";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                    }
                }
            }else{
                request.setAttribute("admin", admin);
                String erro = "Error Update 155";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
            
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("admin", admin);
                String erro = "Error Update 147";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
        return jsp;
    }
}
