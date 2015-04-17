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
public class InsertStudent {

    static String execute(HttpServletRequest request, HttpSession session) {        
        
        String error="";        
        String jsp="";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        Integer id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("password");
        String major = request.getParameter("major");
        Double billing = Double.parseDouble(request.getParameter("billing"));
       
        Student student = new Student(); 
        
        
        try {
           student.setID(id);
           student.setFname(fname);
           student.setLname(lname);
           student.setPassword(password);
           student.setMajor(major);
           student.setBilling(billing);
           Boolean create = StudentDAO.create(student);
            if(create != false){
                jsp = ListStudents.execute(request, session);
               
            }else{
                request.setAttribute("admin", admin);
                String erro = "Error during the operation: Insert Student";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
        } catch (Exception e) {
          
            String erro = "Error during the operation: Insert Student";
            request.setAttribute("error", erro);
            jsp = "/errorAdmin.jsp";
            }
        return jsp;
    
}

    
}
