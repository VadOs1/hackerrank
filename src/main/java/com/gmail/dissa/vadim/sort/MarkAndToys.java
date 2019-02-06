package com.gmail.dissa.vadim.sort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Mark and Jane are very happy after having their first child.Their son loves toys,so Mark wants to buy some.
 * There are a number of different toys lying in front of him,tagged with their prices.Mark has only a certain 
 * amount to spend,and he wants to maximize the number of toys he buys with this money.
 * Given a list of prices and an amount to spend,what is the maximum number of toys Mark can buy?
 * For example,if prices = [1,2,3,4] and Mark has k = 7 to spend,he can buy items [1,2,3] for 6, or [3,4] for 
 * 7 units of currency.He would choose the first group of items.
*/

public class MarkAndToys {
	static int maximumToys(int[] prices, int k) {
		if (prices == null) {
			return 0;
		}

		Arrays.sort(prices);
		int total = 0;
		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += prices[i];
			if (sum > k) {
				break;
			}
			total++;
		}
		return total;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] prices = new int[n];

		String[] pricesItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int pricesItem = Integer.parseInt(pricesItems[i]);
			prices[i] = pricesItem;
		}

		int result = maximumToys(prices, k);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
