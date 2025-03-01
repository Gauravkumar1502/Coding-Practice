package codingproblems.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem200
 */
public class Problem200 {
    public static void main(String[] args) {
        System.out.println("Case 1: " + new Problem200().numIslands(
            new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}
        ));
        System.out.println("Case 2: " + new Problem200().numIslands(
            new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}
            ));
            System.out.println("Case 3: " + new Problem200().numIslands(
            new char[][] {{'1','1','0','0','0'},{'0','1','1','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}
        ));
    }
    public int numIslands(char[][] grid) {
        List<HashMap<Integer, Integer>> islands = new ArrayList();
        for (int x=0;x<grid.length;x++){
            for (int y=0;y<grid[x].length;y++){
                // System.err.print((val-48)+", ");
                if(isPresentOnListOfSet(islands, x, y)){
                    System.out.println("present");
                }else{
                    System.out.println("not present");
                }
            }
            System.err.println();
        }
        return 0;
    }
    private boolean isPresentOnListOfSet(List<HashMap<Integer, Integer>> islands, int x, int y){
        for(var set: islands){
            if(set.containsKey(x) && set.containsValue(y))
                return true;
        }
        return false;
    }
}