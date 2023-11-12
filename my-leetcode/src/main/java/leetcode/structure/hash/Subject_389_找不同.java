package leetcode.structure.hash;

/**
 * https://leetcode.cn/problems/find-the-difference/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_389_找不同 {

    public static void main(String[] args) {
        System.out.println(findTheDifference2("abcd", "abcdf"));
    }

    /**
     * 哈希表
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        int[] ints = new int['z' - 'a' + 1];
        for (char aChar : chars) {
            ints[aChar - 'a']++;
        }
        char[] chars1 = t.toCharArray();
        for (char c : chars1) {
            int index = c - 'a';
            if (ints[index] == 0) {
                return c;
            } else if (ints[index] != 0) {
                ints[index]--;
            }
        }
        return '1';
    }

    /**
     * 求和
     */
    public static char findTheDifference1(String s, String t) {
        int ss = 0;
        for (int i = 0; i < s.length(); i++) {
            ss += s.charAt(i);
        }
        int ts = 0;
        for (int i = 0; i < t.length(); i++) {
            ts += t.charAt(i);
        }

        return (char) (ts - ss);
    }

    /**
     * 如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符。类似于「136. 只出现一次的数字」，我们使用位运算的技巧解决本题。
     */

    public static char findTheDifference2(String s, String t) {
        String union = s + t;
        int res = 0;
        for (int i = 0; i < union.length(); i++) {
            res ^= union.charAt(i);
        }
        return (char) res;
    }

}




