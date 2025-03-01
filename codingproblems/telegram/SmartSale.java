package codingproblems.telegram;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SmartSale {
    // public static int deleteProducts(int[] ids, int m) {
    // // Count the occurrences of each ID number
    // Map<Integer, Integer> count = new HashMap<>();
    // for (int id : ids) {
    // count.put(id, count.getOrDefault(id, 0) + 1);
    // }
    // // Sort the ID numbers in descending order of occurrences
    // List<Map.Entry<Integer, Integer>> sortedCount = new
    // ArrayList<>(count.entrySet());
    // Collections.sort(sortedCount, (a, b) -> b.getValue() - a.getValue());
    // // Initialize a variable to keep track of the number of deleted items
    // int deleted = 0;
    // // Initialize a variable to keep track of the number of different IDs
    // int numIds = 0;
    // // Iterate over the sorted list of ID numbers
    // for (Map.Entry<Integer, Integer> entry : sortedCount) {
    // // If we have reached the maximum number of deletions, break the loop
    // if (deleted >= m) {
    // break;
    // }
    // // If this ID number has not been seen before, increment the number of
    // different
    // // IDs
    // if (entry.getValue() > 0) {
    // numIds++;
    // }
    // // Increment the number of deleted items by the occurrences of this ID number
    // deleted += entry.getValue();
    // }
    // // Subtract the number of deleted items from the total number of items
    // int remaining = ids.length - deleted;
    // // The final number of different IDs is the remaining number of items divided
    // by
    // // the occurrences of the least common remaining ID
    // int finalNumIds = remaining / Collections.min(count.values());
    // return Math.max(finalNumIds, numIds);
    // }

    public static int deleteProducts(List<Integer> ids, int m) {
        // Count occurrences of each ID
        Map<Integer, Integer> idCount = new HashMap<>();
        for (int id : ids) {
            idCount.put(id, idCount.getOrDefault(id, 0) + 1);
        }
        // Sort IDs based on occurrences in descending order
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(idCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> entry : list) {
            if (m == 0) {
                break;
            }
            int count = entry.getValue();

            if (count <= m) {
                m -= count;
                idCount.remove(entry.getKey());
            } else {
                entry.setValue(count - m);
                m = 0;
            }
        }

        return idCount.size();

    }

    public static void main(String[] args) {
        System.out.println(deleteProducts(List.of(1, 1, 1, 1), 2));
        System.out.println(deleteProducts(List.of(1, 2, 3, 1, 2, 2), 3));
        // Output: 4
    }
}
