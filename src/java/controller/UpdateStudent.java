/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdateStudent {
      public static String execute(HttpServletRequest request,  HttpSession session) {
        String jsp = "";
        try {
            // 
            int idOld = Integer.parseInt(request.getParameter("IdStudent"));
            int id = Integer.parseInt(request.getParameter("id"));
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String major = request.getParameter("major");
            Student studentOld = new Student();
            if(id!=idOld){
                studentOld = StudentDAO.getById(idOld);
                System.out.println("PROF OLD"+studentOld.getFname());
                boolean deleteStudent = StudentDAO.delete(studentOld);
                if(deleteStudent){
                    Student studentNew = new Student();
                    studentNew.setID(id);
                    studentNew.setFname(fname);
                    studentNew.setLname(lname);
                    studentNew.setPassword(password);
                    studentNew.setMajor(major);
                    boolean createNew = StudentDAO.create(studentNew);
                    if(createNew){
                        jsp = ListStudents.execute(request, session);
                    }
                    else{
                        String erro = "Error Update";
                        request.setAttribute("error", erro);
                        jsp = "/error.jsp";
                    }
                }
                else{
                String erro = "Error Update";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
            }else{
            studentOld.setID(id);
            studentOld.setFname(fname);
            studentOld.setLname(lname);
            studentOld.setPassword(password);
            studentOld.setMajor(major);
            Boolean update = StudentDAO.update(studentOld);
            if(update!=false)
                jsp = ListStudents.execute(request, session);
            else{
                String erro = "Error Update";
                request.setAttribute("error", erro);
                jsp = "/error.jsp";
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
    
}
