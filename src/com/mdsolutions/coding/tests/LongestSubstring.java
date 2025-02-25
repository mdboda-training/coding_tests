package com.mdsolutions.coding.tests;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		String s="ABCDEFGABEF";
		Set<String> maxLengthStringSet = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			maxLengthStringSet.add( test(s.substring(i, s.length())));
		}
		 int maxLength = maxLengthStringSet.stream()
                 .mapToInt(String::length)
                 .max()
                 .orElse(0);
		 System.out.println(maxLength);
		 maxLengthStringSet.stream()
                 .filter(s1 -> s1.length() == maxLength)
                 .forEach(System.out::println);
	}

	private static String test(String s) {
		String[] sArray = s.split("");
		String maxLengthString = "";
		boolean islastIndex = false;
		StringBuilder sB = new StringBuilder();
		boolean foundDuplicate = false;
		for (int index = 0; index < s.length() && !foundDuplicate; index++) {
			if (index == s.length() - 1) {
				islastIndex = true;
				sB.append(sArray[index]);
			}
			if (sB.toString().contains(sArray[index]) || islastIndex) {
				foundDuplicate = true;
				maxLengthString = sB.toString();
//				System.out.println(sB.toString() + ":" + sB.toString().length());
			}
			sB.append(sArray[index]);
		}
		return maxLengthString;

	}
}
