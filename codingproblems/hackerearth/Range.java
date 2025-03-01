package codingproblems.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Range {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(Solve(n));
        wr.close();
        br.close();
    }

    private static int Solve(int n) {
        int result = 0;
        int[] targets = new int[n];
        for (int i = 0; i < n; i++) {
            targets[i] = i + 1;
        }

        while (targets.length > 1) {
            int[] temp = new int[targets.length / 2];
            // remove index 1, 3, 5, 7 from targets and add to result and also add 2, 4, 6,
            // 8 to temp
            int index = 0;
            for (int i = 0; i < targets.length; i += 2) {
                result += targets[i];
                if (i + 1 < targets.length) {
                    temp[index++] = targets[i + 1];
                }
            }
            targets = temp;
        }
        return result;
    }

}