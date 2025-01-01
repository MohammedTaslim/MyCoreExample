package com.real.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.graphbuilder.math.func.Function;

public class FindingFirstNonRepeatedCharacter {
	
	
	public static void main (String Str[]) {
				
		FindingFirstNonRepeatedCharacter fnr = new FindingFirstNonRepeatedCharacter();
		char ffrn = fnr.firstNonRepeatedCharacter("HNHY%TYGBFRV");
		System.out.println("FindingFirstNonRepeatedCharacter " + ffrn);
		
		
		FindingFirstNonRepeatedCharacter fnr2 = new FindingFirstNonRepeatedCharacter();
		char ffrn2 = fnr2.firstNonRepeatedCharacter2("HNHY%TYGBFRV");
		System.out.println("FindingFirstNonRepeatedCharacter2  " + ffrn2);
		
		FindingFirstNonRepeatedCharacter fnr3 = new FindingFirstNonRepeatedCharacter();
		char ffrn3 = fnr3.firstNonRepeatedCharacter2("HNHY%TYGBFRV");
		System.out.println("FindingFirstNonRepeatedCharacter3 " + ffrn3);
	}
	
	/* it is very fast , In the single traversal approach, we populate an array that's meant to store the
	indexes of all of the characters that appear exactly once in the string. With this array,
	simply return the smallest index containing a non-repeated character */
	
	private static final int EXTENDED_ASCII_CODES = 256;

	public char firstNonRepeatedCharacter(String str) {
	int[] flags = new int[EXTENDED_ASCII_CODES];
	for (int i = 0; i < flags.length; i++) {
	flags[i] = -1;
	}
	for (int i = 0; i < str.length(); i++) {
	char ch = str.charAt(i);
	if (flags[ch] == -1) {
	flags[ch] = i;
	} else {
	flags[ch] = -2;
	}
	}
	int position = Integer.MAX_VALUE;
	for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
	if (flags[i] >= 0) {
	position = Math.min(position, flags[i]);
	}
	}
	return position == Integer.MAX_VALUE ? 	Character.MIN_VALUE : str.charAt(position);
	}

/*
*Another solution consists of looping the string for each character and counting the number of occurrences.
*Every second occurrence (duplicate) simply breaks the loop, jumps to the next character, and repeats the algorithm. 
*If the end of the string is reached, then it returns
*the current character as the first non-repeatable character.
*/
	public char firstNonRepeatedCharacter2(String str) {
		Map<Character, Integer> chars = new LinkedHashMap<>();
		// or use for(char ch: str.toCharArray()) { ... }
		for (int i = 0; i < str.length(); i++) {
		char ch = str.charAt(i);
		chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		for (Map.Entry<Character, Integer> entry: chars.entrySet()) {
		if (entry.getValue() == 1) {
		return entry.getKey();
		}
		}
		return Character.MIN_VALUE;
		}
	
	
	public static String firstNonRepeatedCharacter3(String str) {
		Map<Integer, Long> chs = str.codePoints().mapToObj(cp -> cp).collect(Collectors.groupingBy(Function.identity(),
		LinkedHashMap::new, Collectors.counting()));
		int cp = chs.entrySet().stream().filter(e -> e.getValue() == 1L)
		.findFirst()
		.map(Map.Entry::getKey)
		.orElse(Integer.valueOf(Character.MIN_VALUE));
		return String.valueOf(Character.toChars(cp));
	}
		
}
