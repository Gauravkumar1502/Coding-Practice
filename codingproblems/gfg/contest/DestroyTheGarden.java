/*
 * Geek has grown a good garden with certain plants having their branches
joined with each other. The number of plants in Geek's garden is N and the
number of branches that are overlapped is M.
A malicious guy wants to destroy the Geek's garden by sprinkling poison
on the plants. The poison required to destroy a plant is given by an array
arr. When a plant say x gets destroyed then all the plants with overlapping
branches (directly or indirectly) and requiring less than or equal poison
gets destroyed.
Now calculate the minimum amount of poison he must buy to destroy the
Geeks garden.

Example 1:
Input:
arr = [2, 3, 5, 6]
overlapped = [ [1, 5],[3,4]
Output:
14
Explanation:
6 units of poison can destroy the first and the last plant, 3 units
of poison can destroy the 2nd plant and 5 units of poison can
destroy the 3rd and the 4th plant.

Example 2:
Input:
arr = [1, 2, 3,4]
overlapped -
Output:
14
Explanation:
th
Geek can ddestroy the 4 plant with 4 units of poison and since
it overlaps with the 3rd plant it also gets destroyed. Now, when
the third plant gets destroyed it also destroys the 2nd plant since
it overlaps with third and requires less poison. Similarly upon
destroying second plant will also destroy the first one.
Your Task:
You don't need to read input or print anything. Your task is to complete the
function destroyTheGarden() which takes N, M, arr, and overlapped as
input parameters and returns the minimum amount of poison required.
 */
package codingproblems.gfg.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DestroyTheGarden {
    public static long destroyTheGarden(int n, int m, int arr[], int overlapped[][]) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int[] overlap : overlapped) {
            addToSetIfContain(list, overlap[0], overlap[1]);
        }
        long sum = 0;
        for (HashSet<Integer> set : list)
            sum += findMax(arr, set);

        for (int ele : arr)
            if (ele != 0)
                sum += ele;
        return sum;
    }

    private static long findMax(int[] arr, Set<Integer> set) {
        long max = -1;
        for (int index : set) {
            max = Math.max(max, arr[index - 1]);
            arr[index - 1] = 0;
        }
        return max;
    }

    private static void addToSetIfContain(ArrayList<HashSet<Integer>> list, int a, int b) {
        for (Set<Integer> set : list) {
            if (set.contains(a) || set.contains(b)) {
                set.add(a);
                set.add(b);
                return;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        list.add(set);
    }

    public static void main(String[] args) {
        System.out.println(
                destroyTheGarden(5, 2, new int[] { 2, 3, 4, 5, 6 }, new int[][] { { 1, 5 }, { 3, 4 } }));
        System.out.println(
                destroyTheGarden(4, 3, new int[] { 1, 2, 3, 4 }, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }));
    }
}
