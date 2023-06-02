package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/string-to-integer-atoi/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_5_最长回文子串_TODO {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("eabcb "));
        System.out.println(longestPalindrome("ac "));
    }

    /**
     * 动态规划
     * 1.枚举子问题
     * 2.定义状态
     * P(i,j) = true/false
     * <p>
     * 从第i-j个字母组成的串是否为回文数
     * <p>
     * 2.确认状态转移方程
     * P(i,j) = P(i+1,j-1)&Si==Sj
     * <p>
     * 3.定义dp数组,遍历,初始化
     * dp[i][j] = new dp[s.len][s.len]
     * dp[0][0] = true;
     * dp[0][1] = true
     * dp[1][0] 不存在
     * dp[1][1] = true
     *
     * @param s
     * @return
     */
    public static String longestPalindrome0(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * <p>
     * 对撞指针
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        //最优解-1
        int max = s.length() - 1;
        while (max > 0) {
            //最优解
            int start = 0;
            int end = max;
            //end = 1 l=2
            while (end < s.length()) {
                if (isPalindrome(s, start, end)) {
                    return s.substring(start, end + 1);
                }
                start++;
                end++;
            }
            max--;
        }
        //找不到,任意取一个字符
        return s.substring(0, 1);

    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
