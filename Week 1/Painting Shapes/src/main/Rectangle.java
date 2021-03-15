package main;

/**
 *
 * @author Fachri
 */
public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double r,double s){
        super("Rectangle");
        length = r;
        width = s;
    }
    
    @Override
    public double area(){
        return length*width;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" +  "of length " +length + " and of width "+width;
    }
}
