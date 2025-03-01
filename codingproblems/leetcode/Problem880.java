package codingproblems.leetcode;

public class Problem880 {
    public static void main(String[] args) {
        // System.out.println(new Problem880().decodeAtIndex("leet2code3", 10));
        // System.out.println(new Problem880().decodeAtIndex("ha22", 5));
        // System.out.println(new Problem880().decodeAtIndex("a2345678999999999999999",
        // 1));
        System.out.println(new Problem880().decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }

    public String decodeAtIndex(String s, int k) {
        int i = 0;
        // y959q969u3hb22odq595
        // 222280369
        // leet2code3 6
        // leet
        while (i < k) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {

            } else {
                i++;
            }
        }
        return "";
    }
    // public String decodeAtIndex(String s, int k) {
    // StringBuilder decode = new StringBuilder();
    // for (char c : s.toCharArray()) {
    // if (c >= 48 && c <= 57) {
    // if (decode.length() * (c - 48 - 1) >= k)
    // return String.valueOf(decode.charAt((k - 1) % decode.length()));
    // decode.append(decode.toString().repeat(c - 48 - 1));
    // } else {
    // decode.append(c);
    // }
    // if (decode.length() >= k)
    // break;
    // }
    // System.out.println(decode);
    // return String.valueOf(decode.charAt(k - 1));
    // }
}
