package leetcode.sort;

import static leetcode.sort.SortUtils.assertSort;
import static leetcode.sort.SortUtils.exchange;

/**
 * 选择排序
 * <p>
 * 选择合适的元素放到合适的位置
 * <p>
 * 冒泡找最大值,选择找最小值
 * <p>
 * https://www.bilibili.com/video/BV1dV411U7VN?p=4&vd_source=82f41d572eea48d59af82e978a54f5af
 *
 * @author: cg
 * @date: 2023-02-07 23:11
 **/
public class ChooseSort {


    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 10, 6, -1, -2, 1000, 999, -111, 1};
        sort(ints);
        assertSort(ints);
    }

    private static void sort(int[] ints) {
        //
        for (int i = 0; i < ints.length - 1; i++) {
            int min = ints[i];
            for (int j = i + 1; j < ints.length; j++) {
                if (min > ints[j]) {
                    min = ints[j];
                    exchange(ints, i, j);
                }
            }
        }

    }


}
