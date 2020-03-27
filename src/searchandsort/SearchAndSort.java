/*
 * CSC 140 Project 0
 */
package searchandsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A class of various searching and sorting algorithms.
 * 
 * @author Chase Sonnemaker
 * @version 26 March 2020
 */
public class SearchAndSort {

    private static final Random rdm = new Random();
    private static final int SIZE_THRESH = 15;
    
    /**
     * Creates a list of random integers.
     * 
     * Creates a list of random integers. Each integer falls 
     * between the values of 1 and 99.
     * 
     * @param size The number of random integers in the list.
     * 
     * @return A list of random integers with size elements.
     */
    public static List<Integer> randomIntList(int size) {
        List<Integer> newList = new ArrayList<>();
        for(int i = 0; i < size; i++) {
           int randomInt = 1 + rdm.nextInt(99);
           newList.add(randomInt);
        }// for
        return newList;
    }// randomIntList(int)
    
    
    
    /**
     * Prints all of the elements in a list of integers.
     * 
     * Prints all the elements of a list. If the list
     * has less than 15 elements, the list will be 
     * printed on a single line. If the list has 15 or more
     * elements, the list will be printed one line at a time.
     * This method is designed to format integers with 
     * 2 digits or less so it is not recommended to use this
     * method to print lists with integers that have more than
     * 2 digits.
     * 
     * @param list The list of integers to be printed.
     */
    public static void printIntList(List<Integer> list) {
        if(list.size() < SIZE_THRESH) {
            for(int i : list) {
                System.out.printf("%4d", i);
            }// for
            System.out.println();
        }// if
        else {
            for(int k : list) {
                System.out.printf("%4d\n", k);
            }// for
        }// else
    }// printIntList(List<Integer>)
    
    
    /**
     * Swaps the elements at two indices in a list.
     * 
     * Takes two indices in a list and swaps the elements
     * at those indices. 
     * 
     * @param index1 The index of the first element to be swapped.
     * @param index2 The index of the second element to be swapped.
     * @param list The list where the swap will occur.
     */
    public static void swap(int index1, int index2, List<Integer> list) {
        int index1Value = list.get(index1);
        int index2Value = list.get(index2);
        list.set(index1, index2Value);
        list.set(index2, index1Value);
    }// swap(int, int, List<Integer>)
    
    
    
    /**
     * Returns the index of the smallest integer in a list of integers.
     * 
     * Returns the index of the first instance of the smallest
     * integer in a list of integers. The indices searched include
     * the starting index and extend to the end of the list.
     * 
     * @param index The index that the search begins at.
     * @param list The list being searched.
     * 
     * @return The index of the first instance of the smallest integer.
     */
    public static int findSmallestIndex(int index, List<Integer> list) {
        int smallestIndex = index;
        for(int i = index; i < list.size(); i++) {
            if(list.get(i) < list.get(smallestIndex)) {
                smallestIndex = i;
            }// if
        }// for
        return smallestIndex;
    }// findSmallestIndex(int, List<Integer>)
    
    
    
    /**
     * Moves an integer in a list left until a smaller integer is on the left.
     * 
     * Uses continual swapping to move an element on an integer list
     * left until there is a smaller integer on the left of the element.
     * 
     * @param index The index of the element to move left.
     * @param list The integer list where the moving occurs.
     */
    public static void smallestLeft(int index, List<Integer> list) {
        int indexValue = list.get(index);
        int currentIndex = index;
        int nextIndex = index - 1;
        while(nextIndex >= 0 && indexValue < list.get(nextIndex)) {
            swap(currentIndex, nextIndex, list);
            currentIndex = nextIndex;
            nextIndex = nextIndex - 1;
        }// while
    }// smallestLeft(List<Integer>)
    
    
    
    /**
     * Merges two ordered lists and returns a single ordered list.
     * 
     * Takes two integers lists that are ordered from smallest to 
     * largest, then merges the lists such that they result in 
     * a list that is ordered from smallest to largest.
     * 
     * @param list1 An ordered list of integers.
     * @param list2 An ordered list of integers.
     * @return An ordered list that consists of list1 and list2 merged. 
     */
    public static List<Integer> mergeLists(List<Integer> list1,
                                            List<Integer> list2) {
        List<Integer> newList = new ArrayList<>();
        int curIndex1 = 0;
        int curIndex2 = 0;
        int listSize1 = list1.size();
        int listSize2 = list2.size();
        while(curIndex1 < listSize1 && curIndex2 < listSize2) {
            if(list1.get(curIndex1) < list2.get(curIndex2)) {
                newList.add(list1.get(curIndex1));
                curIndex1++;
            }// if
            else {
                newList.add(list2.get(curIndex2));
                curIndex2++;
            }// else
        }// while
        if(curIndex1 < listSize1) {
            for(int i = curIndex1; i < listSize1; i++) {
                newList.add(list1.get(i));
            }// for
        }// if
        if(curIndex2 < listSize2) {
            for(int k = curIndex2; k < listSize2; k++) {
                newList.add(list2.get(k));
            }// for       
        }// if
        return newList;
    }// cutList(int, int, List<Integer>)
    
    
    
