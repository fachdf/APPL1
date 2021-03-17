package main;

import java.util.Scanner;
public class IntegerList{
    int[] list; //values in the list
    
    //------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size. All elements default to value 0.
    //------------------------------------------------------------
    public IntegerList(int size){
        list = new int[size];
    }
    
    //------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    //------------------------------------------------------------
    public void randomize(){
        int max = list.length;
        for (int i=0; i<list.length; i++)
        list[i] = (int)(Math.random() * max) + 1;
    }
    
    //------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    //------------------------------------------------------------
    public void fillSorted(){
        for (int i=0; i<list.length; i++)
        list[i] = i + 2;
    }
    
    //------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    //------------------------------------------------------------
    @Override
    public String toString(){
        String s = "";
        for (int i=0; i<list.length; i++)
        s += i + ":\t" + list[i] + "\n";
        return s;
    }
    //------------------------------------------------------------
    // linearSearch -- takes a target value and returns the index
    // of the first occurrence of target in the list. Returns -1
    // if target does not appear in the list
    //------------------------------------------------------------
    public int linearSearch(int target){
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
            if (list[i] == target) 
                location = i;
        
        return location;
    }

    //------------------------------------------------------------
    // sortIncreasing -- uses selection sort
    //------------------------------------------------------------
    public void selectionSort()
    {
       int minIndex;
       for (int i=0; i < list.length-1; i++)
       {
           //find smallest element in list starting at location i
           minIndex = i;
           for (int j = i+1; j < list.length; j++)
           if (list[j] < list[minIndex])
           minIndex = j;
           //swap list[i] with smallest element
           int temp = list[i]; 
           list[i] = list[minIndex];
           list[minIndex] = temp;
       }
    } 
    
    //------------------------------------------------------------
    // sortDecreasing -- uses Inserton sort
    //------------------------------------------------------------
    public void insertionSort()
    {
        int n = list.length;
        for (int i = 1; i < n; ++i) {
            int key = list[i];
            int j = i - 1;
 
            while (j >= 0 && list[j] < key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    } 
    
    int binarySearch (int target){
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
             int mid = left + (right - left)/2;   
            if (list[mid] < target) {
                right = mid - 1;
            } else if (list[mid] > target) {
                left  = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}