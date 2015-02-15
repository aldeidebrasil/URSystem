/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
       // String id = request.getParameter("id");
        
        StudentxCourse studentxcourse = new StudentxCourse();  
        try {
           //studentxcourse.setID(id);
           Boolean create = StudentxCourseDAO.create(studentxcourse);
            if(create != false){
                jsp = ListCourses.execute(request);
               
            }else{
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
