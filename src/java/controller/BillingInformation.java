/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.Student;
import controller.vo.StudentxCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class BillingInformation {
     public static String execute(HttpServletRequest request, HttpSession session) throws SQLException {
        String jsp = "";
        String erro = "";
        double bill = 0;
        Integer idStudent = Integer.parseInt(request.getParameter("IdStudent"));
        Student student = StudentDAO.getById(idStudent);
        String year = ""+Calendar.getInstance().get(Calendar.YEAR);
        ArrayList <Course> listCourse = new ArrayList<>();
        ArrayList <StudentxCourse> studentxcourse = StudentxCourseDAO.getBySemester(VerifyTerm.execute(), idStudent, year);
        
        if(studentxcourse != null){
            for(int i=0; i<studentxcourse.size(); i++){
                        Course courseTerm = CourseDAO.getByIdStatus(studentxcourse.get(i).getIdCourse());
                        if(courseTerm!=null){
                            listCourse.add(courseTerm);
                        }
                
                }
        }
            if(listCourse!=null){
              bill = CalcBilling.execute(listCourse, session);
            
            request.setAttribute("student", student);
            request.setAttribute("listCourse", listCourse);
            request.setAttribute("billing", bill);
            jsp = "/billingInformation.jsp";
            }else{
                erro = "You do not have any registration for this semester";
            request.setAttribute("student", student);
            request.setAttribute("error", erro );
            jsp = "/error.jsp";
        }
          return jsp;
    }
}
