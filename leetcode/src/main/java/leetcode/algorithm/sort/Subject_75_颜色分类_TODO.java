package leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sort-colors/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_75_颜色分类_TODO {

    public static void main(String[] args) {
        int[] ints = {0, 1};
        sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 两次遍历
     * 第一次遍历吧0放到数组前部
     * 第二次遍历吧2放到数据后部
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {

        int ptr = 0;

        for (int i = ptr + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        if (ptr >= nums.length) {
            return;
        }

//        for (int i = 0; i < ; i++) {
//
//        }


    }


}




