package com.gmail.dissa.vadim.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Alice is taking a cryptography class and finding anagrams to be very useful. 
 * We consider two strings to be anagrams of each other if the first string's 
 * letters can be rearranged to form the second string. In other words, both 
 * strings must contain the same exact letters in the same exact frequency. 
 * For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 * Alice decides on an encryption scheme involving two large strings where 
 * encryption is dependent on the minimum number of character deletions 
 * required to make the two strings anagrams. Can you help her find this number?
 * Given two strings, a and b, that may or may not be of the same length, determine 
 * the minimum number of character deletions required to make a and b anagrams. 
 * Any characters can be deleted from either of the strings. For example, 
 * if a = cde and b = dcf , we can delete e from string a and f from string b 
 * so that both remaining strings are cd and dc which are anagrams.*/

public class MakingAnagrams {
	static int makeAnagram(String a, String b) {
		int count1[] = new int[26];
		int count2[] = new int[26];

		// count frequency of each charcter in first string
		for (int i = 0; i < a.length(); i++) {
			count1[a.charAt(i) - 'a']++;
		}			

		// count frequency of each charcter in second string
		for (int i = 0; i < b.length(); i++) {
			count2[b.charAt(i) - 'a']++;
		}
			
		// traverse count arrays to find number of charcters to be removed
		int result = 0;
		for (int i = 0; i < 26; i++) {
			result += Math.abs(count1[i] - count2[i]);
		}
			
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String a = scanner.nextLine();

		String b = scanner.nextLine();

		int res = makeAnagram(a, b);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
