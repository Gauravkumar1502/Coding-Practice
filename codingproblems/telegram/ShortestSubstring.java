package codingproblems.telegram;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShortestSubstring {

    public static int shortestSubstring1(String str) {
        int n = str.length();
        int dist_count = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(str.charAt(i))) {
                mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
            } else {
                mp.put(str.charAt(i), 1);
            }
        }
        dist_count = mp.size();
        int size = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int visited[] = new int[256];
            for (int j = 0; j < 256; j++) {
                visited[j] = 0;
            }
            int len = 0;
            for (int j = i; j < n; j++) {
                if (visited[str.charAt(j)] == 0) {
                    count++;
                    visited[str.charAt(j)] = 1;
                }
                len++;
                if (count == dist_count) {
                    break;
                }
            }
            if (len < size && count == dist_count) {
                size = len;
            }
        }
        return size;
    }

    public static int shortestSubstring(String input) {
        Map<Character, Integer> charCount = input.chars()
                .boxed()
                .collect(Collectors.toMap(k -> (char) k.intValue(), v -> 1, Integer::sum));
        int totalUniqueChars = charCount.size();
        int uniqueChars = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (end < input.length()) {
            if (charCount.get(input.charAt(end)) <= 0) {
                uniqueChars++;
            }
            end++;
            while (uniqueChars == totalUniqueChars) {
                minLength = Math.min(minLength, end - start);
                if (charCount.get(input.charAt(start)) != 0) {
                    uniqueChars--;
                }
                start++;
            }
        }
        System.out.println("minLength = " + minLength);
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubstring("bab")); // Output: 2
        System.out.println(shortestSubstring("dabbcabcd")); // Output: 4
    }
}
