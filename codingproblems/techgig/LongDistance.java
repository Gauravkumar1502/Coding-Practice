package codingproblems.techgig;

import java.io.*;
import java.util.*;

public class LongDistance {
    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0){
           int[] paul = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           int[] nina = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           int paulTime = ((int)paul[0]/paul[1])+paul[2];
           int ninaTime = ((int)nina[0]/nina[1])+nina[2];
           if(paulTime>ninaTime){
              System.out.print("PAUL\n"+paulTime);
           }
           else if(paulTime<ninaTime){
              System.out.print("NINA\n"+ninaTime);
           }
           else{
              System.out.print("BOTH\n"+paulTime);
           }
        }
     }
}
