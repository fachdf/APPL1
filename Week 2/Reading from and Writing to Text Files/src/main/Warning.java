package main;

// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;

public class Warning
{
 // --------------------------------------------------------------------
 // Reads student data (name, semester hours, quality points) from a
 // text file, computes the GPA, then writes data to another file
 // if the student is placed on academic warning.
 // --------------------------------------------------------------------
 public static void main (String[] args)
 {
    int creditHrs; // number of semester hours earned
    double qualityPts; // number of quality points earned
    double gpa; // grade point (quality point) average
    String line, name, inputName = "./src/main/students.dat";
    String outputName = "./src/main/warning.dat";
    File fileInput = new File(inputName);
    try
    {
        // Set up scanner to input file
        Scanner inputScan = new Scanner(fileInput);
        // Set up the output file stream
        PrintWriter outFile = new PrintWriter(new FileWriter(outputName));
        // Print a header to the output file
        outFile.println ("----------------------------");
        outFile.println ("Students on Academic Warning");
        outFile.println ("----------------------------");
        outFile.println ();
        
        // Process the input file, one token at a time
        while (inputScan.hasNext())
        {
        /* Get the credit hours and quality points and
           determine if the student is on warning. If so,
           write the student data to the output file */
            String[] data = inputScan.nextLine().split(" ");
            name = data[0];
            creditHrs = Integer.parseInt(data[1]);
            qualityPts = Double.parseDouble(data[2]);
            gpa = qualityPts / creditHrs;
            if(gpa < 1.5 && creditHrs < 30){
                outFile.println (name + " have GPA under 1,5 and credit hours under 30.");
            }else if(gpa < 1.75 && creditHrs < 60 && creditHrs >= 30){
                outFile.println (name + " have GPA under 1,75 and credit hours under 60.");
            }else if(gpa < 2 && creditHrs >= 60){
                outFile.println (name + " have GPA under 2 and credit hours >= 60.");
            }
        }
        // Close output file
        inputScan.close();
        outFile.close();
    }
    catch (FileNotFoundException exception)
    {
        System.out.println ("The file " + inputName + " was not found.");
    }
    catch (IOException exception)
    {
        System.out.println (exception);
    }
    catch (NumberFormatException e)
    {
        System.out.println ("Format error in input file: " + e);
    }
 }
} 