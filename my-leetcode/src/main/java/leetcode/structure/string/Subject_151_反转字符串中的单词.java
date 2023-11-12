package leetcode.structure.string;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_151_反转字符串中的单词 {
    public static void main(String[] args) {
        System.out.println(reverseWords0("the sky is blue"));
        System.out.println(reverseWords0("  hello world  "));

    }


    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public static String reverseWords0(String s) {
        s = " " + s + " ";
        StringBuilder stringBuilder = new StringBuilder(s.length());
        int low = s.length() - 1;
        int fast = s.length() - 2;
        while (fast >= 0) {
            if (s.charAt(fast) == ' ' && s.charAt(fast + 1) != ' ') {
                int to = fast + 1;
                while (to <= low) {
                    stringBuilder.append(s.charAt(to));
                    to++;
                }
            } else if (s.charAt(fast) != ' ' && s.charAt(fast + 1) == ' ') {
                stringBuilder.append(' ');
                low = fast;
            }
            fast--;
        }
        return stringBuilder.substring(1, stringBuilder.length());

    }

    public static String reverseWords(String s) {
        s = " " + s;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && !stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                if (s.charAt(i) != ' ') {
                    stack.push(s.charAt(i));
                }

            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}
