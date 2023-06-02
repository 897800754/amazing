package leetcode.structure.arr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-pivot-index/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_724_寻找数组的中心下标 {

    public static void main(String[] args) {
        int[] req1 = new int[]{-1, -1, 0, 1, 1, 0};
        System.out.println(pivotIndex0(req1));
//        int[] req2 = new int[]{1, 2, 3};
//        System.out.println(pivotIndex(req2));
//
//        int[] req3 = new int[]{2, 1, -1};
//        System.out.println(pivotIndex(req3));

    }

    /**
     * 计算nums总和
     * 左边总和*2+num[i] = nums总和
     * 则返回num[i]
     *
     * @param nums
     * @return
     */
    public static int pivotIndex0(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum = sum + nums[i];
        }
        return -1;
    }


    public static int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        //先遍历一遍,求出right的和.
        int right = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        while (index < nums.length) {
            if (index == 0) {
                if (right == 0) {
                    return 0;
                }
                index++;
                continue;
            }
            left = left + nums[index - 1];
            right = right - nums[index];

            if (left != right) {
                index++;
            } else {
                return index;
            }
        }
        return -1;
    }
}




