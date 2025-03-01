package codingproblems.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * DivisorDilemma           Max. score: 100
Once upon a time, there was a curious mathematician named Alice. She loved playing with numbers. One day, she encountered a challenge.
In this challenge, she had to assume that a magical box containing numbers from I to N existed, and she had to select M distinct numbers
from this box such that the sum of their divisors was the greatest, and then report this maximum possible sum of their divisors.
Alice had to solve this puzzle multiple times for various values of N and M since she was quite busy she asked for your help.

The rules of the challenge are:
    1. You have to answer T such puzzles.
    2. For each puzzle, you are provided with two integers, N and M.
    3. Your task is to determine the maximum total sum of the divisors of M distinct numbers from 1 to N.

Input format
    • The first line contains a single integer T, which denotes the number of puzzles.
    • Each of the next T lines contains two integers N and M.

Output format
    For each puzzle, print in a new line the maximum total sum of the divisors of M distinct numbers from 1 to N.

Constraints
    1 <= T <= 10^6
    1 <= M <= N <= 2 * 10^6

SAMPLE INPUT
1
7 3

SAMPLE OUTPUT
27
*/
public class DivisorDilemma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());
        while (testCases-- > 0) {
            String[] nm = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            System.out.println(divisorDilemma(n, m));
        }
        reader.close();
    }

    private static int divisorDilemma(int n, int m) {
        int[] divisorSum = new int[n];
        for (int i = 0; i < n; i++) {
            divisorSum[i] = sumOfDivisors(i + 1);
        }
        // System.out.println(Arrays.toString(divisorSum));
        Arrays.sort(divisorSum);
        // System.out.println(Arrays.toString(divisorSum));
        int sum = 0;
        for (int i = n - 1; i >= n - m; i--) {
            sum += divisorSum[i];
        }
        return sum;
    }

    private static int sumOfDivisors(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    n /= i;
                    count++;
                }
                int term = 1;
                int p = i;
                for (int j = 0; j < count; j++) {
                    term += p;
                    p *= i;
                }
                sum *= term;
            }
        }
        if (n > 1) {
            sum *= (1 + n); // If n is prime, add (1 + n) to the sum
        }
        return sum;
    }
}
