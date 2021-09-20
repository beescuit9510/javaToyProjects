package myStringSearch;

import java.util.HashMap;
import java.util.stream.Stream;

public class BoyerMooreMatch {

	static public int bmMatch(String txt, String p) {
		int tp = p.length() - 1; // txt pointer
		int pp = p.length() - 1; // pattern pointer
		HashMap<Character, Integer> table = new HashMap<>();

//		pattern length - last appearing idx - 1;
//		Stream.of(p.split("")).forEach(ch -> table.put(ch[0], p.length()-p.lastIndexOf(ch+"")-1));

		p.chars().forEach(n -> table.put((char) n, p.length() - p.lastIndexOf((char) n) - 1));
		System.out.println(table.entrySet());

		while (tp < txt.length()) {

			System.out.println();
			System.out.println(txt);
			Stream.of(new String[tp]).forEach((a) -> System.out.printf(" "));
			System.out.printf("|\n");
			Stream.of(new String[tp - pp]).forEach((a) -> System.out.printf(" "));
			System.out.println(p);

			pp = p.length() - 1;

			while (txt.charAt(tp) == p.charAt(pp)) {
				System.out.println(txt);
				Stream.of(new String[tp]).forEach((a) -> System.out.printf(" "));
				System.out.printf("|\n");
				Stream.of(new String[tp - pp]).forEach((a) -> System.out.printf(" "));
				System.out.println(p);

				if (pp == 0) {
					return tp;
				}
				pp--;
				tp--;

			}

			int val1 = table.getOrDefault(txt.charAt(tp), p.length());

			int val2 = p.length() - pp;

			tp += val1 > val2 ? val1 : val2;
		}
		return -1;

	}

}
