package leetcode.algorithm.backtrack;

import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_22_括号生成_TODO {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
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
        char[] chars = new char[n * 2];

        return null;
    }

    private static void backtrack(int i, int n, Set<String> res, StringBuilder sb) {
    }

}



