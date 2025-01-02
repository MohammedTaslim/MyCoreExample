package com.real.problems;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReversingLettersAndWords {
	private static final String WHITESPACE = " ";
	private static final Pattern PATTERN = Pattern.compile(" +");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReversingLettersAndWords rlw = new ReversingLettersAndWords();
		String rs=rlw.reverseWords("Mohammad Taslim");
		System.out.println("Reversed String =="+ rs);

		String rs2=rlw.reverseWords2("Mohammad Taslim");
		System.out.println("Reversed String =="+ rs2);

		String rs3=rlw.reverseWords2("Hello Words");
		System.out.println("Reversed String =="+ rs3);
	}

	/*
	 * Reversing each word: Instead of manually reversing each word with a for loop, we use new StringBuilder(word).reverse(), 
	 * which directly reverses the word.
	 * Handling trailing whitespace: The .trim() method is used on the final result 
	 * to remove any extra space that might be added after the last word. 	
	 */

	public String reverseWords(String str) {
		String[] words = str.split(WHITESPACE);
		StringBuilder reversedString = new StringBuilder();
		for (String word: words) {
			StringBuilder reverseWord = new StringBuilder();
			for (int i = word.length() - 1; i >= 0; i--) {
				reverseWord.append(word.charAt(i));
			}
			reversedString.append(reverseWord).append(WHITESPACE);
		}
		return reversedString.toString();
	}


	public String reverseWords2(String str) {
		
		String[] words = str.split(WHITESPACE);
		StringBuilder reversedString = new StringBuilder();

		for (String word : words) {
			reversedString.append(new StringBuilder(word).reverse()).append(WHITESPACE);
		}	    
		return reversedString.toString().trim(); // trim to remove the trailing whitespace
	}
	
	/*
	 * 
	 * PATTERN.splitAsStream(str):
	PATTERN is most likely a predefined Pattern object that splits the input string str based on a specific pattern (e.g., whitespace or other delimiters).
	The method splitAsStream() splits the input string str into substrings (or words) and returns a Stream<String>.
	The resulting stream will contain each word or token (depending on the pattern) from the input string.
	Example:

	If PATTERN is a regular expression for whitespace (e.g., \\s+), then PATTERN.splitAsStream(str) will create a stream of words from the string 
	str.map(w -> new StringBuilder(w).reverse()):

	This is using the map function of the stream to transform each word (w) into its reversed version.
	new StringBuilder(w) creates a StringBuilder object for each word w.reverse() is a method of StringBuilder that reverses the characters in the word.
	Example:
	For a word "Hello", it will reverse it to "olleH".collect(Collectors.joining(" ")):

	After mapping each word to its reversed form, the collect operation is used to gather the results into a single string.
	Collectors.joining(" ") is a collector that joins all the reversed words, inserting a single space (" ") between them.

	Example:

	If the reversed words are "olleH" and "dlroW", this will join them into the string "olleH dlroW".
	 * 
	 * 
	 */
	
	public static String reverseWords3(String str) {
		
		try {
			return PATTERN.splitAsStream(str).map(w -> new StringBuilder(w).reverse()).collect(Collectors.joining(" "));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		}

}
