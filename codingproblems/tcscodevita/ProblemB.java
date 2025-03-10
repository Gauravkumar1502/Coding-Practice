/*
 * SnakeAndLadder                       Marks: 30
    — Problem Description
        Snake and Ladder is a board game consisting of snakes and ladders, where the player must reach End position, starting from Start position. Here, snake on the board makes player demotes the player to a lower numbered square and
        ladder promotes player to higher numbered square on the board.
        
        For e.g., given below is the snake and ladder board, where SCpos') represents snake and •pos' indicates where the player's coin will move down to once a player lands on that square. Similarly, L(poS) indicates ladder and •pos' indicates
        where the player's coin will move up to once the player lands on that square. Player always starts from the Start square and must go towards End based on the rolls of the die.
        
        You are supposed to find if it is possible for a player to reach the Endor not, based on die inputs. If it is possible, display 'Possible' with number of snakes and ladders encountered during his/her play else display 'Not possible' along with
        number of snakes, number of ladders and square where the player's coin has ended at.
        
        Note: A player can reach the end if he has the exact number on die input to reach end.
        For e.g., if the player is at 99, he/she can reach end only if the die input is I and not any other input. So, he/she must wait till input on die is I.
        The actual Snake and Ladder board will look as depicted below. This format will be used for providing inputs.
        
        End 99 S(2) 97 96 95 94 93 92 91
        81 82 83 8485 86 87 88 89 90
        80 79 78 77 76 L(99) 74 73 72 71
        61 62 S(22) 6465 66 67 68 69 70
        60 59 58 57 56 55 54 53 52 51
        41 4243 44 L(68) 46 47 48 49 50
        40 39 S(6) 37 36 35 34 33 32 31
        21 2223 2425 26 2728 29 30
        20 19 18 17 S(9) 15 1413 12 11
        start 2345678910

    — Constraints
        1 <= die_inputs <= 6
        Number of die inputs >= O
    
    — Input
        First 10 lines contains snake and ladder board where each line has 10 tokens separated by a space. The tokens can either be integers, Start, End, S(number), L(number) where
        • Integer denotes the square number
        • Start denotes the left bottom position on the board from where player start the game
        • End denotes the left top position on the board
        • S(number) denotes that the current square has a snake that will take you down to a square number mentioned in the parenthesis.
        • L(number) denotes that the current square has a ladder that will take you up to a square number mentioned in the parenthesis.
        Second line contains die_inputs separated by a space.
    
    — Output
        Find if the player is possible to reach the Endor not, based on die_inputs and the board. If it is possible, display 'Possible' with number of snakes and ladders encountered during his/her play else display 'Not possible' along with number
        of snakes, number of ladders and the square where the player's coin has ended at.
        Print all the outputs delimited by a space.
        Refer Examples section for better understanding.
    
    — Time Limit (secs)
        1

    — Examples 1
        Input

        End S(Start) 98 97 96 95 94 93 92 91
        81 82 83 84 L(98) 86 87 88 89 90
        80 79 S(46) 77 76 75 74 73 72 71
        61 62 63 6465 66 67 68 69 70
        60 59 58 57 56 55 S(25) 53 52 51
        41 4243 L(62) 45 4647 48 49 50
        40 39 38 37 36 35 34 33 32 31
        21 2223 L(74) 25 26 27 28 29 30
        20 19 18 17 S(2) 15 14 13 12 11
        start 2 3 4 5 6 7 8 9 10
        5 4 2 4 1
        Output
        Not possible 1 0 2
        
        Explanation
            Based on die inputs, the player moves from start and goes to number 5 first on board then to 9, 11, 15 and finally to S(2) i.e., square numbered 16. Now player encountered snake which takes him to square numbered 2. So, output is 'Not
            possible', as the player couldnt reach the End and the number of snakes and ladders encountered during his/her play are one and zero respectively.

    - Example 2
        Input
        End 99 98 S(7) 96 95 94 93 92 91
        81 82 L(99) 84 85 86 87 88 89 go
        80 79 78 77 76 75 74 73 72 71
        61 S(22) 63 64 65 66 67 68 69 70
        60 59 58 S(14) 56 57 54 53 52 51
        41 42 43 44 45 46 L(80) 48 49 50
        40 39 38 37 36 35 34 33 32 31
        21 22 23 L(63) 25 26 27 28 29 30
        20 19 S(2) 17 16 15 14 13 12 11
        start 2 3 4 5 6 7 8 9 10

        6 6 6 5 4 3 6 6 6 5 6 4 3 1
        
        Output
        Possible 1 2

        Explanation
        Based on the die inputs, the player encountered 1 snake and 2 ladders and was able to reach the End.
 */
package codingproblems.tcscodevita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        String[][] board = new String[10][10];
        for (int i = 0; i < 10; i++)
            board[i] = reader.readLine().trim()
                    .replace("Start", "1")
                    .replace("End", "100")
                    .split(" ");

        byte[] dieInputs = reader.readLine().replaceAll(" ", "").getBytes();
        solve(board, dieInputs);
        out.flush();
        reader.close();
        out.close();

    }

    private static void solve(String[][] board, byte[] dieInputs) {
        byte snakeCount = 0, ladderCount = 0, playerPos = 0;
        for (byte dieInput : dieInputs) {
            playerPos = (byte) (playerPos + dieInput - 48);
            byte[] rowCol = getRowCol(playerPos);
            out.flush();
            if (board[rowCol[0]][rowCol[1]].startsWith("S(")) {
                snakeCount++;
                playerPos = Byte
                        .parseByte(board[rowCol[0]][rowCol[1]].substring(2,
                                board[rowCol[0]][rowCol[1]].length() - 1));
            } else if (board[rowCol[0]][rowCol[1]].startsWith("L(")) {
                ladderCount++;
                playerPos = Byte
                        .parseByte(board[rowCol[0]][rowCol[1]].substring(2, board[rowCol[0]][rowCol[1]].length() - 1));
            }
        }
        if (playerPos == 100) {
            out.println("Possible " + snakeCount + " " + ladderCount);
        } else {
            out.println("Not possible " + snakeCount + " " + ladderCount + " " + playerPos);
        }
    }

    private static byte[] getRowCol(byte playerPos) {
        byte row, col;
        boolean isTenMultiple = playerPos % 10 == 0;
        if (isTenMultiple) {
            row = (byte) (10 - (playerPos / 10));
            col = (byte) (row % 2 == 0 ? 0 : 9);
        } else {
            row = (byte) (9 - (playerPos / 10));
            col = (byte) (row % 2 == 0 ? 10 - (playerPos % 10) : (playerPos % 10) - 1);
        }
        return new byte[] { row, col };
    }

}
