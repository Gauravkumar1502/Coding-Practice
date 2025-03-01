public class BitwiseAndModSpeed {
    public static void main(String[] args) {
        // find max array size
        System.out.println("Max array size: " + findMaxArraySize());
        int len = 10;
        System.out.println("Max array size: " + len);
        // int len = 2147483647;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) ((Math.random() * (1000 - 100)) + 100);
        }
        System.out.println("Length of array: " + len);
        long startTime = System.nanoTime();
        for (int i = 0; i < len; i++) {
            isEvenUsingMod(arr[i]);
        }
        // time seprated by , for better readability in nenoseconds ex 1,000,000,000
        System.out.println("Time taken by isEvenUsingMod: " + String.format("%,d", (System.nanoTime() - startTime))
                + " nanoseconds");
        startTime = System.nanoTime();
        for (int i = 0; i < len; i++) {
            isEvenUsingBitwise(arr[i]);
        }
        System.out.println("Time taken by isEvenUsingBitwise: " + String.format("%,d", (System.nanoTime() - startTime))
                + " nanoseconds");

    }

    static int findMaxArraySize() {
        int low = 10_000_000;
        int high = Integer.MAX_VALUE;
        int limit = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            try {
                int[] arr = new int[mid];
                limit = mid;
                low = mid + 1;
            } catch (OutOfMemoryError e) {
                high = mid - 1;
            }
        }
        return limit;
    }

    static boolean isEvenUsingMod(int num) {
        return num % 2 == 0;
    }

    static boolean isEvenUsingBitwise(int num) {
        return (num & 1) == 0;
    }
}
