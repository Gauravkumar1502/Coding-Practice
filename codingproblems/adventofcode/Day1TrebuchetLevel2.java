package codingproblems.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class Day1TrebuchetLevel2 {
    static String[] map = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        // System.out.println(readFromFile("codingproblems/adventofcode/Day1Trebuchet.txt"));
        System.out.println(solve(readFromFile("codingproblems/adventofcode/Day1Trebuchet.txt")));
    }
    public static long solve(String input) {
        long total = 0;
        HashSet<String> set = new HashSet<>(List.of(map));
        String convertIntToString = convertIntToString(input);
        // find the first occurrence of a number in the string
        // create ref for breaking from both loops
        int index = 1;
        for(String line : convertIntToString.split("\n")) {
            String firstNumber = "";
            for(int i=0; i<line.length()-2; i++) {
                if(set.contains(line.substring(i, i+3))) {
                    firstNumber = line.substring(i, i+3);
                    break;
                }
                if(i+4 <= line.length() && set.contains(line.substring(i, i+4))) {
                    firstNumber = line.substring(i, i+4);
                    break;
                }
                if(i+5 <= line.length() && set.contains(line.substring(i, i+5))) {
                    firstNumber = line.substring(i, i+5);
                    break;
                }
            }
            // find the last occurrence of a number in the string
            String lastNumber = "";
            for(int i=line.length()-1; i>=2; i--) {
                if(set.contains(line.substring(i-2, i+1))) {
                    lastNumber = line.substring(i-2, i+1);
                    break;
                }
                if(i-3 >= 0 && set.contains(line.substring(i-3, i+1))) {
                    lastNumber = line.substring(i-3, i+1);
                    break;
                }
                if(i-4 >= 0 && set.contains(line.substring(i-4, i+1))) {
                    lastNumber = line.substring(i-4, i+1);
                    break;
                }
            }
            int firstN=0, lastN=0;
            for(int i=0;i<10;i++) {
                if(firstNumber.equals(map[i])) {
                    firstN = i;
                }
                if(lastNumber.equals(map[i])) {
                    lastN = i;
                }
            }
            total += firstN*10 + lastN;
        }
        return total;
    }
    private static String convertIntToString(String line) {
        for (int i = 0; i < 10; i++) {
            line = line.replace(String.valueOf(i), map[i]);
        }
        return line;
    }
    private static String readFromFile(String fileName) {
        StringBuilder fileContent = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))))){
            reader.lines().forEach(line -> fileContent.append(line).append("\n"));
        } catch (Exception e) {
            System.out.println("Exception occurred while reading file: " + e.getMessage());
        }
        return fileContent.toString();
    }
}
