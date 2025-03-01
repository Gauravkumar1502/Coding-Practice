package codingproblems.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    
Optimizing Competition (100 Marks)

    A thrilling boat competition is on the horizon, and N enthusiastic participants are eager to team up and participate. Each participant has a weight, represented by Wi. However, there is a catch - the competition only allows teams consisting of two participants. As an organizer, you want to ensure fairness by allowing only teams with the same total weight.
    For instance, if there are K teams, each comprising participants (a1, b1), (a2, b2), ..., (ak, bk), where ai is the weight of the first participant in the i-th team, and bi is the weight of the second participant in the i-th team, a key condition needs to be satisfied: a1 + b1 = a2 + b2 = ... = ak + bk = s, where s is the common total weight of each team.

    Your challenge is to find an optimal value for s such that the maximum possible number of teams can be formed. It is important to note that each participant can only be part of one team.

Input Format

    The first line contains an integer N, the number of participants.
    The second line contains N space-separated integers W1, W2, ..., WN, where wi represents the weight of the i-th participant.

Constraints
    1 ≤ N ≤ 50
    1 ≤ Wi ≤ N

Output Format
    Print the maximum number of teams that can be formed with the optimal total weight s.

Sample TestCase 1
    Input
        6
        1 1 3 4 2 2
    Output
        2
    Explanation

    There are two possible cases:

        Case 1: The value of s = 3
        Two teams can be formed (1, 2) and (1, 2).

        Case 2: The value of s = 4
        Two teams can be formed (1, 3) and (2, 2).


    In any case, the maximum number of valid teams formed are 2.

Time Limit(X):
    0.50 sec(s) for each input.

Memory Limit:
    512 MB

Source Limit:
    100 KB

*/
public class OptimizingCompetition {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // read small integer N
        byte N = Byte.parseByte(reader.readLine().trim());
        int weights[] = Arrays.stream(reader.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxTeams(weights));
    }
    public static int maxTeams(int[] weights) {
        int maxTeams = 0;
        int avg = Arrays.stream(weights).sum() / (weights.length / 2);

        // int teams = formTeamsOfTwo(weights, avg);
        for (int i = avg; i > Arrays.stream(weights).min().getAsInt(); i--) {
            int teams = formTeamsOfTwo(weights, i);
            maxTeams = Math.max(maxTeams, teams);
        }
        return maxTeams;
    }
    public static int formTeamsOfTwo(int[] weights, int avg) {
        int teams = 0;
        boolean[] visited = new boolean[weights.length];
        for (int i = 0; i < weights.length; i++) {
            if (!visited[i]) {
                for (int j = i + 1; j < weights.length; j++) {
                    if (!visited[j] && weights[i] + weights[j] == avg) {
                        visited[i] = visited[j] = true;
                        teams++;
                        break;
                    }
                }
            }
        }
        return teams;
    }
}
