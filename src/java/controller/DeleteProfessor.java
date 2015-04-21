/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Professor;
import controller.vo.ProfessorxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.ProfessorDAO;
import model.ProfessorxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class DeleteProfessor {
    public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        
        try {

            String id = request.getParameter("id");
            ArrayList<ProfessorxCourse> professorxcourse = ProfessorxCourseDAO.getByIdProfessor(Integer.parseInt(id));
            if(professorxcourse==null){
                Professor professor = ProfessorDAO.getById(Integer.parseInt(id));                            
                boolean delete = ProfessorDAO.delete(professor);
                if(delete != false){
                    jsp = ListProfessor.execute(request, session);
                }else{
                    request.setAttribute("admin", admin);
                    String erro = "An error occurred during the operation Delete Professor!";
                    request.setAttribute("error", erro);
                    jsp = "/errorAdmin.jsp";
                }
            }
            else{
               boolean deleteProfessorxCourse = false;
               for(int i=0; i<professorxcourse.size();i++){
                   deleteProfessorxCourse = ProfessorxCourseDAO.delete(professorxcourse.get(i));
                   if(!deleteProfessorxCourse){
                        request.setAttribute("admin", admin);
                        String erro = "An error occurred during the operation Delete Professor!";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                   }
               }
               Professor professor = ProfessorDAO.getById(Integer.parseInt(id));
               boolean delete = ProfessorDAO.delete(professor);
               if(delete){
                   jsp = ListProfessor.execute(request, session);
                }else{
                    request.setAttribute("admin", admin);
                    String erro = "An error occurred during the operation Delete Professor!";
                    request.setAttribute("error", erro);
                    jsp = "/errorAdmin.jsp";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("admin", admin);
            String erro = "An error occurred during the operation Delete Professor!";
            request.setAttribute("error", erro);
            jsp = "/errorAdmin.jsp";
        }
        return jsp;
    }

}
