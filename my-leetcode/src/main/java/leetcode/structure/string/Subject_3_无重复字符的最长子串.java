package leetcode.structure.string;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_3_无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
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
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
//        if (s.length() == 2) {
//            return s.charAt(0) == s.charAt(1) ? 1 : 2;
//        }

        int left = 0;
        int right = 0;
        HashSet<Character> characters = new HashSet<>();

        int maxLen = 0;

        while (right < s.length()) {

            if (characters.contains(s.charAt(right))) {
                maxLen = Math.max(characters.size(), maxLen);
                characters.remove(s.charAt(left));
                left++;
            } else {
                characters.add(s.charAt(right));
                right++;
            }
        }

        return Math.max(characters.size(), maxLen);

    }
}
