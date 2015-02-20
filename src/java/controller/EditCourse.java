/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;

/**
 *
 * @author CMarcelo
 */
public class EditCourse {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String id = request.getParameter("id");
            Course course = CourseDAO.getById(id);
            if(course != null){
                request.setAttribute("course",course);            
                jsp = "/updateCourse.jsp";
            }else{
                String erro = "Error";
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
