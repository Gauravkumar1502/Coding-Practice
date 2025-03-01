package codingproblems.tcscodevita._09_12_23;
/*
 Solo Rider
— Problem Description
    Alex is a freelance developer, who develops applications. One day he got a proposal to develop an app called "SoloRider" which is a transportation service within Hyderabad city.
    Lets consider a location Hydergudawithin the city When a passenger gets down at this location, then the vehicle should be assigned to the nearest customer who booked the transportation service. But there will be multiple customers
    who booked the service and there will be multiple vehicles which will be available to serve that request, in the vicinity. So Alex needs to develop an application which will allocate passengers to the appropriate vehicles. His application
    will calculate the coordinate points of all the passengers and vehicles in the given area and then it follows the below rules to do passenger to vehicle assignment.
    
    Given N passengers and M vehicles which are idle at the given time in Hyderguda. You will have to assign one vehicle to each passenger based on the given rules.
    • The customers should be prioritized based on the lexicographical order of their names.
    • For a given customer, allocate the nearest vehicle which is idle. Here the term idle indicates that the vehicle is currently not associated with any passenger. Use Manhattan Distance for measuring distance between passenger
    and vehicle, vice versa.
    • If more than one idle vehicle are equidistant from the passenger, then allocate them the vehicle which is lexicographically closest.
    • Vehicles have vehicle numbers in the format vid where id is an integer. Lexicographically closest means the one which comes first in the alphabetical order.
    • Once a vehicle gets allocated, then it will move towards the passenger and is no longer available to any other passenger.
    Print the minimum distance traveled by all the vehicles to reach their passengers obeying the given rules.

— Constraints
    1 <= N,M <=100
    1 <= x,y coordinates <= 10^3
    Name of the passenger always comprises or upper and lower case characters.
    Vehicle number is in the format "vid" where id is an integer.
    Number of passengers Number of vehicles.

— Input
    The first line consists of two space delimited integers N, M denoting the number of passengers and vehicles.
    Next N lines will consist of the passenger's name and x,y coordinates of the passenger's exact location, all delimited by space.
    Next M lines will consist of the vehicles number and x,y coordinates of the vehicle's exact location, all delimited by space.

    - Output
    Single line consisting of an integer denoting the minimum distance traveled by all the vehicles to reach their passengers obeying the given rules.

- Time Limit (secs)
    1.0

- Examples
    
    Example 1

    Input
    4 8
    Vishnu 4 4
    Ravali 1 6
    Krishna 8 3
    Vaishnavi 3 2
    V106 6 4
    v42 2 4
    v69 4 1
    v45 3 3
    v66 5 3
    v312 9 5
    v93 8 1
    v123 4 6

    Output
    8

    Explanation
    By plotting the given coordinate points in the 2d graph, it looks like below.
    According to the rules, we prioritize the customers in lexicographical order of their names. So we try assigning a vehicle to the customer named Krishna. For Krishna, the nearest vehicle is v93, so we will assign that vehicle to him. For
    Ravali, the vehicles are v42, v123 are at a distance of 3 from her. So we will assign the one which comes lexicographically first i.e., v123 will be assigned to Ravali. For Vaishnavi, v45 is the nearest vehicle. So we will assign her to that
    vehicle. Lastly, for Vishnu, VI 23, v42, VI 06, v45, v66, all these vehicles are at a distance of 2 from him. Since v123, v45 are already allocated and they are on the way to their customers, we exclude them. Thus we allocate VI 06 to Vishnu.
    On calculating the total distance traveled by all the vehicles in order to reach their customers, the output is 8.

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemC {
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

        int n = nextInt();
        int m = nextInt();
        Passenger[] passengers = new Passenger[n];
        Vehicle[] vehicles = new Vehicle[m];
        for (int i = 0; i < n; i++) {
            passengers[i] = new Passenger(next(), nextInt(), nextInt());
        }
        for (int i = 0; i < m; i++) {
            vehicles[i] = new Vehicle(next(), nextInt(), nextInt());
        }
        solve(passengers, vehicles);


        out.close();
        reader.close();
    }

    private static void solve(Passenger[] passengers, Vehicle[] vehicles) {
        Arrays.sort(passengers);
        Arrays.sort(vehicles);
        int totalMinDistance = 0;
        for (Passenger passenger : passengers) {
            int minDistance = Integer.MAX_VALUE;
            Vehicle vehicleName = null;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.isIdle) {
                    int distance = vehicle.manhattanDistance(passenger);
                    if (distance < minDistance) {
                        minDistance = distance;
                        vehicleName = vehicle;
                    }
                }
            }
            vehicleName.isIdle = false;
            totalMinDistance += minDistance;
            out.println("=>Passenger " + passenger.name + " is assigned to vehicle " + vehicleName + " at distance " + minDistance);
        }
        // out.println("Total min distance: " + totalMinDistance);
        out.println(totalMinDistance);
        out.flush();
    }
}

class Passenger implements Comparable<Passenger> {
    String name;
    int x;
    int y;
    Passenger(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Passenger o) {
        return this.name.compareTo(o.name);
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
class Vehicle implements Comparable<Vehicle> {
    String name;
    int x;
    int y;
    boolean isIdle = true;
    Vehicle(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    int manhattanDistance(Passenger passenger) {
        return Math.abs(this.x - passenger.x) + Math.abs(this.y - passenger.y);
    }
    @Override
    public int compareTo(Vehicle o) {
        return this.name.compareTo(o.name);
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
