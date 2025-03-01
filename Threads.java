import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Threads {
    public static void main(String[] args) {
        /*
         * suppose you are given an array of integers. You have to find the sum of all
         * the elements of the array using threads.
         * Threds must be used to equall to the number of processors available in the
         * system.
         */
        int[] arr = IntStream.range(0, 1000000).map(i -> (int) (Math.random() * 100)).toArray();
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Processors: " + processors);
        int size = arr.length / processors;
        AtomicInteger sum = new AtomicInteger();
        Thread[] threads = new Thread[processors];
        Long st = System.currentTimeMillis();
        for (int i = 0; i < processors; i++) {
            int start = i * size;
            int end = (i + 1) * size;
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    sum.addAndGet(arr[j]);
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
            }
        }
        System.out.println("Time: " + (System.currentTimeMillis() - st));
        System.out.println("Sum Using Threads: " + sum);
        // sum without threads
        st = System.currentTimeMillis();
        int sum2 = Arrays.stream(arr).sum();
        System.out.println("Time: " + (System.currentTimeMillis() - st));
        System.out.println("Sum Without Threads: " + sum2);
        // sum using parallel stream
        st = System.currentTimeMillis();
        int sum3 = Arrays.stream(arr).parallel().sum();
        System.out.println("Time: " + (System.currentTimeMillis() - st));
        System.out.println("Sum Using Parallel Stream: " + sum3);
        // sum using for loop
        st = System.currentTimeMillis();
        int sum4 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum4 += arr[i];
        }
        System.out.println("Time: " + (System.currentTimeMillis() - st));
        System.out.println("Sum Using For Loop: " + sum4);
    }
}
