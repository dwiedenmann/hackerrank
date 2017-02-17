/***********************************************************************************************************************
*			  __               __                              __
*		   / /_  ____ ______/ /_____  ______________ _____  / /__
*		  / __ \/ __ `/ ___/ //_/ _ \/ ___/ ___/ __ `/ __ \/ //_/
*		 / / / / /_/ / /__/ ,< /  __/ /  / /  / /_/ / / / / ,<
*		/_/ /_/\__,_/\___/_/|_|\___/_/  /_/   \__,_/_/ /_/_/|_|
*
************************************************************************************************************************
***	Cracking the Coding Interview **************************************************************************************
************************************************************************************************************************
*
*		https://www.hackerrank.com/challenges/ctci-find-the-running-median
*
* 	Heaps: Find the Running Median
*
*		Check out the resources on the page's right side to learn more about arrays.
*		The video tutorial is by Gayle Laakmann McDowell, author of the best-selling
*		interview book Cracking the Coding Interview.
*
*		The median of a dataset of integers is the midpoint value of the dataset for which
*		an equal number of integers are less than and greater than the value. To find the
*		median, you must first sort your dataset of integers in non-decreasing order, then:
*
*		* If your dataset contains an odd number of elements, the median is the middle
*		  element of the sorted sample. In the sorted dataset {1,2,3}, 2 is the median.
*
*		* If your dataset contains an even number of elements, the median is the average
*		  of the two middle elements of the sorted sample.
*		  In the sorted dataset {1,2,3,4}, (2+3)/2 = 2.5 is the median.
*
*		Given an input stream of  integers, you must perform the following task for each  integer:
*			1. 	Add the  integer to a running list of integers.
*			2. 	Find the median of the updated list (i.e., for the first element through the  element).
*			3. 	Print the list's updated median on a new line. The printed value must be a
*				  double-precision number scaled to  decimal place (i.e.,  format).
*
*		Input Format
*			The first line contains a single integer, , denoting the number of integers in the data stream.
*			Each line  of the  subsequent lines contains an integer, , to be added to your list.
*
*		Constraints
*			1 <= n  <= 10^5
*			0 <= ai <= 10^5
*
*		Output Format
*			After each new integer is added to the list, print the list's updated median
*			on a new line as a single double-precision number scaled to  decimal place (i.e.,  format).
*
*		Sample Input
*			6
*			12
*			4
*			5
*			3
*			8
*			7
*
*		Sample Output
*			12.0
*			8.0
*			5.0
*			4.5
*			5.0
*			6.0
*
*		Explanation
*			There are n = 6 integers, so we must print the new median on a new line
*			as each integer is added to the list:
*				1. list = {12}					 -> {12} 						median = 12
*				2. list = {12,4} 				 -> {4,12}, 				median = (12+4)/2 = 8.0
*				3. list = {12,4,5} 			 -> {4,5,12}, 			median = 5.0
*				4. list = {12,4,5,3} 		 -> {3,4,5,12}, 		median = (4+5)/2 = 4.5
*				5. list = {12,4,5,3,8} 	 -> {3,4,5,8,12}, 	median = 5.0
*				6. list = {3,4,5,7,8,12} -> {3,4,5,7,8,12}, median = (5+7)/2 = 6.0
*
***********************************************************************************************************************/

import java.io.*;			// File
import java.util.*;		// Collections & PriorityQueue

//import java.util.PriorityQueue;
//import java.text.*;
//import java.math.*;
//import java.net.*;


/***************************************************************
* Solution
* https://www.hackerrank.com/challenges/ctci-find-the-running-median
* @author   David Wiedenmann
* @version  1.0
* @since    02/16/2017
***************************************************************/
public class Solution {

// Main
public static void main(String[] args) {


	// Debug
	Boolean debug = false;

	// If in debug mode, simply read the input from the file
	if ( debug == true ) {
		try {
			String workingDir = new File(System.getProperty("user.dir")).getParent();
			String projectDir = "Cracking The Coding Interview/Data Structures/008 Heaps: Find the Running Median";
			String inputFile = workingDir + "/" + projectDir + "/input.txt";

			System.setIn(new FileInputStream( new File(inputFile) ));
		} catch (Exception e) {
			//System.out.println("Input file: not found" + inputFile);
			System.out.println(e);
		}
	}
	// String outputFile = debugPath + "output.txt";
	//try {  }
	//catch (IOException e) { System.out.println("InputFile not found"); }
	//}

	// Scan Input
	Scanner sc = new Scanner(System.in);

	// scan the number
	int n = sc.nextInt();

	// Create a MedianQueue Object
	DoubleQueue q = new DoubleQueue(n, debug);

	// loop through the number
	for (int i = 0; i < n; i++) {

		// get the next number
		int num = sc.nextInt();
		//System.out.println(num);

		// add the int to the queue
		System.out.println(q.add(num));

		// display the median
		//System.out.println(q.median());

	}

	// Close the Scanner
	sc.close();
}
}


/***************************************************************
** Heap / Priority Queue
***************************************************************/
class DoubleQueue {

// PriorityQueue
private PriorityQueue<Integer> a;
private PriorityQueue<Integer> b;
private boolean debug;

// Constructor with composite PriorityQueue size
public DoubleQueue(int n, Boolean debug){

	// Ascending
	a = new PriorityQueue<Integer>(n);

	// Descending
	b = new PriorityQueue<Integer>(n, Collections.reverseOrder());

	this.debug = debug;

}

// add an integer to the queue
public double add(int num){

	PriorityQueue<Integer> q;	// the biggest  queue
	PriorityQueue<Integer> s; // the smallest queue

	// add the number
	if (a.size() != 0 && num < a.peek()) {
		q = a;	//a.add(num);
		s = b;
	} else {
		q = b;	//b.add(num);
		s = a;
	}
	s.add(num);

	int k = s.size() - q.size();
	if (k > 1)
		q.add(s.remove());

	if (this.debug) {
		System.out.format("a.size():%s, b.size():%s%n", a.size(), b.size());
		System.out.format("a.peek():%s, b.peek():%s%n", a.peek(), b.peek());
	}
	double m;

	if (k == 1) {
		m = s.peek();
	} else {
		m = ((double)(a.peek() + b.peek()) / 2);
	}
	return m;
}

}
