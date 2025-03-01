package codingproblems.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Day1Trebuchet {
    public static void main(String[] args) {
        System.out.println(readFromFile("codingproblems/adventofcode/Day1Trebuchet.txt"));
        System.out.println(solve(readFromFile("codingproblems/adventofcode/Day1Trebuchet.txt")));
    }
    public static long solve(String input) {
        long total = 0;
        for(String line : input.split("\n")) {
            total += Long.parseLong(getFirstLastDigit(line));
        }
        return total;
    }
    private static String getFirstLastDigit(String line) {
        char[] firstLastDigit = new char[2];
        char[] lineArray = line.toCharArray();
        for(char c : lineArray) {
            if(Character.isDigit(c)) {
                firstLastDigit[0] = c;
                break;
            }
        }
        for(int i = lineArray.length - 1; i >= 0; i--) {
            if(Character.isDigit(lineArray[i])) {
                firstLastDigit[1] = lineArray[i];
                break;
            }
        }
        return String.valueOf(firstLastDigit);
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
