package com.real.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {

	public static void main(String str[]) {

		CountingDuplicateCharacters cdc = new CountingDuplicateCharacters();
		Map<Character, Integer> count = cdc.countDuplicateCharacters("#RFVVFR#45erdfcv");
		System.out.println(count);
		
		Map<Character, Long> count2 = cdc.countDuplicateCharacters2("#RFVVFR#45erdfcv");
		System.out.println(count2);
	}

	public Map<Character, Integer> countDuplicateCharacters(String str) {
		Map<Character, Integer> result = new HashMap<>();
		// or use for(char ch: str.toCharArray()) { ... }
		for (int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);

			/*compute is a method from the Map interface.
			For the key ch (current character), the compute method:
			Checks if the value (v) is null (i.e., the character hasn't been encountered yet):
			If null, sets the value to 1 (indicating the character's first occurrence).
			Otherwise, increments the existing value (++v).*/

		}
		return result;
	}


	public Map<Character, Long> countDuplicateCharacters2(String str) {
		Map<Character, Long> result = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return result;

		/*Convert String to Stream of Characters:

			str.chars()
			The chars() method returns an IntStream of Unicode code points representing the characters in the string.
			Map int to Character:

			mapToObj(c -> (char) c)
			Since chars() produces an IntStream, this step maps each int code point (c) to its corresponding Character object.
			This transformation is required because Collectors.groupingBy works with objects, not primitives.
			Group and Count Characters:

			collect(Collectors.groupingBy(c -> c, Collectors.counting()))
			Collectors.groupingBy: Groups elements in the stream by a classifier function. 
			In this case, the classifier is c -> c, meaning it groups characters by themselves.
			Collectors.counting: For each group, counts the number of elements (frequencies).
			The result is a Map<Character, Long> where:

			Each key is a unique character from the string.
			Each value is the count of occurrences of that character.
			Return the Result:

			return result;
			Returns the resulting map containing character frequencies.
		 */


	}





}
