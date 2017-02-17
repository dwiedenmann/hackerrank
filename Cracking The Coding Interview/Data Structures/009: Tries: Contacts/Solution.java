import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;



/***************************************************************
** Solution Object
***************************************************************/
public class Solution {

	// Main 
	public static void main(String[] args) {

		// Debug 
		int debug = 0;

		// Scan Input
		Scanner sc = new Scanner(System.in);

		// Create a StringHashmap Object
		StringHashMap h = new StringHashMap();

		// scan the number
		int n = sc.nextInt();

		// loop through the number
		for (int i = 0; i < n; i++) {

			// get the command and arg 
			String op = sc.next();
			String contact = sc.next();

			// Process input
			switch (op) {
				// Add the String
				case "add":
					h.add(contact);
					break;
				// Lookup the String and display
				case "find":
					int response = h.count(contact);
					System.out.println(response);
					break;
			}

			// Debug
			if (debug == 1)
				System.out.println("Count: " + h.count("s"));

		}


		// Close the Scanner
		sc.close();
	}
}


/***************************************************************
** StringHashMap Search Object
***************************************************************/
class StringHashMap {

	// Composite HashMap Object for next letter in String
	HashMap<Character, StringHashMap> hNext = new HashMap<Character, StringHashMap>();

	// length of string
	int count = 0;

	// Add a String to the HashMap
	void add(String s) {

		// increment the counter
		// a bit hacky, but we always count this even if it's empty 
		// so that it works for strings of length 1
		this.count++;

		// if empty, bail out
		if (s.isEmpty()) {
			return;
		}

		// get the first character
		char first = s.charAt(0);

		// add the next character to the hashmap if it's not already there
		if (!hNext.containsKey(first)) {
			hNext.put(first, new StringHashMap());
		}

		// Add the rest of the string to the hashmap
		hNext.get(first).add(s.substring(1));
	}

	// Count how many characters from the string match the HashMap
	int count(String s) {

		// if empty simply return the number of characters in the hashmap
		if (s.isEmpty()) {
			return count;
		}

		// get the first character
		char first = s.charAt(0);

		// check to see if the next character matches
		if (hNext.containsKey(first))
			// check the rest of the string
			return  hNext.get(first).count(s.substring(1));
		else
			// No match
			return 0;
	}
}