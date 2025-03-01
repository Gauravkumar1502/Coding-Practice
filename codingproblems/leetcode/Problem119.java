package codingproblems.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * 119. Pascal's Triangle II
 * 
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * 
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * 
 * Input: rowIndex = 1
 * Output: [1,1]
 *  
 * 
 * Constraints:
 * 
 * 0 <= rowIndex <= 33
 *  
 * 
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);
        for (int j = 0; j <= rowIndex; j++) {
            if (j == 0 || j == rowIndex) {
                result.add(1);
            } else {
                result.add((int) ((long) result.get(j - 1) * (rowIndex - j + 1) / j));
            }
        }
        return result;
    }

    public List<Integer> getRow1(int rowIndex) {
        return IntStream.range(0, rowIndex + 1)
                .map(i -> combination(rowIndex, i)).boxed().toList();
    }

    private int combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
    // public List<Integer> getRow(int rowIndex) {
    // List<Integer> result = new ArrayList<>(rowIndex);
    // long prev = 1; // nc0
    // result.add((int)prev);
    // for (int j = 1; j <= rowIndex; j++) {
    // long current = (long) (prev * (rowIndex - j + 1)) / j; // nCr = (nCr-1 * (n -
    // r + 1))/r
    // System.out.println((int)current);
    // prev = current;
    // result.add((int)current);
    // }
    // return result;
    // }
}
