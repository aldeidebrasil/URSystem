/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Student;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class ListStudents {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Student> listStudents = StudentDAO.getAll();
            if(listStudents != null){
                 request.setAttribute("listStudents", listStudents);
                jsp = "/allStudents.jsp";    
            }else{
                String erro="There is no Students to show!";
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
            ArrayList<Student> listStudents = StudentDAO.getAll();
            if(listStudents != null){
            request.setAttribute("admin", admin);
            request.setAttribute("listStudents", listStudents);
                jsp = "/allStudents.jsp";    
            }else{
                 request.setAttribute("admin", admin);
                String erro="There is no Students to show!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
                
            
        } catch (Exception e) {
            e.printStackTrace();
             request.setAttribute("admin", admin);
           
            String erro="There is no Students to show! 60";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
           
        }
        return jsp;
    }
}
