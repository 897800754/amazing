package leetcode.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

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
     * @param grid
     * @return
     */
    public static int minFallingPathSum(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }
        //dp初始化
        //找到最小的两个dp值
        List<Ele[]> dp = new ArrayList<>();

        Ele[] eles = new Ele[2];
        for (int i = 0; i < grid[0].length; i++) {
            if (eles[0] == null || grid[0][i] < eles[0].value) {
                Ele ele = new Ele(i, grid[0][i]);
                eles[1] = eles[0];
                eles[0] = ele;
                continue;
            }
            if (eles[1] == null || grid[0][i] < eles[1].value) {
                Ele ele = new Ele(i, grid[0][i]);
                eles[1] = ele;
            }
        }
        dp.add(eles);

        for (int i = 1; i < grid.length; i++) {
            Ele[] before = dp.get(i - 1);
            Ele[] current = new Ele[2];
            current[0] = new Ele(-1, Integer.MAX_VALUE);
            for (int j = 0; j < grid.length; j++) {
                if ((grid[i][j] + before[0].value < current[0].value)) {
                    if (before[0].index == j && (current[1] == null || (grid[i][j] + before[1].value < current[1].value))) {
                        Ele ele = new Ele(j, grid[i][j] + before[1].value);
                        current[1] = ele;
                        continue;
                    }
                    Ele ele = new Ele(j, grid[i][j] + before[0].value);
                    current[1] = current[0];
                    current[0] = ele;
                    continue;
                }
                if (current[1] == null || (grid[i][j] + before[1].value < current[1].value)) {
                    if (before[1].index == j) {
                        continue;
                    }
                    Ele ele = new Ele(j, grid[i][j] + before[1].value);
                    current[1] = ele;
                }
            }
            dp.add(current);
        }
        return dp.get(dp.size() - 1)[0].value;
    }

    public static class Ele {
        int index;
        int value;

        public Ele(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
