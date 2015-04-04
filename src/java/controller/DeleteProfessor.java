/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Professor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.ProfessorDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class DeleteProfessor {
    public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        try {

            String id = request.getParameter("id");
            Professor professor = ProfessorDAO.getById(Integer.parseInt(id));                            
            boolean delete = ProfessorDAO.delete(professor);
            if(delete != false){
                jsp = ListProfessor.execute(request, session);
            }else{
                String erro = "An error occurred!";
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
