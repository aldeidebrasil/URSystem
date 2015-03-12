/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.StudentxCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class AddCourseStudent {
     public static String execute(HttpServletRequest request) throws SQLException {
     String error="";        
        String jsp=""; 
        String idCourse = request.getParameter("rd");
        String idStudent = request.getParameter("IdStudent");
        StudentxCourse studentxcourse = new StudentxCourse();  
        try {
           studentxcourse.setIdCourse(idCourse);
           studentxcourse.setIdStudent(Integer.parseInt(idStudent));
           studentxcourse.setIdTerm(VerifyTerm.execute());
           studentxcourse.setYear(""+Calendar.getInstance().get(Calendar.YEAR));
           Boolean create = StudentxCourseDAO.create(studentxcourse);
            if(create == false){
                String erro = "ERROR!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        String year = ""+Calendar.getInstance().get(Calendar.YEAR);
        ArrayList<Course> listCourse = new ArrayList<>();
        ArrayList<StudentxCourse> studentxcourseList = StudentxCourseDAO.getBySemester(VerifyTerm.execute(), Integer.parseInt(idStudent),year);
        for(int i=0; i<studentxcourseList.size();i++){
            Course course = CourseDAO.getById(studentxcourseList.get(i).getIdCourse());
            listCourse.add(course);
        }
        request.setAttribute("listCourse", listCourse);
        return "allCoursesStudent.jsp";
    
    }
}
