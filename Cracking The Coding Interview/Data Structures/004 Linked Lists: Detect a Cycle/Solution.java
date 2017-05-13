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
*		https://www.hackerrank.com/challenges/ctci-linked-list-cycle
*
*       Linked Lists: Detect a Cycle
*
*		A linked list is said to contain a cycle if any node is visited more than
*		once while traversing the list.
*
*		Complete the function provided in the editor below. It has one parameter:
*		a pointer to a Node object named head that points to the head of a linked
*		list. Your function must return a boolean denoting whether or not there
*		is a cycle in the list. If there is a cycle, return true; otherwise,
*		return false.
*
*		Note: If the list is empty,  will be null.
*
*		Input Format
*			Our hidden code checker passes the appropriate argument to your function. You are not responsible for reading any input from stdin.
*
*		Constraints
*			0 <= list size <= 100
*
*		Output Format
*			If the list contains a cycle, your function must return true. If the
*			list does not contain a cycle, it must return false. The binary integer
*			corresponding to the boolean value returned by your function is printed
*			to stdout by our hidden code checker.
*
*		Sample Input
*			The following linked lists are passed as arguments to your function:
*
*			1 -> NULL
*			1 -> 2 -> 3
*			       <-
*
*		Sample Output
*			0
*			1
*
*		Explanation
*			The first list has no cycle, so we return false and the hidden code
*			checker prints 0 to stdout.
*			The second list has a cycle, so we return true and the hidden code
*			checker prints 1 to stdout.
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


	/*
	Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

	A Node is defined as:
	    class Node {
	        int data;
	        Node next;
	    }
	*/

	boolean hasCycle(Node head) {

	}


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
