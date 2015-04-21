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
public class EditStudent {
      public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        try {
            String id = request.getParameter("id");
            Student student = StudentDAO.getById(Integer.parseInt(id));
            ArrayList<Integer> students = StudentDAO.getAllId();
            if(student != null){
                request.setAttribute("admin", admin);
                request.setAttribute("student",student);
                request.setAttribute("students", students);
                jsp = "/updateStudent.jsp";
            }else{
                request.setAttribute("admin", admin);
                String erro = "An error occurred during the operation Edit Student";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("admin", admin);
            String erro = "An error occurred during the operation Edit Student";
            request.setAttribute("error", erro);
            jsp = "/errorAdmin.jsp";
        }
        return jsp;
    }

    
    
}
