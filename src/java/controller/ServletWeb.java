/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        if(action.equals("Login"))            
            jsp = Login.execute(request);
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
        else if(action.equals("SeeCoursesStudent"))
            jsp = ListCoursesStudent.execute(request);
        else if(action.equals("SeeInformationStudent"))
            jsp = SeeInformationStudent.execute(request);
        else if(action.equals("EditPasswordStudent"))
            jsp = EditPasswordStudent.execute(request);
        else if(action.equals("UpdatePasswordStudent"))
            jsp = UpdatePasswordStudent.execute(request);
        else if(action.equals("UpdatePasswordProfessor"))
            jsp = UpdatePasswordProfessor.execute(request);
        else if(action.equals("SeeStudents"))
            jsp = SeeStudents.execute(request);
      //else if(action.equals("AddCourseStudent"))
            //jsp = AddCourseStudent.execute(request);
      
        //
        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    public void destroy() {
        Connection.destroy();
    }}
