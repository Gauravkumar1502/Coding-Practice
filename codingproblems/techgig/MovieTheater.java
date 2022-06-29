package codingproblems.techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Movie Theater (100 Marks)
 * Reena is a movie enthusiast and loves to see movies in theaters. A new movie is releasing this Friday and Reena wants to watch it. Her favorite theater is witnessing a large crowd but she wants to watch the film in that theater only. Reena has her favorite seats in the theater and will watch the movie only if her selected seat is vacant.
 * 
 *  
 * 
 * The theater has S seats and T tickets have already been sold. There are Q seats which are liked by Reena in that theater. Reena is very busy with her modeling project and needs your help in determining if her favorite seat is vacant or not. She will provide you with all the details regarding the number of seats in the theater and the seats already allotted. Can you help her figure out if her favorite seat in the theater is vacant or not? If her favorite seat is occupied, represent the status of that seat with N; else the status of that seat will be Y representing the seat is vacant.
 * 
 * 
 * 
 * Example:
 * 
 * There are 6 seats in the theater, S = 6
 * 
 * 4 seats are already occupied, T = 4
 * 
 * Seats which are occupied are 1, 3, 4 and 6
 * 
 * 
 * 
 * 
 * 
 * Reena likes 3 seats, Q = 3 
 * 
 * Seats Reena like are, 1, 2 and 6
 * 
 * 
 * 
 * Seat 1: It is already occupied by someone so Reena will get N as value.
 * 
 * Seat 2: This seat is empty so Reena will get Y as value and she can book this seat and watch the movie.
 * 
 * Seat 6: This seat is also preoccupied so Reena will get N as value.
 * 
 * 
 * 
 * Input Format
 * The first line of input consists of three space-separated integers,S, T and Q respectively.
 * 
 * Next T lines each will consist of an integer representing the occupied seat.
 * 
 * Next Q lines each will consist of an integer representing the preferred seats of Reena in the theater.
 * 
 * 
 * 
 * Constraints
 * 1<= S <=10^9 (1e9)
 * 
 * 0<= T <=10^6
 * 
 * 0<= Q <=10^6
 * 
 * 
 * The occupied seat and preferred seat will range from 1 to N (both inclusive).
 * 
 * 
 * Note: Read the input from the console.
 * 
 * 
 * 
 * Output Format
 * For each preferred seat of Reena, print it's status (N - Occupied, Y - Vacant) in a separate line.
 * 
 * Sample TestCase 1
 * Input
 * 6 4 4
 * 1
 * 3
 * 4
 * 6
 * 1
 * 2
 * 5
 * 6
 * Output
 * N
 * Y
 * Y
 * N
 * Explanation
 * The occupied seats are the same as the example.
 * 
 * Occupied seats: 1, 3, 4 and 6
 * 
 * Preferred Seats:
 * 
 * Seat 1: Already Occupied, Status = N
 * 
 * Seat 2: Vacant, Status = Y
 * Seat 5: Vacant, Status = Y
 * 
 * Seat 6: Already Occupied, Status = N
 */
public class MovieTheater {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] occupiedSeats = new int[Integer.parseInt(input[1])];
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            occupiedSeats[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < Integer.parseInt(input[3]); i++) {
            if (isOccupied(occupiedSeats, Integer.parseInt(reader.readLine()))) {
                System.out.println("N");
            } else {
                System.out.println("Y");
            }
        }
    }

    private static boolean isOccupied(int[] occupiedSeats, int seat) {
        // fast search for occupied seats occupiedSeats is sorted
        int low = 0;
        int high = occupiedSeats.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (occupiedSeats[mid] == seat) {
                return true;
            } else if (occupiedSeats[mid] < seat) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
