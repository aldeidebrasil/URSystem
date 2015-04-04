/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdateStudent {
      public static String execute(HttpServletRequest request,  HttpSession session) {
        String jsp = "";
        try {
            // 
            String id = request.getParameter("id");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String major = request.getParameter("major");
         
            Student student = new Student();
            student.setID(Integer.parseInt(id));
            student.setFname(fname);
            student.setLname(lname);
            student.setPassword(password);
            student.setMajor(major);
            Boolean update = StudentDAO.update(student);
            if(update!=false)
                jsp = ListStudents.execute(request, session);
            else{
                String erro = "Error Update";
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
