package leetcode.structure.arr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/rotate-array/description/
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_189 {

    public static void main(String[] args) {
//        int[] req = new int[]{1, 2, 3, 4, 5, 6, 7};
//        rotate(req, 3);
//        System.out.println(Arrays.toString(req));

        int[] req1 = new int[]{-1, -100, 3, 99};
        rotate(req1, 2);
        System.out.println(Arrays.toString(req1));
    }

    /**
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < nums.length; i++) {
            newArr[(k + i) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);

    }
}




