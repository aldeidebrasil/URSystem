/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Course;
import controller.vo.Student;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.StudentDAO;

/**
 *
 * @author Aldeide Brasil
 */
public class CalcBilling {
   
    static double execute(ArrayList<Course> listCourse, HttpSession session) {
        double bill=0;
           for(int i=0; i<listCourse.size(); i++){
               bill= bill + listCourse.get(i).getValue();
               Student student = StudentDAO.getById((int)session.getAttribute("userid"));
               student.setBilling(bill);
               StudentDAO.update(student);
        }
        return bill;
    }
    
}
