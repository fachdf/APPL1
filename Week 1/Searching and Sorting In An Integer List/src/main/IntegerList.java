package main;

// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
import java.util.Scanner; 
public class IntegerList
{
    int[] list; //values in the list
    //-------------------------------------------------------
    //create a list of the given size
    //-------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
    }
    //-------------------------------------------------------
    //fill array with integers between 1 and 100, inclusive
    //-------------------------------------------------------
    public void randomize()
    {
        for (int i=0; i<list.length; i++)
        list[i] = (int)(Math.random() * 100) + 1;
    }
    //-------------------------------------------------------
    //print array elements with indices
    //-------------------------------------------------------
    public void print()
    {
        for (int i=0; i<list.length; i++)
        System.out.println(i + ":\t" + list[i]);
    }
    //-------------------------------------------------------
    //return the index of the first occurrence of target in the list.
    //return -1 if target does not appear in the list
    //-------------------------------------------------------
    public int search(int target)
    {
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
        if (list[i] == target)
        location = i;
        return location;
    }
    //-------------------------------------------------------
    //sort the list into ascending order using the selection sort algorithm
    //-------------------------------------------------------
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
    //-------------------------------------------------------
    //change an old value to a new value, nothing happens if the old value is isnt in the list
    //-------------------------------------------------------
    void replaceFirst(int oldVal, int newVal){
        int location = search(oldVal);
        if(location != -1){
            list[location] = newVal;
        }
    }
    //-------------------------------------------------------
    //change an old value to a new value, nothing happens if the old value is isnt in the list
    //-------------------------------------------------------
    void replaceAll(int oldVal, int newVal){
        int location = search(oldVal);
        while(location != -1){
            list[location] = newVal;
            location = search(oldVal);
        }
    }
    //-------------------------------------------------------
    //sorts the list into decreasing (instead of increasing)
    //-------------------------------------------------------
    void sortDecreasing(){
       int minIndex;
       for (int i=0; i < list.length-1; i++)
       {
           //find smallest element in list starting at location i
           minIndex = i;
           for (int j = i+1; j < list.length; j++)
           if (list[j] > list[minIndex])
           minIndex = j;
           //swap list[i] with smallest element
           int temp = list[i]; 
           list[i] = list[minIndex];
           list[minIndex] = temp;
       }
    }
    //-------------------------------------------------------
    //uses a binary search to find the target assuming the list is sorted in decreasing order.
    //(Pakai algo bin. search yang sebelumnya).
    //-------------------------------------------------------
    int binarySearchD (int target){
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
