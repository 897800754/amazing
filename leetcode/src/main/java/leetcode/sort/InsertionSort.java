package leetcode.sort;

import static leetcode.sort.SortUtils.assertSort;
import static leetcode.sort.SortUtils.exchange;

/**
 * 插入排序
 *
 * @author: cg
 * @date: 2023-02-05 23:42
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] ints = {1, 3, 4, -2, 1000, 999, -111, 1};
        sort(ints);
        assertSort(ints);
    }

    protected static void sort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            for (int j = i; j > 0; j--) {
                if (ints[j - 1] > ints[j]) {
                    //
                    exchange(ints, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

//    protected static void sort(int[] ints) {
//        for (int i = 1; i < ints.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (ints[i] < ints[j]) {
//                    //将ints[i],插入到头部
//                    int min = ints[i];
//                    for (int k = i; k > j; k--) {
//                        ints[k] = ints[k - 1];
//                    }
//                    ints[j] = min;
////                    exchange(ints, i, j);
//                    break;
//                }
//            }
//        }
//    }
}
