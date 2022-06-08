package codingproblems.leetcode;

/*
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

 * If target is not found in the array, return [-1, -1].
 *  
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * 
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *  
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class Problem34 {
    public static int[] searchRange(int[] nums, int target) {
        // base case
        if (nums.length == 0)
            return new int[] { -1, -1 };
        if (nums[nums.length - 1] < target || nums[0] > target)
            return new int[] { -1, -1 };

        // First occurance
        int[] result = { -1, -1 };
        // int start = 0;
        // int end = nums.length - 1;
        // while (start <= end) {
        // int mid = start + (end - start) / 2;
        // if (nums[mid] == target) {
        // result[0] = mid;
        // end = mid - 1;
        // } else if (nums[mid] > target) {
        // end = mid - 1;
        // } else {
        // start = mid + 1;
        // }
        // }

        result[0] = search(nums, target, true);
        // if start index is already -1 no need to check last index
        if (result[0] == -1)
            return result;
        // for end index
        // start = 0;
        // end = nums.length - 1;
        // while (start <= end) {
        // int mid = start + (end - start) / 2;
        // if (nums[mid] == target) {
        // result[1] = mid;
        // start = mid + 1;
        // } else if (nums[mid] > target) {
        // end = mid - 1;
        // } else {
        // start = mid + 1;
        // }
        // }
        result[1] = search(nums, target, false);

        return result;
    }

    static int search(int[] nums, int target, boolean firstOccurance) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (firstOccurance) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
