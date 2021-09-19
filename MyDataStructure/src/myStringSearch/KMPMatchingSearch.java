package myStringSearch;

import java.util.stream.IntStream;

public class KMPMatchingSearch {

	static public int kmpMatch(String txt, String patch) {
		int tp = 0; // txt pointer;
		int pp = 0; // patch pointer;
		int[] subString = new int[patch.length()];

		int i = 0;
		for (int j = 1; j < patch.length(); j++) {
			i = patch.charAt(i) == patch.charAt(j) ? ++i : 0;
			subString[j] = i;
		}

//		IntStream.of(subString).forEach(System.out::println);

		while (tp != txt.length() && pp != patch.length()) {
			if (txt.charAt(tp) == patch.charAt(pp)) {
				tp++;
				pp++;
			} else if (pp == 0) {
				tp++;
			} else {
				pp = subString[pp];
			}
		}

		if (pp == patch.length()) {
			return tp - pp;
		}

		return -1;
	}

}
