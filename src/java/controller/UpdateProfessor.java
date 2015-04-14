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
public class UpdateProfessor {
     public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        try {
            // 
            int idOld = Integer.parseInt(request.getParameter("IdProfessor"));
            int id = Integer.parseInt(request.getParameter("id"));
             String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String title = request.getParameter("title");
            Professor professorOld = new Professor();
            if(id!=idOld){
                ArrayList<ProfessorxCourse> listProfessorxcourse = ProfessorxCourseDAO.getByIdProfessor(idOld);
                ArrayList<ProfessorxCourse> listProfessorxcourseNew = new ArrayList<>();
                if(listProfessorxcourse!=null){
                    for(int i=0; i<listProfessorxcourse.size();i++){
                        ProfessorxCourse professorxcourseNew = new ProfessorxCourse();
                        professorxcourseNew.setIdCourse(listProfessorxcourse.get(i).getIdCourse());
                        professorxcourseNew.setIdProfessor(id);
                        listProfessorxcourseNew.add(professorxcourseNew);
                    }
                    boolean professorxcourseDel = ProfessorxCourseDAO.deleteByIdProfessor(idOld);
                    if(professorxcourseDel){
                        Professor professor = ProfessorDAO.getById(idOld);
                       if(ProfessorDAO.delete(professor)){
                    Professor professorNew = new Professor();
                    professorNew.setID(id);
                    professorNew.setFname(fname);
                    professorNew.setLname(lname);
                    professorNew.setPassword(password);
                    professorNew.setTitle(title);
                    if(ProfessorDAO.create(professorNew)){
                        for(int i=0; i<listProfessorxcourseNew.size();i++){
                            ProfessorxCourseDAO.create(listProfessorxcourseNew.get(i));
                        }
                        jsp = ListProfessor.execute(request, session);
                    }else{
                        String erro = "Error Update";
                        request.setAttribute("admin", admin);
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                    }
                }
                        
                    }
                }
                
             }   
            else{
                    professorOld.setID(id);
                    professorOld.setFname(fname);
                    professorOld.setLname(lname);
                    professorOld.setPassword(password);
                    professorOld.setTitle(title);
                    Boolean update = ProfessorDAO.update(professorOld);
                    if(update!=false)
                        jsp = ListProfessor.execute(request, session);
                    else{
                        request.setAttribute("admin", admin);
                        String erro = "Error Update";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("admin", admin);
            String erro = "Error Update";
            request.setAttribute("error", erro);
            jsp = "/errorAdmin.jsp";

        }
        return jsp;
    }
}
