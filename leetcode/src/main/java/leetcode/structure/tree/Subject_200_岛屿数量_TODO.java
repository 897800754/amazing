package leetcode.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_200_岛屿数量_TODO {

    public static void main(String[] args) {
        char[][] grid1 = new char[][]{

                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        char[][] grid2 = new char[][]{

                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        System.out.println(bfs(grid1));
        //dfs
        System.out.println(numIslands0(grid2));

    }

    /**
     * bfs
     * 同化算法
     * <p>
     * 二维转一维  id = 行索引*列长度+col_index
     * <p>
     * 一维转二维
     * row_index = id/列长度
     * col_index = id%列长度
     *
     * @param grid
     * @return
     */
    public static int bfs(char[][] grid) {
        //使用队列进行同化
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char ele = grid[i][j];
                if (ele == '1') {
                    int id = i * col + j;
                    queue.offer(id);
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        //进行同化
                        Integer pollId = queue.poll();
                        //获取行/列
                        int rowIndex = pollId / col;
                        int colIndex = pollId % col;


                        //下
                        if (rowIndex + 1 < row && grid[rowIndex + 1][colIndex] == '1') {
                            queue.offer((rowIndex + 1) * col + colIndex);
                            grid[rowIndex + 1][colIndex] = '0';
                        }
                        //上
                        if (rowIndex - 1 >= 0 && grid[rowIndex - 1][colIndex] == '1') {
                            queue.offer((rowIndex - 1) * col + colIndex);
                            grid[rowIndex - 1][colIndex] = '0';
                        }
                        //左
                        if (colIndex - 1 >= 0 && grid[rowIndex][colIndex - 1] == '1') {
                            queue.offer(rowIndex * col + colIndex - 1);
                            grid[rowIndex][colIndex - 1] = '0';
                        }
                        //右
                        if (colIndex + 1 < col && grid[rowIndex][colIndex + 1] == '1') {
                            queue.offer(rowIndex * col + colIndex + 1);
                            grid[rowIndex][colIndex + 1] = '0';
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * dfs
     *
     * @param grid
     * @return
     */
    public static int numIslands0(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char ele = grid[i][j];
                if (ele == '1') {
                    count++;
                    dfs(grid, i, j);
                } else {
                    //无
                }

            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            //考虑边界问题
            //下
            if (i + 1 < row) {
                dfs(grid, i + 1, j);
            }
            if (i - 1 >= 0) {
                //上
                dfs(grid, i - 1, j);
            }
            if (j - 1 >= 0) {
                //左
                dfs(grid, i, j - 1);
            }
            if (j + 1 < col) {
                //右
                dfs(grid, i, j + 1);
            }

        }

    }
}




