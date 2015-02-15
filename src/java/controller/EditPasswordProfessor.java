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
public class EditPasswordProfessor {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String id = request.getParameter("IdProfessor");
            Professor professor = ProfessorDAO.getById(Integer.parseInt(id));
            if(professor != null){
                request.setAttribute("professor", professor);            
                jsp = "/updatePasswordProfessor.jsp";
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
