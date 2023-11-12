package leetcode.algorithm.sort;

import static leetcode.algorithm.sort.SortUtils.assertSort;
import static leetcode.algorithm.sort.SortUtils.exchange;

/**
 * 冒泡排序
 *
 * @author: cg
 * @date: 2023-02-05 23:42
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 10, 6, -1, -2, 1000, 999, -111, 1};
        sort(ints);
        assertSort(ints);
    }

    protected static void sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    exchange(ints, j, j + 1);
                }
            }
        }

    }
}
