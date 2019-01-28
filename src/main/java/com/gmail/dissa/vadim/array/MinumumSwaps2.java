package com.gmail.dissa.vadim.hackerrank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Minimum Swaps 2
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. 
 * You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the 
 * array in ascending order. For example, given the array arr = [7,1,3,2,4,5,6] we perform the following steps:
 * i   arr                         swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * It took 5 swaps to sort the array.
 */

public class MinumumSwaps2 {
	static int minimumSwaps(int[] arr) {
		Map<Integer, Integer> numberToIndex = IntStream.range(0, arr.length).boxed()
				.collect(Collectors.toMap(i -> arr[i], Function.identity()));

		int swapNum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				int otherIndex = numberToIndex.get(i + 1);

				numberToIndex.put(arr[i], otherIndex);
				numberToIndex.put(i + 1, i);

				swap(arr, i, otherIndex);

				swapNum++;
			}
		}

		return swapNum;

	}

	static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
