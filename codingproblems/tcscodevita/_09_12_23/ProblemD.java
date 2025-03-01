package codingproblems.tcscodevita._09_12_23;
/*
 Pick Up Service
— Problem Description
    James is a truck driver, who travels through multiple cities and picks up the goods from those cities which are to be sent overseas. Initially, he will start from city A and then travel through all the cities, collects goods and then brings
    them back to city A.
    Each city have only one path from city A and each city have k number of goods that are to be picked. James will prioritize the cities with more number of 
    goods ie., if he is currently in city A and are his neighbouring cities then he will
    prioritize B if it has more number of goods or vice versa. If both B and C have equal number of goods, then he will choose the city with minimum entry tax. 
    The entry tax is the amount that we need to pay at the check post in order to
    enter into a city. In case of equal tax, he will head over to the city which comes first, lexicographically.
    James need to travel to all the cities and pickup the packages and return back to the starting city Here once we reached the terminal city, 
    we have to backtrack to particular city and continue to follow the rules for forward propagation
    and make sure we cover all other cities. Given the paths between these cities, number of goods in each city and the entry taxes of the cities, 
    print the route map of his entire journey and the minimum tax he need pay.

    Note: The starting city is exempted from entry tax i.e. any number of times that James enters the starting city, he will be exempt from paying any tax.

— Constraints
    1 <= number of cities <= 10^3
    1 <= number of goods in each city <= 10^3
    1 <= entry tax of each city <= 10^4

— Input
    First line consists of an integer N, representing the total number of cities.
    Next N-1 lines consists of four values in the format, "city7 city2 integer] integer2 representing there exists a route from cityl to city2, the number of goods in the city2 is integer7 and the entry tax of city2 is integer2.

- Output
    Print the route map of his entire journey where route map refers to the order of cities he followed separated by a hyphen and the total tax he paid in two different lines.
    Refer to example section for better understanding.

- Time Limit (secs)
    1.0

- Examples
    Example 1
    
    Input
    8
    hyderabad delhi 10 15
    hyderabad pune 24 60
    delhi kolkata 36 56
    pune kasi 4 90
    delhi chennai 16 100
    kasi manali 41 45
    chennai madhurai 8 20
    
    Output
    hyderabad-pune-kasi-manali-kasi-pune-hyderabad-delhi-kolkata-delhi-chennai-madhurai-chennai-delhi-hyderabad
    666

    Explanation
    James journey starts in hyderabad. By following the given rules and to achieve minimum tax, he will choose the city with more numbers of goods to be picked up ie., pune. From pune he will go to kasi followed by manali and returns
    back to hyderabad. He then goes to delhi, followed by kolkata and then returns back to delhi - From there he goes to chennai followed by madhurai and 
    then finally returns to hyderabad.
    So the route map will look like hyderabad -> pune kasi -> manali -> kasi -> pune hyderabad -> delhi -> kolkata delhi -s chennai -> madhurai -> chennai -> delhi -> hyderabad.
    Upon calculating the entry taxes of respective cities, the minimum tax he need to pay will be 666.

    Example 2

    Input
    6
    banglore mumbai 45 105
    mumbai indore 16 230
    banglore lucknow 45 190
    lucknow kochi 54 96
    lucknow patna 54 28
    
    Output
    banglore-mumbai-indore-mumbai-banglore-lucknow-patna-lucknow-kochi-lucknow-banglore
    1134

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class ProblemD {
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
        String[] fromCitiesInput = new String[n-1];       
        String[] toCitiesInput = new String[n-1];    
        int[] goodsQuantity = new int[n-1];
        int[] tax = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            fromCitiesInput[i] = next();
            toCitiesInput[i] = next();
            goodsQuantity[i] = nextInt();
            tax[i] = nextInt();
        }
        // print the cities
        for (int i = 0; i < n - 1; i++) {
            out.println(fromCitiesInput[i] + " to " + toCitiesInput[i] + " number of goods " + goodsQuantity[i] + " tax " + tax[i]);
        }       
        out.flush();
        solve(fromCitiesInput, toCitiesInput, goodsQuantity, tax);
        out.close();
        reader.close();
    }

    private static void solve(String[] fromCitiesInput, String[] toCitiesInput, int[] goodsQuantity, int[] tax) {
        int len = fromCitiesInput.length+1;
        int[][] graph = new int[len][len];
        LinkedHashSet<String> citiesMap = new LinkedHashSet<>(len);
        for (int i = 0; i < len; i++) {
            if(i<len-1){
                citiesMap.add(fromCitiesInput[i]);
                citiesMap.add(toCitiesInput[i]);
            }
            for (int j = 0; j < len; j++) {
                if(i==j){
                    graph[i][j] = 0;
                }else{
                    int indexOfFromCity = -1;
                    int indexOfToCity = -1;
                    for (int k = 0; k < len-1; k++) {
                        if(fromCitiesInput[k].equals(citiesMap.toArray()[i])){
                            indexOfFromCity = k;
                        }
                        if(toCitiesInput[k].equals(citiesMap.toArray()[j])){
                            indexOfToCity = k;
                        }
                    }
                }
            }
        }

        citiesMap.forEach(System.out::println);


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(graph[i][j]+"\t");
            }
            System.out.println();
        }
    }
}

class City {
    String name;
    List<String> connectedCities;
    int goodsQuantity;
    int tax;

    City(String name, int goodsQuantity, int tax) {
        this.name = name;
        this.goodsQuantity = goodsQuantity;
        this.tax = tax;
        connectedCities = new ArrayList<>();
    }

    void addCity(String cityName) {
        connectedCities.add(cityName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        City city = (City) obj;
        return city.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + " " + goodsQuantity + " " + tax;
    }
}
