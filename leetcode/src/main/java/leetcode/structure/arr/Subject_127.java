package leetcode.structure.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/contains-duplicate/description/
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_127 {

    public static void main(String[] args) {
        int[] req1 = new int[]{-1, -100, 3, 99};
        boolean b = containsDuplicate(req1);
        System.out.println(b);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}




