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
*		https://www.hackerrank.com/challenges/ctci-making-anagrams
*
*       Strings: Making Anagrams
*
*		Check out the resources on the page's right side to learn more about arrays.
*		The video tutorial is by Gayle Laakmann McDowell, author of the best-selling
*		interview book Cracking the Coding Interview.
*
*		Alice is taking a cryptography class and finding anagrams to be very useful.
*		We consider two strings to be anagrams of each other if the first string's
*		letters can be rearranged to form the second string. In other words, both
*		strings must contain the same exact letters in the same exact frequency
*		For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
*
*		Alice decides on an encryption scheme involving two large strings where
*		encryption is dependent on the minimum number of character deletions required
*		to make the two strings anagrams. Can you help her find this number?
*
*		Given two strings, a and b, that may or may not be of the same length, determine
*		the minimum number of character deletions required to make a and b anagrams.
*		Any characters can be deleted from either of the strings.
*
*		Input Format
*			The first line contains a single string, a.
*			The second line contains a single string, b.
*
*		Constraints
*			1 <= |a|, |b| <= 10^4
*			It is guaranteed that a and b consist of lowercase English alphabetic letters
*				(i.e., a through z).
*
*		Output Format
*			Print a single integer denoting the number of characters you must delete
*			to make the two strings anagrams of each other.
*
*		Sample Input
*			cde
*			abc
*
*		Sample Output
*			4
*
*		Explanation
*			We delete the following characters from our two strings to turn them into
*			anagrams of each other:
*
*			Remove d and e from cde to get c.
*			Remove a and b from abc to get c.
*			We must delete 4 characters to make both strings anagrams,
*			so we print 4 on a new line.
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
	for ( int i = 0; i < a.length(); i++ ) {
		c = a.charAt(i);
		if (hash.containsKey(c))
			n = hash.get(c);
		else n = 0;
		hash.put(c, n + 1);
	}

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
