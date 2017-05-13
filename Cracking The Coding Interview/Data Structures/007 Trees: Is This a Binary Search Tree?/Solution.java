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
*		https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
*
*       Trees: Is This a Binary Search Tree
*
*		Check out the resources on the page's right side to learn more about arrays.
*		The video tutorial is by Gayle Laakmann McDowell, author of the best-selling
*		interview book Cracking the Coding Interview.
*
*		For the purposes of this challenge, we define a binary search tree to be
*		a binary tree with the following ordering properties:
*
*		The data value of every node in a node's left subtree is less than the data value of that node.
*		The data value of every node in a node's right subtree is greater than the data value of that node.
*
*		Given the root node of a binary tree, can you determine if it's also a binary search tree?
*
*		Complete the function in your editor below, which has 1 parameter:
*		a pointer to the root of a binary tree. It must return a boolean denoting
*		whether or not the binary tree is a binary search tree. You may have to
*		write one or more helper functions to complete this challenge.
*
*		Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values.
*
*		Input Format
*			You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.
*
*		Constraints
*			0 <= data <= 10^4
*
*		Output Format
*			You are not responsible for printing any output to stdout. Your function
*			must return true if the tree is a binary search tree; otherwise, it must return false. Hidden code stubs will print this result as a Yes or No answer on a new line.
*
*		Sample Input
*		     4
*		   /   \
*		  2     6
*		 / \   / \
*		1   3 5   7
*
*		Sample output
*			Yes
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
			String projectDir = "007 Trees: Is This a Binary Search Tree?";
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


/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
boolean checkBST(Node root) {
	Node i = new Node();
	i.data = -1;
	try {
		traverseBST(root, i);
	} catch (Exception e) {
			return false;
	}
	return true;
}

// class MutableInt {
// 	int data;
// 	MutableInt(int i){
// 		this.data = i;
// 	}
// }

void traverseBST(Node n, Node i) throws Exception {

	if (n == null) return;
	traverseBST(n.left, i);
	//System.out.format("previous: %s\n", i.data);
	if (i.data >= n.data) throw new Exception();
	//System.out.format("traverse: %s\n", n.data);
	i.data = n.data;
	traverseBST(n.right, i);
}

		// works but a bit messier
		boolean checkBST(Node root) {
			try {
				traverseBST(root, -1);
			} catch (Exception e) {
					return false;
			}
			return true;
    }


		Integer traverseBST(Node n, Integer i) throws Exception {

			if (n == null) return null;

			Integer l = traverseBST(n.left, i);

			if (l != null) {
				i = l;
				//if (l >= n.data) throw new Exception();
			}

			//System.out.format("previous: %s\n", i);
			if (i >= n.data) throw new Exception();
			//System.out.format("traverse: %s\n", n.data);
			i = n.data;

			Integer r = traverseBST(n.right, i);

			if (r != null){
				i = r;
				//if (r <= n.data) throw new Exception();
			}

			return i;
		}

		// int traverseBST(Node n, Node p){
		// 	if (n == null) return null;
		// 	int l = traverseBST(n.left,  n);
		// 	System.out.println(n.data);
		// 	int r = traverseBST(n.right,  n);
		// 	return r;
		// }


		// boolean traverseBST(Node n, int pData, int sign){
		// 	if (n == null) return true;
		// 	if ( (sign*n.data) <= (sign*pData) ) return false;
		// 	if (!traverseBST(n.left, n.data, -1)) return false;
		// 	if (!traverseBST(n.right, n.data, +1)) return false;
		// 	return true;
		// }

		def traverse_binary_tree(node, callback):
		    if node is None:
		        return
		    traverse_binary_tree(node.leftChild, callback)
		    callback(node.value)
		    traverse_binary_tree(node.rightChild, callback)




		boolean checkBSTMore(Node n, Node p){
			if (n == null) return true;
			// check parent to child relationship
			if (p != null)  {
				if ((p.left  == n) && (n.data >= p.data)) return false;
				if ((p.right == n) && (n.data <= p.data)) return false;
			}
			// check if child node(s) are BST
			return checkBSTMore(n.left, n) && checkBSTMore(n.right, n);
		}


		boolean traverseBST(Node n, int pData, int sign){
			if (n == null) return true;
			if ( (sign*n.data) <= (sign*pData) ) return false;
			return traverseBST(n.left, n.data, -1) && traverseBST(n.right, n.data, +1);
			//return traverseBST(n.left, pData, -1) && traverseBST(n.right, n.data, +1);

		}


}
