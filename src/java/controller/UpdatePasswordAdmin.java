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
            System.out.println("OKKK");
            Admin admin = AdminDAO.getById(id);
            Boolean update = AdminDAO.updatePassword(admin,password);
            if(update!=false)
                jsp = "OK";    
            else{
                String erro = "Error Update";
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
