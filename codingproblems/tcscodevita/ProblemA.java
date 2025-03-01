/*
 * PrimeConstruction
    — Problem Description
        A math game is introduced in a school competition to test the skills of students. The game deals with Prime numbers.
        The game rules are as follows:
            • From the given set of distinct natural numbers as input, consider the smallest natural number as q.
            • Your task is to compute the smallest prime number (p) such that when p is divided by all the distinct numbers in the input, except q, should result q as the remainder.
    
        — Constraints
            1 < n < 11
            p < 10^0
    
    — Input
        Input consists of n+1 number of distinct natural numbers separated by spaces.
   
    — Output
        Print single integer p if such a p exists, else print "None".
    
    — Time Limit (secs)
        1
    — Examples
        Input
        3 4 5 1
        Output
        61

        Explanation
        Here the n+1 numbers are 3, 4, 5 and 1 where q=1 (the least of the numbers)
        The smallest number that leaves remainder 1 when divided by 3, 4 and 5 is 61 and is prime. Hence, output is 61.
        
        Example 2
        Input
        3 4 5 2
        Output
        None
        
        Explanation
        Here q=2. Any number that when divided by 4 leaving remainder 2 must be an even number e.g., 6, IO, 14 etc. 
        Hence it cant be prime. Hence, output is "None"
 */
package codingproblems.tcscodevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemA {
    static BufferedReader reader;
    static StringTokenizer st;
    static PrintWriter out;

    static String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(reader.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        byte[] byteInput = reader.readLine().trim().replaceAll(" ", "").getBytes();
        int input[] = new int[byteInput.length];
        for (int i = 0; i < byteInput.length; i++)
            input[i] = byteInput[i] - 48;
        solve(input);
        out.flush();
        reader.close();
        out.close();
    }

    private static void solve(int[] input) {
        int q = input[0];
        long product = q;
        for (int i = 1; i < input.length; i++) {
            if (input[i] < q)
                q = input[i];
            product *= input[i];
        }
        if (q != 1)
            product = product / q;

        for (long i = product + q; i < Math.pow(10, 10); i += product) {
            if (isPrime(i)) {
                out.println(i);
                return;
            }
            break;
        }
        out.print("None");
    }

    private static boolean isPrime(long i) {
        if (i == 2)
            return true;
        if (i % 2 == 0)
            return false;
        for (long j = 3; j <= Math.sqrt(i); j += 2)
            if (i % j == 0)
                return false;
        return true;
    }
}
