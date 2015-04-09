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
public class UpdateProfessor {
     public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        try {
            // 
            int idOld = Integer.parseInt(request.getParameter("IdProfessor"));
            int id = Integer.parseInt(request.getParameter("id"));
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String title = request.getParameter("title");
         
            Professor professorOld = new Professor();
            if(id!=idOld){
                professorOld = ProfessorDAO.getById(idOld);
                System.out.println("PROF OLD"+professorOld.getFname());
                boolean deleteProfessor = ProfessorDAO.delete(professorOld);
                if(deleteProfessor){
                    Professor professorNew = new Professor();
                    professorNew.setID(id);
                    professorNew.setFname(fname);
                    professorNew.setLname(lname);
                    professorNew.setPassword(password);
                    professorNew.setTitle(title);
                    boolean createNew = ProfessorDAO.create(professorNew);
                    if(createNew){
                        jsp = ListProfessor.execute(request, session);
                    }
                    else{
                        String erro = "Error Update";
                        request.setAttribute("error", erro);
                        jsp = "/error.jsp";
                    }
                }
                else{
                String erro = "Error Update";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
            }else{
            professorOld.setID(id);
            professorOld.setFname(fname);
            professorOld.setLname(lname);
            professorOld.setPassword(password);
            professorOld.setTitle(title);
            Boolean update = ProfessorDAO.update(professorOld);
            if(update!=false)
                jsp = ListProfessor.execute(request, session);
            else{
                String erro = "Error Update";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
