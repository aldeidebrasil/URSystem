/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Student;
import javax.servlet.http.HttpServletRequest;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class EditPasswordStudent {
   public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String id = request.getParameter("IdStudent");
            System.out.println(id);
            Student student = StudentDAO.getById(Integer.parseInt(id));
            if(student != null){
                request.setAttribute("student",student);            
                jsp = "/updatePasswordStudent.jsp";
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
