package leetcode.algorithm;

/**
 * https://leetcode.cn/problems/first-bad-version/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_278_第一个错误的版本_TODO {
    public static void main(String[] args) {

        System.out.println(firstBadVersion(5));
    }

    /**
     * 二分法查找
     *
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int currentMin = (start + n) / 2;
        while (start >= end) {
            int mid = (start + n) / 2;
            if (isBadVersion(mid)) {
                start = mid;
                currentMin = mid;
            } else {
                end = mid;
            }
        }
        return currentMin;
    }

    public static boolean isBadVersion(int n) {
        return n == 4;
    }
}
