package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/minimum-path-sum/description/
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
     *
     * @param triangle
     * @return
     */
//    public int minimumTotal(List<List<Integer>> triangle) {
//        ArrayList<List<Integer>> dp = new ArrayList<>();
//        //dp 初始化
//        ArrayList<Integer> top = new ArrayList<>();
//        top.add(triangle.get(0).get(0));
//        //递推dp
//        for (int i = 1; i < triangle.size(); i++) {
//
//
//        }
//
//    }

}


