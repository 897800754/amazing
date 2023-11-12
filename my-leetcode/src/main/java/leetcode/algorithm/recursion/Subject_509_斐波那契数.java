package leetcode.algorithm.recursion;

/**
 * https://leetcode.cn/problems/fibonacci-number/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_509_斐波那契数 {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}




