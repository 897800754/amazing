package leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_20_有效的括号 {

    public static void main(String[] args) {
        System.out.println(isValid("(())"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (stack.empty()) {
                stack.push(aChar);
                continue;
            }
            Character peek = stack.peek();

            if ((peek.equals('(') && aChar == ')') || (peek.equals('{') && aChar == '}') || (peek.equals('[') && aChar == ']')) {
                //符合出栈标准
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.empty();
    }
}




