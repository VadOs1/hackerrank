package com.gmail.dissa.vadim.sort;

import java.util.Scanner;

/*Sorting: Bubble Sort
 * 
 * Consider the following version of Bubble Sort:
 * for (int i = 0; i < n; i++) {
 *    for (int j = 0; j < n - 1; j++) {
 *    	 //Swap adjacent elements if they are in decreasing order
 *       if (a[j] > a[j + 1]) {
 *       	swap(a[j], a[j + 1]);
 *       }
 *	  }
 * }
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above. 
 * Once sorted, print the following three lines:
 * Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
 * First Element: firstElement, where firstElement is the first element in the sorted array.
 * Last Element: lastElement, where lastElement is the last element in the sorted array.
 * Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur during execution.
 * For example, given a worst-case but small array to sort: a = [6, 4, 1] we go through the following steps:
 * swap    a
 * 0       [6,4,1]
 * 1       [4,6,1]
 * 2       [4,1,6]
 * 3       [1,4,6]
 * It took 3 swaps to sort the array. Output would be
 * Array is sorted in 3 swaps.
 * First Element: 1
 * Last Element: 6
 * Function Description
 * Complete the function countSwaps in the editor below. It should print the three lines required, then return.
 * countSwaps has the following parameter(s):
 * a: an array of integers.
 * */

public class BubleSort {
	static void countSwaps(int[] a) {

		if (a == null) {
			return;
		}

		int swaps = 0;
		boolean isSorted = false;

		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					int tmp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = tmp;
					swaps++;
					isSorted = false;
				}
			}
		}

		System.out.println("Array is sorted in " + swaps + " swaps. ");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		countSwaps(a);

		scanner.close();
	}
}
