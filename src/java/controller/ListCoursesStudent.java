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
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
class ListCoursesStudent {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        Integer idStudent = Integer.parseInt(request.getParameter("IdStudent"));
        String year = ""+Calendar.getInstance().get(Calendar.YEAR);
        try {
            ArrayList<StudentxCourse> listCoursesStudent = StudentxCourseDAO.getBySemester(VerifyTerm.execute(), idStudent, year);
            ArrayList<Course> listCourses = new ArrayList<>();
            Student student = StudentDAO.getById(idStudent);
            if(listCoursesStudent != null){
                for(int i=0; i<listCoursesStudent.size(); i++){
                    Course course = CourseDAO.getByIdStatus(listCoursesStudent.get(i).getIdCourse());
                    if(course!=null){
                     listCourses.add(course);
                    }
                    
                }
                request.setAttribute("student", student);
                request.setAttribute("listCourses", listCourses);
                jsp = "/listCourseStudent.jsp";    
                
            }else{
                String erro="There is no courses to show!";
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
