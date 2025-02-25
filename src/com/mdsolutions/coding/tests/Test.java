package com.mdsolutions.coding.tests;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String s = "ABCDEFGABEitnxukF";
		String maxString = findLongestUniqueSubstring(s);
		System.out.println("Longest substring with unique characters: " + maxString+" "+maxString.length());
	}

	public static String findLongestUniqueSubstring(String s) {
		int n = s.length();
		String longestSubstring = "";
		int start = 0;

		for (int end = 0; end < n; end++) {
			Set<Character> uniqueChars = new HashSet<>();

			for (int i = start; i <= end; i++) {
				if (!uniqueChars.add(s.charAt(i))) {
					start = i + 1;
					break;
				}
			}

			if (end - start + 1 > longestSubstring.length()) {
				longestSubstring = s.substring(start, end + 1);
			}
		}

		return longestSubstring;
	}

}
