package com.real.problems;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicateCharacters {
	
	public static void main(String str[]) {
		
		CountingDuplicateCharacters cdc = new CountingDuplicateCharacters();
		Map<Character, Integer> count = cdc.countDuplicateCharacters("#RFVVFR#45erdfcv");
		System.out.println(count);
		
	}
	
	public Map<Character, Integer> countDuplicateCharacters(String str) {
		Map<Character, Integer> result = new HashMap<>();
		// or use for(char ch: str.toCharArray()) { ... }
		for (int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}
	
	
	

}
