/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;
import model.ProfessorxCourseDAO;

/**
 *
 * @author Leticia
 */
public class ListCoursesProfessor {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        Integer idProfessor = Integer.parseInt(request.getParameter("IdProfessor"));
        try {
            ArrayList<ProfessorxCourse> listCourse = ProfessorxCourseDAO.getByIdProfessor(idProfessor);
            if(listCourse != null){
                request.setAttribute("listCourse", listCourse);
                jsp = "/seeCoursesProfessor.jsp";    
            }else{
                String erro="There is no courses to show!";
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
