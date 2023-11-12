package leetcode.structure.arr;

import java.util.*;

/**
 * https://leetcode.cn/problems/single-number/description/
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 * <p>
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_136 {

    public static void main(String[] args) {

        int[] req1 = new int[]{2, 2, 1, 3, 3, 4, 4, 1, 9};

        System.out.println(singleNumber(req1));

        System.out.println(singleNumber1(req1));

        System.out.println(singleNumber2(req1));
    }

    /**
     * 异或
     * 成对出现的数 异或为0
     * a^a = 0;
     * a^b^a = (a^a)^b = 0^b =b
     *
     * @param nums
     * @return
     */
    private static int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }

    /**
     * hash表记录
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.compute(nums[i], (key, value) -> {
                if (Objects.isNull(value)) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }

        }
        return nums[nums.length - 1];
    }

    /**
     * 暴力解法
     * 也可以使用hash表记录每个nums出现的次数
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Set<Integer> sets = new HashSet<>();


        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            if (sets.contains(nums[i])) {
                continue;
            }
            //遍历数组
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    //跳过
                    flag = false;
                    sets.add(nums[i]);
                    break;
                }
            }
            if (flag) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }
}




