/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProfessorDAO;
import model.AdminDAO;
import model.StudentDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aldeide Brasil
 */
public class Login {
    @SuppressWarnings("static-access")
    public static String execute(HttpServletRequest request) {        
        
        String error="";        
        String jsp="";        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
       
        Student usr = new Student();
        StudentDAO usrDAO = new StudentDAO();        
        try {
            usr = usrDAO.getStudentLogin(login, password);
            if(usr == null){
                Professor prof = new Professor();
                ProfessorDAO profDAO = new ProfessorDAO();        
                try{
                    prof = profDAO.getProfessorLogin(login,password);
                    if(prof== null){
                    Admin adm = new Admin();
                    AdminDAO admDAO = new AdminDAO();
                    try{
                    adm = admDAO.getAdminLogin(login,password);
                    if(adm == null){
                        error="User not found!";
                        request.setAttribute("error", error);
                        jsp = "/error.jsp";
                    }else{
                        //request.setAttribute("fname", usr.getFname());
                        jsp = "/welcome.jsp";
                    }
                    }catch (Exception e) {
                    e.printStackTrace();
                    jsp = "";
                    }

                    }else{
                        request.setAttribute("lname", prof.getTitle() + " " + prof.getLname());
                        jsp = "/welcomeProfessor.jsp";
                    }
            
                }catch (Exception e) {
                e.printStackTrace();
                jsp = "";
                }               
            }               
            else{  
                request.setAttribute("fname", usr.getFname());
                jsp = "/welcome.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;        
     }
    
    public static void validarSessao(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Integer codUsuario = (Integer) request.getSession().getAttribute("codUsuario");
        String jsp="";
        if(codUsuario == null ){
            jsp = "/index.jsp";
             //Redirecionando pagina
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }        
    }
}
