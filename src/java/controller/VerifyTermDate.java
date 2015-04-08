/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.vo.Term;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.TermDAO;

/**
 *
 * @author Aldeide Brasil
 */
class VerifyTermDate {

    static boolean execute(int idTerm) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        System.out.println("DATE"+dateFormat.format(date));
        Term term = TermDAO.getTerm(idTerm);
        System.out.println(dateFormat.format(term.getDateLimit()));
        
        if(term.getDateLimit().after(date)){
            return true;
        }
        System.out.println(date);
        
        return false;
    }
    
}
