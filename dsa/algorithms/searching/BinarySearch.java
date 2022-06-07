package dsa.algorithms.searching;

public class BinarySearch {
    public static int findInAsc(int[] array, int target) {
        if (array[0] > array[array.length - 1]) {
            throw new IllegalArgumentException("Array not sorted in Ascending Order.");
        }
        int start = 0, end = array.length - 1;
        while (start <= end) {
            // int mid = (start+end)/2; // Do not use this formula for mid becasuse in some
            // case this may break and cross the integer limit
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int findInDsc(int[] array, int target) {
        if (array[0] < array[array.length - 1]) {
            throw new IllegalArgumentException("Array not sorted in Descending Order.");
        }
        int start = 0, end = array.length - 1;
        while (start <= end) {
            // int mid = (start+end)/2; // Do not use this formula for mid becasuse in some
            // case this may break and cross the integer limit
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int orderAgnostic(int[] array, int target) {
        int start = 0, end = array.length - 1;
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
}
