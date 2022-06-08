package codingproblems.leetcode;

/*
 * 744. Find Smallest Letter Greater Than Target
 * Given a characters array letters that is sorted in non-decreasing order and a character 
 * target, return the smallest character in the array that is larger than target.
 * 
 * Note that the letters wrap around.
 * 
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 *  
 * 
 * Example 1:
 * 
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Example 2:
 * 
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Example 3:
 * 
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 *  
 * 
 * Constraints:
 * 
 * 2 <= letters.length <= 104
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 */
public class Problem744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target)
            return letters[0];

        int start = 0;
        int end = letters.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return letters[start];

        // Another Solution

        // int lo = 0, hi = letters.length;
        // while (lo < hi) {
        // int mi = lo + (hi - lo) / 2;
        // if (letters[mi] <= target) lo = mi + 1;
        // else hi = mi;
        // }
        // return letters[lo % letters.length];
    }
}