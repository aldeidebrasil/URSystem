/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.StudentxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
class ListCoursesStudent {
     public static String execute(HttpServletRequest request, Integer idTerm) {
        String jsp = "";
        Integer idStudent = Integer.parseInt(request.getParameter("IdStudent"));
        String idCourse = request.getParameter("rd");
         System.out.println(idTerm);
      /*  try {
            ArrayList<StudentxCourse> listSemester = StudentxCourseDAO.getBySemester(idTerm, idStudent);
            if(listSemester != null){
                request.setAttribute("listSemester", listSemester);
                jsp = "/welcomeStudent.jsp?";    
            }else{
                String erro="There is no courses to show!";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }*/
        return jsp;
    }
    
}
