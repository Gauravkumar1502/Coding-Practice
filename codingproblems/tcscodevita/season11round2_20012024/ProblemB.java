package codingproblems.tcscodevita.season11round2_20012024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

/*
 Problem Name: Raju's Conlang

    - Problem Description
        As we all know Python was created by Guido van Rossum, a Dutch programmer. Raju a coding enthusiast, is trying to become a new Guido van Rossum, by developing a new coding language!
        Initially, he started with developing syntaxes, especially the if, if-else and nested if, which are control flow structures and only using comparison operators(>, ==, !=) along with the print function. He felt that it should deviate from the
        syntax what already exists in other languages. So he made it like below -
        
        If Syntax in Raju's coding language
        is A<B
        Yes
        print A
        si

        If- Else Syntax in Raju's coding language to find the largest among two numbers.
        is A<B
        Yes
        print B
        No
        print A
        si

        Nested If syntax in Raju's coding language to find the largest among three numbers.
        is A>B
        Yes
        is A>C
        Yes
        print A
        No
        print C
        si
        No
        is B>C
        Yes
        print B
        No
        print C
        si
        
        Given a script, just having either If, If-else or nested If, print the output.

    - Constraints
        3 <= number of lines in the script <= 1000
        1 <= Values that variable hold <= 50

    - Input
        The script with any of if, if-else , nested ifwill be present in the first few lines.
        Second last line has the variables used in the script, separated by space. The variable names will be A to Z.
        Last line consists of space separated integers denoting the values of variables mentioned in the above line.

    - Output
        Print the output of the script.

    - Time Limit
        1

    - Examples

        Example 1
            Input
                is A<B
                Yes
                print A
                si
                is A>B
                Yes
                print B
                No
                print A
                si
                A B
                1 2
            Output
                1
                1
            Explanation
                The above script depicts -
                if (A < B) {
                    print(A)
                }
                if (A > B) {
                    print(B)
                }
                else{
                    print(A)
                }
            Here A-1 and B=2, since B > A, according to the condition, we print A as output in the first line which is 1, 
            followed by A>B condition executing else block and printing A as output in the second line which is 1.
 */

public class ProblemB {
    static BufferedReader reader;
    static PrintWriter out;
    public static void main(String[] args) throws IOException{
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        try {
            String[] script = new String[50];
            int i = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                script[i++] = line;
            }
            out.println(Arrays.toString(script));
            String[] variableNames = script[i - 2].split(" ");
            int[] variableValues = Arrays.stream(script[i - 1].split(" "))
                                .mapToInt(Integer::parseInt).toArray();
            out.println(Arrays.toString(variableNames));
            out.println(Arrays.toString(variableValues));

            HashMap<String, Integer> variables = new HashMap<>();
            for (int j = 0; j < variableNames.length; j++) {
                variables.put(variableNames[j], variableValues[j]);
            }
            solve(script, variables);


            out.flush();
            out.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(String[] script, HashMap<String, Integer> variables) {
        int i = 0;
        while (script[i] != null) {
            String line = script[i];
            out.println("index: " + i +"line : " + line);
            if (line.startsWith("is")) {
                // is A<B, is A>B, is A==B, is A!=B
                String[] vars = line.split(" ")[1].split("<|>|==|!=");
                String op = line.split(" ")[1].replaceAll("[A-Z]", "");
                boolean condition = evaluateCondition(vars[0], op, vars[1], variables);
                if (condition) {
                    i++;
                    if (script[i].equals("Yes")) {
                        i++;
                        out.println(variables.get(vars[0]));
                    } else {
                        i++;
                    }
                }      
            }
        }
    }

    private static boolean evaluateCondition(String var1, String op, String var2, HashMap<String, Integer> variables) {
        int val1 = variables.get(var1);
        int val2 = variables.get(var2);
        return switch (op) {
            case "<" -> val1 < val2;
            case ">" -> val1 > val2;
            case "==" -> val1 == val2;
            case "!=" -> val1 != val2;
            default -> false;
        };
    }
}
