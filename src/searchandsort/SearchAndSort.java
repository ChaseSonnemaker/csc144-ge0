/*
 * CSC 140 Project 0
 */
package searchandsort;

import java.util.List;
import java.util.ArrayList;
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
     * between the values of 1 and 99. Help Source: Professor Leon Tabak.
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
     * 2 digits. Help Source: Professor Leon Tabak.
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
     * Help Source: 
     * <a href="https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/">
     * hackerearth </a>
     * 
     * @param list1 An ordered list of integers.
     * @param list2 An ordered list of integers.
     * 
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
            else if(list1.get(curIndex1) > list2.get(curIndex2)){
                newList.add(list2.get(curIndex2));
                curIndex2++;
            }// else if
            else {
                newList.add(list1.get(curIndex1));
                curIndex1++;  
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
    }// mergeLists(List<Integer>, List<Integer>)
    
    
    
    /**
    * Finds the index of the first instance of a number in a list of integers.
    * 
    * Uses a sequential search algorithm to find and return the index 
    * of the first instance of a specific number in a list of integers 
    * or returns -1 if the number does not appear. 
    * Help Source: Professor Leon Tabak.
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
    * Help Source: Professor Leon Tabak.
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
     * Help Source: 
     * <a href="https://www.interviewbit.com/tutorial/insertion-sort-algorithm/">
     * InterviewBit </a>
     * 
     * @param list The list of integers to be sorted.
     */
    public static void insertionSort(List<Integer> list) {
        for(int i = 1; i < list.size(); i++) {
            smallestLeft(i, list);
        }// for
    }// insertionSort(List<Integer>)
    
    
    
    /**
     * Returns a cloned list of integers that is sorted in ascending order.
     * 
     * Takes a list of integers and uses the merge sort algorithm 
     * to return a clone of the list that is sorted from 
     * smallest to largest. Help Source: 
     * <a href="https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/">
     * hackerearth </a>
     * 
     * @param list The list of integers to be sorted.
     * 
     * @return A clone of the list that is sorted.
     */
    public static List<Integer> mergeSort(List<Integer> list) {
        int min = 0;
        int max = list.size();
        int mid = (max + min) / 2;
        List<Integer> leftList = list.subList(min, mid);
        List<Integer> rightList = list.subList(mid, max);
        if(list.size() == 1) {
            return list;
        }// if
        else {
            leftList = mergeSort(leftList);
            rightList = mergeSort(rightList);
        }// else
        List<Integer> newList = mergeLists(leftList, rightList);
        return newList;
    }// mergeSort(List<Integer>)
    
    
    
    public static void main( String [] args ) {
        
        // Method Tests
        System.out.println("Searching and Sorting Algorithms Tests");
        System.out.println();
        
        // randomIntList and printIntList Tests
        System.out.println("randomIntList and printIntList Tests");
        List<Integer> testList = randomIntList(8);
        printIntList(testList);
        System.out.println("Should print a random list of integers");
        System.out.println();
        
        // swap Test
        System.out.println("swap Test");
        System.out.println("Test List");
        printIntList(testList);
        swap(0, 1, testList);
        System.out.println("Swapped index 0 and 1");
        printIntList(testList);
        System.out.println();
        
        // findSmallestIndex Test
        System.out.println("findSmallestIndex Test");
        System.out.println("Test List");
        printIntList(testList);
        System.out.println("findSmallestIndex starting at index 0");
        System.out.println("Index of Smallest: " + 
                            findSmallestIndex(0, testList));
        System.out.println();
        
        // smallestLeft Test
        System.out.println("smallestLeft Test");
        System.out.println("Test List");
        printIntList(testList);
        System.out.println("Move index 7 until there is a smaller left number");
        smallestLeft(7, testList);
        printIntList(testList);
        System.out.println();
        
        // mergeLists Test
        System.out.println("mergeList Test");
        List<Integer> mergeList1 = randomIntList(6);
        System.out.println("List 1");
        insertionSort(mergeList1);
        printIntList(mergeList1);
        List<Integer> mergeList2 = randomIntList(6);
        System.out.println("List 2");
        insertionSort(mergeList2);
        printIntList(mergeList2);
        System.out.println("Merged List");
        List<Integer> newList = mergeLists(mergeList1, mergeList2);
        printIntList(newList);
        System.out.println("Merged List Number of Elements: " + newList.size());
        System.out.println("Sum of List 1 and List 2 Elements: " +
                            (mergeList1.size() + mergeList2.size())); 
        System.out.println();
        
        // Search Testing List Creation
        List<Integer> searchList = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            searchList.add(i);
        }// for
        
        // sequentialSearch Test
        System.out.println("sequentialSearch (Linear Search) Test");
        System.out.println("Test List");
        printIntList(searchList);
        System.out.println("Target: 1, Search Index: "
                          + sequentialSearch(1, searchList) 
                          + ", Real Index: 0");
        System.out.println("Target: 5, Search Index: "
                          + sequentialSearch(5, searchList) 
                          + ", Real Index: 4");
        System.out.println("Target: 11, Search Index: "
                          + sequentialSearch(-1, searchList) 
                          + ", Real Index: -1");
        System.out.println();

        // binarySearch Test
        System.out.println("binarySearch Test");
        System.out.println("Ordered Test List");
        printIntList(searchList);
        System.out.println("Target: 10, Search Index: "
                          + binarySearch(10, searchList) 
                          + ", Real Index: 9");
        System.out.println("Target: 6, Search Index: "
                          + sequentialSearch(6, searchList) 
                          + ", Real Index: 5");
        System.out.println("Target: 15, Search Index: "
                          + sequentialSearch(-1, searchList) 
                          + ", Real Index: -1");
        System.out.println();
        
        // Sort Testing Lists Creation
        List<Integer> sortList = randomIntList(14);
        List<Integer> selectionList = new ArrayList<>();
        List<Integer> insertionList = new ArrayList<>();
        for(int i : sortList) {
         selectionList.add(i);
         insertionList.add(i);       
        }// for
        System.out.println("Sort Testing List");
        printIntList(sortList);
        System.out.println();
        
        
        // selectionSort Test
        System.out.println("selectionSort Test");
        System.out.println("Selection Sorted List");
        selectionSort(selectionList);
        printIntList(selectionList);
        System.out.println();
        
        // insertionSort Test
        System.out.println("insertionSort Test");
        System.out.println("Insertion Sorted List");
        insertionSort(insertionList);
        printIntList(insertionList);
        System.out.println();
        
        // mergeSort Test
        System.out.println("mergeSort Test");
        System.out.println("Merge Sorted List");
        List<Integer> mergeList = mergeSort(sortList);
        printIntList(mergeList);
    } // main( String [] )
} // SearchAndSort
