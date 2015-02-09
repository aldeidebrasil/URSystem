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
public class EditProfessor {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String id = request.getParameter("id");
            Professor professor = ProfessorDAO.getById(Integer.parseInt(id));
            if(professor != null){
                request.setAttribute("professor",professor);            
                jsp = "/updateProfessor.jsp";
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
