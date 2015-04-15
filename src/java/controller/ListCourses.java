/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Course;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.CourseDAO;

/**
 *
 * @author Leticia
 */
public class ListCourses {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
            
        try {
            ArrayList<Course> listCourse = CourseDAO.getAll();
            if(listCourse != null){
                request.setAttribute("listCourse", listCourse);
                jsp = "/allCourses.jsp";    
            }else{
                String erro="There is no courses to show!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
            
        try {
            ArrayList<Course> listCourse = CourseDAO.getAll();
            if(listCourse != null){
                request.setAttribute("admin", admin);
                request.setAttribute("listCourse", listCourse);
                jsp = "/allCourses.jsp";    
            }else{
                request.setAttribute("admin", admin);
                String erro="There is no courses to show!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("admin", admin);
                String erro="There is no courses to show!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
        }
        return jsp;
    }
}
