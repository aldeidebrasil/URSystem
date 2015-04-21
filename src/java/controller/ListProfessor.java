/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Professor;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.ProfessorDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class ListProfessor {
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ArrayList<Professor> listProfessor = ProfessorDAO.getAll();
            if(listProfessor != null){
                request.setAttribute("listProfessor", listProfessor);
                jsp = "/allProfessors.jsp";    
            }else{
                String erro="There is no Professors to show!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
                
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
         Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        try {
            ArrayList<Professor> listProfessor = ProfessorDAO.getAll();
            if(listProfessor != null){
                request.setAttribute("admin", admin);
                request.setAttribute("listProfessor", listProfessor);
                jsp = "/allProfessors.jsp";    
            }else{
                request.setAttribute("admin", admin);
                String erro="There is no Professors to show!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
                
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("admin", admin);
                String erro="There is no Professors to show!";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
        return jsp;
    }
}
