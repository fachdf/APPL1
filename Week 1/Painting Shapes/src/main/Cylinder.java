package main;

/**
 *
 * @author Fachri
 */
public class Cylinder extends Shape{
    private double radius;
    private double height;
    
    public Cylinder(double r,double s){
        super("Cylinder");
        radius = r;
        height = s;
    }
    
    @Override
    public double area(){
        return Math.PI*radius*radius*height;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" + "of radius " +radius + " and of height "+height;
    }
}

