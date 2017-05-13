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
*		https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
*
*       Queues: A Tale of Two Stacks
*
*		A queue is an abstract data type that maintains the order in which
*		elements were added to it, allowing the oldest elements to be removed
*		from the front and new elements to be added to the rear. This is called
*		a First-In-First-Out (FIFO) data structure because the first element
*		added to the queue (i.e., the one that has been waiting the longest)
*		is always the first one to be removed.
*
*		A basic queue has the following operations:
*			Enqueue: add a new element to the end of the queue.
*			Dequeue: remove the element from the front of the queue and return it.
*
*		In this challenge, you must first implement a queue using two stacks.
*		Then process queries, where each query is one of the following  types:
*			1 x: Enqueue element x into the end of the queue.
*			2: Dequeue the element at the front of the queue.
*			3: Print the element at the front of the queue.
*
*		Input Format
*			The first line contains a single integer, q, denoting the number of queries.
*			Each line i of the q subsequent lines contains a single query in the form
*			described in the problem statement above. All three queries start with an
*			integer denoting the query type, but only query 1 is followed by an
*			additional space-separated value, x, denoting the value to be enqueued.
*
*		Constraints
*			1 <= q <= 10^5
*			1 <= type <= 3
*			1 <= |x| <= 10^9
*			It is guaranteed that a valid answer always exists for each query of type 3.
*
*		Output Format
*			For each query of type 3, print the value of the element at the front of
*			the queue on a new line.
*
*		Sample Input
*			10
*			1 42
*			2
*			1 14
*			3
*			1 28
*			3
*			1 60
*			1 78
*			2
*			2
*
*		Sample Output
*			14
*			14
*
*		Explanation
*			We perform the following sequence of actions:
*			Enqueue 42; 																		queue = {42}.
*			Dequeue the value at the head of the queue, 42; queue = {}.
*			Enqueue 14; 																		queue = {14}.
*			Print the value at the head of the queue, 14; 	queue = {14}.
*			Enqueue 28; 																		queue = {14, 28}.
*			Print the value at the head of the queue, 14; 	queue = {14, 28}.
*			Enqueue 60; 																		queue = {14, 28, 60}.
*			Enqueue 78; 																		queue = {14, 28, 60, 78}.
*			Dequeue the value at the head of the queue, 14; queue = {28, 60, 78}.
*			Dequeue the value at the head of the queue, 28; queue = {60, 78}.
*
*
***********************************************************************************************************************/


/*
 * This comment is NOT a class level javadoc comment.
 * Such comments appear just above the class declaration, not at the
 * start of the file.
 */
import java.lang.Math;
import java.io.*;
import java.util.*;
//import java.util.HashTable;


public class Solution {

// Main
public static void main(String[] args) {


	// Debug
	Boolean debug = false;

	// If in debug mode, simply read the input from the file
	if ( debug == true ) {
		try {
			String workingDir = new File(System.getProperty("user.dir")).getParent();
			String projectDir = "002 Strings: Making Anagrams";
			String inputFile = workingDir + "/" + projectDir + "/input1.txt";

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

	// scan the strings
	String a = sc.nextLine();
	String b = sc.nextLine();
	System.out.println(numberNeeded(a, b));

	// Close the Scanner
	sc.close();
}

private static int numberNeeded(String a, String b){
	// handle large k
	//if (k >= n)
	//	k = k % n;

	//System.out.println(a);
	//System.out.println(b);

	Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();

	char c = '\u0000';
	int n;

	// Count characters in string a
	for ( int i = 0; i < a.length(); i++ ) {
		c = a.charAt(i);
		if (hash.containsKey(c))
			n = hash.get(c);
		else n = 0;
		hash.put(c, n + 1);
	}

	// Count characters in string b
	for ( int i = 0; i < b.length(); i++ ) {
		c = b.charAt(i);
		//System.out.println(c);
		if (hash.containsKey(c))
			n = hash.get(c);
		else n = 0;
		hash.put(c, n - 1);
	}

	int d = 0;
	for(Character key: hash.keySet()) {
		d += Math.abs(hash.get(key));
		//System.out.format("%s: %d\n", key, hash.get(key));
	}

	return d;

}
}
