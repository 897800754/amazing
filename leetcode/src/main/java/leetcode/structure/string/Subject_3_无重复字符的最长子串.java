package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_3_无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] ints = new int[26];
        int left = 0;
        int right = 0;
        int maxLen = 1;

        while (right < s.length()) {
            char c = s.charAt(right);
            int index = c - 'a';
            if (ints[index] == 0) {
                ints[index]++;
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else if (ints[index] == 1) {
                //说明重复了
                right++;
                ints[index]++;
                ints[left]--;
                left++;
                while (left <= right) {
                    if (ints[s.charAt(left) - 'a'] > 1) {
                        //说明继续要向→走
                        ints[s.charAt(left) - 'a']--;
                        left++;
                    } else {
                        break;
                    }
                }
            }
        }
        return maxLen;
    }
}
