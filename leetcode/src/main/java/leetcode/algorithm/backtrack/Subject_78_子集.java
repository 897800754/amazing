package leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_78_子集 {

    public static void main(String[] args) {
        System.out.println(subsets0(new int[]{1, 2, 3}));
//        System.out.println(1 << 1);
//        System.out.println(0 << 1);
    }

    /**
     * todo
     * 拓展法
     * https://www.bilibili.com/video/BV1NV411b7qN/?spm_id_from=333.999.0.0&vd_source=82f41d572eea48d59af82e978a54f5af
     */

    /**
     * https://leetcode.cn/problems/subsets/solutions/420294/zi-ji-by-leetcode-solution/
     * 迭代法实现子集枚举
     * 每一位代表改位置元素是否出现,通过迭代法,罗列出所有的子集
     * 000 []
     * 001 [1]
     * 010 [2]
     * 011 [1,2]
     * 100 [3]
     * 101 [1,3]
     * 110 [2,3]
     * 111 [1,2,3]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets0(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            //取出mask不等于0的部分.
            List<Integer> subSet = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                //1<<i 表示001(1),010(2),100(4) 与mask 相与得到是否 第1,2,3位为1
                if ((mask & (1 << i)) != 0) {
                    subSet.add(nums[i]);
                }
            }
            res.add(subSet);
        }
        return res;
    }

    /**
     * 递归法实现子集枚举
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtrack(i, nums, res, new ArrayList<Integer>(), new HashSet<Integer>());
        }
        return res;
    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> buffer, HashSet<Integer> hasUse) {
        if (i == buffer.size()) {
            res.add(new ArrayList<>(buffer));
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (!hasUse.contains(nums[j])) {
                    hasUse.add(nums[j]);
                    buffer.add(nums[j]);
                    backtrack(i, nums, res, buffer, hasUse);
                    buffer.remove(buffer.size() - 1);
                }
            }
        }
    }

}



