package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/string-to-integer-atoi/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_14_最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        //先去除第一个字符串
        boolean flag = true;
        int index = 0;
        while (index < strs[0].length()) {
            for (int i = 0; i < strs.length - 1; i++) {
                //边界
                if (index >= strs[i].length() || index >= strs[i + 1].length()) {
                    flag = false;
                    break;
                }
                //字符不相等
                if (strs[i].charAt(index) != (strs[i + 1].charAt(index))) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            index++;
        }

        return strs[0].substring(0, index);

    }
}
