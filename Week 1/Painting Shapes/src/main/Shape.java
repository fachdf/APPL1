package main;

/**
 *
 * @author Fachri
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
