package leetcode.str;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Demo2 {
    private HashMap<Character, Character> mappings;

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        if (s == null || ("".equals(s.trim()) && !"".equals(s))) return false;
        if ("".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[') {
                stack.push(charArr[i]);
            } else {
                //{{+)则return false
                if (stack.size() == 0) return false;
                if (charArr[i] == ')' && !stack.peek().equals('(')) return false;
                if (charArr[i] == '}' && !stack.peek().equals('{')) return false;
                if (charArr[i] == ']' && !stack.peek().equals('[')) return false;
                stack.pop();
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isValid1(String s) {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

}
