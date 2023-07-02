package leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_78_子集 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
//        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    /**
     * 拓展法
     * https://www.bilibili.com/video/BV1NV411b7qN/?spm_id_from=333.999.0.0&vd_source=82f41d572eea48d59af82e978a54f5af
     * n=0 []
     * n=1 [1]
     * n=2 [2],[2,1]
     * n=3 [3],[3,1],[3,2],[3,2,1]
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {
            int index = res.size() - 1;
            //取出当前index之前的subSet
            while (index >= 0) {
                List<Integer> subSet = res.get(index);
                ArrayList<Integer> newSet = new ArrayList<>(subSet);
                newSet.add(nums[i - 1]);
                res.add(newSet);
                index--;
            }
        }
        return res;
    }


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
     * 回溯算法
     * https://www.bilibili.com/video/BV1NV411b7qN/?spm_id_from=333.788&vd_source=82f41d572eea48d59af82e978a54f5af
     * []               找长度为0的子集
     * 1  ->  2  ->   3  [1],[2],[3]      找长度为1的子集
     * 2->3    3         [1,2],[1,3][2,3] 找长度为2的子集
     * 3                 [1,2,3]          找长度为3的子集
     * 为了防止重复,每次递归都是找当前元素后面的元素.
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backtrack(i, nums, res, new ArrayList<Integer>(), 0);
        }
        return res;
    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> buffer, int index) {
        if (i == buffer.size()) {
            res.add(new ArrayList<>(buffer));
            return;
        }
        for (int j = index; j < nums.length; j++) {
            buffer.add(nums[j]);
            backtrack(i, nums, res, buffer, j + 1);
            buffer.remove(buffer.size() - 1);
        }
    }


//
//    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> buffer, int index) {
//        if (i == buffer.size()) {
//            res.add(new ArrayList<>(buffer));
//            return;
//        }
//        for (int j = index; j < nums.length; j++) {
//            buffer.add(nums[j]);
//            backtrack(i, nums, res, buffer, j + 1);
//            buffer.remove(buffer.size() - 1);
//        }
//
//    }


    /**
     * dfs,一条路走到黑
     * []
     * [1]
     * [1,2]
     * [1,3]
     * [1,2,3]
     * [2]
     * [2,3]
     * [3]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, new ArrayList<Integer>());
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, int index, List<Integer> subSet) {
        res.add(new ArrayList<>(subSet));
        if (nums.length == index) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            subSet.add(nums[i]);
            dfs(nums, res, i + 1, subSet);
            subSet.remove(subSet.size() - 1);
        }

    }

}



