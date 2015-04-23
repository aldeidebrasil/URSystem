/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.Student;
import controller.vo.StudentxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class DropCourseStudent {

    static String execute(HttpServletRequest request) {
        String jsp = "";
        try {

            String id = request.getParameter("IdCourse");
            int idStudent = Integer.parseInt(request.getParameter("IdStudent"));
            Student student = StudentDAO.getById(idStudent);
            request.setAttribute("student", student);
            if(VerifyTermDate.execute(VerifyTerm.execute())){
       
            StudentxCourse studentxcourse = StudentxCourseDAO.getByIdCourseStudent(id, idStudent);
            Course course = CourseDAO.getById(id);
           if(studentxcourse!=null){
            boolean delete = StudentxCourseDAO.delete(studentxcourse);
            if(delete != false){
                course.setStatus("open");
                CourseDAO.updateStatus(course);
                jsp = ListCoursesStudent.execute(request);
                
            }else{
                String erro = "An error occurred during the operation Unregister Course!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }}
           else{
           String erro = "An error occurred during the operation Unregister Course!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
           }}
            else{
            String erro = "Sorry! You cannot change your schedule anymore.";
            request.setAttribute("error", erro);
            jsp = "/error.jsp";
        }
        } catch (Exception e) {
            e.printStackTrace();
            }
        return jsp;
    
    }
    
}
