package myStringSearch;

import java.util.stream.IntStream;

public class KMPMatchingSearch {

	static public int kmpMatch(String txt, String pattern) {
		int tp = 0; // txt pointer;
		int pp = 0; // pattern pointer;
		int[] subString = new int[pattern.length()];

		int i = 0;
		for (int j = 1; j < pattern.length(); j++) {
			i = pattern.charAt(i) == pattern.charAt(j) ? ++i : 0;
			subString[j] = i;
		}

//		IntStream.of(subString).forEach(System.out::println);

		while (tp < txt.length() && pp != pattern.length()) {
			if (txt.charAt(tp) == pattern.charAt(pp)) {
				tp++;
				pp++;
			} else if (pp == 0) {
				tp++;
			} else {
				pp = subString[pp];
			}
		}

		if (pp == pattern.length()) {
			return tp - pp;
		}

		return -1;
	}

}
