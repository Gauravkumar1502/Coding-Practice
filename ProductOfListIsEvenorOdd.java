import java.util.Arrays;

public class ProductOfListIsEvenorOdd {
    public static void main(String[] args) {
        int len = 5;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) ((Math.random() * (1000 - 100)) + 100);
        }
        int sum = 0;
        boolean productIsEven = false;
        for (int i = 0; i < len; i++) {
            productIsEven = productIsEven || (arr[i] % 2 == 0);
            sum += arr[i];
        }
        if (productIsEven) {
            System.out.println("Sum is : " + sum + " and Product is even");
        } else {
            System.out.println("-1");
        }

    }

}
