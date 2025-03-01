package codingProblems.telegram;

public class Partition {

    public static void main(String[] args) {
        int[] array = new int[] { 8, 3, 2, 1, 7, 4, 6, 5 };
        partition(array);
        System.out.println(array);
    }

    static void partition(int[] arr) {
        int pivit = arr[arr.length - 1];
        // 8, 3, 2, 1, 7, 4, 6, 5
        // 5, 3, 2, 1, 7, 4, 6, 8
        // 4, 3, 2, 1, 5, 7, 6, 8


    }

}
