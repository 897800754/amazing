package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/climbing-stairs/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_70_爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(2) == climbStairs0(2));
        System.out.println(climbStairs(1) == climbStairs0(1));
        System.out.println(climbStairs(3) == climbStairs0(3));
        System.out.println(climbStairs(4) == climbStairs0(4));
    }

    /**
     * 使用滑动窗口算法
     * n1=1
     * n2=2
     * n3=n1+n2
     * n4=n3+n2
     * <p>
     * [q,p,r]
     *
     * @param n
     * @return
     */
    public static int climbStairs0(int n) {
        int q;
        int p = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            q = p;
            p = r;
            r = q + p;
        }
        return r;
    }

    /**
     * f(1) = 1;
     * f(2) = 2;
     * 到达三阶的解为 到达2阶的解+到达一阶的解
     * f(3) = f(2)+f(1)
     * 归纳:
     * 到达n阶的解围 到达n-1 +到达n-2的解
     * f(n) = f(n-1)+f(n-2);
     * <p>
     * 可以使用记忆化搜索
     * 数组作为hash表
     * <p>
     * 递归四要素
     * 确认入参,终止条件,确认返回值,函数递推公式
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] ints = new int[n];
        return climbStairs(n, ints);
    }

    public static int climbStairs(int n, int[] table) {
        if (table[n - 1] != 0) {
            return table[n - 1];
        }

        if (n == 1) {
            table[n - 1] = 1;
            return 1;
        }
        if (n == 2) {
            table[n - 1] = 2;
            return 2;
        }
        int i = climbStairs(n - 1, table) + climbStairs(n - 2, table);
        table[n - 1] = i;
        return i;
    }

}
