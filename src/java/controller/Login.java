/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.StudentxCourse;
import controller.vo.ProfessorxCourse;
import controller.vo.Admin;
import controller.vo.Professor;
import controller.vo.Student;
import controller.vo.Course;
import model.ProfessorDAO;
import model.AdminDAO;
import model.StudentDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CourseDAO;
import model.StudentxCourseDAO;
import model.ProfessorxCourseDAO;

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
        HttpSession session = request.getSession(true);
        
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
                        session.setAttribute("userid",adm.getID());
                        jsp = "/welcomeAdmin.jsp";
                    }
                    }catch (Exception e) {
                    e.printStackTrace();
                    jsp = "";
                    }

                    }else{
                        session.setAttribute("userid",prof.getID());
                        jsp = OpenProfessor.execute(request,session);
                    }
            
                }catch (Exception e) {
                e.printStackTrace();
                jsp = "";
                }               
            }               
            else{ 
                session.setAttribute("userid",usr.getID());
                jsp = OpenStudent.execute(request,session);
               }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;        
     }
    
}
