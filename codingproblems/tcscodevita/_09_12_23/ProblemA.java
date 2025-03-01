package codingproblems.tcscodevita._09_12_23;
/*
    Password Generator

    - Problem Description
    CAPTCHA is a service that is used to know whether app users are humans or bots. This includes clicking in
    a specific area, entering the given numbers in text box, selecting the mentioned things from the pictures
    etc. But company XYZ wanted to update the CAPTCHA pattern for high security.

    Scientific notation, also known as standard form or exponential notation, is a way to write very large or very
    small numbers in a more compact and manageable form, In scientific notation, nonzero numbers are
    written in the form m x 10 or mtimes ten raised to the power of n, where n is an integer, and the coefficient
    m is a nonzero real number (usually between I and IO in absolute value, and nearly always written as a
    terminating decimal).

    Tina, a developer, is working on creating a CAPTCHA system that requires a high level of human
    engagement i.e., from the given number one has to perform some operations on it and then enter the result
    in the text box provided. The rules for generating the password are given below.

    1. You will receive a numerical value. Transform the provided decimal number into scientific notation.
    Simplify all the digits after the decimal point to a single digit by adding all the digits until it
    becomes single digit, and apply the same rule to the exponent.
    
    2. Next, create a string by concatenating the first three letters of each digit when expressed as words,
    while keeping the symbols and letter •e' unchanged. This resultant string will be denoted as Sl.
    
    3. If the digit resulting from reducing the value of exponent to a single digit is odd, concatenate all the
    letters at odd positions in the given name (using I-based indexing). This string is referred to as S2.

    4. your desired password will be the combination of Sl and S2, separated by an symbol, forming
    the format Sl @S2.

    Given t number of test cases. In each test cases there is an integer / decimal number and the name of the
    person who is trying to resolve the CAPTCHA Print the correct password in each test case. In case of
    invalid number, print "Invalid input'.

    Note: Some additional rules in this problem are:
    • If the given number is 3, scientific notation will be 3.0e0.
    • Ifthe given number is 323, scientific notation will be 3.23e+2
    • Mathematically, the decimal number 0437 represents 437.

    - Constraints
    1 <= len(name) <= 100
    1 <= len(number) <= 100
    1 <= t <= 10
    Number can be negative.
    There will be no spaces in the given name.
    Name will be consisting of only lower case letters. If not, consider invalid.

    - Input
    The first line consists of T, number of test cases.
    Next T lines contain number and name separated by space.

    - Output
    Print the password for each test case in a new line.

    - Time Limit (secs)
    1.0

    - Examples

    Example 1

    Input
    2
    054785949 rajarajeswari
    00.00000934749 bhuvaneswari

    Output
    fiv.onee+sev@rjrjsai
    nin.nine-six@hvnsai

    Explanation
    case 1: Let S1="" and S2=""
    Given number represent 54785949 which is 5.4785949e+7 in scientific notation. By reducing the number
    after the point (4785949) to a single digit, we get 1 and by reducing power to a single digit we get 7. So,
    according to given rules, the first string will be fiv.onee+sev. Since 7 is an odd number, we select all the
    letters at odd place of the name. So S2 will become rjrjsai.
    So the final password will be fiv.onee+sev@rjrjsai

    case 2: Let S1="" and S2=""
    The scientific notation for the given decimal number is 9.34749e-6. By reducing the number after the point
    (34749) to a single digit, we get 9 and by reducing power to a single digit we get 6. So, according to given
    rules, the first string will be nin.nine-six. Since 6 is even number, we select all the letters at even place of the
    string. So S2 will be hvnsai.
    So the final password will be nin.nine-six@hvnsai

    Example 2

    Input
    2
    12.7u3 mahadev
    3 dhanyajoselyn

    Output
    Invalid
    thnzerezer@hnaoey

    Explanation
    Case 1: Given input is invalid, hence print "Invalid".
    Case 2 Obeying the rules, scientific notation of 3 will be 3.0eO. By the given rules Sl will be thr.zerezer and
    S2 will be hnaoey. Hence the required output is thr.zerezer@hnaoey.
*/

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

    // read byte
    static byte nextByte() throws IOException {
        return Byte.parseByte(next());
    }
    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        byte t = nextByte();
        while (t-- > 0) {
            String number = next();
            String name = next();
            out.print(solve(number, name));
            out.flush();
        }    
        reader.close(); 
        out.close();
    }

    private static String solve(String number, String name) {
        // if number not valid return "Invalid"
        try {
            StringBuilder result = new StringBuilder();
            String num = "" + Double.parseDouble(number);
            num = num.toLowerCase();
            String fistDigit = num.substring(0, 1);
            if(!num.contains("e")) {
                result.append(toLetter(fistDigit.charAt(0)).substring(0, 3));
                result.append(".zerezer@");
                for (int i = 1; i < name.length(); i += 2) {
                    result.append(name.charAt(i));
                }
                return result.toString();
            }
            String afterDecimal = num.substring(num.indexOf('.') + 1,num.indexOf('e'));
            String exp = num.substring(num.indexOf('e') + 1);

            result.append(toLetter(fistDigit.charAt(0)).substring(0, 3));
            result.append(".");
            result.append(toLetter(reduceToSingleDigit(afterDecimal)).substring(0, 3));
            result.append("e");
            result.append(exp.contains("-") ? "-" : "+");
            exp = exp.replaceAll("-", "");
            int start = (Integer.parseInt(exp) % 2 == 0) ? 1 : 0;
            exp = toLetter(reduceToSingleDigit(exp)).substring(0, 3);
            result.append(exp);
            result.append("@");
            for (int i = start; i < name.length(); i += 2) {
                result.append(name.charAt(i));
            }
            return result.toString();
        } catch (NumberFormatException e) {
            return "Invalid";
        }
    }

    private static char reduceToSingleDigit(String substring) {
        if (substring.length() == 1)
            return substring.charAt(0);
        int sum = 0;
        while (substring.length() > 1) {
            sum = 0;
            for (int i = 0; i < substring.length(); i++) {
                sum += substring.charAt(i) - 48;
            }
            substring = "" + sum;
        }
        return (char) (sum + 48);
    }

    private static String toLetter(char number) {
        switch (number) {
            case '0':
                return "zero";
            case '1':
                return "one";
            case '2':
                return "two";
            case '3':
                return "three";
            case '4':
                return "four";
            case '5':
                return "five";
            case '6':
                return "six";
            case '7':
                return "seven";
            case '8':
                return "eight";
            default:
                return "nine";
        }
    }
}
