/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.StudentxCourse;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class AddCourseStudent {
     public static String execute(HttpServletRequest request) {
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
        return jsp;
    
    }
}
