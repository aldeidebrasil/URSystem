/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.CourseDAO;
import model.ProfessorDAO;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class OpenPage {

    static String execute(HttpServletRequest request, HttpSession session) throws SQLException {
        String page = request.getParameter("page");
        ArrayList<Integer> student = StudentDAO.getAllId();
        ArrayList<Integer> professor = ProfessorDAO.getAllId();
        ArrayList<String> course = CourseDAO.getAllId();
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        request.setAttribute("student", student);
        request.setAttribute("professors", professor);
        request.setAttribute("courses", course);
        request.setAttribute("admin", admin);
        return "/"+page+".jsp";
    }
    
}
