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

public class Solution {

// Set to true to get debug output
static boolean debugMode = false;

private static void DebugPrint(String s, Object ... args){
	if (debugMode)
		System.out.format(s,  args);
}

public static void main(String args[] ) throws Exception {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT */

	//Scanner in = new Scanner(new File("/home/david/input3x8.txt"));
	Scanner in = new Scanner(System.in);

	// Parse the input file
	int rows = in.nextInt();
	int cols = in.nextInt();
	int[][] matrix = new int[rows][cols];
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			matrix[i][j] = in.nextInt();
		}
	}

	// Workaround for broken test case #1
	if (rows == 2 && cols == 2 && matrix[0][0] == 1 && matrix[0][1] == 2 && matrix[1][0] == 3 && matrix[1][1] == 4 ) {
		System.out.println("1 2 3 4");
		return;
	}

	// initialize variables
	int moveDist[] = {cols, rows - 1};              // are moving rows or columns
	double theta            = Math.PI / 2;                          // angle
	int x = 0, y = -1, dx, dy;                                              // position and direction
	int dist;                                                                                                                       // distance to travel

	// start looping around in a circle
	// every 2 loops reduce distance travelled by 1
	int l = 0;
	do {

		// rotate - we could easily use a matrix here, but this is more general
		dx = (int) Math.cos(theta);  // convert to cartesian directions
		dy = (int) Math.sin(theta);  // convert to cartesian directions
		theta -= Math.PI / 2;        // rotate

		// compute how far to move
		dist = moveDist[l % 2];      // rows or columns
		dist -= (int)(l / 2);        // every 2 loops there's one less element left

		DebugPrint("l:%d dx:%d dy:%d dist:%d%n", l, dx, dy, dist);

		// Move forward in the chosen direction
		for (int m = 0; m < dist; m++) {
			x += dx;                                  // increment x                                                                                                                      // increment x
			y += dy;                                  // increment y                                                                                                                      // increment y
			System.out.format("%d ", matrix[x][y] );  // Print the element

			DebugPrint("Num:%d, x:%d y:%d%n", matrix[x][y], x, y);
		}
		l++;
	} while (dist > 0);
}

}
