/*
 * Geek isa software developer working on an algorithm that processes an
integer array arr of length n. The values in arr represent data points, and
each data point falls within the range of 0 to M-1. Geek's task is to modify
the array arr in the minimum number of operations to ensure that the data
points are in non-decreasing order.
In one operation, Geek can increase the value of a data point arr[i] by 1,
taking the modulo M of the result. So the goal is to find the minimum
number of operations required to make the array arr non-decreasing.
Example 1:
Input: 4,1,3,2
m=5
Output:
2
Explanation:
Explanation:
After applying the operations on 0th and 3rd indexes we get the
resultant array as {0,1,3,3} which is non-decreasing . Hence
minimum 2 operations are required.
xample 2:
Input :
m=10
Output:
Explanation:
Array is intially in non-decreasing order so 0 operations are
required.
 */
package codingproblems.gfg.contest;

public class EffcientArrayTransformation {
    public static void main(String[] args) {
        System.out.println(minOperations(4, 5, new int[] { 4, 1, 3, 2 }));
        System.out.println(minOperations(5, 10, new int[] { 0, 0, 1, 3, 7 }));
    }

    public static int minOperations(int n, int m, int arr[]) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                count++;
            }
        }
        return count;
    }
}
