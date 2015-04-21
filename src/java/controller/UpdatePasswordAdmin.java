/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import javax.servlet.http.HttpServletRequest;
import model.AdminDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdatePasswordAdmin {
    static String execute(HttpServletRequest request){
        String jsp = "";
        try {
            String password = request.getParameter("password");
            String id = request.getParameter("IdAdmin");
            Admin admin = AdminDAO.getById(id);
            Boolean update = AdminDAO.updatePassword(admin,password);
            if(update!=false)
                jsp = "OK";    
            else{
                request.setAttribute("admin", admin);
                String erro = "Error during the operation Change Password";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}