    /**
    * Finds the index of the first instance of a number in a list of integers.
    * 
    * Uses a sequential search algorithm to find and return the index 
    * of the first instance of a specific number in a list of integers 
    * or returns -1 if the number does not appear.
    * 
    * @param target The integer to be searched for.
    * @param list The list of integers.
    * 
    * @return The index of the target in the list or -1 if there is no target.
    */    
    public static int sequentialSearch(int target, List<Integer> list) {
        int index = -1;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == target) {
                index = i;
                break;
            }// if
        } // for
        return index;
    } // sequentialSearch(int, List<Integer>)
    
    
    
    /**
    * Finds the index of the first instance of a number in an ordered list of integers.
    * 
    * Uses a binary search algorithm to find and return the index 
    * of the first instance of a specific number in an ordered list of integers
    * or returns -1 if the number does not appear.
    * 
    * @param target The integer to be searched for.
    * @param list The ordered list of integers.
    * 
    * @return The index of the target in the ordered list or -1 if there is no target.
    */    
    public static int binarySearch(int target, List<Integer> list) {
        int min = 0;
        int max = list.size() - 1;
        int index = -1;
        while(min < max && index < 0) {
            int mid = (max + min) / 2;
            if(target == list.get(max)) {
                index = max;
            }// if
            else if(target == list.get(min)) {
                index = min;
            }// else if
            else if(target == list.get(mid)) {
                index = mid;
            }// else if
            else if(target > list.get(mid)) {
                min = mid + 1;
            }// else if
            else {
                max = mid - 1;
            }// else
        }// while
        return index;     
    } // binarySearch(int, List<Integer>)
    
    
 
    /**
     * Sorts a list of integers to be in ascending order.
     * 
     * Uses the selection sort algorithm to sort a list
     * of integers to be from smallest to largest.
     * 
     * @param list The list of integers to be sorted.
     */
    public static void selectionSort(List<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            int nextSmallestIndex = findSmallestIndex(i, list);
            swap(i, nextSmallestIndex, list);
        }// for
    }// selectionSort(List<Integer>)
    
    
    
    /**
     * Sorts a list of integers to be in ascending order.
     * 
     * Uses the insertion sort algorithm to sort a list
     * of integers to be from smallest to largest.
     * 
     * @param list The list of integers to be sorted.
     */
    public static void insertionSort(List<Integer> list) {
        for(int i = 1; i < list.size(); i++) {
            smallestLeft(i, list);
        }// for
    }// insertionSort(List<Integer>)
    
    
    
    /**
     * Sorts a list of integers to be in ascending order.
     * 
     * Uses the merge sort algorithm to sort a list
     * of integers to be from smallest to largest.
     * 
     * @param list The list of integers to be sorted.
     */
    public static void mergeSort(List<Integer> list) {
        
    }// mergeSort(List<Integer>)
    
    
    
    public static void main( String [] args ) {
        System.out.println( "Searching and sorting algorithms" );
        
        //Other Method Tests
        System.out.println("Other Method Tests");
        System.out.println("randomIntList and printIntList");
        List<Integer> testList = randomIntList(8);
        printIntList(testList);
        
        System.out.println("swap index 0 and index 2");
        swap(0, 2, testList);
        printIntList(testList);
        
        System.out.println("findSmallestIndex starting at index 0");
        System.out.println(findSmallestIndex(0, testList));
        
        System.out.println("smallestLeft moving index 7");
        smallestLeft(7, testList);
        printIntList(testList);
        
        System.out.println("mergeLists using two lists");
        List<Integer> mergeList1 = randomIntList(8);
        System.out.println("List 1");
        insertionSort(mergeList1);
        printIntList(mergeList1);
        List<Integer> mergeList2 = randomIntList(8);
        System.out.println("List 2");
        insertionSort(mergeList2);
        printIntList(mergeList2);
        System.out.println("Merged Lists");
        List<Integer> newList = mergeLists(mergeList1, mergeList2);
        printIntList(newList);
        
        
//        // Sequential Search Test
//        System.out.println("Sequential (Linear) Search Test");
//        System.out.println("Test List");
//        List<Integer> testList1 = randomIntList(50);
//        printIntList(testList1);
//        int index = sequentialSearch(50, testList1);
//        System.out.println("Target: 50 Index: " + index);
//
//        // Binary Search Test
//        System.out.println("Binary Search Test");
//        System.out.println("Ordered Test List");
//        List<Integer> testList2 = randomIntList(50);
//        Collections.sort(testList2);
//        printIntList(testList2);
//        int index2 = binarySearch(50, testList2);
//        System.out.println("Target: 50 Index: " + index2);
        
//        // Selection Sort Test
//        System.out.println("Selection Sort Test");
//        System.out.println("Original List");
//        List<Integer> testList3 = randomIntList(14);
//        printIntList(testList3);
//        System.out.println("Selection Sorted List");
//        selectionSort(testList3);
//        printIntList(testList3);
        
//        // Insertion Sort Test
//        System.out.println("Insertion Sort Test");
//        System.out.println("Original List");
//        List<Integer> testList4 = randomIntList(14);
//        printIntList(testList4);
//        System.out.println("Insertion Sorted List");
//        insertionSort(testList4);
//        printIntList(testList4);
        
//        // Merge Sort Test
//        System.out.println("Merge Sort Test");
//        System.out.println("Original List");
//        List<Integer> testList5 = randomIntList(14);
//        printIntList(testList5);
//        System.out.println("Merge Sorted List");
//        mergeSort(testList5);
//        printIntList(testList5);
        
    } // main( String [] )
} // SearchAndSort
