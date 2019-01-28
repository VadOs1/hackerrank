package com.gmail.dissa.vadim.hackerrank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Given a 6X6 2D Array, arr:
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * We define an hourglass in A to be a subset of values with indices falling in this pattern in arr's graphical representation:
 * a b c
 *   d
 * e f g
 * There are  16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum 
 * for every hourglass in arr, then print the maximum hourglass sum. 
 * Sample Input
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * Sample Output
 * 19
 * Explanation
 * The hourglass with the maximum sum (19) is:
 * 2 4 4
 *   2
 * 1 2 4
*/
public class Array2d {
	static int hourglassSum(int[][] arr) {
		if (arr == null || arr.length < 3 || arr.length > 6) {
			return 0;
		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i] == null || arr[i].length > 6) {
				return 0;
			}
			for (int k = 0; k < arr[i].length - 2; k++) {
				if (arr[i][k] < -9 || arr[i][k] > 9) {
					return 0;
				}

				int row1 = arr[i][k] + arr[i][k + 1] + arr[i][k + 2];
				int row2 = arr[i + 1][k + 1];
				int row3 = arr[i + 2][k] + arr[i + 2][k + 1] + arr[i + 2][k + 2];
				int tmpResult = row1 + row2 + row3;
				if (tmpResult > result) {
					result = tmpResult;
				}
			}
		}

		return result == Integer.MIN_VALUE ? 0 : result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
