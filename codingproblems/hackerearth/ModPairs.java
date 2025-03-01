package codingproblems.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Mod Pairs    Max. score: 100
Given an array A of N elements, a prime number P and an integer K. It is guaranteed all the elements in the array are distinct.

Find the number of pairs of indices (i, j) such that (1 <= i < j <= N) and (A[i] + A[j]) x (A[i]^2 + A[j]^2) ) === K mod P
Note: 1 based indexing is followed.

Input format
The first line contains 3 space-separated integers N, P, K.
• The second line contains N space-separated integers denoting the array A.

Output format
Print the number of pairs of indices which satisfy the given condition in a new line.

Constraints
2 <= N <= 10^5
—0 <= K, A[i] <= P - 1
2 <= P <= 10^5

SAMPLE INPUT
3 3 0
0 1 2

SAMPLE OUTPUT
1
 */
public class ModPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] npk = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(npk[0]);
        int p = Integer.parseInt(npk[1]);
        int k = Integer.parseInt(npk[2]);
        int[] a = new int[n];
        String[] aStr = reader.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }
        System.out.println(modPairs(a, p, k));
    }

    private static int modPairs(int[] a, int p, int k) {
        /*
         * time complexity: O(n^2)
         * 
         * int count = 0;
         * for (int i = 0; i < a.length - 1; i++) {
         * for (int j = i + 1; j < a.length; j++) {
         * if ((a[i] + a[j]) * (a[i] * a[i] + a[j] * a[j]) % p == k) {
         * count++;
         * }
         * }
         * }
         * return count;
         */

        /*
         * time complexity: O(n^2)
         * 
         * int count = 0;
         * for (int i = 0; i < a.length; i++) {
         * long square = (long) Math.pow(a[i], 2);
         * for (int j = i + 1; j < a.length; j++) {
         * long sum = a[i] + a[j];
         * long product = sum * (square + (long) Math.pow(a[j], 2));
         * if (product % p == k) {
         * count += 1;
         * }
         * }
         * }
         * return count;
         */
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            long square = (long) Math.pow(a[i], 2);
            for (int j = i + 1; j < a.length; j++) {
                long sum = a[i] + a[j];
                if (sum % p != k)
                    continue;
                long product = sum * (square + (long) Math.pow(a[j], 2));
                if (product % p == k) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
