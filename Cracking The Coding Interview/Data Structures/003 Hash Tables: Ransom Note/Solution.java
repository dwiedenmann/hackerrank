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
*		https://www.hackerrank.com/challenges/ctci-ransom-note
*
*       Hash Tables: Ransom Note
*
*		A kidnapper wrote a ransom note but is worried it will be traced back to him.
*		He found a magazine and wants to know if he can cut out whole words from it
*		and use them to create an untraceable replica of his ransom note. The words
*		in his note are case-sensitive and he must use whole words available in the
*		magazine, meaning he cannot use substrings or concatenation to create the words he needs.
*
*		Given the words in the magazine and the words in the ransom note, print Yes
*		if he can replicate his ransom note exactly using whole words from the
*		magazine; otherwise, print No.
*
*		Input Format
*
*		The first line contains two space-separated integers describing the
*		respective values of m (the number of words in the magazine) and n
*		(the number of words in the ransom note).
*		The second line contains m space-separated strings denoting the words
*		present in the magazine.
*		The third line contains n space-separated strings denoting the words
*		present in the ransom note.
*
*		Constraints
*			1 <= m
*			n <= 30000
*			1 <= length of any word <= 5
*			Each word consists of English alphabetic letters (i.e., a to z and A to Z).
*			The words in the note and magazine are case-sensitive.
*
*		Output Format
*			Print Yes if he can use the magazine to create an untraceable replica
*			of his ransom note; otherwise, print No.
*
*		Sample Input
*
*			6 4
*			give me one grand today night
*			give one grand today
*
*		Sample Output
*			Yes
*
*		Explanation
*			All four words needed to write an untraceable replica of the ransom note
*			are present in the magazine, so we print Yes as our answer.
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
