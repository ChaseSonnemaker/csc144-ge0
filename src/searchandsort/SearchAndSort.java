/*
 * CSC 140 Project 0.
 */
package searchandsort;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A class of various searching and sorting algorithms.
 * 
 * This class contains a variety of searching and sorting methods which 
 * make use of different algorithms. The primary methods of this class are
 * <code>sequentialSearch</code>, <code>binaySearch</code>, 
 * <code>selectionSort</code>, <code>insertionsort</code>, and
 * <code>mergeSort</code> but also contains the necessary help and testing
 * methods to support them.
 * <P>
 * <P>
 * Class,
 * <P>
 * While creating the methods of this class, I discovered several key lessons 
 * regarding both Java and the wider field of software engineering which I hope
 * you, by examining this class and listening to my development process, might be able 
 * to learn. These lessons range from understanding Java, to adopting key design 
 * strategies, to gaining more experience with the fundamentals of modern programming.
 * <P>
 * <b>Understanding Java: </b> 
 * I have a beginner's proficiency in both Python, like you, and R. As 
 * expected, examining this project can began to teach us the basics of Java 
 * syntax; however, there are a couple wider differences I wish to highlight 
 * between languages like Python and languages like Java. One major difference 
 * is between how Python and Java manage scope. In Python,
 * local variables were generally only a consideration with functions. Variables 
 * defined in a function could not be accessed outside the function since they are
 * local variables. In Java, I noticed that curly brackets tend to dictate local 
 * variables which means that variables defined in loops and if statements will be 
 * inaccessible to anything outside of them. While I am still to this
 * concept, this issue required workarounds which can be seen several times 
 * throughout the project and originally resulted a lot of errors. The 
 * only real information I found on the topic can be found 
 * <a href="https://stackoverflow.com/questions/30727711/local-variable-scope-in-java-vs-python">
 * here</a>, so please be aware of this major difference.
 * <P>
 * Another key Java concept I hope that you will learn from this example is the 
 * intricacies of type declaration. While we began learning this at the start of the 
 * week, it is very easy to forget to declare variable types while coding, especially  
 * coming from Python. While I was originally annoyed at this, using the 
 * <code>List</code> class was really the first clue I had as to how complex and 
 * substantially type declaration is. I first began this example trying to declare 
 * everything as a <code>ListArray</code> but the final version was switched to a 
 * <code>List</code>. If you are confused as to why, consider looking at Professor 
 * Tabak's post on the subject and more information can be found
 * <a href="https://stackoverflow.com/questions/43462404/what-does-listinteger-list-new-arraylistinteger-actually-mean">
 * here</a>. This source mentions that generalizing our type allows us to late use 
 * other list classes like <code>LinkedList</code> since every list implements 
 * <code>List</code> and will have the equivalent methods of <code>List</code> written. 
 * This examples use of a <code>List</code> variables over <code>ListArray</code> 
 * variables is both a hint and a message to those you learning Java to respect the 
 * power of the type declaration and understand its importance!
 * <P>
 * <b>Adopting Key Design Strategies: </b>
 * One strategy I want to share is the process of writing tests before writing methods.
 * When I was learning I had heard of this strategy, but never really implemented it. 
 * During the later half of this project, I began writing methods by creating a stub, 
 * then making a test for the stub, then writing the body of the method. 
 * This strategy works far better. Instead of needing to hunt back through the code for 
 * mistakes later, I can run my code while rereading my method. Errors point 
 * to lines and I am already there, only a few minutes after previously writing. 
 * This makes the entire debugging process far easier. This example also shows how
 * writing the tests beforehand, gives you a better idea about how the method will 
 * actually work, since the parameters and return is basically already designed. 
 * This makes the writing process easier too! Overall, the process of both creating 
 * tests before methods and writing stubs makes writing and debugging a far less 
 * intimidating prospect. While I did eventually work on the tests to make them more 
 * presentable, I intend for this example to show you that complex coding can be made
 * easier by creating tests and stubs first and I hope you will learn from my initial 
 * mistakes and start to adopt this coding methodology by beginning with
 * the test in future projects.
 * <P>
 * <b>Fundamentals of Java: </b> Recursion is a concept that has always been tricky 
 * for me. Sometimes I have a hard time seeing a recursive solution to a problem, and 
 * I usually forget to even look for one. While originally learning Python, I 
 * became somewhat comfortable with recursion; but, when I started learning Java, 
 * that confidence quickly faded. For this example, I decided to try the merge sort 
 * algorithm as a recursive method to help you become acclimated to recursion in Java.
 * This was not an easy task and took a lot of time, even with 
 * extensive help from others and internet resources. The resulting merge method 
 * will recall the basics of merging: the requirement of a stop condition, 
 * a method call to itself, and a smaller problem resulting from each iteration. While 
 * a lot of what you will learn from this recursive example is likely review, I also 
 * want to share a few aspects of recursion that might be new. For example, a recursive 
 * method does not need to have a return statement and can be a void method. 
 * I even found a version of a merge sort that works on a list and does not return 
 * anything which you can view 
 * <a href="https://www.baeldung.com/java-merge-sort">here</a>. Another new concept is 
 * the prospect of using the results of recursive method to further the method. 
 * Most of the recursive functions you would have written in CSC 140 simply returned a 
 * transformed value resulting from the recursive function; however, my merge method 
 * continues and calls another method on the results of the two recursive calls. These
 * newer ideas open up the possibilities for using recursion and will hopefully make 
 * the you more adept and comfortable writing code and experimenting using recursion.
 * I hope this explanation has cleared up some confusions and I hope this example
 * provides you with knowledge, confidence, and inspiration to encourage your future 
 * learning of Java and software engineering!
 * <P>
 * <P>
 * <b>My Project Conclusion: </b>
 * In addition to these larger ideas, I learned a lot more from this project including
 * Javadoc commenting and html tags, comfort with the Java language, and working with 
 * other people to guide and gain guidance and I hope students can learn these concepts
 * from my examples too. Note that my Javadoc comments are a little more in-depth than 
 * a typical Java API comment would be, especially in describing uses and algorithms; 
 * however, this is done to confirm/show my understanding of the methods and to 
 * practice with the Javadoc comments. I tried to keep the comments organized to avoid
 * any extra confusion this may have caused.
 * 
 * @author Chase Sonnemaker
 * @version 29 March 2020
 */
