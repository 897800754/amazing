package leetcode.algorithm.sort;

import static leetcode.algorithm.sort.SortUtils.assertSort;

/**
 * @author: cg
 * @date: 2023-02-12 15:55
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, -2, 1000, 999, -111, 1};
        sort(arr);
        assertSort(arr);


    }

    private static int[] helper;

    protected static void sort(int[] arr) {
        helper = new int[arr.length];
        int lo = 0;
        int hi = arr.length - 1;
        sort(arr, lo, hi);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        //获取mid, 0 ,3
        int mid = (lo + hi) / 2;

        sort(arr, lo, mid);

        sort(arr, mid + 1, hi);

        merge(arr, lo, mid, hi);

    }


    public static void merge(int[] arr, int lo, int mid, int hi) {

        int loIndex = lo;

        int hiIndex = mid + 1;

        int helperIndex = lo;

        while (true) {
            if (hiIndex == hi) {
                //高位已经遍历完了,低位数组已经全部有序

                //将低位放到数组末端
                while (loIndex <= mid) {
                    helper[helperIndex++] = arr[loIndex++];
                }
                break;
            }
            if (loIndex == mid) {
                //低位已经遍历完了,高位数组已经全部有序
                //将高位放到辅助数组
                while (hiIndex <= hi) {
                    helper[helperIndex++] = arr[hiIndex++];
                }
                break;
            }
            //均未遍历完
            if (arr[hiIndex] < arr[loIndex]) {
                //
                helper[helperIndex++] = arr[hiIndex];
                hiIndex++;
            } else {
                helper[helperIndex++] = arr[loIndex];
                loIndex++;
            }
        }

        for (int i = lo; i <= hi; i++) {
            arr[i] = helper[i];
        }


    }


}
