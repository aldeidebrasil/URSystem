/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class EditStudent {
      public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        try {
            Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
            String id = request.getParameter("id");
            Student student = StudentDAO.getById(Integer.parseInt(id));
            if(student != null){
                request.setAttribute("admin", admin);
                request.setAttribute("student",student);            
                jsp = "/updateStudent.jsp";
            }else{
                String erro = "Error";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    
    
}
