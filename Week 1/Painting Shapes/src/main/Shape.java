/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Imam
 */
public abstract class Shape {
    private String name;
    
    public Shape (String name){  
        this.name = name;    
    }  
    
    abstract double area();
    
    @Override
    public String toString(){  
    return name;
    }
}
