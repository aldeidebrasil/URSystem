/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Professor;
import controller.vo.ProfessorxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.CourseDAO;
import model.ProfessorDAO;
import model.ProfessorxCourseDAO;

/**
 *
 * @author Leticia
 */
public class ListCoursesProfessor {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        Integer idProfessor = Integer.parseInt(request.getParameter("IdProfessor"));
        Professor professor = ProfessorDAO.getById(idProfessor);
        try {
            ArrayList<ProfessorxCourse> listCourse = ProfessorxCourseDAO.getByIdProfessor(idProfessor);
            if(listCourse != null){
                request.setAttribute("listCourse", listCourse);
                jsp = "/seeCoursesProfessor.jsp";    
            }else{
                request.setAttribute("professor", professor);
                String erro="There is no courses to show!";
                request.setAttribute("error", erro);
                jsp = "/errorProfessor.jsp";
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("professor", professor);
            String erro="There is no courses to show!";
            request.setAttribute("error", erro);
            jsp = "/errorProfessor.jsp";
         }
        return jsp;
    }
    
}
