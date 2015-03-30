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
public class ListAllCoursesStudent {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        Integer idStudent = Integer.parseInt(request.getParameter("IdStudent"));
        String year = ""+Calendar.getInstance().get(Calendar.YEAR);
        try {
            ArrayList<StudentxCourse> listCoursesStudent = StudentxCourseDAO.getByIdStudent(idStudent);
            ArrayList<Course> listCourse = new ArrayList<>();
            Student student = StudentDAO.getById(idStudent);
            if(listCoursesStudent != null){
                for(int i=0; i<listCoursesStudent.size(); i++){
                    if(!listCoursesStudent.get(i).getYear().equals(year)){
                        Course course = CourseDAO.getById(listCoursesStudent.get(i).getIdCourse());
                        listCourse.add(course);
                    }
                }
                request.setAttribute("student", student);
                request.setAttribute("listCourse", listCourse);
                jsp = "/allCoursesStudent.jsp";    
                
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
