/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Student;
import controller.vo.StudentxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class DeleteStudent {
     public static String execute(HttpServletRequest request, HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        try {
            
            String id = request.getParameter("id");
            ArrayList<StudentxCourse> studentxcourse = StudentxCourseDAO.getByIdStudent(Integer.parseInt(id));
            if(studentxcourse==null){
                Student student = StudentDAO.getById(Integer.parseInt(id));                            
                    boolean delete = StudentDAO.delete(student);
                    if(delete != false){
                        jsp = ListStudents.execute(request, session);
                    }else{
                        request.setAttribute("admin", admin);
                        String erro = "Error during the operation Delete Student";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                    }
            }
            else{
            boolean deleteStudentxCourse = false;
            for(int i=0; i<studentxcourse.size(); i++){
                deleteStudentxCourse = StudentxCourseDAO.delete(studentxcourse.get(i));
                if(!deleteStudentxCourse){
                    request.setAttribute("admin", admin);
                        String erro = "Error during the operation Delete Student";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                    
                }
            }
                     Student student = StudentDAO.getById(Integer.parseInt(id));                            
                    boolean delete = StudentDAO.delete(student);
                    if(delete != false){
                        jsp = ListStudents.execute(request, session);
                    }else{
                        request.setAttribute("admin", admin);
                        String erro = "Error during the operation Delete Student!";
                        request.setAttribute("error", erro);
                        jsp = "/errorAdmin.jsp";
                    }
               
            }
            
           
        } catch (Exception e) {
            e.printStackTrace();
             request.setAttribute("admin", admin);
                String erro = "Error during the operation Delete Student";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
            
        }
        return jsp;
    }

    
}
