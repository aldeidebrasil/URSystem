/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aldeide Brasil
 */
public class Logout {
    public static String execute(HttpServletRequest request) {        
        HttpSession session = request.getSession(false);
        session.removeAttribute("userid");
        return "/index.jsp";
    }
}
