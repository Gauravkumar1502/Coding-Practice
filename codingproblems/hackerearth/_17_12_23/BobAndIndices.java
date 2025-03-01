package codingproblems.hackerearth._17_12_23;
/*
Bob and Indices                                     Max. score: 100

Bob is given three arrays A, B and C of length N each. A pair of indices (i, j), where O < i,j < N is called good if A[i] is equal to B[C[j]].
Find an integer X denoting the number of good indices.

Input format
    - The first line contains an integer T, which denotes the number of test cases.
    - The first line of each test case contains an integers N, denoting the size of the array A, B and C.
    - The second line of each test case contains N space-separated integers, denoting the array A.
    - The third line of each test case contains N space-separated integers, denoting the array B.
    - The fourth line of each test case contains N space-separated integers, denoting the array C.

Output format
    - For each test case, print an integer .X denoting the number of good indices in a new line.

Constraints
    - 1 <= T <= 10
    - 1 <= N <= 10^5
    - 0 <= A[i], B[i], C[i] <= N

Sample Input
2
3
0 1 2
1 0 1
0 1 2
1
0
0
0

Sample Output
    3
    1

Explanation
    - For test case 1:
        • (0, 1) is a good pair as A[0] = B[C[1]]
        • (1, 2) is a good pair as A[1] = B[C[2]]
        • (1, 0) is a good pair as A[1] = B[C[0]]
        Hence the answer is 3.
    
    - For test case 2: N is 1. So, only one good pair exists.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;
public class BobAndIndices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // number of test cases
        int result[] = new int[T];
        while(T-- > 0){
            int N = Integer.parseInt(reader.readLine().trim()); // size of the array A, B and C        
            int[] A = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] B = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] C = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i = 0; i < N; i++)
                C[C[i]] = B[i];
                
            result[T] = solve(A, B, C);
        }
        for(int i = result.length-1; i >= 0; i--)
            System.out.println(result[i]);
    }

    private static int solve(int[] a, int[] b, int[] c) throws FileNotFoundException, UnsupportedEncodingException {
        HashMap<Integer, Integer> map = new HashMap<>();
        // write to file
        PrintWriter writer = new PrintWriter("./output"+a.length+".txt", "UTF-8");
        for(int i = 0; i < c.length; i++){
            writer.print("a["+i+"] = "+a[i]+", " + "c["+i+"] = "+c[i]+"\n");
        }
        writer.close();
        // set of a 
        HashSet<Integer> set1 = new HashSet<>();
        set1.addAll(Arrays.asList(Arrays.stream(a).boxed().toArray(Integer[]::new)));
        int co = 0;
        for(int i : set1){
            int currentTatal = 0;
            for(int j = 0; j < c.length; j++){
                if(i == c[j]){
                    co++;
                    currentTatal++;
                }
            }
            System.out.println("a["+i+"] = "+a[i]+" currentTatal = "+currentTatal);
        }
        System.out.println("co = "+co);
        for(int i = 0; i < c.length; i++){
            if(map.containsKey(c[i])){
                map.put(c[i], map.get(c[i])+1);
            }else{
                map.put(c[i], 1);
            }
        }
        int count = 0;
        int j = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < a.length; i++){
            if(map.containsKey(a[i]) && !set.contains(a[i])){
                set.add(a[i]);
                count += map.get(a[i]);
                // System.out.println(j++ +" - > "+a[i] + " " + map.get(a[i]));
            }
        }
        return count;
    }
    
}
