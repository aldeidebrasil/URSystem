/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class OpenPage {

    static String execute(HttpServletRequest request, HttpSession session) {
        String page = request.getParameter("page");
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        request.setAttribute("admin", admin);
        return "/"+page+".jsp";
    }
    
}
