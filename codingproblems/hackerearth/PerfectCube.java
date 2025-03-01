package codingproblems.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Problem
Given an array 
 of 
 integers.

Find the count of subarrays whose product of elements is a perfect cube.

Input Format:

First line contains an integer 
.
Next line contains 
 space-separated integers denoting the array elements.
Output Format:

Print the number of subarrays whose product of elements is a perfect cube.

Constraints:
1<=N<=10^5
1<=A[i]<=10^5
 

Sample Input
4
2 4 6 36
Sample Output
3
Time Limit: 2
Memory Limit: 256
Source Limit:
Explanation
Three subarrays with product of elements as a perfect cube are
[2, 4] product = 8 (2^3)
[6, 36] product = 216 (6^3)
[2, 4, 6, 36] product = 1728 (12^3)
 */
public class PerfectCube {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr = br.readLine().trim().split(" ");

    }

    public static void windowOfN(int[] arr, int windowSize) {
        for (int i = 0; i < arr.length; i += windowSize) {
            
        }
    }

}
