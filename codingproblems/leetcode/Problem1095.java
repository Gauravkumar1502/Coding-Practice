package codingproblems.leetcode;

public class Problem1095 {
    public int findInMountainArray(int target, int[] mountainArr) {
        // base condition
        if (mountainArr.length < 3)
            return -1;

        // find peak element
        int highest = findPeakElementIndex(mountainArr);
        // if present in asc side return index
        int inLeft = orderAgnostic(mountainArr, 0, highest, target);
        if (inLeft != -1)
            return inLeft;
        return orderAgnostic(mountainArr, highest + 1, mountainArr.length - 1, target);
    }

    private static int orderAgnostic(int[] array, int start, int end, int target) {
        boolean isAsc = (array[start] < array[end]);
        while (start <= end) {
            // int mid = (start+end)/2; // Do not use this formula for mid becasuse in some
            // case this may break and cross the integer limit
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (array[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (array[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    private static int findPeakElementIndex(int[] mountainArr) {
        int start = 0;
        int end = mountainArr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr[mid] < mountainArr[mid + 1]) {
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
        return start;
    }
}
