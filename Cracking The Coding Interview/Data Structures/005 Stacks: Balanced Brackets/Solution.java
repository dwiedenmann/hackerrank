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
*		https://www.hackerrank.com/challenges/ctci-balanced-brackets
*
*       Stacks: Balanced Brackets
*
*		A bracket is considered to be any one of the following characters:
*		(, ), {, }, [, or ].
*
*		Two brackets are considered to be a matched pair if the an opening bracket
*		(i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or })
*		of the exact same type. There are three types of matched pairs of brackets:
*		[], {}, and ().
*
*		A matching pair of brackets is not balanced if the set of brackets it
*		encloses are not matched. For example, {[(])} is not balanced because
*		the contents in between { and } are not balanced. The pair of square
*		brackets encloses a single, unbalanced opening bracket, (, and the pair
*		of parentheses encloses a single, unbalanced closing square bracket, ].
*
*		By this logic, we say a sequence of brackets is considered to be balanced
*		if the following conditions are met:
*
*		It contains no unmatched brackets.
*		The subset of brackets enclosed within the confines of a matched pair
*		of brackets is also a matched pair of brackets.
*		Given  strings of brackets, determine whether each sequence of brackets
*		is balanced. If a string is balanced, print YES on a new line; otherwise,
*		print NO on a new line.
*
*		Input Format
*			The first line contains a single integer, n, denoting the number of strings.
*			Each line i of the n subsequent lines consists of a single string, s,
*			denoting a sequence of brackets.
*
*		Constraints
*			1 <= n <= 10^3
*			1 <= length(s) <= 10^3, where  is the length of the sequence.
*			Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
*
*		Output Format
*			For each string, print whether or not the string of brackets is balanced
*			on a new line. If the brackets are balanced, print YES; otherwise, print NO.
*
*		Sample Input
*			3
*			{[()]}
*			{[(])}
*			{{[[(())]]}}
*
*		Sample Output
*			YES
*			NO
*			YES
*
*		Explanation
*			The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
*			The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced. Thus, we print NO on a new line.
*			The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
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


	public static boolean isBalanced(String expression) {

	}

// Main
public static void main(String[] args) {


	// Debug
	Boolean debug = false;

	// If in debug mode, simply read the input from the file
	if ( debug == true ) {
		try {
			String workingDir = new File(System.getProperty("user.dir")).getParent();
			String projectDir = "005 Stacks: Balanced Brackets";
			String inputFile = workingDir + "/" + projectDir + "/input1.txt";

			System.setIn(new FileInputStream( new File(inputFile) ));
		} catch (Exception e) {
			//System.out.println("Input file: not found" + inputFile);
			System.out.println(e);
		}
	}

	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
	}

	// Close the Scanner
	in.close();
}


}
