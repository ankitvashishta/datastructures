package com.ankit.data.structures.strings;

/**
 * Given a word, write a function to generate all of its unique generalized abbreviations.
 *
 * A generalized abbreviation of a word can be generated by replacing each substring of the
 * word with the count of characters in the substring.
 * Take the example of ab which has four substrings: , a, b, and ab.
 * After replacing these substrings in the actual word by the count of characters,
 * we get all the generalized abbreviations: ab, 1b, a1, and 2.
 * 
 * Note: All contiguous characters should be considered one substring,
 * e.g., we cant take a and b as substrings to get 11; since a and b are contiguous,
 * we should consider them together as one substring to get an abbreviation 2.
 * 
 * Example : 
 * Input: "BAT"
 * Output: "BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3"
 */
import java.util.ArrayList;
import java.util.List;

class GeneralizedAbbreviation {

	/*
	 * Runtime Complexity: O(N*(2^N)).
	 * 
	 * Since we had two options for each character, we will have a maximum of 2^N
	 * combinations. While processing each element, we do need to concatenate the
	 * current string with a character. This operation will take O(N), so the
	 * overall time complexity of our algorithm will be O(N*2^N).
	 * 
	 * Space Complexity: O(N*(2^N)).
	 */
	public static List<String> generateGeneralizedAbbreviation(String word) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			StringBuilder strBuilder = new StringBuilder(word);
			strBuilder.setCharAt(i, '1');
			result.add(strBuilder.toString());
		}
		return generateGeneralizedAbbreviation(word, 1, result);
	}

	public static List<String> generateGeneralizedAbbreviation(String word, int index, List<String> result) {
		if (index < word.length()) {
			List<String> resultCopy = new ArrayList<String>(result);
			for (String temp : result) {
				for (int i = 0; i < temp.length(); i++) {
					if (Character.isDigit(temp.charAt(i)))
						continue;
					StringBuilder strBuilder = new StringBuilder(temp);
					if (i > 0) {
						Character ch = temp.charAt(i - 1);
						if (Character.isDigit(ch)) {
							strBuilder.setCharAt(i - 1, ++ch);
							strBuilder.delete(i, i + 1);
						}
					}
					String res = strBuilder.toString();
					if (!resultCopy.contains(res))
						resultCopy.add(strBuilder.toString());
				}
			}
			result = resultCopy;
			return generateGeneralizedAbbreviation(word, ++index, result);
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
		System.out.println("Generalized abbreviation are: " + result);

		result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
		System.out.println("Generalized abbreviation are: " + result);
	}
}
