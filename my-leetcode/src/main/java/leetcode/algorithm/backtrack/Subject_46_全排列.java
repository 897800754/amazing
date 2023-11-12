package leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_46_全排列 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, new ArrayList<Integer>(nums.length), res);
        return res;
    }

    private static void backtrack(int[] nums, List<Integer> buffer, List<List<Integer>> res) {
        if (buffer.size() == nums.length) {
            res.add(new ArrayList<>(buffer));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!buffer.contains(nums[i])) {
                    buffer.add(nums[i]);
                    backtrack(nums, buffer, res);
                    buffer.remove(buffer.size() - 1);
                }

            }
        }

    }
}



