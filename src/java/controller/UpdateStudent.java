/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Admin;
import controller.vo.Course;
import controller.vo.Student;
import controller.vo.StudentxCourse;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AdminDAO;
import model.CourseDAO;
import model.StudentDAO;
import model.StudentxCourseDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class UpdateStudent {
    public static String execute(HttpServletRequest request,  HttpSession session) {
        String jsp = "";
        Admin admin = AdminDAO.getById((String)session.getAttribute("userid"));
        try {
            // 
            int idOld = Integer.parseInt(request.getParameter("IdStudent"));
            int id = Integer.parseInt(request.getParameter("id"));
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String major = request.getParameter("major");
            Student studentOld = new Student();
            System.out.println("38");
            if(id!=idOld){
                ArrayList<StudentxCourse> listStudentxcourse = StudentxCourseDAO.getByIdStudent(idOld);
                ArrayList<StudentxCourse> listStudentxcourseNew = new ArrayList<>();
                if(listStudentxcourse!=null){
                    for(int i=0; i<listStudentxcourse.size(); i++){
                        StudentxCourse studentxcourseNew = new StudentxCourse();
                        studentxcourseNew.setIdCourse(listStudentxcourse.get(i).getIdCourse());
                        studentxcourseNew.setIdStudent(id);
                        studentxcourseNew.setIdTerm(listStudentxcourse.get(i).getIdTerm());
                        studentxcourseNew.setYear(listStudentxcourse.get(i).getYear());
                        listStudentxcourseNew.add(studentxcourseNew);
                        System.out.println("50");
                    }
                    boolean studentxcourseDel = StudentxCourseDAO.deleteByIdStudent(idOld);
                    if(studentxcourseDel){
                        Student student = StudentDAO.getById(idOld);
                        if(StudentDAO.delete(student)){
                            Student studentNew = new Student();
                            studentNew.setID(id);
                            studentNew.setFname(fname);
                            studentNew.setLname(lname);
                            studentNew.setPassword(password);
                            studentNew.setMajor(major);
                            Boolean createStudent = StudentDAO.create(studentNew);
                            System.out.println("68");
                            if(createStudent!=false){
                                 for(int i=0; i<listStudentxcourseNew.size(); i++){
                                   StudentxCourseDAO.create(listStudentxcourseNew.get(i));
                                }
                                jsp = ListStudents.execute(request, session);
                            } else{
                                request.setAttribute("admin", admin);
                                String erro = "Error Update 64";
                                request.setAttribute("error", erro);
                                jsp = "/errorAdmin.jsp";
                                 System.out.println("82");

                            }
                        }
                       
                    }
                }
                Student student = StudentDAO.getById(idOld);
               
            }else{
                studentOld.setID(id);
                studentOld.setFname(fname);
                studentOld.setLname(lname);
                studentOld.setPassword(password);
                studentOld.setMajor(major);
                Boolean update = StudentDAO.update(studentOld);
                System.out.println("97");
                if(update!=false)
                    jsp = ListStudents.execute(request, session);
                else{
                    request.setAttribute("admin", admin);

                    String erro = "Error Update 90";
                    request.setAttribute("error", erro);
                    jsp = "/errorAdmin.jsp";
                }
                }
        } catch (Exception e) {
            request.setAttribute("admin", admin);
       
            e.printStackTrace();
             String erro = "Error Update 96";
                request.setAttribute("error", erro);
                jsp = "/errorAdmin.jsp";
        }
        return jsp;
    }
    
}
