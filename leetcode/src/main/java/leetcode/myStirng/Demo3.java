package leetcode.myStirng;

/**
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？ 
 * 1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....  
 * f(n) = f(n-1)+f(n-2)
 * f3 = f1+f2
 * f4 = f3+f2
 * f4 = (f1+f2)+f2
 */
public class Demo3 {
    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        System.out.println(demo3.getNum(8));
    }

    private Integer getNum(Integer months) {
        if (months == 1 || months == 2) {
            return 1;
        } else {
            return getNum(months - 1) + getNum(months - 2);
        }
    }

}
