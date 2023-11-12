package leetcode.algorithm.divideandconquer;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/majority-element/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_169_多数元素 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * hash表
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashTable = new HashMap<>(nums.length);
        int limit = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            hashTable.compute(nums[i], (k, v) -> {
                if (v == null) {
                    v = 1;
                } else {
                    v++;
                }
                return v;
            });
            Integer value = hashTable.get(nums[i]);
            if (value > limit) {
                return nums[i];
            }
        }
        return -1;
    }
}




