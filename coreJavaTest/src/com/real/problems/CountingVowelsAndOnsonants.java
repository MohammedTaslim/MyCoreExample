package com.real.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;



public class CountingVowelsAndOnsonants {
	
	private static final Set<Character> allVowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountingVowelsAndOnsonants cvo = new CountingVowelsAndOnsonants();
		Pair<Integer, Integer> p =CountingVowelsAndOnsonants.countVowelsAndConsonants("Mohammad Taslim");
		System.out.println("countVowelsAndConsonants ="+ p.toString());
		}
	
	
	public static Pair<Integer, Integer>countVowelsAndConsonants(String str) {
	str = str.toLowerCase();
	int vowels = 0;
	int consonants = 0;
	for (int i = 0; i < str.length(); i++) {
	char ch = str.charAt(i);
	if (allVowels.contains(ch)) {
	vowels++;
	} else if ((ch >= 'a' && ch <= 'z')) {
	consonants++;
	}
	}
	return Pair.of(vowels, consonants);
	}		
	
	

}
