package codingproblems.telegram;

/*
 * Write a program that will take an input string which consist of an even number of 4 digit
 * words. You need to do the swaping of chracters in the following manner in the input string 
 * to genrate new string.
 * 
 * ex:
 *  input ->    LOTP FNYG KWEQ BDCG KLUI OTFP
 *              
 *  output ->   YGFN TPLO CGBD EQKW FPOT UIKL    
 */
public class StringSwap {

    public static String swap(String string) {
        StringBuilder result = new StringBuilder();
        for (String str : string.split(" ")) {
            result.append(str.charAt(2));
            result.append(str.charAt(3));
            result.append(str.charAt(0));
            result.append(str.charAt(1));
            result.append(" ");
        }
        String[] splitString = result.toString().split(" ");
        result.setLength(0);
        for (int i = 0; i < splitString.length - 1; i += 2) {
            result.append(splitString[i + 1] + " ");
            result.append(splitString[i] + " ");
        }
        System.out.println("result : " + result);
        // alternate Swap

        return result.toString();
    }
}
