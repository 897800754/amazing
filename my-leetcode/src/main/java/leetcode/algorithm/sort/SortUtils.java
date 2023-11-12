package leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * @author: cg
 * @date: 2023-02-07 23:41
 **/
public class SortUtils {

    public static void exchange(int[] ints, int i, int j) {
        int temp = ints[j];
        ints[j] = ints[i];
        ints[i] = temp;
    }


    public static void assertSort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                throw new RuntimeException(String.format("sort error , arr:%s", Arrays.toString(ints)));
            }
        }
        System.out.println(Arrays.toString(ints));
    }
}
