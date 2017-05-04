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
*		https://www.hackerrank.com/challenges/ctci-array-left-rotation
*
*       Arrays: Left Rotation
*
*		Check out the resources on the page's right side to learn more about arrays.
*		The video tutorial is by Gayle Laakmann McDowell, author of the best-selling
*		interview book Cracking the Coding Interview.
*
*		A left rotation operation on an array of size  shifts each of the array's
*		elements  unit to the left. For example, if  left rotations are performed
*		on array [1,2,3,4,5], then the array would become [3,4,5,1,2].
*
*		Given an array of n integers and a number, d, perform d left rotations on
*		the array. Then print the updated array as a single line of
*		space-separated integers.
*
*		Input Format
*		The first line contains two space-separated integers denoting the respective
*		values of n (the number of integers) and d (the number of left rotations you
*		must perform).
*		The second line contains n space-separated integers describing the respective
*		elements of the array's initial state.
*
*		Constraints
*		1 <= n <= 10^5
*		1 <= d <= n
*		1 <= ai <= 10^6
*
*		Output Format
*		Print a single line of n space-separated integers denoting the final state
*		of the array after performing d left rotations.
*
*		Sample Input
*		5 4
*		1 2 3 4 5

*		Sample Output
*		5 1 2 3 4

*		Explanation
*		When we perform d=4 left rotations, the array undergoes the following
*		sequence of changes:
*		[1,2,3,4,5]
*		[2,3,4,5,1]
*		[3,4,5,1,2]
*		[4,5,1,2,3]
*		[5,1,2,3,4]
*
*		Thus, we print the array's final state as a single line of space-separated
*		values, which is 5 1 2 3 4.
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
			String projectDir = "001 Arrays: Left Rotation";
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

	// scan the number
	int n = sc.nextInt();
	int k = sc.nextInt();
	int a[] = new int[n];
	for(int a_i = 0; a_i < n; a_i++){
			a[a_i] = sc.nextInt();
	}

	//System.out.println(n);

	int[] output = new int[n];

	output = arrayLeftRotation(a, n, k);
	for(int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

	System.out.println();

	// Close the Scanner
	sc.close();
}

private static int[] arrayLeftRotation(int[] a, int n, int k){
	// handle large k
	//if (k >= n)
	//	k = k % n;

	int r[] = new int[n];

	//int len = a.length;
	for(int i = 0; i < n; i++){
			r[i] = a[(i + k) % n];
	}
	return r;
}

}
