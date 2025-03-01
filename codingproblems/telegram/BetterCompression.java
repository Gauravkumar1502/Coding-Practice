package codingproblems.telegram;

import java.util.Map;
import java.util.TreeMap;

public class BetterCompression {

    public static String betterCompression(String s) {
        Map<Character, Integer> counts = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int count = Integer.parseInt(s.substring(i + 1, j));
                counts.put(c, counts.getOrDefault(c, 0) + count);
                i = j - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(betterCompression("a12b56c1"));
        System.out.println(betterCompression("a12c56a1b5"));
    }

}