public class SearchAndSort {

    /**
     * An instance of the Random class.
     * 
     * Used in the <code>SearchAndSort</code> class to generate random integers
     * for the for filling lists int the <code>randomIntList</code> method.
     */
    private static final Random rdm = new Random();
    
    /**
     * A list size threshold.
     * 
     * Used in the <code>SearchAndSort</code> class to define the largest list 
     * size at which lists printed by the <code>printIntList</code> method
     * will be printed on a single line rather than as one element per line.
     */
    private static final int SIZE_THRESH = 15;
    
    
    
    
    /**
     * Creates a list of a specified size of random positive integers.
     * 
     * Integers included can range from 1 to a specified maximum value. Used 
     * in the <code>SearchAndSort</code> class to generate lists used for 
     * testing sorting and searching methods.
     * <P>
     * <b>Help Source:</b> Leon Tabak.
     * 
     * @param size The number of random integers to be included in the list.
     * @param max A positive integer that represents the largest integer 
     * that can be included in the list.
     * @return A list of random integers.
     */
    public static List<Integer> randomIntList(int size, int max) {
        List<Integer> newList = new ArrayList<>();
        
        for(int i = 0; i < size; i++) {
           int randomInt = 1 + rdm.nextInt(max);
           newList.add(randomInt);
        }// for
        
        return newList;
    }// randomIntList(int, int)
    
    
    
