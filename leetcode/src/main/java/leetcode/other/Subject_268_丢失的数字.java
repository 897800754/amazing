package leetcode.other;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_268_丢失的数字 {

    public static void main(String[] args) {
        System.out.println(missingNumber0(new int[]{0, 1}));
    }

    /**
     * hash表
     * 其他方法:异或,等差数量求和再做减法
     *
     * @param nums
     * @return
     */
    public static int missingNumber0(int[] nums) {
        boolean[] ba = new boolean[nums.length + 1];

        for (int num : nums) {
            ba[num] = true;
        }

        for (int i = 0; i < ba.length; i++) {
            if (!ba[i]) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 排序暴力解
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return 1;
        }
        if (nums.length == 1 && nums[0] == 1) {
            return 0;
        }

        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] - 1) {
                return nums[i + 1] - 1;
            }
        }
        return nums.length;
    }
}




