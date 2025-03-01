package codingproblems.techgig;
import java.util.Scanner;
/*

    You are given a string S containing two characters 'a' and 'b'. In one operation, you can choose any two non-equal indexes in the string and swap the characters. You have to tell the minimum number of operations needed to make the string non-decreasing.

    We define a string as non-decreasing if S[i] <= S[i+1], holds for every i(0 based) such that (0 <= i <=N-2). 

    Input Format
        The only line of input consists of a string, S.

    Constraints
        1 <= |S|<= 10^5

        |S| - length of the string

    Output Format
        Print the minimum number of operations required to make the string non-decreasing.

    Sample TestCase 1
        Input
        abbab

        Output
        1
        Explanation
        We can choose i=1 and j=3 and swap them, the converted string is aabbb which is non-decreasing.
 */
public class Convertor {
    public static void main(String args[] ) throws Exception {
        String S;
        try (Scanner scanner = new Scanner(System.in)) {
            S = scanner.nextLine().trim();
        }

        int minOperations = minOperationsToNonDecreasing(S);
        System.out.println(minOperations);
    }
    public static int minOperationsToNonDecreasing(String S) {
        int countB = 0, minOperations = 0;
      for (int i = 0; i < S.length(); i++) {
          if (S.charAt(i) == 'b') {
              countB++;
          } else if (countB > 0) {
              minOperations += countB;
              countB--;
          }
      }
      return minOperations/2;
    }
}
