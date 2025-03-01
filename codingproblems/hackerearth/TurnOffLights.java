package codingproblems.hackerearth;

/*
 * Turn Off Lights              Max. score: 100
There are n bulbs arranged in a row. The state of the bulbs is represented by a binary string bulbs of length n, the O at ith position in the
string represents the bulb is OFF and I represents the bulb is ON, where O i < n. You have to switch OFF all the bulbs by performing
following operation atmost k times. 

The operation is defined as:-
• Choose any index i in the string bulb and turn OFF all the lights having indexes i to min(n — I, i + I — I) (Inclusive), where I is a pre
defined number, greater than zero and fixed for all the operations.
The task is to find the smallest value of I greater than zero, such that you can turn OFF all the bulbs in atmost k operations.

Input format
• The first line of input contains two space separated integers, n and k, representing the size of string bulb and maximum number of
operations you can perform.
• The second line of input contains a binary string, bulbs.

Output format
The output contains a single integer, the minimum possible value of I greater than zero such that you are able to turn OFF all the bulbs in
atmost k operations.

Constraints
1 <= n <= 10^6
1 <= k <= n

SAMPLE INPUT
10 4
0101011111

SAMPLE OUTPUT
3

Explanation
For /= 1, The operation can be perfomed by choosing following intervals
    • [1, 1], [3, 3], [5, 5], [6, 6], [7, 7], [8, 81, [9, 9] -7 operations
For /= 2, The operation can be perfomed by choosing following intervals
    • [1, 2], [3, 4], [5, 6], [7, 8], [9, 9]-5 operations

For /= 3,    The operation can be perfomed by choosing following intervals
    • [1, 3], [5, 7], [8, 9] -3 operations

Hence the answer is 3.
 */
public class TurnOffLights {
    public static void main(String[] args) {

    }
}
