package leetcode.algorithm.backtrack;

/**
 * https://leetcode.cn/problems/word-search/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_79_单词搜索 {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        //找到所有可以作为 起始点的格子
        char startChar = word.charAt(0);


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == startChar) {
                    //循环每个起始点,上下左右走,每走一步都判断是否满足word,如果不满足回退,如果都不满足 break
                    boolean[][] hasUse = new boolean[board.length][board[0].length];
                    if (dfs(board, word, 0, i, j, board.length, board[i].length, hasUse)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //上下左右
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private static boolean dfs(char[][] board, String word, int index, int row, int col, int limitRow, int limitCol, boolean[][] hasUse) {
        if (index == word.length() - 1) {
            return board[row][col] == word.charAt(index);
        }
        if (board[row][col] == word.charAt(index)) {
            hasUse[row][col] = true;
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isArea(newRow, newCol, limitRow, limitCol) && !hasUse[newRow][newCol]) {
                    if (dfs(board, word, index + 1, newRow, newCol, limitRow, limitCol, hasUse)) {
                        return true;
                    }
                }
            }
            hasUse[row][col] = false;
        }
        return false;
    }

    private static boolean isArea(int newRow, int newCol, int limitRow, int limitCol) {
        return newRow >= 0 && newRow < limitRow && newCol >= 0 && newCol < limitCol;
    }


}



