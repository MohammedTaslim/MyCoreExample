package com.real.problems;

import java.util.Map;

public class CheckingWhetherAStringContainsOnly {
	
	public static void main(String str[]) {

		CheckingWhetherAStringContainsOnly cwa = new CheckingWhetherAStringContainsOnly();
		boolean ba = cwa.containsOnlyDigits("Taslim9");
		System.out.println("containsOnlyDigits =" +ba );
		boolean ba1 = cwa.containsOnlyDigits("7869");
		System.out.println("containsOnlyDigits1 =" +ba1 );
		
		boolean ba2 = cwa.containsOnlyDigits2("7869");
		System.out.println("containsOnlyDigits2 =" +ba2 );
		
		boolean ba3 = cwa.containsOnlyDigits3("7869");
		System.out.println("containsOnlyDigits3 =" +ba3 );
		
	}

	/*
	 * The solution relying on Character.isDigit() is pretty simple and fast—loop the
       string characters and break the loop if this method returns false:
	 * 
	 * 
	 */
	
	public static boolean containsOnlyDigits(String str) {
		for (int i = 0; i < str.length(); i++) {
		if (!Character.isDigit(str.charAt(i))) {
		return false;
		}
		}
		return true;
		}
	
	/*
	 * .str.chars() -This converts the string str into an IntStream, where each element in the stream represents the Unicode value of a character in the string.
	 * .anyMatch(n -> !Character.isDigit(n))n -> !Character.isDigit(n): This is a lambda expression. 
	 * For each character n in the stream (represented by its Unicode value), 
	 * it checks whether the character is not a digit using the Character.isDigit(n) method.
	 * anyMatch(): This method returns true if any element in the stream matches the given predicate (in this case, if it is not a digit).
	 * 
	 * */
	public static boolean containsOnlyDigits2(String str) {
		return !str.chars()
		.anyMatch(n -> !Character.isDigit(n));
		}
/*
 * Another solution relies on String.matches(). This method returns a
 * boolean value indicating whether or not this string matches the given regular expression:
 * */
	
	
	public static boolean containsOnlyDigits3(String str) {
		return str.matches("[0-9]+");
		}
	
	
	
}
