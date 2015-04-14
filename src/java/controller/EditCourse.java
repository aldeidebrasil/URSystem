/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Course;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.CourseDAO;

/**
 *
 * @author CMarcelo
 */
public class EditCourse {
    public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        try {
            String id = request.getParameter("id");
            Course course = CourseDAO.getById(id);
            if(course != null){
                request.setAttribute("admin", admin);
                request.setAttribute("course",course);            
                jsp = "/updateCourse.jsp";
            }else{
                request.setAttribute("admin", admin);
                String erro = "Error";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
                
        } catch (Exception e) {
            e.printStackTrace();
             request.setAttribute("admin", admin);
                String erro = "Error";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
        return jsp;
    }
}
