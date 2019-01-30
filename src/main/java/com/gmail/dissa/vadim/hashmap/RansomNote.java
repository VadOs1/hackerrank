package com.gmail.dissa.vadim.hashmap;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. 
 * He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica 
 * of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. 
 * He cannot use substrings or concatenation to create the words he needs. Given the words in the magazine and the words in 
 * the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 * For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". 
 * The magazine has all the right words, but there's a case mismatch. The answer is No.
*/

public class RansomNote {
	static void checkMagazine(String[] magazine, String[] note) {
		if (magazine == null || note == null) {
			return;
		}

		List<String> lst = Arrays.stream(magazine).collect(Collectors.toList());

		for (String s : note) {
			if (lst.contains(s)) {
				boolean isRemoved = lst.remove(s);
				if (!isRemoved) {
					System.out.println("No");
					return;
				}
			} else {
				System.out.print("No");
				return;
			}
		}

		System.out.println("Yes");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
