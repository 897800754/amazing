package leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle-ii/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_119_杨辉三角2 {

    public static void main(String[] args) {
        System.out.println(getRow0(3));
    }

    /**
     * 输入: rowIndex = 3
     * 输出: [1,3,3,1]
     * 动态规划
     * <p>
     * 1.枚举子问题
     * 2.确认状态
     * dp[i,j]
     * 状态方程
     * dp[i,j] = dp[i-1,j-1]+dp[i-1,j]
     * dp数据初始化
     * dp[0,0] = 1
     * dp[i,j==row] = 1
     * dp[i,j==0] = 1
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow0(int rowIndex) {
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
//        dp[0][0] = 1;

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j == i) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        List<Integer> objects = new LinkedList<>();
        for (int i : dp[rowIndex]) {
            objects.add(i);
        }
        return objects;
    }

    /**
     * 递归
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = 0; j <= rowIndex; j++) {
            res.add(getRow(rowIndex, j));
        }
        return res;
    }


    public static Integer getRow(int rowIndex, int j) {
        if (j == 0) {
            return 1;
        }
        if (j == rowIndex) {
            return 1;
        }
        return getRow(rowIndex - 1, j - 1) + getRow(rowIndex - 1, j);
    }
}




