package leetcode.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/triangle/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_120_三角形最小路径和 {

    public static void main(String[] args) {
        System.out.println("" + null);
    }

    /**
     * 当n = 0时, dp[m][0] = triangle[m-1][0]+dp[m-1][0]
     * 当0<n<end时,dp[m][n] = min(dp[m-1][n-1]+triangle[m][n],dp[m-1][n]+triangle[m][n])
     * 当n = end时,dp[m][n] =  triangle[m-1][n-1]+dp[m-1][n-1]
     * <p>
     * https://leetcode.cn/problems/triangle/solutions/329143/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
     * 空间可优化
     * 只需要 长度N*2的一维数组即可.
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<List<Integer>> dp = new ArrayList<>();
        //dp 初始化
        ArrayList<Integer> top = new ArrayList<>();
        top.add(triangle.get(0).get(0));
        dp.add(top);

        //递推dp


        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> subTr = triangle.get(i);
            for (int j = 0; j < subTr.size(); j++) {
                if (j == 0) {
                    List<Integer> subDp = new ArrayList<>();
                    subDp.add(dp.get(i - 1).get(0) + subTr.get(j));
                    dp.add(subDp);

                } else if (j == subTr.size() - 1) {
                    List<Integer> subDp = dp.get(i);
                    subDp.add(dp.get(i - 1).get(j - 1) + subTr.get(j));

                } else {
                    List<Integer> subDp = dp.get(i);
                    subDp.add(Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + subTr.get(j));
                }
            }


        }

        List<Integer> integers = dp.get(dp.size() - 1);
        int min = integers.get(0);
        for (Integer integer : integers) {
            min = Math.min(min, integer);
        }
        return min;
    }

}


