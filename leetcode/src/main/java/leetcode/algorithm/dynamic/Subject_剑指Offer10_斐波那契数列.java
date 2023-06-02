package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_剑指Offer10_斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        int[] cache = new int[n+1];
        return fib0(n, cache);
    }

    public static int fib0(int n, int[] cache) {
        if (n == 0) {
            cache[0] = 0;
            return 0;
        }
        if (n == 1) {
            cache[1] = 1;
            return 1;
        }
        int fib;
        if (cache[n - 1] != 0) {
            fib = cache[n - 1];
        } else {
            fib = fib0(n - 1, cache);
        }
        int fib1;
        if (cache[n - 2] != 0) {
            fib1 = cache[n - 2];
        } else {
            fib1 = fib0(n - 2, cache);
        }
        return fib + fib1;
    }
}




