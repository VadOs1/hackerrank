package com.gmail.dissa.vadim.hashmap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Given two strings, determine if they share a common substring. 
 * A substring may be as small as one character.
 * For example, the words "a", "and", "art" share the common substring . 
 * The words "be" and "cat" do not share a substring.
 * Function Description
 * Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.
*/

public class TwoStrings {
	static String twoStrings(String s1, String s2) {
		Set<Character> hs1 = new HashSet<>();
		Set<Character> hs2 = new HashSet<>();

		for (char a1 : s1.toCharArray()) {
			hs1.add(a1);
		}

		for (char a2 : s2.toCharArray()) {
			hs2.add(a2);
		}

		for (char c1 : hs1) {
			for (char c2 : hs2) {
				if (c1 == c2) {
					return "YES";
				}
			}
		}

		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
