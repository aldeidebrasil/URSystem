/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import model.ProfessorDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdateProfessor {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            // 
            String id = request.getParameter("id");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String title = request.getParameter("title");
         
            Professor professor = new Professor();
            professor.setID(Integer.parseInt(id));
            professor.setFname(fname);
            professor.setLname(lname);
            professor.setPassword(password);
            professor.setTitle(title);
            Boolean update = ProfessorDAO.update(professor);
            if(update!=false)
                jsp = ListProfessor.execute(request);
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
