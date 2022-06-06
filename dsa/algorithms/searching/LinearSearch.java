package dsa.algorithms.searching;

public class LinearSearch {

    public static int findInt(int[] array, int target) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public static int findLong(double[] array, double target) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public static int findFloat(float[] array, float target) {
        for (int index = 0; index < array.length; index++) {
            if (Float.compare(array[index], target) == 0) {
                return index;
            }
        }
        return -1;
    }

    public static int findDouble(double[] array, double target) {
        for (int index = 0; index < array.length; index++) {
            if (Double.compare(array[index], target) == 0) {
                return index;
            }
        }
        return -1;
    }

    public static int findChar(char[] array, char target) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public static int findCharIgnoreCase(char[] array, char target) {
        for (int index = 0; index < array.length; index++) {
            if (Character.toLowerCase(array[index]) == Character.toLowerCase(target)) {
                return index;
            }
        }
        return -1;
    }

    public static int findChar(String string, char target) {
        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) == target) {
                return index;
            }
        }
        return -1;
    }

    public static int findCharIgnoreCase(String string, char target) {
        for (int index = 0; index < string.length(); index++) {
            if (string.toLowerCase().charAt(index) == Character.toLowerCase(target)) {
                return index;
            }
        }
        return -1;
    }

    public static int findString(String[] strings, String target) {
        for (int index = 0; index < strings.length; index++) {
            if (strings[index].equals(target)) {
                return index;
            }
        }
        return -1;
    }

    public static int findStringIgnoreCase(String[] strings, String target) {
        for (int index = 0; index < strings.length; index++) {
            if (strings[index].equalsIgnoreCase(target)) {
                return index;
            }
        }
        return -1;
    }

}
