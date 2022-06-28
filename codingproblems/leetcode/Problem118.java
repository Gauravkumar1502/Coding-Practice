package codingproblems.leetcode;

import java.util.List;
import java.util.ArrayList;

/*
 * 118. Pascal's Triangle
 * 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * 
 * Input: numRows = 1
 * Output: [[1]]
 *  
 * 
 * Constraints:
 * 
 * 1 <= numRows <= 30
 */
public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    temp.add(1);
                } else {
                    int previousElement1 = result.get(i - 2).get(j - 1);
                    int previousElement2 = result.get(i - 2).get(j - 2);
                    temp.add(previousElement1 + previousElement2);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
