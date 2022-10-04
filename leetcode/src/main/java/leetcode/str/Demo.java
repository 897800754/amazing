package leetcode.str;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix1(new String[]{"c"}));
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str1 = strs[0];
        if (strs.length == 1) {
            return str1;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(str1.substring(0, i))) {
                    return str1.substring(0, i - 1);
                }

            }
            if (i == str1.length()) {
                return str1;
            }
        }
        return "";
    }
    /*public static  String longestCommonPrefix2(String[] strs) {
        //使用hashmap
        for (int i = 0;i<=strs.length;i++)
    }*/
}
