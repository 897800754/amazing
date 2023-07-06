package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 **/
public class Subject_1289_下降路径最小和II {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}, {2, 2, 1, 2, 2}


        }));

    }

    /**
     * <p>
     * dp[i][j] = grid[i][j]+Min(dp[i-1,0->len(n!=j)])
     * Min(dp[i-1,0->len(n!=j)]) ->获取上一行的最小值
     * 使用二维数组 cache[m] = v ,m越大元素值越底大,v为上一行的列值,找到第一个j!=v的值v1,即找到不在同一列的dp值
     * todo 没有ac,难受~~~
     *
     * @param grid
     * @return
     */
    public static int minFallingPathSum(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }
        //上一层最小值
        int minMinIndex = -1;
        int minMinValue = Integer.MAX_VALUE;
        //上一层第二最小值
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        //
        for (int i = 0; i < grid[0].length; i++) {
            if (minMinValue > grid[0][i]) {
                minIndex = minMinIndex;
                minValue = minMinValue;
                minMinIndex = i;
                minMinValue = grid[0][i];
                continue;
            }
            if (minValue > grid[0][i]) {
                minIndex = i;
                minValue = grid[0][i];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //

            }
        }


    }


}
