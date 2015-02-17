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
 * @author Leticia
 */
public class UpdatePasswordProfessor {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String password = request.getParameter("password");
            Integer id = Integer.parseInt(request.getParameter("IdProfessor"));
          
            Professor professor = ProfessorDAO.getById(id);
            professor.setPassword(password);
            Boolean update = ProfessorDAO.updatePassword(professor,password);
            if(update!=false)
                jsp = SeeInformationProfessor.execute(request);
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
