/*
 * A. Increasing Sequence
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
You are given a sequence a1,a2,…,an
. A sequence b1,b2,…,bn
 is called good, if it satisfies all of the following conditions:

bi
 is a positive integer for i=1,2,…,n
;
bi≠ai
 for i=1,2,…,n
;
b1<b2<…<bn
.
Find the minimum value of bn
 among all good sequences b1,b2,…,bn
.
Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤100
). The description of the test cases follows.

The first line of each test case contains a single integer n
 (1≤n≤100
).

The second line of each test case contains n
 integers a1,a2,…,an
 (1≤ai≤109
).

Output
For each test case, print a single integer — the minimum value of bn
 among all good sequences b
.

Example
inputCopy
3
5
1 3 2 6 7
4
2 3 4 5
1
1
outputCopy
8
4
2
Note
In the first test case, b=[2,4,5,7,8]
 is a good sequence. It can be proved that there is no good b
 which b5<8
.

In the second test case, b=[1,2,3,4]
 is an optimal good sequence.

In the third test case, b=[2]
 is an optimal good sequence.
 */
package codingproblems.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IncreasingSequence {

    static BufferedReader in;
    static StringTokenizer st;
    static PrintWriter out;

    static String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = nextInt();
            while (t-- > 0) {
                int n = nextInt();
                int[] a = new int[n];

                for (int j = 0; j < n; j++)
                    a[j] = nextInt();

                int min = (a[0] == 1) ? 2 : 1;
                for (int j = 1; j < n; j++) {
                    int currentMin = Math.min(min + 1, a[j]);
                    if (currentMin == a[j]) {
                        currentMin = currentMin + 1;
                    }
                    if (currentMin <= min)
                        currentMin = min + 1;

                    min = Math.max(min, currentMin);
                }
                out.println(min);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}