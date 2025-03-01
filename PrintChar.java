import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintChar {
    private static int spaceCount = 3;
    private static int cursorRow = 0;
    private static int cursorCol = 0;
    private static int charCount = -1;
    private static int rowCount = 0;
    private static int N = 0;

    private static void setCursor(int row) {
        if (getTerminalColumns() < cursorCol + N + spaceCount) {
            System.out.println(cursorRow + " " + cursorCol);
            rowCount++;
            cursorCol = 0;
            charCount = 0;
            System.out.println((rowCount * (N + 2)) + row + " " + (N + spaceCount) * charCount);
        }
        cursorRow = (rowCount * (N + 2)) + row;
        cursorCol = (N + spaceCount) * charCount;
        // System.out.println(cursorRow + " " + cursorCol);
        System.out.print("\033[" + cursorRow + ";" + cursorCol + "H");
    }

    private static void printA() {
        charCount++;
        for (int i = 1; i <= N; i++) {
            setCursor(i);
            for (int j = 1; j <= N; j++) {
                if (i == 1 || i == 3 || j == 1 || j == N) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void display(String string, int n) {
        N = n;
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            printA();
        }
    }

    private static int getTerminalColumns() {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "mode con");
        Process p;
        try {
            p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("Columns")) {
                    return Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
                }
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
