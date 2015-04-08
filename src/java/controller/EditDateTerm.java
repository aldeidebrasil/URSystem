/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Term;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.TermDAO;

/**
 *
 * @author Aldeide Brasil
 */
class EditDateTerm {

    static String execute(HttpServletRequest request,  HttpSession session) throws ParseException {
        String jsp = "";
        
        String dateStart= request.getParameter("termDate");
        String dateLimit= request.getParameter("dateLimit");
        String dateEnd= request.getParameter("dateEnd");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dS = formatter.parse(dateStart); 
        Date dL = formatter.parse(dateLimit); 
        Date dF = formatter.parse(dateEnd); 
        
        int idTerm = Integer.parseInt(request.getParameter("term"));
        Term term = TermDAO.getTerm(idTerm);
        java.sql.Date sqlDateStart = new java.sql.Date(dS.getTime());
        term.setDateStart(sqlDateStart);
        java.sql.Date sqlDateLimit = new java.sql.Date(dL.getTime());
        term.setDateLimit(sqlDateLimit);
        java.sql.Date sqlDateEnd = new java.sql.Date(dF.getTime());
        term.setDateEnd(sqlDateEnd);
        
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        request.setAttribute("admin", admin);
        if(TermDAO.update(term)==true){
            jsp=ListTerm.execute(request, session);
        }else{
            System.out.println("NOT OK");
             String erro = "ERRO - NAO ATUALIZOU";
            request.setAttribute("error", erro);
            jsp = "/error.jsp";
        }
        return jsp;
    }
    
}