    /**
     * Prints and formats a list of integers.
     * 
     * If the list has more elements than the <code>SIZE_THRESH</code> property,
     * which is set to 15, than the list will be printed with one element 
     * in each line. Else the list will print all elements to a single line.
     * Formats each integer element such that each has a minimum of 4 spaces
     * and is useful for integers with 3 digits or fewer which will be
     * consistently formatted. Not recommended for lists with integers larger
     * than 3 digits. Used in the <code>SearchAndSort</code> class to print 
     * the lists of method tests.
     * <P>
     * <b>Help Source:</b> Leon Tabak.
     * 
     * @param list A list of integers to be printed.
     */
    public static void printIntList(List<Integer> list) {
        if(list.size() <= SIZE_THRESH) {
            
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
    * Finds the index of the first instance of a number in a list of integers
    * or returns -1 if no index exists.
    * 
    * <P>
    * <b>Uses and Limitations:</b> Best used to determine the index/existence
    * of an integer in an unsorted list of integers. While still usable for 
    * sorted lists, more computationally efficient methods such as 
    * <code>binarySearch</code> would be more effective.
    * <P>
    * <b>Algorithm Implementation:</b> Uses the sequential (linear) search 
    * algorithm which has complexity O(n). This implementation begins by 
    * assuming the target will not be found then sequentially compares 
    * each element in the list to the target. If the target is found, the 
    * algorithm halts and returns the index of the target. More information 
    * about the sequential search algorithm can be found
    * <a href="https://www.geeksforgeeks.org/linear-search/">here</a>.
    * <P>
    * <b>Help Source:</b> Leon Tabak.
    * 
    * @param list A list of integers to search.
    * @param target An integer to be searched for.
    * @return The index of the first element of the target in the list 
    * or -1 if there is no target element.
    */    
    public static int sequentialSearch(List<Integer> list, int target) {
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
    * Finds the index of the first instance of a number in an ordered list of 
    * integers or returns -1 if no index exists.
    * 
    * <P>
    * <b>Uses and Limitations:</b> Best used to determine the index/existence 
    * of an integer in an ordered list of integers. Requires the list of 
    * integers to be sorted in ascending order and is not guaranteed to find
    * the first element. So if the list is unsorted or the first index is 
    * required, another search algorithm like <code>sequentialSearch</code> 
    * would be ideal.
    * <P>
    * <b>Algorithm Implementation:</b> Uses the binary search algorithm which
    * has a complexity of O(log n). This implementation begins by assuming 
    * the target will not be found and establishing a first and last index. 
    * Next the following steps are repeated. First a middle index is calculated.
    * Then elements at the first, last, and middle indices are compared to the 
    * target. If one of them matches the target, the index is recorded. 
    * Otherwise the target is compared to the middle index element. If larger, 
    * the index above the middle index becomes the new first index. If smaller, 
    * the index below the middle index becomes the new last index. This is 
    * repeated until the target is found or the first and last index are equal. 
    * More information about the binary search algorithm can be found 
    * <a href="https://www.geeksforgeeks.org/binary-search/">here</a>.
    * <P>
    * <b>Help Source:</b> Leon Tabak.
    * 
    * @param list An ordered list of integers to search through.
    * @param target An integer to be searched for.
    * @return The index of the target in the ordered list or -1 
    * if there is no target.
    */    
    public static int binarySearch(List<Integer> list, int target) {
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
     * Swaps the elements at two indices in a list of integers.
     * 
     * Allows for the element located at an index in a list of integers to be
     * moved to another index, while the element at the second index is moved 
     * to the first index. Used in the <code>SearchAndSort</code> class 
     * to move elements in the <code>selectionSort</code> 
     * and <code>smallestLeft</code> methods.
     * <P>
     * <b>Help Source:</b> Leon Tabak
     * 
     * @param list The list where the swap is to occur.
     * @param index1 The index of the first element to be swapped.
     * @param index2 The index of the second element to be swapped.
     * 
     */
    public static void swap(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }// swap(int, int, List<Integer>)
    
    
    
    
     /**
     * Returns the index of the smallest integer in a list of integers where 
     * the starting index to search is specified.
     * 
     * Searches each element in a list of integers starting at a specified
     * index and ending at the end of the list and returns the index of the
     * first instance of the smallest integer in the searched area. Used in 
     * the <code>SearchAndSort</code> class in the <code>selectionSort</code> 
     * method to identify the next smallest integer to sort in a list when 
     * the first integers are already sorted.
     * <P>
     * <b>Help Source:</b> Leon Tabak
     * 
     * @param list The list being searched.
     * @param index The index that the search begins at which is included in 
     * the search.
     * @return The index of the first instance of the smallest integer.
     */
    public static int findSmallestIndex(List<Integer> list, int index) {
        int smallestIndex = index;
        for(int i = index; i < list.size(); i++) {
            
            if(list.get(i) < list.get(smallestIndex)) {
                smallestIndex = i;
            }// if
            
        }// for
        return smallestIndex;
    }// findSmallestIndex(int, List<Integer>)
    
    
 
    /**
     * Sorts a list of integers to be in ascending order.
     * 
     * <P>
     * <b>Uses and Limitations:</b> Best used for sorting a list of integers to
     * be from smallest to largest. Acceptable for small list sorting where
     * time is not a major constraint. Generally, another method such as 
     * <code>insertionSort</code> or <code>mergeSort</code> is recommended 
     * as these have the potential to be more efficient.
     * <P>
     * <b>Algorithm Implementation:</b> Uses the selection sort algorithm which
     * has a complexity of O(n&sup2;). This implementation repeats the
     * following steps. First the <code>findSmallestIndex</code> method is used 
     * to find the index of the smallest integer between the current index and 
     * final index. Then the <code>swap</code> method is used to switch the 
     * elements of the smallest integer's index and current index. This is 
     * repeated for every index except the last. More information about the 
     * selection sort algorithm can be found 
     * <a href="https://www.geeksforgeeks.org/selection-sort/">here</a>.
     * 
     * @param list A list of integers to be sorted.
     */
    public static void selectionSort(List<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            int nextSmallestIndex = findSmallestIndex(list, i);
            swap(list, i, nextSmallestIndex);
        }// for
    }// selectionSort(List<Integer>)
    
    
    
     /**
     * Moves the element at a specified index left in a list of integers 
     * until an equal or smaller integer is on the index to the left.
     * 
     * Takes the index of an element and moves that element to the next
     * lowest index if the next element is a larger integer. Continues this 
     * process until a smaller or equal integer is encountered then halts. 
     * Used in the <code>SearchAndSort</code> class in the 
     * <code>insertionSort</code> method to move elements while sorting to 
     * their appropriate index in the sorted half of the list 
     * 
     * @param list The integer list where the moving occurs.
     * @param index The index of the element to move left.
     */
    public static void smallestLeft(List<Integer> list, int index) {
        int indexValue = list.get(index);
        int currentIndex = index;
        int nextIndex = index - 1;
        while(nextIndex >= 0 && indexValue < list.get(nextIndex)) {
            swap(list, currentIndex, nextIndex);
            currentIndex = nextIndex;
            nextIndex = nextIndex - 1;
        }// while
    }// smallestLeft(List<Integer>)
    
    
    
    /**
     * Sorts a list of integers to be in ascending order.
     * 
     * <P>
     * <b>Uses and Limitations:</b> Best used for sorting lists of integers to
     * be ordered from smallest to largest. A better choice compared to
     * <code>selectionSort</code> despite having the same worst-case complexity 
     * due to the potential of <code>insertionSort</code> to make fewer 
     * comparisons if the list already has some order to it; however, because
     * of the worst case complexity, still only recommended for small lists
     * where time is not a major constraint. 
     * <P>
     * <b>Algorithm Implementation:</b> Uses the insertion sort algorithm which
     * has a complexity of O(n&sup2;). This implementation uses the 
     * <code>smallestLeft</code> method to move the element located at an 
     * index left until the index directly to the left has a smaller element.
     * This is repeated for every index except the first, starting with the 
     * second. More information about the insertion sort algorithm can be found
     * <a href="https://www.geeksforgeeks.org/insertion-sort/">here</a>.
     * <P>
     * Help Source: 
     * <a href="https://www.interviewbit.com/tutorial/insertion-sort-algorithm/">
     * InterviewBit </a>
     * 
     * @param list A list of integers to be sorted.
     */
    public static void insertionSort(List<Integer> list) {
        for(int i = 1; i < list.size(); i++) {
            smallestLeft(list, i);
        }// for
    }// insertionSort(List<Integer>)
    
    
    
     /**
     * Merges two ordered lists and returns a single ordered list.
     * 
     * The two lists must be integer lists ordered in ascending order. Compares
     * the first element of each list and adds the smallest to a new list. Once
     * one list is completely emptied, all elements of the remaining list are 
     * added to the new list. The resulting list will also be an integer list 
     * ordered in ascending order. Used in the <code>SearchAndSort</code> class 
     * as the recombination aspect of the <code>mergeSort</code> method.
     * <P>
     * <b>Help Source:</b> 
     * <a href="https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/">
     * hackerearth </a>
     * 
     * @param list1 An ordered list of integers.
     * @param list2 An ordered list of integers.
     * @return An ordered list of integers that consists of 
     * list1 and list2 merged. 
     */
    public static List<Integer> mergeLists(List<Integer> list1,
                                            List<Integer> list2) {
        List<Integer> newList = new ArrayList<>();
        int curIndex1 = 0;
        int curIndex2 = 0;
        int listSize1 = list1.size();
        int listSize2 = list2.size();
        
        while(curIndex1 < listSize1 && curIndex2 < listSize2) {
            if(list1.get(curIndex1) <= list2.get(curIndex2)) {
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
    }// mergeLists(List<Integer>, List<Integer>)
    
    
    
    /**
     * Returns a clone of a list of integers that has been sorted to be in
     * ascending order.
     * 
     * <P>
     * <b>Uses and Limitations:</b> Best used for sorting a list of integers to 
     * be from largest to smallest. Generally considered to be more time 
     * efficient compared to <code>selectionSort</code> or 
     * <code>insertionSort</code>. So would usually be recommended over them 
     * for larger lists or when time is a key constraint. This particular 
     * implementation creates a sorted clone rather than sorting a full list 
     * and is recursive, with the potential to create many lists while 
     * executing. So if the original list must be sorted or there is a key 
     * memory constraint, another sort method is recommended.
     * <P>
     * <b>Algorithm Implementation:</b> Uses the merge sort algorithm which has
     * a complexity of O(n log n). This implementation is recursive. If there 
     * is a single element in the passed list, the list is returned as is. 
     * Otherwise, the list is split into two sub-lists at a midpoint and 
     * <code>mergeSort</code> is called on each. Once returned, each sub-list 
     * is combined using the <code>mergeLists</code> method which merges 
     * ordered lists into a single ordered list. This single ordered list is 
     * then returned. More information on the merge sort algorithm can be found
     * <a href="https://www.geeksforgeeks.org/merge-sort/">here</a>.
     * <P>
     * Help Source: 
     * <a href="https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/">
     * hackerearth</a>, Jack Castiglione, Marcus Quirk
     * 
     * @param list A list of integers to be sorted.
     * @return A sorted clone of the passed list.
     */
    public static List<Integer> mergeSort(List<Integer> list) {
        if(list.size() == 1) {
        return list;
        }// if
        
        int min = 0;
        int max = list.size();
        int mid = (max + min) / 2;
        List<Integer> leftList = list.subList(min, mid);
        List<Integer> rightList = list.subList(mid, max);

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);
        List<Integer> newList = mergeLists(leftList, rightList);
        return newList;
    }// mergeSort(List<Integer>)
    
    
    
    /**
     * Tests the various methods featured in this class.
     * 
     * Each method featured in this class has a test 
     * to show their functionality. These lists used in the tests are randomly 
     * generated each time the main is run and designed to be printed onto 
     * the console so rerunning will create new tests. 
     * Below is a brief description of the tests. 
     * <P>
     * <b>randomIntList and printIntList: </b>
     * Tested together by calling them to build a simple list of integers. 
     * The printed list should have 8 elements consisting of integers between 
     * 1 and 99.
     * <P>
     * <b>swap: </b>
     * Tested by calling it to swap the elements at index 0 and index 1 of a 3
     * element list. The second printed list should be identical to the first
     * but with the first and second integers swapped.
     * <P>
     * <b>findSmallestIndex: </b>
     * Tested by calling it to find the smallest integer starting at index
     * 0 for a list of 10 integers. The printed index should match the smallest
     * number in the printed list
     * <P>
     * <b>smallestLeft: </b>
     * Tested by calling it to move the element at index 2 in a 3 element list
     * left until it is directly to the left of a smaller element. The second 
     * printed list should be identical to the first except the third element 
     * should be directly left of a smaller element. Note: This may result in 
     * no movement. 
     * <P>
     * <b>merge: </b>
     * Tested by calling it to merge two smaller sorted lists of 5 integers. 
     * The merged list should have all of the elements of both of the smaller 
     * lists and all the elements should also be ordered from smallest to 
     * largest.
     * <P>
     * <b>sequentialSearch: </b>
     * Tested by calling it to find the first index of a 5 on an unordered list 
     * of 10 integers that number between 1 and 10. The printed index should 
     * correspond to the index of the first 5 in the printed list, or be a -1 
     * if there are no 5s in the list.
     * <P>
     * <b>binarySearch: </b>
     * Tested by calling it to find an index of a 5 on an ordered list 
     * of 10 integers that number between 1 and 10. The printed index should 
     * correspond to the index of a 5 in the printed list, or be a -1 
     * if there are no 5s in the list.
     * <P>
     * <b>Sort Methods: </b>
     * The methods <code>selectionSort</code>, <code>insertionSort</code>, and
     * <code>mergeSort</code> are tested by calling them to sort a list of 10 
     * integers. The second printed list of each should be a version 
     * of the first printed list ordered from smallest to largest.
     */
    public static void main(String [] args) {
        
        // Method Tests
        System.out.println("Searching and Sorting Algorithms Tests");
        System.out.println("_________________________________________________");
        
        
        // randomIntList and printIntList Tests
        System.out.println("randomIntList and printIntList Tests");
        System.out.println("Elements: 8, Max Value: 99");
        List<Integer> testList = randomIntList(8, 99);
        printIntList(testList);
        System.out.println("_________________________________________________");
        
        
        // swap Test
        System.out.println("swap Test");
        List<Integer> swapList = randomIntList(3, 99);
        printIntList(swapList);
        swap(swapList, 0, 1);
        System.out.println("Swap index 0 and 1");
        printIntList(swapList);
        System.out.println("_________________________________________________");
        
        
        // findSmallestIndex Test
        System.out.println("findSmallestIndex Test");
        List<Integer> findList = randomIntList(10, 99);
        printIntList(findList);
        System.out.println("Index of Smallest Starting at Index 0: "
                            + findSmallestIndex(testList, 0));
        System.out.println("_________________________________________________");
        
        
        // smallestLeft Test
        System.out.println("smallestLeft Test");
        List<Integer> leftList = randomIntList(3, 99);
        printIntList(leftList);
        System.out.println("Move index 2 until there is a smaller left number");
        smallestLeft(leftList, 2);
        printIntList(leftList);
        System.out.println("_________________________________________________");
        
        
        // mergeLists Test
        System.out.println("mergeList Test");
        List<Integer> mergeList1 = randomIntList(5, 99);
        System.out.println("Ordered List 1");
        Collections.sort(mergeList1);
        printIntList(mergeList1);
        List<Integer> mergeList2 = randomIntList(5, 99);
        System.out.println("Ordered List 2");
        Collections.sort(mergeList2);
        printIntList(mergeList2);
        System.out.println("Merged List");
        List<Integer> newList = mergeLists(mergeList1, mergeList2);
        printIntList(newList);
        System.out.println("_________________________________________________");
        
   
        // sequentialSearch Test
        System.out.println("sequentialSearch Test");
        List<Integer> sequentialList = randomIntList(10, 10);
        printIntList(sequentialList);
        int sequentialResult = sequentialSearch(sequentialList, 5);
        System.out.println("Target: 5 Index: " + sequentialResult);
        System.out.println("_________________________________________________");


        // binarySearch Test
        System.out.println("binarySearch Test");
        List<Integer> binaryList = randomIntList(10, 10);
        Collections.sort(binaryList);
        printIntList(binaryList);
        int binaryResult = binarySearch(binaryList, 5);
        System.out.println("Target: 5 Index: " + binaryResult);
        System.out.println("_________________________________________________");
        
        
        // selectionSort Test
        System.out.println("selectionSort Test");
        List<Integer> selectionList = randomIntList(10, 99);
        printIntList(selectionList);
        System.out.println("Selection Sorted List");
        selectionSort(selectionList);
        printIntList(selectionList);
        System.out.println("_________________________________________________");
        
        
        // insertionSort Test
        System.out.println("insertionSort Test");
        List<Integer> insertionList = randomIntList(10, 99);
        printIntList(insertionList);
        System.out.println("Insertion Sorted List");
        insertionSort(insertionList);
        printIntList(insertionList);
        System.out.println("_________________________________________________");
        
        // mergeSort Test
        System.out.println("mergeSort Test");
        List<Integer> mergeList = randomIntList(10, 99);
        printIntList(mergeList);       
        System.out.println("Merge Sorted List");
        printIntList(mergeSort(mergeList));
    } // main(String [])
} // SearchAndSort
