/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Term;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.TermDAO;

/**
 *
 * @author Aldeide Brasil
 */
class ListTerm {
    static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        try {
            Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
            ArrayList<Term> listTerm = TermDAO.getAll();
            if(listTerm != null){
                request.setAttribute("admin", admin);
                request.setAttribute("listTerm", listTerm);
                jsp = "/allTerm.jsp";    
            }else{
                String erro="There is no Terms to show!";
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
