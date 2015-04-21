/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Student;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdatePasswordStudent {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String password = request.getParameter("password");
            Integer id = Integer.parseInt(request.getParameter("IdStudent"));
          
            Student student = StudentDAO.getById(id);
            Boolean update = StudentDAO.updatePassword(student,password);
            if(update!=false){
                jsp = "OK";
            }
               // jsp = SeeInformationStudent.execute(request);
            else{
                request.setAttribute("student", student);
                String erro = "Error during the operation Update Password";
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
