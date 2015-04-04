/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class OpenAdmin {
     static String execute(HttpServletRequest request, HttpSession session) throws SQLException {
                        
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        request.setAttribute ("admin", admin);
        return "/welcomeAdmin.jsp";
    } 

    static String executeAlert(HttpServletRequest request, HttpSession session, String confirm) throws SQLException {
                        
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        
        request.setAttribute ("admin", admin);
        request.setAttribute("ok", confirm);
        return "/welcomeAdmin.jsp";
    }
    
}
