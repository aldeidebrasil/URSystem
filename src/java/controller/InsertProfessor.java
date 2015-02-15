/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Professor;
import javax.servlet.http.HttpServletRequest;
import model.ProfessorDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class InsertProfessor {
    static String execute(HttpServletRequest request) {        
        
        String error="";        
        String jsp=""; 
        Integer id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("password");
        String title = request.getParameter("title");
       
        Professor professor = new Professor();  
        try {
           professor.setID(id);
           professor.setFname(fname);
           professor.setLname(lname);
           professor.setPassword(password);
           professor.setTitle(title);
                    
            Boolean create = ProfessorDAO.create(professor);
            if(create != false){
                jsp = ListProfessor.execute(request);
               
            }else{
                String erro = "ERROR!";
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
