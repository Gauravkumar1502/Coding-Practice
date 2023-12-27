package codingproblems.gfg;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Anti Diagonal Traversal of Matrix          
 Difficulty Level : Medium

 Give a N*N square matrix, return an array of its anti-diagonals in top-leftmost to bottom-rightmost order. In an element of a anti-diagonal (i, j), surrounding elements will be (i+1, j-1) and (i-1, j+1). Look at the examples for more clarity.

Example 1:

    Input:
    N = 2
    matrix[][] = 1 2
                3 4
    Output:
    1 2 3 4

    Explanation:
    List of anti-diagnoals in order is
    {1}, {2, 3}, {4}

Example 2:

    Input:
    N = 3
    matrix[][] = 3 2 3
                4 5 1
                7 8 9
    Output:
    3 2 4 3 5 7 1 8 9

    Explanation:
    List of anti-diagnoals in order is
    {3}, {2, 4}, {3, 5, 7}, {1, 8}, {9}

Your Task:
You dont need to read input or print anything. Complete the function antiDiagonalPattern() that takes matrix as input parameter and returns a list of integers in order of the values visited in the anti-Diagonal pattern. 

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(N * N)
 

Constraints:
1 <= N <= 100
0 <= mat[i][j] <= 100
 */
public class AntiDiagonalTraversalOfMatrix {

    public static void main(String[] args) {
        System.out.println("AntiDiagonalTraversalOfMatrix : " + 
            Arrays.toString(antiDiagonalPattern(
            new int[][] { { 1, 2, 3 }, { 4, 5, 6 },{ 7, 8, 9 } })));
        System.out.println("AntiDiagonalTraversalOfMatrix : " +
            Arrays.toString(antiDiagonalPattern(
            new int[][] { { 1, 2 }, { 3, 4 } })));
        System.out.println("AntiDiagonalTraversalOfMatrix : " +
            Arrays.toString(antiDiagonalPattern(
            new int[][] { { 3, 2, 3 }, { 4, 5, 1 }, { 7, 8, 9 } })));
    }
    public static int[] antiDiagonalPattern(int[][] matrix)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(matrix.length + matrix[0].length - 1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                result.add(new ArrayList<Integer>(i + j + 1));
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                result.get(i + j).add(matrix[i][j]);
            }
        }
        int index = 0;
        int[] finalResult = new int[matrix.length * matrix.length];
        for (ArrayList<Integer> row : result) {
            for (int ele : row) {
                if (index == finalResult.length)
                    break;
                finalResult[index++] = ele;
            }
        }
        return finalResult;
    }
}
