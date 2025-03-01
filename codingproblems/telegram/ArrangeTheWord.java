package codingproblems.telegram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrangeTheWord {
    public static String arrange(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        // Create a HashMap to store the words grouped by length
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            if (!groups.containsKey(length)) {
                groups.put(length, new ArrayList<>());
            }
            groups.get(length).add(word);
        }
        // Sort the keys (lengths of the words)
        List<Integer> keys = new ArrayList<>(groups.keySet());
        Collections.sort(keys);
        // Build the rearranged sentence
        StringBuilder sb = new StringBuilder();
        for (int length : keys) {
            // Get the words of current length
            List<String> group = groups.get(length);
            for (String word : group) {
                // Capitalize the first letter of the first word
                if (sb.length() == 0) {
                    sb.append(word.substring(0, 1).toUpperCase());
                    sb.append(word.substring(1).toLowerCase());
                } else {
                    sb.append(" ");
                    sb.append(word.toLowerCase());
                }
            }
        }
        // Add the period at the end
        sb.append(".");
        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "The ines are printed in reverse order.";
        System.out.println(arrange(sentence.replace('.', ' ')));
        System.out.println(arrange("Cats and hats.".replace('.', ' ')));
        // Output: "In the are lines order printed reverse."
    }
}
