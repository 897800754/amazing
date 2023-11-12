package leetcode.structure.arr;

import java.util.*;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/description/
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_350 {

    public static void main(String[] args) {
        int[] req1 = new int[]{1, 2, 2, 1};
        int[] req2 = new int[]{2, 2};

        System.out.println(Arrays.toString(intersect(req1, req2)));
        System.out.println(Arrays.toString(intersect1(req1, req2)));
    }

    /**
     * 排序+双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ints = new int[Math.min(nums1.length, nums2.length)];

        //双指针
        int index1 = 0;

        int index2 = 0;

        int index = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] > nums2[index2]) {
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                ints[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(ints, 0, index);
    }

    /**
     * 双map解决,暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums1Map = toMap(nums1);
        HashMap<Integer, Integer> nums2Map = toMap(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : nums1Map.entrySet()) {
            if (nums2Map.containsKey(entry.getKey())) {
                //交集
                int count = Math.min(entry.getValue(), nums2Map.get(entry.getKey()));
                while (count-- > 0) {
                    res.add(entry.getKey());

                }
            }
        }

        int[] ints = new int[res.size()];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = res.get(i);
        }

        return ints;
    }

    private static HashMap<Integer, Integer> toMap(int[] nums1) {
        HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            map.compute(nums1[i], (key, value) -> {
                if (Objects.isNull(value)) {
                    return 1;
                } else {
                    return value + 1;
                }
            });
        }
        return map;
    }
}




