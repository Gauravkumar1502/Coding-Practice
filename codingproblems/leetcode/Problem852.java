package codingproblems.leetcode;

/*
 * 852. Peak Index in a Mountain Array
 * Let's call an array arr a mountain if the following properties hold:

 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: arr = [0,1,0]
 * Output: 1
 * Example 2:
 * 
 * Input: arr = [0,2,1,0]
 * Output: 1
 * Example 3:
 * 
 * Input: arr = [0,10,5,2]
 * Output: 1
 *  
 * 
 * Constraints:
 * 
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * arr is guaranteed to be a mountain array.
 *  
 * 
 * Follow up: Finding the O(n) is straightforward, could you find an O(log(n)) solution? * 
 */
public class Problem852 {

    // for this problem maximum element is the answer.

    // Using linear search
    // public int peakIndexInMountainArray(int[] arr) {
    // int i = 0;
    // while (arr[i] < arr[i + 1])
    // i++;
    // return i;
    // }

    // Using binary Search search
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // you are in asc part of array
                // because we know that mid+1 element > mid element
                start = mid + 1;
            } else {
                // you are in desc part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2
        // checks above
        return start; // or return end as both are equal
    }
}
