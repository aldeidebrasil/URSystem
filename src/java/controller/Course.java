/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Leticia
 */
public class Course {
    private String ID;
    private String nameCourse;
    private String department;
    private String prerequisite;
    private String term;
    private String status;
    private Double value;
    private Integer IDProfessor;

    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getNameCourse() {
        return nameCourse;
    }
    
    public void setNameCourse(String NameCourse) {
        this.nameCourse = nameCourse;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String Department) {
        this.department = department;
    }
    
    public String getPrerequisite() {
        return prerequisite;
    }
    
    public void setPrerequisite(String Prerequisite) {
        this.prerequisite = prerequisite;
    }
    
    public String getTerm() {
        return term;
    }
    
    public void setTerm(String Term) {
        this.term = term;
    }
    
    /*public String getStatus() {
        if(this.status == 1){
            return "open";
        }
        if (this.status == 2){
            return "full";
        }
        if (this.status == 3){
            return "canceled";
        }
        return null;
    }*/
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String Status) {
        this.status = status;
    }
    
    public Double getValue() {
        return value;
    }
    
    public void setValue(Double Value) {
        this.value = value;
    }
    
    public Integer getIDProfessor() {
        return IDProfessor;
    }
    
    public void setIDProfessor(Integer IDProfessor) {
        this.IDProfessor = IDProfessor;
    } 
    
}
