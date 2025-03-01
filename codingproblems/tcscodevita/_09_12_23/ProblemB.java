package codingproblems.tcscodevita._09_12_23;
/*
 WareHouse
— Problem Description
    A godown, which in other words called as a warehouse, is a building which is used to store raw materials or manufactured goods until they are exported to 
    other places.
    There are n number of go-downs which are used to store and ripe large quantity of bananas. Once the bananas are ripened, every godown owner will pack all 
    those bananas as a single unit and transport them to airport for exporting them to other countries. 
    All these godowns are close to each other and the owners are friendly. So while transporting the bananas, they would like to share the vehicle 
    (if possible) in order to reduce the transportation cost. But only two people can share a vehicle and each vehicle can carry a weight of "w" tons at a time.
    Given an array representing the weights of bananas of each owner, the maximum limit that the vehicle can hold, 
    find the minimum number vehicles needed to transport all the bananas to the airport.
    Note: There are no loads which are heavier than the given limit.
    The weight of the bananas is measured in tons.

— Constraints
    0 <= len(arr) <= 10^5
    0 <= arr[i] <= 10^5
    The array may have duplicate numbers.

— Input
    First line consists of an array of integers denoting the weights of bananas in the godown.
    Second line consists of a single integer k which denotes the maximum weight limit of the vehicle in tons.

- Output
    Print the minimum number of vehicles needed.

- Time Limit (secs)
    1.0

- Examples
    Example 1

    Input
    4285136
    8

    Output
    4

    Explanation
    We can load (8), (4,3), (6,2), (6 j) in 4 different vehicles. Any other arrangements will never give less than 4 vehicles.
    
    Example 2
    
    Input
    47911683
    12
    
    Output
    5
    
    Explanation
    We can load (11), (8,3), (6,4), (9), (7) in 5 different vehicles. Any other arrangements will never give less than 5 vehicles.

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemB {
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
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = nextInt();
        if(k == 0 || arr.length == 0) {
            out.print(0);
            out.flush();
            reader.close();
            out.close();
            return;
        }
        out.print(solve(arr, k));
        out.flush();
        reader.close();
        out.close();
    }

    private static int solve(int[] arr, int k) {
        // sort the array
        Arrays.sort(arr);
        int result = 0;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            if (arr[left] + arr[right] <= k) {
                left++;
                right--;
            } else {
                right--;
            }
            result++;
        }
        return result;
    }
    
}
