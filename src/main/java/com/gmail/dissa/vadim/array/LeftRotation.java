package com.gmail.dissa.vadim.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if 2
 * left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2]. Given an array  a of n
 * integers and a number, perform  left rotations on the array. Return the updated array to be printed as a single line
 * of space-separated integers.
 */

public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {

        for (int i = 0; i < d; i++) {
            int first = a[0];
            System.arraycopy(a, 1, a, 0, a.length - 1);
            a[a.length - 1] = first;
        }

        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
