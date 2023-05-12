package leetcode;

/**
 * @author: cg
 * @date: 2023-05-11 13:35
 **/
public class ArrayUtils {
    public static void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
