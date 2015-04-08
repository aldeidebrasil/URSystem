/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.StudentxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;
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
            StudentxCourse studentxcourse = StudentxCourseDAO.getByIdCourseStudent(id, idStudent);
            Course course = CourseDAO.getById(id);
           if(studentxcourse!=null){
            boolean delete = StudentxCourseDAO.delete(studentxcourse);
            if(delete != false){
                course.setStatus("open");
                CourseDAO.updateStatus(course);
                jsp = ListCoursesStudent.execute(request);
                
            }else{
                String erro = "An error occurred!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }}
           else{
           String erro = "Student does not exist";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
           }
        } catch (Exception e) {
            e.printStackTrace();
            }
        return jsp;
    
    }
    
}
