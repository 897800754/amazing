package leetcode.structure.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_15_三数之和_TODO {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 暴力解,遍历三次
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int i1 = i + 1; i1 < nums.length - 1; i1++) {
                for (int j = i1 + 1; j < nums.length; j++) {
                    if (i != i1 && i != j && i1 != j && (nums[i] + nums[i1] + nums[j] == 0)) {
                        //检查是否重复
                        List<Integer> integers = Arrays.asList(nums[i], nums[i1], nums[j]);
                        if (check(lists, integers)) {
                            lists.add(integers);
                        }
                    }
                }
            }
        }
        return lists;
    }

    private static boolean check(ArrayList<List<Integer>> lists, List<Integer> integers) {
        HashSet<Integer> integers2 = new HashSet<>(integers);
        for (List<Integer> list : lists) {
            HashSet<Integer> integers1 = new HashSet<>(list);
            boolean flag = true;
            for (Integer integer : integers1) {
                if (!integers2.contains(integer)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return false;
            }
        }
        return true;
    }
}




