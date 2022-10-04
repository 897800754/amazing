package leetcode.myStirng;

import java.util.Arrays;

/**
 * int类型数组 {1,3,44,21,43,3,43,1,1,2,3,4,67,212,11}
 * 过滤重复元素 数组长度不能浪费
 */
public class Demo9 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 44, 1, 3, 3, 43, 1, 1, 2, 3, 4, 22, 11, 22, 22, 11};
        int len = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) len++;
        }
        len++;
        int[] newArr = new int[len];
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) newArr[index++] = arr[i];
            //如果后两位不相等
            if (i == arr.length - 2 && arr[i] != arr[i + 1]) newArr[index++] = arr[i + 1];
            //如果后两位相等
            if (i == arr.length - 2 && arr[i] == arr[i + 1]) newArr[index++] = arr[i];
        }
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }
}
