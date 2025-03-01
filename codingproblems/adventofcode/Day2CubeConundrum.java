package codingproblems.adventofcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day2CubeConundrum {
    public static void main(String[] args) {
        // System.out.println(readFromFile("codingproblems/adventofcode/Day2CubeConundrum.txt"));
        System.out.println(solve(readFromFile("codingproblems/adventofcode/Day2CubeConundrum.txt")));
    }
    private static int solve(String input) {
        final int MAX_BLUE = 14, MAX_RED = 12, MAX_GREEN = 13;
        int total = 0;
        for(String line : input.split("\n")) {
            int blueCount = 0, redCount = 0, greenCount = 0;
            int gameID = Integer.parseInt(line.substring(5,line.indexOf(':')));
            String[] sets = line.substring(line.indexOf(':')+2).split(";");
            for(String set : sets) {
                String[] cubes = set.split(",");
                System.out.println(Arrays.toString(cubes));
                for(String cube : cubes) {
                    String[] countColor = cube.split(" ");
                    System.out.println(Arrays.toString(countColor));
                    if(countColor[1].equals("blue")) {
                        blueCount += Integer.parseInt(countColor[0]);
                    } 
                    if(countColor[1].equals("red")) {
                        redCount += Integer.parseInt(countColor[0]);
                    }
                    if(countColor[1].equals("green")) {
                        greenCount += Integer.parseInt(countColor[0]);
                    }
                }
                // System.out.printf("Game ID: %d - Blue: %d - Red: %d - Green: %d\n", gameID, blueCount, redCount, greenCount);
                if(blueCount > MAX_BLUE || redCount > MAX_RED || greenCount > MAX_GREEN){
                    System.out.printf("Game ID: " + gameID);
                    break;
                }
            }
            total += gameID;
        }
        return total;
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
