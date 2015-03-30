/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
        if(action.equals("Login"))   {         
            jsp = Login.execute(request);
        if(jsp.equals("notFound")){
            request.setAttribute("ok", "notFound");
            jsp="/index.jsp";
        }
        }
        else if(action.equals("InsertStudent"))
            jsp = InsertStudent.execute(request);
        else if(action.equals("DeleteStudent"))
            jsp = DeleteStudent.execute(request);
        else if(action.equals("EditStudent"))
            jsp = EditStudent.execute(request);
        else if(action.equals("UpdateStudent"))
            jsp = UpdateStudent.execute(request);
        else if(action.equals("InsertProfessor"))
            jsp = InsertProfessor.execute(request);
        else if(action.equals("DeleteProfessor"))
            jsp = DeleteProfessor.execute(request);
        else if(action.equals("EditProfessor"))
            jsp = EditProfessor.execute(request);
        else if(action.equals("UpdateProfessor"))
            jsp = UpdateProfessor.execute(request);
        else if(action.equals("InsertCourse"))
            jsp = InsertCourse.execute(request);
        else if(action.equals("SeeCoursesProfessor"))
            jsp = ListCoursesProfessor.execute(request);
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
        else if(action.equals("SeeInformationProfessor"))
            jsp = SeeInformationProfessor.execute(request);
        else if(action.equals("EditPasswordProfessor"))
            jsp = EditPasswordProfessor.execute(request);
        else if(action.equals("UpdatePasswordProfessor"))
            jsp = UpdatePasswordProfessor.execute(request);
        else if(action.equals("SeeStudents"))
            jsp = SeeStudents.execute(request);
        else if(action.equals("AddCourseStudent"))
          try {
              jsp = AddCourseStudent.execute(request);
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
                jsp = BillingInformation.execute(request);
        } catch (SQLException ex) {
            Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if(action.equals("Logout"))
            jsp = Logout.execute(request);
       else if(action.equals("EditCourse"))
            jsp = EditCourse.execute(request);
        else if(action.equals("DeleteCourse"))
            jsp = DeleteCourse.execute(request);
        else if(action.equals("UpdateCourse"))
            jsp = UpdateCourse.execute(request);
        else if(action.equals("OpenStudent")){
            try {
                jsp = OpenStudent.execute(request, request.getSession());
            } catch (SQLException ex) {
                Logger.getLogger(ServletWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
            
        
        //
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    public void destroy() {
        Connection.destroy();
    }}
