package leetcode.structure.arr;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_80_删除有序数组中的重复项2_TODO {

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeDuplicates(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int start = 0;

        int point = 1;

        boolean flag = false;

        while (point < nums.length - 1) {
            if (nums[start] == nums[point]) {
                if (flag) {

                } else {
                    flag = true;
                    start++;
                    point++;
                }
            } else {
                start++;
                point++;
                flag = false;
            }
        }
        return nums.length;
    }
}




