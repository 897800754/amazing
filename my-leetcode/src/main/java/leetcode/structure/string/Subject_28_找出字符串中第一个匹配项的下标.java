package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/ *
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_28_找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
//        System.out.println(strStr("sadbutsad", "sad"));
//        System.out.println(strStr("butsad", "sad"));
//        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("mississippi", "issipi"));
        System.out.println(strStr("abc", "c"));


    }

    /**
     * 暴力解
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }

        int le = needle.length() - 1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            int x = i;
            boolean flag = true;
            while (j <= le) {
                if (haystack.charAt(x) != needle.charAt(j)) {
                    //
                    flag = false;
                    break;
                }
                j++;
                x++;
            }
            if (flag) {
                return i;
            }
        }
        return -1;

    }
}
