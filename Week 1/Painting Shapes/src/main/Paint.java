//******************************************************  // Paint.java  
//  
// Represents a type of paint that has a fixed area  // covered by a gallon. All measurements are in feet.  //******************************************************  
package main;
public class Paint  
{  
 private double coverage; //number of square feet per gallon  
 //-----------------------------------------  
 // Constructor: Sets up the paint object.  
 //-----------------------------------------  
 public Paint(double c)  
 {  
    coverage = c;  
 }  
 //---------------------------------------------------   // Returns the amount of paint (number of gallons)   // needed to paint the shape given as the parameter.   //---------------------------------------------------   
 public double amount(Shape s)  
 {  
 System.out.println ("Computing amount for " + s);
 double paintNeeded = s.area()/coverage; 
 System.out.println ("Amount of paint needed is " + paintNeeded);
 return paintNeeded;  
 }  
} 
