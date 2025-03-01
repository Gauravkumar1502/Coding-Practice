package codingproblems.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Swap Sum             Max. score: 100
You are given two arrays, A and B of length N. In one operation, you can swap Ali] and B[il. Find the maximum sum of A after
performing at most K operations.

Input format
• The first line contains an integer T, denoting the number of test cases.
The first line of each test case contains two integers, N and K.
• The second line of each test case contains N space-separated integers, elements of array A.
The third line of each test case contains N space-separated integers, elements of array B.

Output format
For each test case, print the maximum sum of A after performing at most K operations in a new line.

Constraints
1 <= T <= 10
1 <= N <= 10^5
0<= A[i], B[i] <= 10^3

SAMPLE INPUT
2
5 3
1 3 1 3 1
2 4 1 6 5
3 1
1 5 1
3 4 2

SAMPLE OUTPUT
17
9

Explanation
For test case 1: We can perform the operations at indexes 2, 4, and 5 (1 -based indexing). A becomes [1, 4, 1, 6, 51. Hence, the answer is 17.
For test case 2: We can perform the operations at index 1 (1 -based indexing). A becomes [3, 5, II. Hence, the answer is 9.
 */
public class SwapSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        while (testCases-- > 0) {
            String[] nk = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] a = new int[n];
            int[] b = new int[n];
            String[] aStr = reader.readLine().trim().split(" ");
            String[] bStr = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(aStr[i]);
                b[i] = Integer.parseInt(bStr[i]);
            }
            System.out.println(swapSum(a, b, k));
        }

        reader.close();
    }

    private static int swapSum(int[] a, int[] b, int k) {
        int sum = 0;
        int[] diff = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            diff[i] = b[i] - a[i];
            sum += a[i];
        }
        // sort the diff array
        Arrays.sort(diff);
        // System.out.println("Sorted array : " + Arrays.toString(diff));
        for (int i = diff.length - 1; k > 0 && i >= 0; i--, k--) {
            if (diff[i] > 0) {
                sum += diff[i];
            } else {
                break;
            }
        }
        return sum;
    }
}
