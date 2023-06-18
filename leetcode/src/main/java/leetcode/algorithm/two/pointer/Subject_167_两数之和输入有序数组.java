package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * @author: cg
 * @date: 2023-02-05 23:14
 **/
public class Subject_167_两数之和输入有序数组 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }

    /**
     * hash解法
     * 也可以使用双指针,对撞指针
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        //key为匹配的值,value为相匹配的下标
        Integer[] hash = new Integer[2001];
        //0~1000为非负数,大于1000为负数

        for (int i = 0; i < numbers.length; i++) {
            if (hash[numbers[i] >= 0 ? numbers[i] : numbers[i] + 1000] != null) {
                //存在值,返回
                int[] ans = new int[2];
                ans[0] = hash[numbers[i] >= 0 ? numbers[i] : numbers[i] + 1000] + 1;
                ans[1] = i + 1;
                return ans;
            }
            int need = target - numbers[i];
            hash[need >= 0 ? need : need + 1000] = i;
        }
        return null;
    }

}
