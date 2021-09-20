package myStringSearch;

import java.util.stream.Stream;

public class BruteForceSearch {

	static public int bfMatch(String txt, String pattern) {

		int tp = 0; // txtPointer
		int pp = 0; // patchPointer

		while (tp != txt.length() && pp != pattern.length()) {
			if (txt.charAt(tp) == pattern.charAt(pp)) {
				tp++;
				pp++;
			} else {
				tp = tp - pp + 1;
				pp = 0;
			}
		}

		if (pp == pattern.length()) {
			return tp - pp;
		}

		return -1;
	}

	static public int bfMatchLast2(String txt, String pattern) {

		int tp = 0; // txtPointer
		int pp = 0; // patchPointer
		int idxToReturn = -1;

		while (tp != txt.length()) {
			if (txt.charAt(tp) == pattern.charAt(pp)) {
				tp++;
				pp++;
			} else {
				tp = tp - pp + 1;
				pp = 0;
			}
			if (pp == pattern.length()) {
				int idx = tp-pp;
				int len = txt.length()-1;
				idxToReturn = (len-idx);
				tp = tp - pp + 1;
				pp = 0;
			}
		}

		return idxToReturn;
	}

	static public int bfMatchWithVisual(String txt, String pattern) {

		int tp = 0; // txtPointer
		int pp = 0; // patchPointer

		while (tp != txt.length() && pp != pattern.length()) {

			System.out.println();
			System.out.println(txt);
			Stream.of(new String[tp]).forEach((a) -> System.out.printf(" "));
			System.out.printf("|\n");
			Stream.of(new String[tp]).forEach((a) -> System.out.printf(" "));
			System.out.println(pattern);

			if (txt.charAt(tp) == pattern.charAt(pp)) {
				tp++;
				pp++;
			} else {
				tp = tp - pp + 1;
				pp = 0;
			}
		}

		if (pp == pattern.length()) {
			return tp - pp;
		}

		return -1;
	}

	static public int bfMatchLast(String txt, String pattern) {
		int tp = txt.length() - 1;
		int pp = pattern.length() - 1;

		while (tp > 0 && pp > 0) {
			if (txt.charAt(tp) == pattern.charAt(pp)) {
				tp--;
				pp--;
			} else {
				tp = tp + ((pattern.length() - 1) - pp) - 1;
				pp = pattern.length() - 1;
			}
		}

		if (pp == 0) {
			return txt.length() - 1 - tp;
		}

		return -1;
	}

}
