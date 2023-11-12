package leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_22_括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * n=1 ()
     * n=2 (()),()(),()()
     * n=3 (())(),()(()),((()))  || ()()(),(()()),()()()
     *
     * <p>
     * 1 <= n <= 8
     * <p>
     * <p>
     * (())(())
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        backtrack(n, res, new StringBuilder(), 0, 0);
        return new ArrayList<>(res);
    }

    /**
     * @param n
     * @param res
     * @param sb
     * @param left  左边括号数量
     * @param right 右边括号数量
     * 回溯的过程中, 右括号数量 小于 左括号数量 小于 最大左括号数量
     */
    private static void backtrack(int n, Set<String> res, StringBuilder sb, Integer left, Integer right) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
        } else {
            //剪枝
            if (left < n) {
                //添加左括号
                backtrack(n, res, sb.append("("), left + 1, right);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right < left) {
                backtrack(n, res, sb.append(")"), left, right + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

}



