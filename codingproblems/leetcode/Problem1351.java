package codingproblems.leetcode;

/*
 * 1351. Count Negative Numbers in a Sorted Matrix
 * 
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 * 
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *  
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *  
 * 
 * Follow up: Could you find an O(n + m) solution?
 */
public class Problem1351 {
    public int countNegatives(int[][] grid) {
        // Using Array in O(n + m)

        int count = 0;
        for (int i = 0; i < (grid.length * grid[0].length); i++) {
            if (grid[i / grid[0].length][i % grid[0].length] < 0) {
                count++;
            }
        }
        return count;

        // Using Binary Search
    }
}
