/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.vo.Term;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aldeide Brasil
 */
public class TermDAO {
     private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    public static boolean create(Term term) {
        try {
              
            pstmt = Connection.getConnection().prepareStatement(
                    "INSERT INTO TERM(id, name, date, dateLimit, dateEnd) VALUES(?,?,?,?,?)");
            pstmt.setInt(1, term.getId());
            pstmt.setString(2, term.getName());
            pstmt.setDate(3,term.getDateStart());
            pstmt.setDate(4,term.getDateLimit());
            pstmt.setDate(5,term.getDateEnd());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean update(Term term) {
        try {
             pstmt = Connection.getConnection().prepareStatement(
                    "UPDATE TERM SET id = ?, name = ?, date=?, dateLimit=?, dateEnd=? WHERE id = ?");
            pstmt.setInt(1, term.getId());
            pstmt.setString(2, term.getName());
            pstmt.setDate(3,term.getDateStart());
            pstmt.setDate(4,term.getDateLimit());
            pstmt.setDate(5,term.getDateEnd());
            pstmt.setInt(6, term.getId());
            pstmt.executeUpdate();
            pstmt.close();
            return true;
         } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Term getTerm(int id){
        try {
            Term term = null;
           // System.out.println(login);
            pstmt = Connection.getConnection().prepareStatement(
                      "select * from term where id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                term = new Term();
                term.setName(rs.getString("name"));
                term.setId(rs.getInt("id"));
                term.setDateStart(rs.getDate("date"));
                term.setDateLimit(rs.getDate("dateLimit"));
                term.setDateEnd(rs.getDate("dateEnd"));
            }
            return term;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    public static ArrayList<Term> getAll(){
        try{
            ArrayList<Term> listAll = null;
            Term term = new Term();            
            pstmt = Connection.getConnection().prepareStatement(
                    "SELECT * FROM term ORDER BY id");
            rs = pstmt.executeQuery();           
            
            if (rs.next()) {
                listAll = new ArrayList<Term>();
                do {                    
                    term = new Term();
                    term.setId(rs.getInt("id"));
                    term.setName(rs.getString("name"));
                    term.setDateStart(rs.getDate("date"));
                    term.setDateLimit(rs.getDate("dateLimit"));
                    term.setDateEnd(rs.getDate("dateEnd"));
                    listAll.add(term);
                } while (rs.next());
            }
            rs.close();
            pstmt.close();
            return listAll;
       } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
