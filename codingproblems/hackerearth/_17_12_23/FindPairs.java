package codingproblems.hackerearth._17_12_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Stream;

/*
Find pairs                                       Max. score: 100

Given an array A of length N. Find the number of ordered pairs (i, j) which satisfy the given condition
    - (A[i] — A[j])/(i-j) = 1 
    - A[i] — A[j] should be divisible by i — j
    - i != j

Input format
    - The first line contains an integer N.
    - The second line of each test case contains N space-separated integers, denoting the elements of array A.

Output format
    - Print the number of ordered pairs (i, j) which satisfy the above condition in a new line.

Constraints
    - 1 <= N <= 5 * 10^5
    - 1 <= A[i] <= 10^6

Sample Input
    3
    1 2 3

Sample Output
    6
 */
public class FindPairs {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] A = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(A[i] - i)) {
                map.put(A[i] - i, map.get(A[i] - i) + 1);
            } else {
                map.put(A[i] - i, 1);
            }
        }
        long count = 0;
        for (int i = 0; i < N; i++) {
            if (map.containsKey(A[i] - i)) {
                count += map.get(A[i] - i)-1;
            }
        }
        System.out.println(count);
    }
}
