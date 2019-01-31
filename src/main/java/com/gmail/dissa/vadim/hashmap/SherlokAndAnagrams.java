package com.gmail.dissa.vadim.hashmap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form 
 * the other string. Given a string, find the number of pairs of substrings of the string that 
 * are anagrams of each other.
 * For example s = mom, the list of all anagrammatic pairs is [m,m], [mo, om] at positions 
 * [[0],[2]],[[0,1],[0,2]]respectively.
 * Function Description
 * Complete the function sherlockAndAnagrams in the editor below. It must return an integer 
 * that represents the number of anagrammatic pairs of substrings in s.
*/

public class SherlokAndAnagrams {
	static int sherlockAndAnagrams(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return 0;
		}

		int numOfChars = 1;
		int result = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			for (int l = 0; l < s.length() - i - 1; l++) {
				String val1 = s.substring(l, numOfChars + l);
				for (int k = l + 1; k < s.length() - i; k++) {
					String val2 = s.substring(k, numOfChars + k);
					if (isAnagram(val1, val2)) {
						result++;
					}
				}
			}
			numOfChars++;
		}
		return result;
	}

	static boolean isAnagram(String s, String t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		int[] letters = new int[26];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			if (--letters[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();
			int result = sherlockAndAnagrams(s);
			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
		scanner.close();
	}
}
