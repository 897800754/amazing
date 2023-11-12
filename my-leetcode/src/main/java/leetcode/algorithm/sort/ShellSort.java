package leetcode.algorithm.sort;

import static leetcode.algorithm.sort.SortUtils.assertSort;
import static leetcode.algorithm.sort.SortUtils.exchange;

/**
 * 冒泡排序
 *
 * @author: cg
 * @date: 2023-02-05 23:42
 **/
public class ShellSort {

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 10, 6, -1, -2, 1000, 999, -111};
        sort(ints);
        assertSort(ints);
    }

    protected static void sort(int[] arr) {
        //1.找到增长量初始值
        //已知最小增长量,找到最大增长量
        int h = 1;

        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }
        //2.根据N进行分组,进行插入排序

        while (h >= 1) {
            //找到每个分组  待插入的元素
            for (int i = h; i < arr.length; i++) {
                //逆序遍历 前面的元素
                for (int j = i; j >= h; j = j - h) {
                    if (arr[j] < arr[j - h]) {
                        exchange(arr, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            //3.找到下一个增量量,循环

            h = h / 2;
        }


    }
}
