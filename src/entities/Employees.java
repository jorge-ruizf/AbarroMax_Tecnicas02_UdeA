/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class Employees {
    private ArrayList<String> employees;
    
    public Employees(ArrayList<String> employees){
        this.employees = employees;
    }
    
    public void registerEmployee(){
        //null
    }
    
    public void addEmployee(String name){
        this.employees.add(name);
    }
}
