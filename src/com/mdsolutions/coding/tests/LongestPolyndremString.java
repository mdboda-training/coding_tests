package com.mdsolutions.coding.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class LongestPolyndremString {
	public static void main(String[] args) {
//		String input = "lirliriliri";
		String input = "racecar";
		Map<Character, List<Integer>> charsAndIndexes = new HashMap<Character, List<Integer>>();
		IntStream.range(0, input.length()).forEach(index -> {
			charsAndIndexes.computeIfAbsent(input.charAt(index), k -> new ArrayList<Integer>()).add(index);
		});
		System.out.println(charsAndIndexes);
		Set<String> polyndremStrings = new HashSet<String>();
		charsAndIndexes.forEach((c, indexes) -> {
			for (int loop = 0; loop < indexes.size(); loop++) {
				int startIndex = indexes.get(loop);
				for (int i = loop + 1; i < indexes.size(); i++) {
					String s1 = new String(input.substring(startIndex, indexes.get(i) + 1));
					if (s1.equals(new StringBuilder(s1).reverse().toString())) {
						polyndremStrings.add(s1);
					}
				}
			}
		});
		System.out.println(polyndremStrings);
	}
}
