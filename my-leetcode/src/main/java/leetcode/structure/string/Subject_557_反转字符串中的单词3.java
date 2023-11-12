package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_557_反转字符串中的单词3 {
    public static void main(String[] args) {
        System.out.println(reverseWords("God Ding"));
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        s = s + " ";
        StringBuilder sb = new StringBuilder(s.length());
        //遍历s
        int start = 0;
        int end = 0;

        char[] chars = s.toCharArray();

        while (end < chars.length) {
            if (chars[end] == ' ') {
                //需要进行反转了
                //start->end 进行翻转
                int e = end - 1;
                int st = start;
                while (e >= st) {
                    sb.append(chars[e--]);
                }
                //完成后
                sb.append(chars[end]);
                end++;
                start = end;
            } else {

                end++;

            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
