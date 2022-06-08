package codingproblems.telegram;

public class FloorElement {
    public static int floor(int[] array, int target) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return target;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return array[end];
    }
}
