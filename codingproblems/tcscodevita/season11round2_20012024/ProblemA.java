package codingproblems.tcscodevita.season11round2_20012024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 Problem Name: Getaway Gala

    - Problem Description
        At the annual office holiday party, excitement buzzed as employees gathered for a lucky draw. Among the prizes was a weekend getaway voucher.

        With a small number of attendees forming a row, the organizer chose to forego the conventional lucky dip approach. 
        Instead, they introduced a more curious and engaging method that will eliminate every employee except one, who is considered as winner

        The organizer aimed to eliminate employees in two rounds. In the first round, he will form a row of employees who participated. 
        Then he will select the first letters of all the employees from left to right and form a string S. Then he will start eliminating the employees 
        whose name is forming the palindrome (every time he will delete the first name from left to right which is forming a palindrome). 
        He will continue this process till the string S does not have any sub strings which are palindromes.

        For example, consider the names {Hari Giri Siri Gopi Hima} in the row Here the string S formed by picking the first letter of the names is HGSGH. Note that substring GSG is a palindrome -When processing from left to right, the alphabet
        G from the name Gopi forms a palindrome. We call the name Gopi as Mirror Word Hence we eliminate Gopi in the first iteration.

        Now only names {Hari Giri Siri Hima} remain. String S is HGSH which does not have any palindrome. Hence the final row will be {Hari Giri Siri Hima}. If string S had more palindromes we would apply the same procedure as mentioned in
        paragraph above. Since string S is now palindrome free, the organizers will now apply a different criteria.

        This criteria will be to remove every Nth person from the remaining names everytime processing the names from left to right The last name remaining is the winner of the lucky draw.
        
        Given the list of names of employees, and the value of N, find out the who the winner is.

    - Constraints
        Names comprise of upper and lower case characters. Processing is case insensitive.
        1 <= number of employees <= 1000
        1 <= N <= 1000
        1 <= length of name <= 10

    - Input
        First line consists of an array indicating the names of employees present in the row. Names are space separated.
        Second line consists of a single integer N denoting the interval of elimination.

    - Output
        Print the name of the employee who is going to be the winner. Print the name as it is given in the array.

    - Time Limit
        1

    - Examples

        Example 1
            Input
                Janu gita sana gopi jaslin Tony Ritu Naina sonu Neha
                2
            Output
                Janu
            Explanation
                As we can see, gopi is forming a mirror word according to the given rules, thus we eliminate the employee named gopi. 
                Now gopi's position will be empty. Again, the name Neha is forming mirror word, hence we remove the name Neha and the resulting row will be 
                {Janu gita sana jaslin Tony Ritu Naina sonu}. Now there can be no palindromes after picking the first alphabets of the remaining names. 
                Hence the second criteria is now applied where N is 2. Now, processing from left to right, if we start removing every 2nd name (Nth name) 
                until we are left with one person, then it turns out that Janu will be the winner, hence print "Janu".

        Example 2
            Input
                Vishal ram Vina veda Lekha Rahul Keerthi
                1
            Output
                Keerthi
            Explanation
                As we can see, Vina is forming a mirror word, removing it will result in {Vishal ram veda Lekha Rahul Keerthi}. Next, veda forms the mirror 
                word. On removing we will get {Vishal ram Lekha Rahul Keerthi}. Next, Rahul forms the mirror word which upon removal will yeild {
                Vishal ram Lekha Keerthi}. Now there can be no palindromes after picking the first alphabets of the remaining names. 
                Hence the second criteria is now applied where N is I.From Vishal, if we start removing every 1 st name until we are left with one person, 
                it turns out that Keerthi will be the winner, hence print "Keerthi'.
*/
 
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

        String[] names = reader.readLine().split(" ");
        int n = nextInt();

        out.print(solve(names, n));

        out.flush();
        reader.close();
        out.close();
    }

    private static String solve(String[] names, int n) {
        ArrayList<Integer> playersIndices = IntStream.range(0, names.length).boxed().collect(Collectors.toCollection(ArrayList::new));
        StringBuilder firstLetters = new StringBuilder(
            Arrays.stream(names).reduce("", (res, name) -> res + name.charAt(0)).toLowerCase()
        );
        while (true) {
            int mirrorWordIndex = getMirrorWordIndex(firstLetters);
            if (mirrorWordIndex == -1) {
                break;
            }
            playersIndices.remove(mirrorWordIndex);
            firstLetters.deleteCharAt(mirrorWordIndex);
            out.println("remaining: " + firstLetters);
        }
        // remove every nth player
        if (playersIndices.size() == 1) {
            return names[playersIndices.get(0)];
        }
        if (n == 1) {
            return names[playersIndices.get(playersIndices.size() - 1)];
        }
        int winnerIndex = josephus(playersIndices.size(), n);
        out.println("winnerIndex: " + winnerIndex);
        out.flush();
        return names[playersIndices.get(winnerIndex)];
    }

    private static int getMirrorWordIndex(StringBuilder firstLetters) {
        for (int winSize = 2; winSize <= firstLetters.length(); winSize++) {
            for (int i = 0; i <= firstLetters.length() - winSize; i++) {
                String subStr = firstLetters.substring(i, i + winSize);
                out.println(subStr);
                out.flush();
                if (isPalindrome(subStr)) {
                    return i + winSize - 1;
                }
            }
        }
        return -1;
    }

    private static int josephus(int n, int k) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result;
    }

    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
