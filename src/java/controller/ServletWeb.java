/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.Connection;
/**
 *
 * @author Aldeide Brasil
 */
public class ServletWeb extends HttpServlet {
 private ServletContext sc;
    private String jsp = "";
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sc = config.getServletContext();
        Connection.conectar(sc.getInitParameter("url"), sc.getInitParameter("user"),
                sc.getInitParameter("password"), sc.getInitParameter("driver"));
    }
    
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
 @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        //Login
        if(action.equals("Login"))   {         
            jsp = Login.execute(request);
            if(jsp.equals("notFound")){
                request.setAttribute("ok", "notFound");
                jsp="/index.jsp";
            }
        }
        //Admin Action
         else if(action.equals("OpenPage")){
            try {
                jsp = OpenPage.execute(request, request.getSession());
            } catch (SQLException ex) {
                Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
         else if(action.equals("EditDateTerm"))
            try { 
                jsp = EditDateTerm.execute(request, request.getSession());
        } catch (ParseException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        } 
        else if(action.equals("InsertStudent"))
            jsp = InsertStudent.execute(request, request.getSession());
        else if(action.equals("DeleteStudent"))
            jsp = DeleteStudent.execute(request, request.getSession());
        else if(action.equals("EditStudent"))
            jsp = EditStudent.execute(request, request.getSession());
        else if(action.equals("UpdateStudent"))
            jsp = UpdateStudent.execute(request, request.getSession());
        else if(action.equals("InsertProfessor"))
            jsp = InsertProfessor.execute(request, request.getSession());
        else if(action.equals("DeleteProfessor"))
            jsp = DeleteProfessor.execute(request, request.getSession());
        else if(action.equals("EditProfessor"))
            jsp = EditProfessor.execute(request, request.getSession());
        else if(action.equals("UpdateProfessor"))
            jsp = UpdateProfessor.execute(request, request.getSession());
        else if(action.equals("InsertCourse"))
            jsp = InsertCourse.execute(request, request.getSession());
        else if(action.equals("EditCourse"))
            try {
                jsp = EditCourse.execute(request, request.getSession());
        } catch (SQLException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if(action.equals("DeleteCourse"))
            jsp = DeleteCourse.execute(request, request.getSession());
        else if(action.equals("UpdateCourse"))
            try {
                jsp = UpdateCourse.execute(request, request.getSession());
        } catch (SQLException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if(action.equals("UpdatePasswordAdmin")){
            jsp = UpdatePasswordAdmin.execute(request);
            if(jsp.equals("OK")){
                try {
                    jsp = OpenAdmin.executeAlert(request, request.getSession(),"OK");
                } catch (SQLException ex) {
                    Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(action.equals("OpenAdmin")){
            try {
                jsp = OpenAdmin.execute(request, request.getSession());
            } catch (SQLException ex) {
                Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        //Professot
        else if(action.equals("SeeCoursesProfessor"))
            jsp = ListCoursesProfessor.execute(request);
        else if(action.equals("SeeInformationProfessor"))
            jsp = SeeInformationProfessor.execute(request);
        else if(action.equals("EditPasswordProfessor"))
            jsp = EditPasswordProfessor.execute(request);
        else if(action.equals("UpdatePasswordProfessor")){
            jsp = UpdatePasswordProfessor.execute(request);
            if(jsp.equals("OK")){
                try {
                    jsp = OpenProfessor.executeAlert(request, request.getSession(),"OK");
                } catch (SQLException ex) {
                    Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(action.equals("OpenProfessor")){
            try {
                jsp = OpenProfessor.execute(request, request.getSession());
            } catch (SQLException ex) {
                Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        //Student
        else if(action.equals("OpenStudent")){
            try {
                jsp = OpenStudent.execute(request, request.getSession());
            } catch (SQLException ex) {
                Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        else if(action.equals("SeeInformationStudent"))
            jsp = SeeInformationStudent.execute(request);
        else if(action.equals("EditPasswordStudent"))
            jsp = EditPasswordStudent.execute(request);
        else if(action.equals("UpdatePasswordStudent")){
            jsp = UpdatePasswordStudent.execute(request);
            if(jsp.equals("OK")){
                try {
                    jsp = OpenStudent.executeAlert(request, request.getSession(),"OK");
                } catch (SQLException ex) {
                    Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(action.equals("SeeStudents"))
            jsp = SeeStudents.execute(request);
        else if(action.equals("AddCourseStudent"))
          try {
              jsp = AddCourseStudent.execute(request, request.getSession());
        } catch (SQLException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        }

        else if(action.equals("ListCoursesStudent"))
            jsp = ListCoursesStudent.execute(request);
        else if(action.equals("DropCourseStudent"))
            jsp = DropCourseStudent.execute(request);
        else if(action.equals("ListAllCoursesStudent"))
            jsp = ListAllCoursesStudent.execute(request);
         else if(action.equals("BillingInformation"))
            try {
                jsp = BillingInformation.execute(request, request.getSession());
        } catch (SQLException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if(action.equals("Logout"))
            jsp = Logout.execute(request);
       
      
           
        
        //
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    public void destroy() {
        Connection.destroy();
    }}
