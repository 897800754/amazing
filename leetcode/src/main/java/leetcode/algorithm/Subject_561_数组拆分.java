package leetcode.algorithm;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/array-partition/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_561_数组拆分 {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
    }

    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            max += Math.min(nums[i], nums[i + 1]);
        }
        return max;
    }

}
